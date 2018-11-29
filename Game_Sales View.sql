CREATE VIEW Game_Sales As
SELECT DISTINCT g_gamename, s_sales, con_name ,r_regionname
FROM sales, developer, game, region, console
WHERE s_gamekey = g_gamekey AND g_devkey = d_devkey AND r_regionkey = s_regionkey AND con_consolekey = s_consolekey
ORDER BY r_regionname, s_sales DESC;
