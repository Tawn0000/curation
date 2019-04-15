SELECT U_id, Wc_id, U_name, U_sex, U_icon, U_bluetooth_status,U_query_status,U_tag
FROM [dbo].[User]
WHERE U_id=1

INSERT INTO  [dbo].[User] (Wc_id, U_name, U_sex, U_icon, U_bluetooth_status,U_query_status,U_tag)
VALUES ('fag123','lingxiao','男','jfkafajflajf','关','是','cute')

Select *
From [dbo].[User]

Select *
From [dbo].[Admin]

describe Admin
ORDER BY a_id ASC


INSERT INTO [dbo].[Admin](a_Id,wc_id, a_password, a_name, a_level)
VALUES ('2','admin','123456','lingxiao','1')

Select *
From [dbo].[Comment]

Select *
From [dbo].[E_tag]

Select *
From [dbo].[Exhibit]

SELECT *
FROM  [dbo].[Exhibition]

SELECT *
FROM [dbo].[Feedback]

SELECT *
FROM [dbo].[Ibeacon]

SELECT *
FROM [dbo].[Record]

SELECT *
FROM [dbo].UE

SELECT *
FROM [dbo].[User]