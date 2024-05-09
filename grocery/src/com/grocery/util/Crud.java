package com.grocery.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.grocery.groceryDAO.InterfaceImplementaion;
import com.grocery.grocerytest.GroceryTest;
import com.grocery.model.Grocery;
import com.grocery.model.UserRegister;

public class Crud {
	DbConnect db=new DbConnect();
	//UserRegister ur=new UserRegister();
	InterfaceImplementaion ii=new InterfaceImplementaion();
	
	GroceryTest groceytest=new GroceryTest();
	
	
		public void insert(UserRegister user) throws SQLException {
			String insertQuery = "insert into register (name, password,address,mobile) values (?,?,?,?)";
			Connection connection = db.getConnection();
			PreparedStatement ps=connection.prepareStatement(insertQuery);
			ps.setString(1,user.getName());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getAddress());
			ps.setString(4, user.getMobile());
			int rows = ps.executeUpdate();
			System.out.println(rows+" user registered sucessfully");
		}
		
		public void getUserPassword(UserRegister user,String name) throws SQLException {
			String getuser="select userid,name,password from register  where name=? ";
			Connection connection = db.getConnection();
			PreparedStatement ps=connection.prepareStatement(getuser);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		}
		
		public void getUserPasswordAdmin(UserRegister user,String name) throws SQLException {
			String getuser="select adminid,name,password from admin  where name=? ";
			Connection connection = db.getConnection();
			PreparedStatement ps=connection.prepareStatement(getuser);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		}
		
		public void insertProduct(Grocery grocery,UserRegister user) throws SQLException {
			//System.out.println("id from db "+user.getUserid());
			String insertproduct="insert into product(product,quantity,price,amount,userid)values(?,?,?,?,?)";
			Connection connection = db.getConnection();
			PreparedStatement ps=connection.prepareStatement(insertproduct);
			ps.setString(1,grocery.getProduct());
			ps.setInt(2,grocery.getQuantity());
			ps.setInt(3,grocery.getPrice());
			ps.setInt(4,grocery.getAmount());
			ps.setInt(5,user.getUserid());
			ps.executeUpdate();
		}
		
		public boolean cheakUser( UserRegister user )
	            throws ClassNotFoundException, SQLException {
	        String selectQuery = "select name,password from register where name= ? ";
	        Connection connection = db.getConnection();
	        PreparedStatement prepare = connection.prepareStatement(selectQuery);
	        prepare.setString(1, user.getName());
	        ResultSet rs = prepare.executeQuery();

	        if (!rs.next()) {
	        	return true;
	        } else {
	            System.out.println("Username already exists .");
	        }
			return false;
	        

	    }
		
		public void getProductList(UserRegister user) throws SQLException {
			String selectQuery="select product,quantity,price,amount from product where userid=?";
			 Connection connection = db.getConnection();
			 PreparedStatement prepare = connection.prepareStatement(selectQuery);
			 prepare .setInt(1,user.getUserid());
			 ResultSet rs = prepare.executeQuery();
			 while(rs.next()) {
				 System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"   "+rs.getInt(3)+"   "+rs.getInt(4));
			 }
		}
		
		public void updateUser(UserRegister user,int id) throws SQLException {
			String updateQuery="update register set name=?,password=?,address=?,mobile=? where userid=?";
			PreparedStatement ps=db.getConnection().prepareStatement(updateQuery);
			ps.setString(1,user.getName());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getAddress());
			ps.setString(4,user.getMobile());
			ps.setInt(5, id);
			ps.executeUpdate();
			System.out.println("updated sucessfully");
		}
		
		public void deleteUser(int id) throws SQLException {
			String deleteQuery="delete from register where userid=?;";
			PreparedStatement ps=db.getConnection().prepareStatement(deleteQuery);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("deleted sucessfully");
		}
		
		public void getAccounts() throws SQLException {
			String selectQuery="select userid,name,password,address,mobile from register";
			Statement stmt=db.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(selectQuery);
			System.out.println("id    name    password    address    mobile");
			System.out.println("*******************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
		}
		
		public void getAccount(UserRegister user) throws SQLException {
			String selectQuery="select  userid,name,password,address,mobile from register where userid=?";
			 Connection connection = db.getConnection();
		        PreparedStatement ps = connection.prepareStatement(selectQuery);
		        ps.setInt(1,user.getUserid());
		        ResultSet rs=ps.executeQuery();
		        System.out.println("id    name    password    address    mobile");
				System.out.println("*******************************************");
		        while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
		        }
		        
		}
		
		public void getPurchaseDetails(int id) throws SQLException {
			String selectQuery="select product,quantity,price,amount from product where userid=?";
			 PreparedStatement ps=db.getConnection().prepareStatement(selectQuery);
			 ps.setInt(1,id);
			 ResultSet rs=ps.executeQuery();
			 System.out.println("product    quantity    price    amount");
			 System.out.println("**************************************");
			 while(rs.next()) {
				 System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
			 }
		}
		
		
}
