USE [InventoryManagement4]
GO
/****** Object:  Table [dbo].[account]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[Profile_id] [int] NOT NULL,
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[SaleManager_ID] [varchar](10) NULL,
	[SalePerson_ID] [varchar](10) NULL,
	[Admin_ID] [varchar](10) NULL,
	[InventoryManager_ID] [varchar](10) NULL,
	[Postion] [varchar](10) NOT NULL,
	[Avatar] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[Profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Administration]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administration](
	[Admin_ID] [varchar](10) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Age] [int] NOT NULL,
	[Sex] [varchar](10) NOT NULL,
	[Phone] [varchar](100) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Address] [varchar](255) NOT NULL,
	[Position] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Admin_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Division]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Division](
	[Div_ID] [int] NOT NULL,
	[Div_Name] [varchar](255) NOT NULL,
	[Div_Shift] [varchar](255) NOT NULL,
	[Div_Position] [varchar](255) NULL,
	[Div_Time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[Div_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Division_Detail]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Division_Detail](
	[Div_ID] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GoodsCategories]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GoodsCategories](
	[Category_ID] [int] NOT NULL,
	[Category_name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Category_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Import_Product]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Import_Product](
	[Import_ID] [varchar](50) NOT NULL,
	[Sup_ID] [varchar](10) NULL,
	[Categories_name] [varchar](50) NOT NULL,
	[Import_Product_Name] [varchar](255) NOT NULL,
	[Expiry] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Import_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Import_Product_Detail]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Import_Product_Detail](
	[Import_Product_Detail_ID] [varchar](50) NOT NULL,
	[Import_ID] [varchar](50) NOT NULL,
	[Product_ID] [int] NOT NULL,
	[Import_Quantity_Product] [int] NOT NULL,
	[ImportDate] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Import_Product_Detail_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inventory_Manager]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inventory_Manager](
	[InventoryManager_ID] [varchar](10) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Age] [int] NOT NULL,
	[Sex] [varchar](10) NOT NULL,
	[Phone] [varchar](100) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Address] [varchar](255) NOT NULL,
	[Position] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[InventoryManager_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[InventoryStatics]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InventoryStatics](
	[InventoryStatics_ID] [varchar](10) NOT NULL,
	[InventoryManager_ID] [varchar](10) NOT NULL,
	[Quantity_Products] [int] NOT NULL,
	[Date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[InventoryStatics_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[InventoryStaticsDetail]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InventoryStaticsDetail](
	[Inventory_Statics_Detail_ID] [varchar](10) NOT NULL,
	[InventoryStatics_ID] [varchar](10) NOT NULL,
	[Product_ID] [int] NOT NULL,
	[Inventory_Statics_Detail_Date] [datetime] NOT NULL,
	[Quantity_Product] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Inventory_Statics_Detail_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Order_ID] [int] NOT NULL,
	[SalePerson_ID] [varchar](10) NOT NULL,
	[Order_date] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Order_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product_Order_Detail]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_Order_Detail](
	[Order_Detail_ID] [int] NOT NULL,
	[Order_ID] [int] NOT NULL,
	[Product_ID] [int] NOT NULL,
	[Product_Quantity_Order] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Order_Detail_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Product_ID] [int] NOT NULL,
	[Category_ID] [int] NULL,
	[Product_name] [varchar](255) NOT NULL,
	[Product_price] [int] NOT NULL,
	[Product_quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Product_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Returns]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Returns](
	[Order_ID] [int] NOT NULL,
	[Order_Detail_ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Revenue]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Revenue](
	[Revenue_Date] [date] NOT NULL,
	[SaleManager_ID] [varchar](10) NOT NULL,
	[Funds] [int] NOT NULL,
	[Profits] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Revenue_Date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SaleManager]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SaleManager](
	[SaleManager_ID] [varchar](10) NOT NULL,
	[SalePerson_ID] [varchar](10) NULL,
	[Name] [varchar](50) NOT NULL,
	[Age] [int] NOT NULL,
	[Sex] [varchar](10) NOT NULL,
	[Phone] [varchar](100) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Address] [varchar](255) NOT NULL,
	[Position] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SaleManager_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SalePerson]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalePerson](
	[SalePerson_ID] [varchar](10) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Age] [int] NOT NULL,
	[Sex] [varchar](10) NOT NULL,
	[Phone] [varchar](100) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Address] [varchar](255) NOT NULL,
	[Position] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SalePerson_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 7/16/2023 10:53:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[Sup_ID] [varchar](10) NOT NULL,
	[Sup_Name] [varchar](255) NOT NULL,
	[Sup_Phone] [varchar](20) NOT NULL,
	[Sup_Category] [varchar](50) NULL,
	[Sup_Address] [varchar](255) NULL,
	[Sup_Email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Sup_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Administration] ([Admin_ID], [Name], [Age], [Sex], [Phone], [Email], [Address], [Position]) VALUES (N'a', N'name1', 1, N'm', N'sex', N'00sds', N'asdas', N'dasdasd')
GO
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (1, N'Electronics')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (2, N'Clothing')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (3, N'Beauty Products')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (4, N'Home Goods')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (5, N'Sports Equipment')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (6, N'Toys')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (7, N'Books')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (8, N'Outdoor Gear')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (9, N'Office Supplies')
INSERT [dbo].[GoodsCategories] ([Category_ID], [Category_name]) VALUES (10, N'Food and Beverages')
GO
INSERT [dbo].[Import_Product] ([Import_ID], [Sup_ID], [Categories_name], [Import_Product_Name], [Expiry]) VALUES (N'IMP001', N'Sup1', N'Beauty', N'Product1', CAST(N'2023-06-30T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product] ([Import_ID], [Sup_ID], [Categories_name], [Import_Product_Name], [Expiry]) VALUES (N'IMP002', N'Sup1', N'Clothing', N'Product2', CAST(N'2023-10-12T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product] ([Import_ID], [Sup_ID], [Categories_name], [Import_Product_Name], [Expiry]) VALUES (N'IMP003', N'Sup1', N'Electronics', N'Product3', CAST(N'2024-02-15T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product] ([Import_ID], [Sup_ID], [Categories_name], [Import_Product_Name], [Expiry]) VALUES (N'IMP004', N'Sup1', N'Electronics', N'Product4', CAST(N'2023-09-10T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product] ([Import_ID], [Sup_ID], [Categories_name], [Import_Product_Name], [Expiry]) VALUES (N'IMP005', N'Sup1', N'Clothing', N'Product5', CAST(N'2023-12-31T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL001', N'IMP001', 14, 9, CAST(N'2023-06-02T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL0012', N'IMP001', 3, 5, CAST(N'2023-05-30T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL002', N'IMP002', 15, 3, CAST(N'2023-10-05T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL003', N'IMP002', 16, 10, CAST(N'2023-10-05T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL004', N'IMP002', 17, 2, CAST(N'2023-10-05T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL005', N'IMP003', 18, 7, CAST(N'2023-12-15T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL006', N'IMP004', 19, 1, CAST(N'2024-08-10T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL007', N'IMP005', 2, 4, CAST(N'2023-07-01T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL008', N'IMP004', 20, 8, CAST(N'2024-08-10T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL009', N'IMP005', 21, 2, CAST(N'2023-07-01T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL010', N'IMP001', 4, 7, CAST(N'2023-06-01T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'DETAIL011', N'IMP001', 4, 10, CAST(N'2023-06-01T00:00:00.000' AS DateTime))
INSERT [dbo].[Import_Product_Detail] ([Import_Product_Detail_ID], [Import_ID], [Product_ID], [Import_Quantity_Product], [ImportDate]) VALUES (N'minh', N'IMP001', 1, 1, CAST(N'2022-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Inventory_Manager] ([InventoryManager_ID], [Name], [Age], [Sex], [Phone], [Email], [Address], [Position]) VALUES (N'1', N'Minh', 20, N'male', N'0338460275', N'MInh@gmail.com', N'nowhere', N'InventoryManager')
GO
INSERT [dbo].[InventoryStatics] ([InventoryStatics_ID], [InventoryManager_ID], [Quantity_Products], [Date]) VALUES (N'IS0001', N'1', 40, CAST(N'2020-08-09' AS Date))
INSERT [dbo].[InventoryStatics] ([InventoryStatics_ID], [InventoryManager_ID], [Quantity_Products], [Date]) VALUES (N'IS0002', N'1', 40, CAST(N'2020-08-10' AS Date))
INSERT [dbo].[InventoryStatics] ([InventoryStatics_ID], [InventoryManager_ID], [Quantity_Products], [Date]) VALUES (N'IS0003', N'1', 40, CAST(N'2020-09-10' AS Date))
INSERT [dbo].[InventoryStatics] ([InventoryStatics_ID], [InventoryManager_ID], [Quantity_Products], [Date]) VALUES (N'IS0004', N'1', 40, CAST(N'2023-06-20' AS Date))
INSERT [dbo].[InventoryStatics] ([InventoryStatics_ID], [InventoryManager_ID], [Quantity_Products], [Date]) VALUES (N'IS0005', N'1', 40, CAST(N'2023-06-21' AS Date))
GO
INSERT [dbo].[Orders] ([Order_ID], [SalePerson_ID], [Order_date]) VALUES (1, N'1', CAST(N'2023-06-22T00:00:00.000' AS DateTime))
INSERT [dbo].[Orders] ([Order_ID], [SalePerson_ID], [Order_date]) VALUES (2, N'1', CAST(N'2023-06-22T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Product_Order_Detail] ([Order_Detail_ID], [Order_ID], [Product_ID], [Product_Quantity_Order]) VALUES (11, 1, 1, 5)
INSERT [dbo].[Product_Order_Detail] ([Order_Detail_ID], [Order_ID], [Product_ID], [Product_Quantity_Order]) VALUES (12, 1, 2, 4)
INSERT [dbo].[Product_Order_Detail] ([Order_Detail_ID], [Order_ID], [Product_ID], [Product_Quantity_Order]) VALUES (13, 1, 5, 3)
INSERT [dbo].[Product_Order_Detail] ([Order_Detail_ID], [Order_ID], [Product_ID], [Product_Quantity_Order]) VALUES (14, 1, 7, 1)
INSERT [dbo].[Product_Order_Detail] ([Order_Detail_ID], [Order_ID], [Product_ID], [Product_Quantity_Order]) VALUES (15, 2, 1, 5)
GO
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (1, 4, N'Red Lipstick', 15, 50)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (2, 7, N'Harry Potter and the Sorcerer''s Stone', 20, 100)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (3, 1, N'iPhone X', 800, 10)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (4, 5, N'Dinnerware Set', 50, 20)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (5, 9, N'Jeans', 50, 30)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (6, 3, N'Stapler', 5, 200)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (7, 3, N'Treadmill', 1000, 5)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (8, 1, N'Barbie Doll', 25, 75)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (9, 2, N'Tent', 150, 3)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (10, 4, N'Coffee Beans', 10, 100)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (14, 1, N'Nail Polish', 9, 10)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (15, 2, N'Coffee Maker', 89, 5)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (16, 3, N'Smart TV', 149, 8)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (17, 4, N'Jump Rope', 24, 45)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (18, 1, N'Mascara', 7, 24)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (19, 2, N'Vacuum Cleaner', 129, 36)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (20, 5, N'T-Shirt', 29, 85)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (21, 3, N'Sweater', 59, 1)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (22, 4, N'Wireless Earbuds', 79, 0)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (23, 1, N'Dumbbells', 39, 2)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (24, 2, N'Moisturizer', 19, 85)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (25, 5, N'Pillow', 69, 46)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (26, 3, N'Skirt', 49, 12)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (27, 4, N'Digital Camera', 299, 5)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (28, 1, N'Gym Bag', 19, 1)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (29, 2, N'Eyeliner', 14, 75)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (30, 5, N'Plant Pot', 39, 21)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (31, 3, N'Phone', 15, 65)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (32, 4, N'Jacket', 89, 85)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (33, 1, N'Smart Watch', 199, 75)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (34, 2, N'Tennis Racket', 69, 24)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (35, 5, N'Perfume', 29, 26)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (36, 3, N'Air Purifier', 149, 341)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (37, 4, N'Shoes', 79, 452)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (38, 2, N'Candle', 49, 15)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (39, 3, N'Laptop', 299, 14)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (40, 4, N'Soccer Ball', 59, 54)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (41, 1, N'Face Mask', 12, 75)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (42, 2, N'Throw Blanket', 79, 15)
INSERT [dbo].[Products] ([Product_ID], [Category_ID], [Product_name], [Product_price], [Product_quantity]) VALUES (43, 9, N'Jeans', 69, 3)
GO
INSERT [dbo].[SalePerson] ([SalePerson_ID], [Name], [Age], [Sex], [Phone], [Email], [Address], [Position]) VALUES (N'1', N'Minh', 20, N'male', N'0338460275', N'Minh@gmail.com', N'nowhere', N'InventoryManager')
GO
INSERT [dbo].[Supplier] ([Sup_ID], [Sup_Name], [Sup_Phone], [Sup_Category], [Sup_Address], [Sup_Email]) VALUES (N'Sup1', N'MVcompany', N'0338460275', N'Electronics', N'nowhere', N'Sup@gmail.com')
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD FOREIGN KEY([Admin_ID])
REFERENCES [dbo].[Administration] ([Admin_ID])
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD FOREIGN KEY([InventoryManager_ID])
REFERENCES [dbo].[Inventory_Manager] ([InventoryManager_ID])
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD FOREIGN KEY([SaleManager_ID])
REFERENCES [dbo].[SaleManager] ([SaleManager_ID])
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD FOREIGN KEY([SalePerson_ID])
REFERENCES [dbo].[SalePerson] ([SalePerson_ID])
GO
ALTER TABLE [dbo].[Division_Detail]  WITH CHECK ADD FOREIGN KEY([Div_ID])
REFERENCES [dbo].[Division] ([Div_ID])
GO
ALTER TABLE [dbo].[Import_Product]  WITH CHECK ADD FOREIGN KEY([Sup_ID])
REFERENCES [dbo].[Supplier] ([Sup_ID])
GO
ALTER TABLE [dbo].[Import_Product_Detail]  WITH CHECK ADD FOREIGN KEY([Import_ID])
REFERENCES [dbo].[Import_Product] ([Import_ID])
GO
ALTER TABLE [dbo].[Import_Product_Detail]  WITH CHECK ADD FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Products] ([Product_ID])
GO
ALTER TABLE [dbo].[InventoryStatics]  WITH CHECK ADD FOREIGN KEY([InventoryManager_ID])
REFERENCES [dbo].[Inventory_Manager] ([InventoryManager_ID])
GO
ALTER TABLE [dbo].[InventoryStaticsDetail]  WITH CHECK ADD FOREIGN KEY([InventoryStatics_ID])
REFERENCES [dbo].[InventoryStatics] ([InventoryStatics_ID])
GO
ALTER TABLE [dbo].[InventoryStaticsDetail]  WITH CHECK ADD FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Products] ([Product_ID])
GO
ALTER TABLE [dbo].[Product_Order_Detail]  WITH CHECK ADD FOREIGN KEY([Order_ID])
REFERENCES [dbo].[Orders] ([Order_ID])
GO
ALTER TABLE [dbo].[Product_Order_Detail]  WITH CHECK ADD FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Products] ([Product_ID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([Category_ID])
REFERENCES [dbo].[GoodsCategories] ([Category_ID])
GO
ALTER TABLE [dbo].[Returns]  WITH CHECK ADD FOREIGN KEY([Order_Detail_ID])
REFERENCES [dbo].[Product_Order_Detail] ([Order_Detail_ID])
GO
ALTER TABLE [dbo].[Returns]  WITH CHECK ADD FOREIGN KEY([Order_ID])
REFERENCES [dbo].[Orders] ([Order_ID])
GO
ALTER TABLE [dbo].[Revenue]  WITH CHECK ADD FOREIGN KEY([SaleManager_ID])
REFERENCES [dbo].[SaleManager] ([SaleManager_ID])
GO
