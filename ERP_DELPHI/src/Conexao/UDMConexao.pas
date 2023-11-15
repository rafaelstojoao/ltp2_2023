unit UDMConexao;

interface

uses
  System.SysUtils, System.Classes, FireDAC.Stan.Intf, FireDAC.Stan.Option,
  FireDAC.Stan.Error, FireDAC.UI.Intf, FireDAC.Phys.Intf, FireDAC.Stan.Def,
  FireDAC.Stan.Pool, FireDAC.Stan.Async, FireDAC.Phys, FireDAC.Phys.MSSQL,
  FireDAC.Phys.MSSQLDef, FireDAC.VCLUI.Wait, FireDAC.Phys.ODBCBase, Data.DB,
  FireDAC.Comp.Client;

type
  TdmConexao = class(TDataModule)
    Conexao: TFDConnection;
    FDPhysMSSQLDriverLink1: TFDPhysMSSQLDriverLink;
    FDManager: TFDManager;
    procedure DataModuleCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  dmConexao: TdmConexao;

implementation

uses
  UTools, Vcl.Forms;

{%CLASSGROUP 'Vcl.Controls.TControl'}

{$R *.dfm}

procedure TdmConexao.DataModuleCreate(Sender: TObject);
begin
   {$Region 'DataModuleCreate'}
   try
      FDPhysMSSQLDriverLink1.ODBCDriver := 'ODBC Driver 17 for SQL Server';
      Conexao.Connected := False;
      LerIni(Application.ExeName, Conexao, FDManager);
      Conexao.Connected := True;
   except on Exc:Exception do
      raise Exception.Create('Erro ao conectar com o banco de dados: ' + Exc.Message);
   end;
   {$EndRegion 'DataModuleCreate'}
end;

end.
