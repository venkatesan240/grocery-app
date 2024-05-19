package com.grocery.grocerydao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.grocery.model.UserRegister;
import com.grocery.util.Crud;

public  class InterfaceImplementaion implements GroceryInterface{
	Scanner scan=new Scanner(System.in);
	int j=0;
	Validation valid=new Validation();
	public boolean loginCredencial(Crud connect,UserRegister userregister) throws SQLException {
	    System.out.println("TO LOGIN");
	    System.out.println("--------");
	    
	    while(true) {
	        System.out.println("Enter userName:");
	        String username = scan.next();
	        
	        boolean userFound = false;
	        
	        connect.getUserPassword(userregister,username);
	      //  for(UserRegister user : GroceryTest.userCredentialsList) {
	            if(username.equals(userregister.getName())) {
	                userFound = true;
	                
	                while(true) {
	                    System.out.println("Enter password:");
	                    String password = scan.next();
	                    
	                    if(password.equals(userregister.getPassword())) {
	                        return true; // Login successful
	                    } else {
	                        System.out.println("Invalid password. Please enter the correct password.");
	                    }
	                }
	            }
	      //  }
	        
	        if(!userFound) {
	            System.out.println("Invalid username. Please enter the correct username.");
	        }
	    }
	}

	@Override
	public void getuserDetails(UserRegister userregister, Crud connect) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("USER REGISTOR");
				System.out.println("-------------");
				while(true) {
					System.out.println("enter your name:");
					String name=scan.next();
					if(valid.name(name)) {
						userregister.setName(name);
						try {
							if(!connect.cheakUser(userregister)) {
								System.out.println("enter your name:");
								String name1=scan.next();
								userregister.setName(name1);
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					}
					System.out.println("invalid name");
				}
				while(true) {
					System.out.println("create password:");
					String password=scan.next();
					if(valid.password(password)) {
						userregister.setPassword(password);
						break;
					}
					System.out.println("invalid password");
				}
				while(true) {
					System.out.println("enter your address:");
					scan.nextLine();
					String address=scan.nextLine();
					if(valid.address(address)) {
						userregister.setAddress(address);
						break;
					}
					System.out.println("invalid address,please enter alphabets");
				}
				while(true) {
					System.out.println("enter your mobile");
					String mobile=scan.next();
					if(valid.mobile(mobile)) {
						userregister.setMobile(mobile);
						System.out.println("Registered Sucessfully");
						break;
					}
					System.out.println("invalid mobile,please enter 10 numbers");
				}
				connect.insert(userregister);
		       // GroceryTest.userCredentialsList.add(new UserRegister(j++,userregister.getName(), userregister.getPassword()));
				//return userregister;
				
	}

	@Override
	public void updateAccount( Crud connect,UserRegister userregister) throws SQLException {
		// TODO Auto-generated method stub
		int id=getId();
		while(true) {
			System.out.println("Enter the name");
			scan.nextLine();
			String name=scan.nextLine();
			if(valid.name(name)) {
				userregister.setName(name);
				break;
			}
			System.out.println("invalid name");
		}
		while(true) {
			System.out.println("create password:");
			String password=scan.next();
			if(valid.password(password)) {
				userregister.setPassword(password);
				break;
			}
			System.out.println("invalid password");
		}
		while(true) {
			System.out.println("enter your address:");
			scan.nextLine();
			String address=scan.nextLine();
			if(valid.address(address)) {
				userregister.setAddress(address);
				break;
			}
			System.out.println("invalid address,please enter alphabets");
		}
		while(true) {
			System.out.println("enter your mobile");
			String mobile=scan.next();
			if(valid.mobile(mobile)) {
				userregister.setMobile(mobile);
				break;
			}
			System.out.println("invalid mobile,please enter 10 numbers");
		}

		connect.updateUser(userregister, id);
	}

	@Override
	public void deleteAccount(Crud connect) throws SQLException {
		// TODO Auto-generated method stub
		connect.deleteUser(getId());
		
	}

	@Override
	public void getAccounts(Crud connect) throws SQLException {
		// TODO Auto-generated method stub
		connect.getAccounts();
	}

	@Override
	public boolean adminLoginCredencial(Crud connect, UserRegister userregister) throws SQLException {
		// TODO Auto-generated method stub
		 while(true) {
		        System.out.println("Enter userName:");
		        String username = scan.next();
		        
		        boolean userFound = false;
		        
		        connect.getUserPasswordAdmin(userregister,username);
		      //  for(UserRegister user : GroceryTest.userCredentialsList) {
		            if(username.equals(userregister.getName())) {
		                userFound = true;
		                
		                while(true) {
		                    System.out.println("Enter password:");
		                    String password = scan.next();
		                    
		                    if(password.equals(userregister.getPassword())) {
		                        return true; // Login successful
		                    } else {
		                        System.out.println("Invalid password. Please enter the correct password.");
		                    }
		                }
		            }
		      //  }
		        
		        if(!userFound) {
		            System.out.println("Invalid username. Please enter the correct username.");
		        }
		    }
	}

	@Override
	public void getaccount(Crud connect,UserRegister userregister) throws SQLException {
		// TODO Auto-generated method stub
		connect.getAccount(userregister);        
	}

	@Override
	public void getPurchaseDetails(Crud connect) throws SQLException {
		// TODO Auto-generated method stub
		connect.getPurchaseDetails(getId());
	}
	
	public int getId() {
		int id = 0;
		try {
		System.out.println("Enter the id:");
		id=scan.nextInt();
		}catch(InputMismatchException e) {
			System.out.println(e);
		}
		return id;
	}

	


	
	

	

}
