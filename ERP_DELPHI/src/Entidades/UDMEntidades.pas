unit UDMEntidades;

interface

uses
  System.SysUtils, System.Classes, FireDAC.Stan.Intf, FireDAC.Stan.Option,
  FireDAC.Stan.Param, FireDAC.Stan.Error, FireDAC.DatS, FireDAC.Phys.Intf,
  FireDAC.DApt.Intf, FireDAC.Stan.Async, FireDAC.DApt, Data.DB,
  FireDAC.Comp.DataSet, FireDAC.Comp.Client, UDMConexao;

type
  TdmEntidades = class(TDataModule)
    QVertice: TFDQuery;
    QStatus: TFDQuery;
    QAresta: TFDQuery;
    QLocais: TFDQuery;
    QCampus: TFDQuery;
    QAndares: TFDQuery;
    QDirecao: TFDQuery;
    QBlocos: TFDQuery;
    dsVertice: TDataSource;
    dsBlocos: TDataSource;
    dsStatus: TDataSource;
    dsArestas: TDataSource;
    dsLocais: TDataSource;
    dsDirecao: TDataSource;
    dsCampus: TDataSource;
    dsAndares: TDataSource;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  dmEntidades: TdmEntidades;

implementation

{%CLASSGROUP 'Vcl.Controls.TControl'}

{$R *.dfm}

end.
