unit UTools;

interface

uses
  FireDAC.Comp.Client, System.IniFiles;

   procedure LerIni(AApplication: String; var AConection: TFDConnection; var AFDManager: TFDManager);
   function LeINICrypt(AINI : TIniFile; ASection, AIdent, APass : String): String ;
   
   const
      cYearCreation = 23;
      cHash = 'pamdniaf';
implementation

uses
  System.SysUtils,
  ACBrUtil.FilesIO,
  ACBrUtil.Base, System.Classes;

procedure LerIni(AApplication: String; var AConection: TFDConnection; var AFDManager: TFDManager);
var
   LINI : TIniFile ;
   LArqCONF, LPass  : String ;
   LParametros: TStringList;
begin
   {$Region 'LerIni'}
   LArqCONF  := ExtractFilePath(AApplication) + 'config.ini' ;

   LINI   := TIniFile.Create(LArqCONF) ;
   LParametros := TStringList.Create;
   try
      LPass  := IntToStrZero( StringCrc16(cHash + IntToStrZero(315, cYearCreation)), cYearCreation) ;

      LParametros.Add('Server=' + Trim(LeINICrypt(LINI, 'DATA-BASE', 'Server', LPass)));
      LParametros.Add('Database=' + Trim(LeINICrypt(LINI, 'DATA-BASE', 'Database', LPass)));
      LParametros.Add('User_Name=' + Trim(LeINICrypt(LINI, 'DATA-BASE', 'User', LPass)));
      LParametros.Add('Password=' + Trim(LeINICrypt(LINI, 'DATA-BASE', 'Password', LPass)));
      
      AFDManager.Active := False;
      AFDManager.AddConnectionDef('faindmapdb_connection', 'MSSQL', LParametros);
      AFDManager.Active := True;      
      
      AConection.Params.Clear;
      AConection.LoginPrompt        := False;
      AConection.ConnectionDefName  := 'faindmapdb_connection';
      
   finally
      FreeAndNil(LINI);
      FreeAndNil(LParametros);
   end;
   {$EndRegion 'LerIni'}
end;

function LeINICrypt(AINI : TIniFile; ASection, AIdent, APass : String) : String ;
var
   LSStream  : TStringStream;
   LCryptStr : String;
begin 
   {$Region 'LeINICrypt'}
   LSStream := TStringStream.Create('') ;
   try
      AINI.ReadBinaryStream(ASection, AIdent, LSStream);
      LCryptStr := LSStream.DataString  ;
      Result   := StrCrypt( LCryptStr, APass) ;
   finally
      LSStream.Free;
   end;
   {$EndRegion 'LeINICrypt'}
end;

end.
