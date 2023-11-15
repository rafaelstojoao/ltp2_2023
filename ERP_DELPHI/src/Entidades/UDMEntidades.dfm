object dmEntidades: TdmEntidades
  OldCreateOrder = False
  Height = 302
  Width = 396
  object QVertice: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM vertices WHERE id_status = 1;')
    Left = 40
    Top = 24
  end
  object QStatus: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM status;')
    Left = 256
    Top = 24
  end
  object QAresta: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM arestas;')
    Left = 40
    Top = 136
  end
  object QLocais: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM locais;')
    Left = 256
    Top = 144
  end
  object QCampus: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM campus;')
    Left = 152
    Top = 88
  end
  object QAndares: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM andares WHERE id_status = 1;')
    Left = 256
    Top = 88
  end
  object QDirecao: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM direcao;')
    Left = 40
    Top = 88
  end
  object QBlocos: TFDQuery
    Connection = dmConexao.Conexao
    SQL.Strings = (
      'SELECT * FROM blocos WHERE id_status = 1;')
    Left = 152
    Top = 24
  end
  object dsVertice: TDataSource
    DataSet = QVertice
    Left = 72
    Top = 24
  end
  object dsBlocos: TDataSource
    DataSet = QBlocos
    Left = 184
    Top = 24
  end
  object dsStatus: TDataSource
    DataSet = QStatus
    Left = 288
    Top = 24
  end
  object dsArestas: TDataSource
    DataSet = QAresta
    Left = 72
    Top = 136
  end
  object dsLocais: TDataSource
    DataSet = QLocais
    Left = 288
    Top = 144
  end
  object dsDirecao: TDataSource
    DataSet = QDirecao
    Left = 72
    Top = 88
  end
  object dsCampus: TDataSource
    DataSet = QCampus
    Left = 184
    Top = 88
  end
  object dsAndares: TDataSource
    DataSet = QAndares
    Left = 288
    Top = 88
  end
end
