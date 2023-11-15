unit UCadLocais;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.ExtCtrls, RzPanel,
  Vcl.Mask, RzEdit, RzCmboBx, RzDBCmbo, RzLabel, RzButton, UDMEntidades,
  cxGraphics, cxControls, cxLookAndFeels, cxLookAndFeelPainters, cxContainer,
  cxEdit, cxTextEdit, cxMaskEdit, cxDropDownEdit, cxDBEdit,
  FireDAC.Comp.Client, UDMConexao;

type
  TfrmCadLocais = class(TForm)
    panelPrincipal: TRzPanel;
    lblTitulo: TRzLabel;
    lblStatus: TLabel;
    lblAndar: TLabel;
    lblBloco: TLabel;
    lblCampus: TLabel;
    lblLinhaTitulo: TLabel;
    edtLocal: TRzEdit;
    edtLaboratorio: TRzEdit;
    lblLocal: TRzLabel;
    lblLaboratorio: TRzLabel;
    btnSalvar: TRzButton;
    cbxAndares: TRzComboBox;
    cbxCampus: TRzComboBox;
    cbxBlocos: TRzComboBox;
    cbxStatus: TRzComboBox;
    cbxNumLocal: TRzComboBox;
    lblNumLocal: TLabel;
    procedure FormCreate(Sender: TObject);
    procedure FormDestroy(Sender: TObject);
    procedure btnSalvarClick(Sender: TObject);
  private
    { Private declarations }
    procedure OpenQuerys;
    procedure CloseQuerys;
    procedure CarregaCombos(AComboBox: TRzComboBox; AQuery: TFDQuery; ANameIDTable, ANameDescricaoTable: String);
    function GravaSalaVertice: Boolean;
  public
    { Public declarations }
  end;

var
  frmCadLocais: TfrmCadLocais;

implementation

{$R *.dfm}

procedure TfrmCadLocais.btnSalvarClick(Sender: TObject);
begin
   {$Region 'btnSalvarClick'}
   if Trim(edtLocal.Text) = '' then
   begin
      ShowMessage('Nome do Local não pode ser vázio!');
      Exit;
   end;

   if GravaSalaVertice then
   begin
      ShowMessage('Dados Inseridos com sucesso');
      CloseQuerys();
      OpenQuerys();
      edtLocal.Text        := '';
      edtLaboratorio.Text  := '';
      cbxNumLocal.ItemIndex:= 0;
   end;
   {$EndRegion 'btnSalvarClick'}
end;

procedure TfrmCadLocais.CarregaCombos(AComboBox: TRzComboBox; AQuery: TFDQuery; ANameIDTable, ANameDescricaoTable: String);
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
         AComboBox.ItemIndex := 0;
      end;
   except on Exc: Exception do
      raise Exception.Create('Ocorreu um erro ao tentar carregar os combos: ' + Exc.Message);
   end;
   {$EndRegion 'CarregaCombos'}
end;

procedure TfrmCadLocais.CloseQuerys;
begin
   {$Region 'CloseQuerys'}
   dmEntidades.QCampus.Close;
   dmEntidades.QStatus.Close;
   dmEntidades.QAndares.Close;
   dmEntidades.QBlocos.Close;
   {$EndRegion 'CloseQuerys'}
end;

procedure TfrmCadLocais.FormCreate(Sender: TObject);
begin
   {$Region 'FormCreate'}
   OpenQuerys();
   {$EndRegion 'FormCreate'}
end;

procedure TfrmCadLocais.FormDestroy(Sender: TObject);
begin
   {$Region 'FormDestroy'}
   CloseQuerys();
   {$EndRegion 'FormDestroy'}
end;

function TfrmCadLocais.GravaSalaVertice: Boolean;
var
   LQueryLocais, LQueryVertices: TFDQuery;
