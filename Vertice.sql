CREATE TABLE [dbo].[Vertice](
	[IDVertice] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [varchar](50) NULL,
	[IDBloco] [int] NULL,
	[IDAndar] [int] NULL,
	[IDStatus] [int] NULL,
	[IDCampus] [int] NULL,
	[latitude] [float] NULL,
	[longitude] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDVertice] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Vertice] ON 
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (11, N'sala1', 2, 1, 1, 2, -760385800, -49221000)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (12, N'sala1', 1, 2, 1, 2, -760388200, -49219400)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (13, N'sala2', 1, 2, 1, 2, -760386500, -49218800)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (14, N'sala2', 1, 1, 1, 2, -760386400, -49218700)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (15, N'sala3', 2, 1, 1, 2, -760385400, -49220200)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (16, N'sala4', 2, 1, 1, 2, -760383800, -49220800)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (17, N'sala5', 2, 1, 1, 2, -760383500, -49219700)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (18, N'sala5', 2, 2, 1, 2, -760383500, -49219700)
GO
INSERT [dbo].[Vertice] ([IDVertice], [Nome], [IDBloco], [IDAndar], [IDStatus], [IDCampus], [latitude], [longitude]) VALUES (19, N'sala7', 2, 1, 1, 2, -760382900, -49218400)
GO
SET IDENTITY_INSERT [dbo].[Vertice] OFF
GO
