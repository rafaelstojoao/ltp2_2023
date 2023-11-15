unit UCadCaminhos;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, RzCmboBx, RzButton,
  Vcl.Mask, RzEdit, RzLabel, Vcl.ExtCtrls, RzPanel, UDMConexao, UDMEntidades,
  FireDAC.Comp.Client, FireDAC.Stan.Intf, FireDAC.Stan.Option,
  FireDAC.Stan.Param, FireDAC.Stan.Error, FireDAC.DatS, FireDAC.Phys.Intf,
  FireDAC.DApt.Intf, FireDAC.Stan.Async, FireDAC.DApt, Data.DB,
  FireDAC.Comp.DataSet;

type
  TfrmCadCaminhos = class(TForm)
    panelPrincipal: TRzPanel;
    lblTitulo: TRzLabel;
    lblDirecao: TLabel;
    lblChegada: TLabel;
    lbSaida: TLabel;
    lblLinhaTitulo: TLabel;
    lblDistancia: TRzLabel;
    btnSalvar: TRzButton;
    cbxDirecao: TRzComboBox;
    cbxSaida: TRzComboBox;
    cbxChegada: TRzComboBox;
    edtDistancia: TRzNumericEdit;
    QChegada: TFDQuery;
    QSaida: TFDQuery;
    procedure btnSalvarClick(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
    procedure cbxSaidaChange(Sender: TObject);
  private
    { Private declarations }
    procedure OpenQuerys;
    procedure CloseQuerys;
    procedure CarregaCombos(AComboBox: TRzComboBox; AQuery: TFDQuery; ANameIDTable, ANameDescricaoTable: String);
    procedure CarregaCombosWhere(AComboBox: TRzComboBox; AQuery: TFDQuery; ANameIDTable, ANameDescricaoTable, ATable, AWhere: String);
    function GravaCaminho: Boolean;
  public
    { Public declarations }
  end;

var
  frmCadCaminhos: TfrmCadCaminhos;

implementation

{$R *.dfm}

{ TfrmAresta }

procedure TfrmCadCaminhos.btnSalvarClick(Sender: TObject);
begin
   {$Region 'btnSalvarClick'}
   if edtDistancia.Value = 0 then
   begin
      ShowMessage('Insirá a distância');
      Exit;
   end;

   if GravaCaminho then
   begin
      ShowMessage('Caminhos criado com sucesso');
      CloseQuerys();
      OpenQuerys();
      edtDistancia.Value := 0;
   end;
   {$EndRegion 'btnSalvarClick'}
end;

procedure TfrmCadCaminhos.CarregaCombos(AComboBox: TRzComboBox; AQuery: TFDQuery;
  ANameIDTable, ANameDescricaoTable: String);
begin
   {$Region 'CarregaCombos'}
   try
      (* Adiciono as empresas no combobox *)
      if not AQuery.IsEmpty then
      begin
         AComboBox.Items.Clear;
         AComboBox.Values.Clear;

         AQuery.First;
         while not AQuery.Eof do
         begin
            AComboBox.AddItemValue(AQuery.FieldByName(ANameIDTable).AsString + ' - ' +
                     AQuery.FieldByName(ANameDescricaoTable).AsString,
                     AQuery.FieldByName(ANameIDTable).AsString);

            AQuery.Next;
         end;
         AComboBox.ItemIndex := -1;
      end;
   except on Exc: Exception do
      raise Exception.Create('Ocorreu um erro ao tentar carregar os combos: ' + Exc.Message);
   end;
   {$EndRegion 'CarregaCombos'}
end;

procedure TfrmCadCaminhos.CarregaCombosWhere(AComboBox: TRzComboBox;
  AQuery: TFDQuery; ANameIDTable, ANameDescricaoTable, ATable, AWhere: String);
begin
   {$Region 'CarregaCombosWhere'}
   try
      AQuery.Close;
      AQuery.SQL.Clear;
      AQuery.SQL.Add(Format('SELECT * FROM %s WHERE %s ', [ATable, AWhere]));
      AQuery.Open();

      if not AQuery.IsEmpty then
      begin
         AComboBox.Items.Clear;
         AComboBox.Values.Clear;

         AQuery.First;
         while not AQuery.Eof do
         begin
            AComboBox.AddItemValue(AQuery.FieldByName(ANameIDTable).AsString + ' - ' +
                     AQuery.FieldByName(ANameDescricaoTable).AsString,
                     AQuery.FieldByName(ANameIDTable).AsString);

            AQuery.Next;
         end;
         AComboBox.ItemIndex := -1;
      end;
   except on Exc: Exception do
      raise Exception.Create('Ocorreu um erro ao tentar carregar os combos com trativas: ' + Exc.Message);
   end;
   {$EndRegion 'CarregaCombosWhere'}
end;

procedure TfrmCadCaminhos.cbxSaidaChange(Sender: TObject);
var
   LWhere: String;
   LStatus: Integer;
begin
   {$Region 'cbxSaidaChange'}
   LStatus := 1;
   LWhere := Format(' id_vertice <> %d AND id_status = %d ', [StrToInt(cbxSaida.Value), LStatus]);
   CarregaCombosWhere(cbxChegada, QChegada, 'id_vertice', 'nome', 'vertices', LWhere);
   {$EndRegion 'cbxSaidaChange'}
end;

procedure TfrmCadCaminhos.CloseQuerys;
begin
   {$Region 'CloseQuerys'}
   dmEntidades.QCampus.Close;
   dmEntidades.QStatus.Close;
   dmEntidades.QAndares.Close;
   dmEntidades.QBlocos.Close;
   {$EndRegion 'CloseQuerys'}
end;

procedure TfrmCadCaminhos.FormClose(Sender: TObject; var Action: TCloseAction);
begin
   {$Region 'FormClose'}
   CloseQuerys();
   {$EndRegion 'FormClose'}
end;

procedure TfrmCadCaminhos.FormCreate(Sender: TObject);
begin
   {$Region 'FormCreate'}
   OpenQuerys();
   {$EndRegion 'FormCreate'}
end;

function TfrmCadCaminhos.GravaCaminho: Boolean;
var
   LQueryAresta: TFDQuery;
begin
   {$Region 'GravaCaminho'}
   Result := False;
   LQueryAresta   := TFDQuery.Create(nil);
   try
      LQueryAresta.Connection    := dmConexao.Conexao;
      try
         LQueryAresta.Close;
         LQueryAresta.SQL.Clear;
         LQueryAresta.SQL.Add('SELECT * FROM arestas WHERE id_vertice_origem = :id_vertice_origem AND id_vertice_destino = :id_vertice_destino');
         LQueryAresta.ParamByName('id_vertice_origem').AsInteger  := StrToInt(cbxSaida.Value);
         LQueryAresta.ParamByName('id_vertice_destino').AsInteger := StrToInt(cbxChegada.Value);
         LQueryAresta.Open();

         if not LQueryAresta.IsEmpty then
         begin
            ShowMessage('Caminho já cadastrado');
            Exit;
         end;

         LQueryAresta.Append;
         LQueryAresta.FieldByName('id_vertice_origem').AsInteger  := StrToInt(cbxSaida.Value);
         LQueryAresta.FieldByName('id_vertice_destino').AsInteger := StrToInt(cbxChegada.Value);
         LQueryAresta.FieldByName('distancia').AsFloat            := edtDistancia.Value;
         LQueryAresta.FieldByName('id_direcao').AsInteger         := StrToInt(cbxDirecao.Value);
         LQueryAresta.Post;

         Result := True;
      except on Exc:Exception do
         raise Exception.Create('Erro Inserir Caminhos: ' + Exc.Message);
      end;
   finally
      FreeAndNil(LQueryAresta);
   end;
   {$EndRegion 'GravaCaminho'}
end;

procedure TfrmCadCaminhos.OpenQuerys;
var
   LWhere: String;
   LStatus: Integer;
begin
   {$Region 'OpenQuerys'}
   LStatus:= 1;
   LWhere := Format(' id_status = %d', [LStatus]);

   dmEntidades.QDirecao.Open;
   CarregaCombos(cbxDirecao, dmEntidades.QDirecao, 'id_direcao', 'descricao');

   CarregaCombosWhere(cbxSaida, QSaida, 'id_vertice', 'nome', 'vertices', LWhere);

   cbxChegada.Items.Clear;;
   cbxChegada.Values.Clear;
   cbxChegada.ItemIndex := -1;
   cbxChegada.Text := '';
   {$EndRegion 'OpenQuerys'}
end;

end.
