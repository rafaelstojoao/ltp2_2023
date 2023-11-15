object frmPrincipal: TfrmPrincipal
  Left = 0
  Top = 0
  Caption = 'Home'
  ClientHeight = 433
  ClientWidth = 768
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  Menu = MainMenu1
  OldCreateOrder = False
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object panelPrincipal: TRzPanel
    Left = 0
    Top = 0
    Width = 768
    Height = 433
    Align = alClient
    Color = clCream
    TabOrder = 0
  end
  object MainMenu1: TMainMenu
    Left = 712
    Top = 8
    object Cadastros1: TMenuItem
      Caption = '&Cadastros'
      object Salas1: TMenuItem
        Caption = '&Locais'
        OnClick = Salas1Click
      end
      object Campus1: TMenuItem
        Caption = '&Campus'
      end
      object Blocos1: TMenuItem
        Caption = '&Blocos'
      end
      object ConexoAresta1: TMenuItem
        Caption = '&Caminhos (Aresta)'
        OnClick = ConexoAresta1Click
      end
    end
  end
end
