package com.java.regex.javaReGex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ProductDAO {
	Connection getDBConnection(){
		   Connection conn=null;
		  try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/regex","root","" );
		  } catch (SQLException e) {
			e.printStackTrace();
		} 
		  return conn; 
	   }
	
	HashMap<Product,Integer> getProductInfo(){
		   HashMap<Product,Integer> pdInfo=new LinkedHashMap<Product,Integer>();
		   Connection conn=getDBConnection();
		   try {
			   Statement statement=conn.createStatement();
			   ResultSet rs=statement.executeQuery("select id,name,price from Product");
			   int i=0;
			   while(rs.next()) { //extracting data from 
				   Product product=new Product();
				   product.setPid(rs.getInt("id"));
				   product.setPname(rs.getString("name"));
				   product.setPprice(rs.getInt("price"));
			     pdInfo.put(product,i);
			     i++;
			   }
			   conn.close();

		   }
		   catch(SQLException e) {
			   e.printStackTrace();
		   }
		   return pdInfo;
	   }
	
	int bill(String s){
		   Connection conn=getDBConnection();
		   int price=0;
		   try {
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery("select price from Product where name= '"+s+"'"); 
			while(rs.next()) { //extracting data from 
			       price = rs.getInt("price");
			     
		    }
			conn.close();

		   } catch (SQLException e) {
			e.printStackTrace();
		}
		   
		   return price;
	   }

}
