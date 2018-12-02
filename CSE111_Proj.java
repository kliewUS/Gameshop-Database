import java.sql.*;
import java.util.*;

//Project created by Khai-Yuan Liew and Kyle Stephan for CSE 111 Project 

public class CSE111_Proj {
	
	public static void insertTuple(Connection conn) throws SQLException{
		 PreparedStatement stat = null;
		 
		 String table = " ";
	     Scanner in = new Scanner (System.in);
		 
		 int input = 0;	 
		 
		 //1 - console
		 //2 - customer
		 //3 - developer
		 //4 - game
		 //5 - inventory
		 //6 - region
		 //7 - sales
		 
		 try {
			 
				while(input != -1){
					System.out.println("Choose a table to perform the insertion: ");
					System.out.println("Enter 1 to insert to console.");
					System.out.println("Enter 2 to insert to customer.");
					System.out.println("Enter 3 to insert to developer.");
					System.out.println("Enter 4 to insert to game.");
					System.out.println("Enter 5 to insert to inventory.");
					System.out.println("Enter 6 to insert to region.");
					System.out.println("Enter 7 to insert to sales.");
					System.out.println("Enter -1 to stop inserting.");
					input = in.nextInt();
					
					if(input == 1){
						table = "console";
					}else if (input == 2){
						table = "customer";
					}else if (input == 3){
						table = "developer";
					}else if (input == 4){
						table = "game";
					}else if (input == 5){
						table = "inventory";
					}else if (input == 6){
						table = "region";
					}else if (input == 7){
						table = "sales";
					}else if (input == -1){
						return;
					}else{
						return;
					}
					
					conn.setAutoCommit(false);
					 
					String SQL = " "; 
					
					if(table == "console"){
						
						System.out.println("Enter console key: ");
						int conkey = in.nextInt();					
						System.out.println("Enter console name: ");
						String name = in.next();
						System.out.println("Enter region key: ");
						int regkey = in.nextInt();
						System.out.println("Enter manufacturer name: ");
						String mfgr = in.next();
						System.out.println("Enter price: ");
						double price = in.nextDouble();
												
						SQL = "INSERT INTO " + table + "(con_consolekey, con_name, con_regionkey, con_mfgr, con_price) VALUES(?, ?, ?, ?, ?)"; 
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1,conkey);
						stat.setString(2, name);
						stat.setInt(3,regkey);
						stat.setString(4, mfgr);
						stat.setDouble(5, price);
												
					}else if(table == "customer"){
						
						System.out.println("Enter customer key: ");
						int custkey = in.nextInt();
						in.nextLine();
						System.out.println("Enter name: ");
						String name = in.nextLine();
						System.out.println("Enter phone: ");
						String phone = in.next();
						in.nextLine();
						System.out.println("Enter address: ");
						String address = in.nextLine();
						System.out.println("Enter Credit Card Num: ");
						String credcard = in.next();
												
						SQL = "INSERT INTO " + table + "(c_custkey, c_name, c_phone, c_address, c_credcardnum) VALUES(?, ?, ?, ?, ?)"; 
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1,custkey);
						stat.setString(2, name);
						stat.setString(3, phone);
						stat.setString(4, address);
						stat.setString(5, credcard);						
						
					}else if(table == "developer"){
						
						System.out.println("Enter developer key: ");
						int devkey = in.nextInt();
						in.nextLine();
						System.out.println("Enter developer name: ");
						String devname = in.nextLine();
						System.out.println("Enter publisher name: ");
						String publisher = in.nextLine();
						System.out.println("Enter office address: ");
						String officeaddress = in.nextLine();

												
						SQL = "INSERT INTO " + table + "(d_devkey, d_devname, d_publisher, d_officeaddress) VALUES(?, ?, ?, ?)"; 
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, devkey);
						stat.setString(2, devname);
						stat.setString(3, publisher);
						stat.setString(4, officeaddress);	
											
					}else if(table == "game"){
						
						System.out.println("Enter game key: ");
						int gamekey = in.nextInt();
						in.nextLine();
						System.out.println("Enter game name: ");
						String gamename = in.nextLine();
						System.out.println("Enter developer key: ");
						int devkey = in.nextInt();
						System.out.println("Enter region key: ");
						int regkey = in.nextInt();
						System.out.println("Enter price: ");
						double price = in.nextDouble();
						
						System.out.println("Enter release date: ");
						String releasedate = in.next(); //Must be in YYYY-MM-DD format
						
						System.out.println("Enter console key: ");
						int conkey = in.nextInt();
						
						SQL = "INSERT INTO " + table + "(g_gamekey, g_gamename, g_devkey, g_regionkey, g_price, g_releasedate, g_consolekey) VALUES(?, ?, ?, ?, ?, ?, ?)"; 
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, gamekey);
						stat.setString(2, gamename);
						stat.setInt(3, devkey);
						stat.setInt(4, regkey);
						stat.setDouble(5, price);
						stat.setString(6, releasedate);
						stat.setInt(7, conkey);
															
					}else if(table == "inventory"){
						
						System.out.println("Enter customer key: ");
						int custkey = in.nextInt();					
						System.out.println("Enter game key: ");
						int gamekey = in.nextInt();	
						System.out.println("Enter console key: ");
						int conkey = in.nextInt();	
						System.out.println("Enter price: ");
						double price = in.nextDouble();

												
						SQL = "INSERT INTO " + table + "(i_custkey, i_gamekey, i_consolekey, i_price) VALUES(?, ?, ?, ?)"; 
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, custkey);
						stat.setInt(2, gamekey);
						stat.setInt(3, conkey);
						stat.setDouble(4, price);
						
					}else if(table == "region"){
						
						System.out.println("Enter region key: ");
						int devkey = in.nextInt();
						in.nextLine();
						System.out.println("Enter region name: ");
						String devname = in.nextLine();
												
						SQL = "INSERT INTO " + table + "(r_regionkey, r_regionname) VALUES(?, ?)"; 
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, devkey);
						stat.setString(2, devname);
						
						
					}else if(table == "sales"){
						
						System.out.println("Enter game key: ");
						int gamekey = in.nextInt();	
						System.out.println("Enter console key: ");
						int conkey = in.nextInt();	
						System.out.println("Enter region key: ");
						int regkey = in.nextInt();
						System.out.println("Enter number of sales: ");
						int sales = in.nextInt();
												
						SQL = "INSERT INTO " + table + "(s_gamekey, s_consolekey, s_regionkey, s_sales) VALUES(?, ?, ?, ?)"; 
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, gamekey);
						stat.setInt(2, conkey);
						stat.setInt(3, regkey);
						stat.setInt(4, sales);					
					}
					
					stat.executeUpdate();
					
					System.out.println("Record successfully inserted");
								
					conn.commit(); //End Transaction
					
					
				}

									
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("Deletion failed. Rollbacking...");
			conn.rollback();
		}
		 
	}
	
	public static void deleteTuple(Connection conn) throws SQLException{
		 PreparedStatement stat = null;
		 
		 String table = " ";
	     Scanner in = new Scanner (System.in);
		 
		 int input = 0;	 
		 
		 try {
				while(input != -1){
					System.out.println("Choose a table to perform the deletion: ");
					System.out.println("Enter 1 to delete tuple(s) to console.");
					System.out.println("Enter 2 to delete tuple(s) to customer.");
					System.out.println("Enter 3 to delete tuple(s) to developer.");
					System.out.println("Enter 4 to delete tuple(s) to game.");
					System.out.println("Enter 5 to delete tuple(s) to inventory.");
					System.out.println("Enter 6 to delete tuple(s) to region.");
					System.out.println("Enter 7 to delete tuple(s) to sales.");
					System.out.println("Enter -1 to stop deleting.");
					input = in.nextInt();
					
					if(input == 1){
						table = "console";
					}else if (input == 2){
						table = "customer";
					}else if (input == 3){
						table = "developer";
					}else if (input == 4){
						table = "game";
					}else if (input == 5){
						table = "inventory";
					}else if (input == 6){
						table = "region";
					}else if (input == 7){
						table = "sales";
					}else if (input == -1){
						return;
					}else{
						return;
					}
					
					conn.setAutoCommit(false);
					 
					String SQL = " ";
					
					if(table == "console"){
						
						System.out.println("Enter 1 if you want to delete a console from the database");
						System.out.println("Enter 2 if you want to delete a console in a region from the database");
						System.out.println("Enter any key to terminate the deletion.");
						int prompt = in.nextInt();
						
						if(prompt == 1){
							
							System.out.println("Enter the console key: ");
							int conkey = in.nextInt();
							
							SQL = "DELETE FROM " + table + " WHERE con_consolekey = ?";
							
							stat = conn.prepareStatement(SQL);
												
							stat.setInt(1, conkey);
							
							
						}else if (prompt == 2){
							
							System.out.println("Enter the console key: ");
							int conkey = in.nextInt();
							
							System.out.println("Enter the region key: ");							
							int regionkey = in.nextInt();
							
							SQL = "DELETE FROM " + table + " WHERE con_consolekey = ? AND con_regionkey = ?";
							
							stat = conn.prepareStatement(SQL);
												
							stat.setInt(1, conkey);
							stat.setInt(2, regionkey);
							
						}else{
							return;
						}
						
					}else if(table == "customer"){
						//1. Delete by c_key - Doesn't exist anymore
						
						System.out.println("Enter the customer key: ");
						int custkey = in.nextInt();
						
						SQL = "DELETE FROM " + table + " WHERE c_custkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, custkey);
						
					}else if(table == "developer"){
						//1. Delete by d_key - Doesn't exist anymore
						//2. Delete by d_publisher - Doesn't exist anymore
						
						System.out.println("Enter 1 if you want to delete a specified developer from the DB");
						System.out.println("Enter 2 if you want to delete a specified publisher from the DB");
						System.out.println("Enter any key to terminate the deletion.");
						int prompt = in.nextInt();
						
						if(prompt == 1){
							
						System.out.println("Enter the developer key: ");
						int devkey = in.nextInt();
						
						SQL = "DELETE FROM " + table + " WHERE d_devkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, devkey);
						
							
						}else if(prompt == 2){
							
						in.nextLine();
						
						System.out.println("Enter the publisher name: ");
						String pubname = in.nextLine();
						
						SQL = "DELETE FROM " + table + " WHERE d_publisher = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setString(1, pubname);
						
							
						}else{
							return;
						}
						
						
					}else if(table == "game"){
						//Save for last.
						//1. Delete by gamekey - Doesn't exist anymore/Not selling well.
						//2. Delete by devkey - Doesn't exist anymore/Liquidated.
						//3. Delete by regionkey with either dev or gamekey - Not selling well.
						//4. Delete old games (release date)
						//5. Delete by console key based on gamekey and/or region
						System.out.println("Enter 1 if you want to delete a specified game");
						System.out.println("Enter 2 if you want to delete all games from a developer");
						System.out.println("Enter 3 if you want to delete a specified game from a region");
						System.out.println("Enter 4 if you want to delete records that are released eariler than the specified date");
						System.out.println("Enter 5 if you want to delete a game in a specified console platform in a region");
						System.out.println("Enter any key to terminate the deletion.");
						int prompt = in.nextInt();
						
						if(prompt == 1){
							
						System.out.println("Enter the game key: ");
						int gamekey = in.nextInt();
							
						SQL = "DELETE FROM " + table + " WHERE g_gamekey = ?";
							
						stat = conn.prepareStatement(SQL);
							
						stat.setInt(1, gamekey);
							
						}else if(prompt == 2){
							
						System.out.println("Enter the developer key: ");
						int devkey = in.nextInt();
								
						SQL = "DELETE FROM " + table + " WHERE g_devkey = ?";
								
						stat = conn.prepareStatement(SQL);
								
						stat.setInt(1, devkey);
							
						}else if(prompt == 3){
							
						System.out.println("Enter the game key: ");
						int gamekey = in.nextInt();
						
						System.out.println("Enter the region key: ");
						int regionkey = in.nextInt();
								
						SQL = "DELETE FROM " + table + " WHERE g_gamekey = ? AND g_regionkey = ?";
								
						stat = conn.prepareStatement(SQL);
								
						stat.setInt(1, gamekey);
						stat.setInt(2, regionkey);
							
						}else if(prompt == 4){
							
						System.out.println("Enter the date: ");
					    String date = in.next();							
							
						SQL = "DELETE FROM " + table + " WHERE g_releasedate <= ?";
							
						stat = conn.prepareStatement(SQL);
									
						stat.setString(1, date);
							
						}else if(prompt == 5){
							
						System.out.println("Enter the game key: ");
						int gamekey = in.nextInt();
							
						System.out.println("Enter the region key: ");
						int regionkey = in.nextInt();
						
						System.out.println("Enter the console key: ");
						int conkey = in.nextInt();
									
						SQL = "DELETE FROM " + table + " WHERE g_gamekey = ? AND g_regionkey = ? AND g_consolekey = ?";
									
						stat = conn.prepareStatement(SQL);
									
						stat.setInt(1, gamekey);
						stat.setInt(2, regionkey);
						stat.setInt(3, conkey);
							
						}else{
							
						}
						
						
					}else if(table == "inventory"){
						//1. Delete custkey due to canceled/fulfilled order.
						System.out.println("Enter the customer key: ");
						int custkey = in.nextInt();
						
						SQL = "DELETE FROM " + table + " WHERE i_custkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, custkey);
						
					}else if(table == "region"){
						//1. Delete by regionkey
						System.out.println("Enter the region key: ");
						int regionkey = in.nextInt();
						
						SQL = "DELETE FROM " + table + " WHERE r_regionkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, regionkey);
						
					}else if(table == "sales"){
						//1. Delete sales less than a set amount
						System.out.println("Enter amount of sales: ");
						int sales = in.nextInt();
						
						SQL = "DELETE FROM " + table + " WHERE s_sales < ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, sales);
					}
	
					int del = stat.executeUpdate();
					
					System.out.println(del + " Record(s) successfully deleted");
					
					conn.commit();
					
				}	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("Delete failed. Rollbacking...");
			conn.rollback();
		}		
	}
	
	public static void updateTuple(Connection conn) throws SQLException{
		 PreparedStatement stat = null;
		 
		 String table = " ";
	     Scanner in = new Scanner (System.in);
		 
		 int input = 0;	 
		 
		 try {
				while(input != -1){
					System.out.println("Choose a table to perform the update: ");
					System.out.println("Enter 1 to update tuple(s) to console.");
					System.out.println("Enter 2 to update tuple(s) to customer.");
					System.out.println("Enter 3 to update tuple(s) to developer.");
					System.out.println("Enter 4 to update tuple(s) to game.");
					System.out.println("Enter 5 to update tuple(s) to inventory.");
					System.out.println("Enter 6 to update tuple(s) to region.");
					System.out.println("Enter 7 to update tuple(s) to sales.");
					System.out.println("Enter -1 to stop updating.");
					input = in.nextInt();
					
					if(input == 1){
						table = "console";
					}else if (input == 2){
						table = "customer";
					}else if (input == 3){
						table = "developer";
					}else if (input == 4){
						table = "game";
					}else if (input == 5){
						table = "inventory";
					}else if (input == 6){
						table = "region";
					}else if (input == 7){
						table = "sales";
					}else if (input == -1){
						return;
					}else{
						return;
					}
					
					conn.setAutoCommit(false);
					 
					String SQL = " ";
					
					//Should not be changing up keys.
					if(table == "console"){
						//1. Price Rise/Reduction
						
						System.out.println("Enter the console key you want to update: ");
						int conkey = in.nextInt();
						
						System.out.println("Enter the region key you want to update: ");
						int regionkey = in.nextInt();
						
						System.out.println("Enter the price: ");
						double price = in.nextDouble();
						
						
						SQL = "UPDATE " + table + " SET con_price = ? " + " WHERE con_consolekey = ? AND con_regionkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setDouble(1, price);
						stat.setInt(2, conkey);
						stat.setInt(3, regionkey);
						
						
					}else if(table == "customer"){
						//1. c_name - Person under new name.
						//2. c_phone - Changed Phone num.
						//3. c_address - Change address/Moved
						//4. c_credcardnum - Changed Credit Cards.
						
						System.out.println("Enter 1 if you want to update a customer name");
						System.out.println("Enter 2 if you want to update a customer phone number");
						System.out.println("Enter 3 if you want to update a customer address");
						System.out.println("Enter 4 if you want to update a customer credcardnum");						
						System.out.println("Enter any key to terminate the update.");
						int prompt = in.nextInt();
						
						if(prompt == 1){
							
						System.out.println("Enter the customer key you want to update: ");
						int custkey = in.nextInt();
						
						in.nextLine();
						
						System.out.println("Enter the new name: ");
						
						String name = in.nextLine();
							
						SQL = "UPDATE " + table + " SET c_name = ? " + " WHERE c_custkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setString(1, name);
						stat.setInt(2, custkey);
							
						}else if(prompt == 2){
							
						System.out.println("Enter the customer key you want to update: ");
						int custkey = in.nextInt();
							
						System.out.println("Enter the new phone number: ");
							
						String phonenum = in.next();
						
						SQL = "UPDATE " + table + " SET c_phone = ? " + " WHERE c_custkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setString(1, phonenum);
						stat.setInt(2, custkey);
							
						}else if(prompt == 3){
							
						System.out.println("Enter the customer key you want to update: ");
						int custkey = in.nextInt();
						
						in.nextLine();
								
						System.out.println("Enter the new address: ");
								
						String address = in.nextLine();
							
						SQL = "UPDATE " + table + " SET c_address = ? " + " WHERE c_custkey = ?";
							
						stat = conn.prepareStatement(SQL);
							
						stat.setString(1, address);
						stat.setInt(2, custkey);
							
						}else if(prompt == 4){
							
						System.out.println("Enter the customer key you want to update: ");
						int custkey = in.nextInt();
									
						System.out.println("Enter the new credit card number: ");
									
						String credcardnum = in.next();
								
						SQL = "UPDATE " + table + " SET c_credcardnum = ? " + " WHERE c_custkey = ?";
								
						stat = conn.prepareStatement(SQL);
								
						stat.setString(1, credcardnum);
						stat.setInt(2, custkey);
							
						}else{
							return;
						}
						
						
					}else if(table == "developer"){
						//1. d_name - Renamed
						//2. d_publisher - Changed Ownership or Renamed.
						//3. d_address - Changed address.
						
						System.out.println("Enter 1 if you want to update a developer name");
						System.out.println("Enter 2 if you want to update a publisher name");
						System.out.println("Enter 3 if you want to update an office address");						
						System.out.println("Enter any key to terminate the update.");
						int prompt = in.nextInt();
						
						if(prompt == 1){
							
						System.out.println("Enter the developer key you want to update: ");
						int devkey = in.nextInt();
						
						in.nextLine();
						
						System.out.println("Enter the new developer name: ");
						
						String devname = in.nextLine();
						
						SQL = "UPDATE " + table + " SET d_devname = ? " + " WHERE d_devkey = ?";
						
						stat = conn.prepareStatement(SQL);
								
						stat.setString(1, devname);
						stat.setInt(2, devkey);
							
						}else if(prompt == 2){
						
						in.nextLine();
						
						System.out.println("Enter the publisher name you want to update: ");
						
						String pubname_in = in.nextLine();
						
						System.out.println("Enter the new publisher name: ");
						
						String pubname_out = in.nextLine();	
						
						SQL = "UPDATE " + table + " SET d_publisher = ? " + " WHERE d_publisher = ?";
						
						stat = conn.prepareStatement(SQL);
						
								
						stat.setString(1, pubname_out);
						stat.setString(2, pubname_in);
						
							
						}else if(prompt == 3){
							
						System.out.println("Enter the developer key you want to update: ");
						int devkey = in.nextInt();
							
						in.nextLine();
							
						System.out.println("Enter the new developer name: ");
							
						String address = in.nextLine();
							
						SQL = "UPDATE " + table + " SET d_officeaddress = ? " + " WHERE d_devkey = ?";
							
						stat = conn.prepareStatement(SQL);
									
						stat.setString(1, address);
						stat.setInt(2, devkey);
							
						}else{
							return;
						}
						
						
					}else if(table == "game"){
						//1. g_price with specifed regionkey, consolekey, gamekey. Price rise/reduction
						
						System.out.println("Enter the console key you want to update to: ");
						int conkey = in.nextInt();
						
						System.out.println("Enter the region key you want to update to: ");
						int regionkey = in.nextInt();
						
						System.out.println("Enter the game key you want to update to: ");
						int gamekey = in.nextInt();
						
						System.out.println("Enter the price: ");
						double price = in.nextDouble();
						
						SQL = "UPDATE " + table + " SET g_price = ? " + " WHERE g_consolekey = ? AND g_regionkey = ? AND g_gamekey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setDouble(1, price);
						stat.setInt(2, conkey);
						stat.setInt(3, regionkey);
						stat.setInt(4, gamekey);
						
						
					}else if(table == "inventory"){
						//1. i_gamekey with i_consolekey and i_price changing.
						
						System.out.println("Enter the customer key you want to update: ");
						int custkey = in.nextInt();
						
						System.out.println("Enter the game key you want to update: ");
						int gamekey_out = in.nextInt();
						
						System.out.println("Enter the console key you want to update: ");
						int conkey_out = in.nextInt();
						
						System.out.println("Enter the new game key: ");
						int gamekey_in = in.nextInt();
						
						System.out.println("Enter the new console key: ");
						int conkey_in = in.nextInt();
						
						System.out.println("Enter the price: ");
						double price = in.nextDouble();
						
						SQL = "UPDATE " + table + " SET i_gamekey = ?, i_consolekey = ?, i_price = ? " + " WHERE i_custkey = ? AND i_gamekey = ? AND i_consolekey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, gamekey_in);
						stat.setInt(2, conkey_in);
						stat.setDouble(3, price);
						stat.setInt(4, custkey);
						stat.setInt(5, gamekey_out);
						stat.setInt(6, conkey_out);
						
						
					}else if(table == "region"){
						//1. Change region name? Why do that? (Might remove later.)
						
						System.out.println("Enter the region key you want to update to: ");
						int regionkey = in.nextInt();
						
						System.out.println("Enter the new region name");
						String region_name = in.next();
						
						SQL = "UPDATE " + table + " SET r_regionname = ? " + " WHERE r_regionkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setString(1, region_name);
						stat.setInt(2, regionkey);
						
					}else if(table == "sales"){
						//1. Change sales to reflect current sales.
						
						System.out.println("Enter the game key you want to update to: ");
						int gamekey = in.nextInt();
						
						System.out.println("Enter the console key you want to update to: ");
						int conkey = in.nextInt();
						
						System.out.println("Enter the region key you want to update to: ");
						int regionkey = in.nextInt();
						
						System.out.println("Enter the number of sales: ");
						int sales = in.nextInt();
						
						SQL = "UPDATE " + table + " SET s_sales = ? " + " WHERE s_gamekey = ? AND s_consolekey = ? AND s_regionkey = ?";
						
						stat = conn.prepareStatement(SQL);
						
						stat.setInt(1, sales);
						stat.setInt(2, gamekey);
						stat.setInt(3, conkey);
						stat.setInt(4, regionkey);						
					}
					
					int up = stat.executeUpdate();
					
					System.out.println(up + " Record(s) successfully updated");
					
					conn.commit();
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("Updating failed. Rollbacking...");
			conn.rollback();
		}		
	}
	
    public static void select(Connection conn) throws SQLException{
        PreparedStatement stat = null;

        String table = " ";
        Scanner in = new Scanner (System.in);

        int input = 0;

        //1 - console
        //2 - customer
        //3 - developer
        //4 - game
        //5 - inventory
        //6 - region
        //7 - sales

        try {

            while(input != -1){
                System.out.println("Choose a Query to Execute: ");
                System.out.println("Enter 1 to select customer inventory.");
                System.out.println("Enter 2 to insert to customer.");
                System.out.println("Enter 3 to insert to developer.");
                System.out.println("Enter 4 to insert to game.");
                System.out.println("Enter 5 to insert to inventory.");
                System.out.println("Enter 6 to insert to region.");
                System.out.println("Enter 7 to insert to sales.");
                System.out.println("Enter -1 to stop inserting.");
                input = in.nextInt();

                if(input == 1){
                    table = "customerinventory";
                }else if (input == 2){
                    table = "customer";
                }else if (input == 3){
                    table = "developer";
                }else if (input == 4){
                    table = "game";
                }else if (input == 5){
                    table = "inventory";
                }else if (input == 6){
                    table = "region";
                }else if (input == 7){
                    table = "sales";
                }else if (input == -1){
                    return;
                }else{
                    return;
                }

                conn.setAutoCommit(false);

                String SQL = " ";

                if(table == "customerinventory"){

                }else if(table == "customer"){
                	
                }else if(table == "developer"){

                }else if(table == "game"){

                }else if(table == "inventory"){


                }else if(table == "region"){


                }else if(table == "sales"){

                }

                stat.executeUpdate();

                System.out.println("Record successfully inserted");

                conn.commit(); //End Transaction


            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("Deletion failed. Rollbacking...");
            conn.rollback();
        }

    }	
	

	public static void main(String[] args) throws ClassNotFoundException{
	      Class.forName("org.sqlite.JDBC");

	      Scanner in = new Scanner (System.in);
	      Connection connection = null;
	      
		try {
			int input = 0;
			connection = DriverManager.getConnection("jdbc:sqlite:CSE111_Project.db");
			System.out.println("GameShop Database Version 1 (11/28/2018). Manager Use Only.\n");
			
			while(input != -1){				
				System.out.println("Welcome to the GameShop Database! Please make an option.\n");
				System.out.println("Enter 1 to insert a tuple to a specified table.");
				System.out.println("Enter 2 to delete tuple(s) to a specified table.");
				System.out.println("Enter 3 to make an update to a specified table.");
				System.out.println("Enter 4 to execute queries.");
				System.out.println("Enter -1 to terminate program.");
				input = in.nextInt();
				
				if(input == 1){
					//INSERT
					insertTuple(connection);
				}else if(input == 2){
					//DELETE
					deleteTuple(connection);
				}else if(input == 3){
					//UPDATE
					updateTuple(connection);
				}else if(input == 4){
					//SELECT
					select(connection);
					//Put a method to implement select statement.
					
					System.out.println("Functionality Coming Soon!");
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				System.out.println("Closing database...");
			} catch (SQLException e) { 
				System.err.println(e);
			}
		}

	}

}
