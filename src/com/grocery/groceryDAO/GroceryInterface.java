package com.grocery.groceryDAO;

import java.sql.SQLException;

import com.grocery.model.UserRegister;
import com.grocery.util.Crud;

public interface GroceryInterface {
	
	public void getuserDetails(UserRegister userregister,Crud connect) throws SQLException;
	public boolean loginCredencial(Crud connect,UserRegister userregister) throws SQLException;
	public abstract boolean adminLoginCredencial(Crud connect,UserRegister userregister) throws SQLException ;
	public abstract void updateAccount(Crud connect,UserRegister userregister) throws SQLException;
	public abstract void deleteAccount(Crud connect) throws SQLException;
	public abstract void getAccounts(Crud connect) throws SQLException;
	public abstract void getaccount(Crud connect,UserRegister userregister) throws SQLException;
	public abstract void getPurchaseDetails(Crud connect) throws SQLException;
}
