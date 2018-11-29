CREATE VIEW Customer_Inventory AS
SELECT DISTINCT c_name, i_gamekey, g_gamename, i_consolekey, con_name, i_price
FROM inventory, customer, game, console
WHERE i_custkey = c_custkey
  AND g_gamekey = i_gamekey
  AND con_consolekey = i_consolekey
ORDER BY c_name;