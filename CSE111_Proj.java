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
						
					}else if(table == "customer"){
						
					}else if(table == "developer"){
						
					}else if(table == "game"){
						
					}else if(table == "inventory"){
						
					}else if(table == "region"){
						
					}else if(table == "sales"){
						
					}
					
				}	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("Insertion failed. Rollbacking...");
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
					
					if(table == "console"){
						
					}else if(table == "customer"){
						
					}else if(table == "developer"){
						
					}else if(table == "game"){
						
					}else if(table == "inventory"){
						
					}else if(table == "region"){
						
					}else if(table == "sales"){
						
					}
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("Updating failed. Rollbacking...");
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
