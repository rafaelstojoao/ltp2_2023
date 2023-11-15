object frmCadLocais: TfrmCadLocais
  Left = 0
  Top = 0
  BorderIcons = [biSystemMenu]
  BorderStyle = bsDialog
  Caption = 'Cadastro dos Locais'
  ClientHeight = 342
  ClientWidth = 326
  Color = clBtnFace
  Constraints.MaxHeight = 371
  Constraints.MaxWidth = 332
  Constraints.MinHeight = 371
  Constraints.MinWidth = 332
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  Position = poScreenCenter
  OnCreate = FormCreate
  OnDestroy = FormDestroy
  PixelsPerInch = 96
  TextHeight = 13
  object panelPrincipal: TRzPanel
    Left = 0
    Top = 0
    Width = 326
    Height = 342
    Align = alClient
    Caption = '\'
    Color = clCream
    Padding.Left = 3
    Padding.Top = 3
    Padding.Right = 3
    Padding.Bottom = 3
    TabOrder = 0
    object lblTitulo: TRzLabel
      Left = 5
      Top = 5
      Width = 316
      Height = 24
      Align = alTop
      Alignment = taCenter
      Caption = 'Cadastro de Salas'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -20
      Font.Name = 'Tahoma'
      Font.Style = [fsBold, fsUnderline]
      ParentFont = False
      Layout = tlCenter
      ExplicitWidth = 179
    end
    object lblStatus: TLabel
      Left = 5
      Top = 167
      Width = 316
      Height = 20
      Align = alTop
      Alignment = taCenter
      AutoSize = False
      Caption = 'Status'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = [fsUnderline]
      ParentFont = False
      Layout = tlCenter
      ExplicitTop = 155
      ExplicitWidth = 313
    end
    object lblAndar: TLabel
      Left = 5
      Top = 125
      Width = 316
      Height = 20
      Align = alTop
      Alignment = taCenter
      AutoSize = False
      Caption = 'Andar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = [fsUnderline]
      ParentFont = False
      Layout = tlCenter
      ExplicitTop = 113
      ExplicitWidth = 313
    end
    object lblBloco: TLabel
      Left = 5
      Top = 83
      Width = 316
      Height = 20
      Align = alTop
      Alignment = taCenter
      AutoSize = False
      Caption = 'Bloco'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = [fsUnderline]
      ParentFont = False
      Layout = tlCenter
      ExplicitTop = 71
      ExplicitWidth = 313
    end
    object lblCampus: TLabel
      Left = 5
      Top = 45
      Width = 316
      Height = 16
      Align = alTop
      Alignment = taCenter
      Caption = 'Campus'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      Layout = tlCenter
      ExplicitWidth = 46
    end
    object lblLinhaTitulo: TLabel
      Left = 5
      Top = 29
      Width = 316
      Height = 16
      Align = alTop
      Alignment = taCenter
      Caption = '____________________________________________'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      ExplicitWidth = 308
    end
    object lblLocal: TRzLabel
      Left = 5
      Top = 216
      Width = 106
      Height = 16
      Caption = 'Descri'#231#227'o do Local'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
    end
    object lblLaboratorio: TRzLabel
      Left = 163
      Top = 216
      Width = 65
      Height = 16
      Caption = 'Laborat'#243'rio'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
    end
    object lblNumLocal: TLabel
      Left = 5
      Top = 250
      Width = 316
      Height = 26
      Align = alBottom
      Alignment = taCenter
      AutoSize = False
      Caption = 'Local ID'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = [fsUnderline]
      ParentFont = False
      Layout = tlCenter
      ExplicitTop = 280
    end
    object edtLocal: TRzEdit
      Left = 5
      Top = 232
      Width = 155
      Height = 22
      Text = ''
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
    end
    object edtLaboratorio: TRzEdit
      Left = 166
      Top = 232
      Width = 155
      Height = 22
      Text = ''
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
    end
    object btnSalvar: TRzButton
      Left = 5
      Top = 298
      Width = 316
      Height = 39
      Align = alBottom
      Caption = 'Salvar'
      TabOrder = 2
      OnClick = btnSalvarClick
    end
    object cbxAndares: TRzComboBox
      Left = 5
      Top = 145
      Width = 316
      Height = 22
      Align = alTop
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 3
    end
    object cbxCampus: TRzComboBox
      Left = 5
      Top = 61
      Width = 316
      Height = 22
      Align = alTop
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 4
    end
    object cbxBlocos: TRzComboBox
      Left = 5
      Top = 103
      Width = 316
      Height = 22
      Align = alTop
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 5
    end
    object cbxStatus: TRzComboBox
      Left = 5
      Top = 187
      Width = 316
      Height = 22
      Align = alTop
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 6
    end
    object cbxNumLocal: TRzComboBox
      Left = 5
      Top = 276
      Width = 316
      Height = 22
      Align = alBottom
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 7
      Text = '1'
      Items.Strings = (
        '1'
        '2'
        '3'
        '4'
        '5'
        '6'
        '7'
        '8'
        '9'
        '10'
        '11'
        '12'
        '13'
        '14'
        '15'
        '16'
        '17'
        '18'
        '19'
        '20'
        '21'
        '22'
        '23'
        '24'
        '25'
        '26'
        '27'
        '28'
        '29'
        '30'
        '31'
        '32'
        '33'
        '34'
        '35'
        '36'
        '37'
        '38'
        '39'
        '40'
        '41'
        '42'
        '43'
        '44'
        '45'
        '46'
        '47'
        '48'
        '49'
        '50'
        'Cantinas|Banheiros|Bebedouros...')
      ItemIndex = 0
      Values.Strings = (
        '1'
        '2'
        '3'
        '4'
        '5'
        '6'
        '7'
        '8'
        '9'
        '10'
        '11'
        '12'
        '13'
        '14'
        '15'
        '16'
        '17'
        '18'
        '19'
        '20'
        '21'
        '22'
        '23'
        '24'
        '25'
        '26'
        '27'
        '28'
        '29'
        '30'
        '31'
        '32'
        '33'
        '34'
        '35'
        '36'
        '37'
        '38'
        '39'
        '40'
        '41'
        '42'
        '43'
        '44'
        '45'
        '46'
        '47'
        '48'
        '49'
        '50'
        '-1')
    end
  end
end