begin
   {$Region 'GravaSalaVertice'}
   Result := False;
   LQueryLocais   := TFDQuery.Create(nil);
   LQueryVertices := TFDQuery.Create(nil);
   try
      LQueryLocais.Connection    := dmConexao.Conexao;
      LQueryVertices.Connection  := dmConexao.Conexao;
      try
         LQueryLocais.Close;
         LQueryLocais.SQL.Clear;
         LQueryLocais.SQL.Add('SELECT * FROM locais WHERE num_local = :num_local AND num_local <> -1');
         LQueryLocais.ParamByName('num_local').AsInteger := StrToInt(cbxNumLocal.Value);
         LQueryLocais.Open();

         if not LQueryLocais.IsEmpty then
         begin
            ShowMessage('Local já cadastrado');
            Exit;
         end;

         LQueryLocais.Append;
         LQueryLocais.FieldByName('num_local').AsInteger       := StrToInt(cbxNumLocal.Value);
         LQueryLocais.FieldByName('nome_local').AsString       := edtLocal.Text;
         LQueryLocais.FieldByName('nome_laboratorio').AsString := edtLaboratorio.Text;
         LQueryLocais.Post;

         LQueryVertices.Close;
         LQueryVertices.SQL.Clear;
         LQueryVertices.SQL.Add(' INSERT INTO vertices ( ');
         LQueryVertices.SQL.Add('   id_bloco, ');
         LQueryVertices.SQL.Add('   id_andar, ');
         LQueryVertices.SQL.Add('   id_local, ');
         LQueryVertices.SQL.Add('   id_status, ');
         LQueryVertices.SQL.Add('   id_campus, ');
         LQueryVertices.SQL.Add('   nome, ');
         LQueryVertices.SQL.Add('   latitude, ');
         LQueryVertices.SQL.Add('   longitude ');
         LQueryVertices.SQL.Add(' )  ');
         LQueryVertices.SQL.Add(' VALUES ');
         LQueryVertices.SQL.Add('   ( ');
         LQueryVertices.SQL.Add('     :id_bloco, ');
         LQueryVertices.SQL.Add('     :id_andar, ');
         LQueryVertices.SQL.Add('     :id_local, ');
         LQueryVertices.SQL.Add('     :id_status, ');
         LQueryVertices.SQL.Add('     :id_campus, ');
         LQueryVertices.SQL.Add('     :nome, ');
         LQueryVertices.SQL.Add('     :latitude, ');
         LQueryVertices.SQL.Add('     :longitude ');
         LQueryVertices.SQL.Add('   ) ');
         LQueryVertices.ParamByName('id_bloco').AsInteger  := StrToInt(cbxBlocos.Value);
         LQueryVertices.ParamByName('id_andar').AsInteger  := StrToInt(cbxAndares.Value);
         LQueryVertices.ParamByName('id_local').AsInteger  := LQueryLocais.FieldByName('id_local').AsInteger;
         LQueryVertices.ParamByName('id_status').AsInteger := StrToInt(cbxStatus.Value);
         LQueryVertices.ParamByName('id_campus').AsInteger := StrToInt(cbxCampus.Value);
         LQueryVertices.ParamByName('nome').AsString       := edtLocal.Text;
         LQueryVertices.ParamByName('latitude').AsFloat    := 123;
         LQueryVertices.ParamByName('longitude').AsFloat   := 456;
         LQueryVertices.ExecSQL();

         Result := True;
      except on Exc:Exception do
         raise Exception.Create('Erro Inserir Locais e o Vertice: ' + Exc.Message);
      end;
   finally
      FreeAndNil(LQueryVertices);
      FreeAndNil(LQueryLocais);
   end;
   {$EndRegion 'GravaSalaVertice'}
end;

procedure TfrmCadLocais.OpenQuerys;
begin
   {$Region 'OpenQuerys'}
   dmEntidades.QCampus.Open;
   CarregaCombos(cbxCampus, dmEntidades.QCampus, 'id_campus', 'descricao');

   dmEntidades.QStatus.Open;
   CarregaCombos(cbxStatus, dmEntidades.QStatus, 'id_status', 'descricao');

   dmEntidades.QAndares.Open;
   CarregaCombos(cbxAndares, dmEntidades.QAndares, 'id_andar', 'nome');

   dmEntidades.QBlocos.Open;
   CarregaCombos(cbxBlocos, dmEntidades.QBlocos, 'id_bloco', 'nome');
   {$EndRegion 'OpenQuerys'}
end;

end.
