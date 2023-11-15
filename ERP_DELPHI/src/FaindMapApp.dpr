program FaindMapApp;

uses
  Vcl.Forms,
  UDMEntidades in 'Entidades\UDMEntidades.pas' {dmEntidades: TDataModule},
  UDMConexao in 'Conexao\UDMConexao.pas' {dmConexao: TDataModule},
  UCadCaminhos in 'ModelView\UCadCaminhos.pas' {frmCadCaminhos},
  UCadLocais in 'ModelView\UCadLocais.pas' {frmCadLocais},
  UPrincipal in 'ModelView\UPrincipal.pas' {frmPrincipal},
  UTools in 'Tools\UTools.pas';

{$R *.res}

begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TdmConexao, dmConexao);
  Application.CreateForm(TfrmPrincipal, frmPrincipal);
  Application.CreateForm(TdmEntidades, dmEntidades);
  Application.Run;
end.
