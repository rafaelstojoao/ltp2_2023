unit UPrincipal;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.ExtCtrls, RzPanel, Vcl.Menus,
  UCadLocais, UCadCaminhos;

type
  TfrmPrincipal = class(TForm)
    panelPrincipal: TRzPanel;
    MainMenu1: TMainMenu;
    Cadastros1: TMenuItem;
    Salas1: TMenuItem;
    Campus1: TMenuItem;
    Blocos1: TMenuItem;
    ConexoAresta1: TMenuItem;
    procedure Salas1Click(Sender: TObject);
    procedure ConexoAresta1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frmPrincipal: TfrmPrincipal;

implementation

{$R *.dfm}

procedure TfrmPrincipal.ConexoAresta1Click(Sender: TObject);
begin
   {$Region 'ConexoAresta1Click'}
   Application.CreateForm(TfrmCadCaminhos, frmCadCaminhos);
   try
      frmCadCaminhos.ShowModal;
   finally
      FreeAndNil(frmCadCaminhos);
   end;
   {$EndRegion 'ConexoAresta1Click'}
end;

procedure TfrmPrincipal.Salas1Click(Sender: TObject);
begin
   {$Region 'Salas1Click'}
   Application.CreateForm(TfrmCadLocais, frmCadLocais);
   try
      frmCadLocais.ShowModal;
   finally
      FreeAndNil(frmCadLocais);
   end;
   {$EndRegion 'Salas1Click'}
end;

end.
