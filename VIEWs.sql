
CREATE VIEW Game_Sales As
SELECT DISTINCT g_gamename, s_sales, con_name ,r_regionname
FROM sales, developer, game, region, console
WHERE s_gamekey = g_gamekey AND g_devkey = d_devkey AND r_regionkey = s_regionkey AND con_consolekey = s_consolekey
ORDER BY r_regionname, s_sales DESC;


CREATE VIEW Customer_Inventory AS
SELECT DISTINCT c_name, i_gamekey, g_gamename, i_consolekey, con_name, i_price
FROM inventory, customer, game, console
WHERE i_custkey = c_custkey
  AND g_gamekey = i_gamekey
  AND con_consolekey = i_consolekey
ORDER BY c_name;

CREATE VIEW Game_Info As
SELECT DISTINCT g_gamename, g_price, g_releasedate, con_name, d_devname
FROM developer, game, console, region
WHERE g_devkey = d_devkey AND  con_consolekey = g_consolekey AND g_regionkey = r_regionkey AND r_regionkey = 0
ORDER BY g_gamename;


CREATE VIEW GamebyDev As
SELECT DISTINCT d_devname, g_gamename, g_price, con_name
FROM developer, game, console
WHERE d_devkey = g_devkey AND g_consolekey = con_consolekey
ORDER BY d_devname;


