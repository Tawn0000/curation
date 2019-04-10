SELECT U_id, Wc_id, U_name, U_sex, U_icon, U_bluetooth_status,U_query_status,U_tag
FROM [dbo].[User]
WHERE U_id=1

INSERT INTO  [dbo].[User] (Wc_id, U_name, U_sex, U_icon, U_bluetooth_status,U_query_status,U_tag)
VALUES ('fag123','lingxiao','男','jfkafajflajf','关','是','cute')

Select *
From [dbo].[User]