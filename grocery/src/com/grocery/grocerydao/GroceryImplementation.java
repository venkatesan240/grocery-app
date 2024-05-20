package com.grocery.grocerydao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.grocery.model.Grocery;
import com.grocery.model.UserRegister;
import com.grocery.util.Crud;

public class GroceryImplementation {
	Scanner scan=new Scanner(System.in);
	int quantity,amount,totalAmount=0;
	//Grocery grocery=new Grocery();
	AbtractImplementation ai=new AbtractImplementation();
	//InterfaceImplementaion ii=new InterfaceImplementaion();
	//UserRegister userregister=new UserRegister();
	Crud connect=new Crud();
	Validation validate=new Validation();
	int choice,i=0;
	ArrayList<Grocery> productList = new ArrayList<>();
	
	public void priceCalculator(String product,int price,Grocery grocery,UserRegister user) throws SQLException {
		 
		while(true) {
			System.out.println("Enter quantity:");
			quantity = scan.nextInt();
			if(validate.Numbers(quantity)) {
				int amount=quantity*price;
				System.out.println("amount for "+product+" is:"+amount);
				productList.add(new Grocery(quantity,amount,product,price));
				totalAmount=totalAmount+amount;
			    grocery.setTotalamount(totalAmount);
			    i++;
				break;
			}
		}
	}
	
	public void getDiscount(Grocery grocery) {
		double discount;
		int totalamount=grocery.getTotalamount();
		if(totalamount>500) {
			discount=totalamount*0.1;
			System.out.println("after discount price:"+(totalamount-discount));
		}else if(totalamount>1000) {
			discount=totalamount*0.2;
			System.out.println("after discount price:"+(totalamount-discount));
		}
	}
	
	//public UserRegister getDetails() {
		//GroceryTest test  = new GroceryTest();
		//UserRegister userregister = ii.getUserDetails(userregister);
		//System.out.println(loginCredencials);
		//return userregister;
	//}
	
//	public boolean loginCredencial() {
//	    System.out.println("TO LOGIN");
//	    System.out.println("--------");
//	    
//	    while(true) {
//	        System.out.println("Enter userName:");
//	        String username = scan.next();
//	        
//	        boolean userFound = false;
//	        
//	      //  for(UserRegister user : GroceryTest.userCredentialsList) {
//	            if(username.equals(user.getName())) {
//	                userFound = true;
//	                
//	                while(true) {
//	                    System.out.println("Enter password:");
//	                    String password = scan.next();
//	                    
//	                    if(password.equals(user.getPassword())) {
//	                        return true; // Login successful
//	                    } else {
//	                        System.out.println("Invalid password. Please enter the correct password.");
//	                    }
//	                }
//	            }
//	      //  }
//	        
//	        if(!userFound) {
//	            System.out.println("Invalid username. Please enter the correct username.");
//	        }
//	    }
//	}

	public void getBill(UserRegister user,Grocery grocery) throws SQLException {
		System.out.println("**********************************");
		System.out.println("       VENKATESAN AGENCY          ");
		System.out.println("**********************************");
		System.out.println("product   quantity   price  amount");
		System.out.println("**********************************");
		for(Grocery grocery1:productList) {
			System.out.println(grocery1.getProduct()+"\t"+grocery1.getQuantity()+"\t"+grocery1.getPrice()+"\t"+grocery1.getAmount());
		}
		//connect.getProductList(user);
//		for(int j=0;j<i;j++) {
//			System.out.println(grocery.product[j]+"       "+grocery.price[j]+"       "+grocery.quantity[j]+"       "+grocery.amount[j]);
//		}
		System.out.println("**********************************");
		System.out.println("Total amount :                "+grocery.getTotalamount());
		System.out.println("**********************************");
	}
	
	public void makePayment(Grocery grocery,Crud connect,UserRegister user) throws SQLException {
		System.out.println("enter payment mode:");
		System.out.println("1.online");
		System.out.println("2.cash on delivery");
		choice=scan.nextInt();
		switch(choice) {
		case 1:
			while(true) {
			System.out.println("enter the online payment mode(upi/credit/debit)");
			String payment=scan.next();
			if(payment.equals("upi") || payment.equals("credit") || payment.equals("debit")) {
				Random rand=new Random();
				int max=10000,min=1000;
				int ramdom = rand.nextInt(max - min + 1) + min;
				System.out.println("Enter payment id("+ramdom+"):");
				int payId=scan.nextInt();
				if(payId == ramdom) {
					System.out.println("payable amount:"+grocery.getTotalamount());
					System.out.println("please enter yes to confirm:");
					String sh=scan.next();
					if(sh.equals("yes")) {
						connect.insertPrice(grocery.getTotalamount(),user);
						System.out.println("payment sucessfull...");
						break;
					}else {
						
						System.out.println("payment failed..");
					}
				}else {
					System.out.println("Wrong id please re-enter");
				}
				
			}else {
				System.out.println("please enter valid input");
			}
			}
			break;
		case 2:
			System.out.println("your product will delivered at tomorrow");
			break;
		}
	}
	public void productList() {
		System.out.println("\n1.dry fruits");
		System.out.println("2.snacks");
		System.out.println("3.cookingOil");
		System.out.println("4.beverages");
		System.out.println("5.spices");
		System.out.println("6.rices");
		System.out.println("7.biscuits");
		System.out.println("please enter 1 to 7");
	}
	
	
	public void getBiscuit(Grocery grocery,UserRegister user) throws SQLException {
		do {
			System.out.println("1.milkbiscuit(30 rs)");
			System.out.println("2.marrygold(30rs)");
			System.out.println("3.darkfantasy(40rs)");
			System.out.println("4.bourbon(30rs)");
			System.out.println("5.exit");
			choice=scan.nextInt();
			switch(choice) {
			case 1:
				priceCalculator("milkbiscuit",30,grocery,user);
				break;
			case 2:
				priceCalculator("marrygold",30,grocery,user);
				break;
			case 3:
				priceCalculator("darkfantasy",40,grocery,user);
				break;
			case 4:
				priceCalculator("bourbon",30,grocery,user);
				break;
			}
		}while(choice!=5);
	}
	
		public void getDryFruits(Grocery grocery,UserRegister user) throws SQLException {
			
			do {
				System.out.println("1.almont(40Rs)");
				System.out.println("2.dates(80Rs)");
				System.out.println("3.cashew nuts(100Rs)");
				System.out.println("4.exit");
				choice=scan.nextInt();
				switch(choice) {
				case 1:
					priceCalculator("almond",40,grocery,user);
					break;
				case 2:
					priceCalculator("dates",80,grocery,user);
					break;
				case 3:
					priceCalculator("cashew nuts",100,grocery,user);
					break;
				}
			}while(choice!=4);
		}
		
		public void getSnacks(Grocery grocery,UserRegister user) throws SQLException {
			do {
				System.out.println("1.kurkura(20Rs)");
				System.out.println("2.lays(20Rs)");
				System.out.println("3.murukku(40Rs)");
				System.out.println("4.chips(10Rs)");
				System.out.println("5.exit");
				choice=scan.nextInt();
				switch(choice) {
				case 1:
					priceCalculator("kurkura",20,grocery,user);
					break;
				case 2:
					priceCalculator("lays",20,grocery,user);
					break;
				case 3:
					priceCalculator("murukku",40,grocery,user);
					break;
				case 4:
					priceCalculator("chips",10,grocery,user);
					break;
				}
			}while(choice!=5);
		}

		public void getCookingOil(Grocery grocery,UserRegister user) throws SQLException {
			do {
				System.out.println("1.sunflower(150Rs)");
				System.out.println("2.fortuner(100Rs)");
				System.out.println("3.ithayam(200Rs)");
				System.out.println("4.exit");
				choice=scan.nextInt();
				switch(choice) {
				case 1:
					priceCalculator("sunflower",150,grocery,user);
					break;
				case 2:
					priceCalculator("fortuner",100,grocery,user);
					break;
				case 3:
					priceCalculator("ithayam",200,grocery,user);
					break;
				}
			}while(choice!=4);
		}

		public void getBeverages(Grocery grocery,UserRegister user) throws SQLException {
			do {
				System.out.println("1.coco cola(40Rs)");
				System.out.println("2.pepsi(50Rs)");
				System.out.println("3.mountain due(30rs)");
				System.out.println("4.7up(40Rs)");
				System.out.println("5.exit");
				choice=scan.nextInt();
				switch(choice) {
				case 1:
					priceCalculator("coco cola",40,grocery,user);
					break;
				case 2:
					priceCalculator("pepsi",50,grocery,user);
					break;
				case 3:
					priceCalculator("mountain due",30,grocery,user);
					break;
				case 4:
					priceCalculator("7up",40,grocery,user);
					break;
				}
			}while(choice!=5);
		}
		
		public void getSpices(Grocery grocery,UserRegister user) throws SQLException {
			do {
				System.out.println("1.mutton masala(20Rs)");
				System.out.println("2.chicken 65 masala(10Rs)");
				System.out.println("3.aachi masala(20Rs)");
				System.out.println("4.fish fry masala(10Rs)");
				System.out.println("5.exit");
				choice=scan.nextInt();
				switch(choice) {
				case 1:
					priceCalculator("mutton masala",10,grocery,user);
					break;
				case 2:
					priceCalculator("chicken masala",10,grocery,user);
					break;
				case 3:
					priceCalculator("panner masala",20,grocery,user);
					break;
				case 4:
					priceCalculator("fish masala",10,grocery,user);
					break;
				}
			}while(choice!=5);
		}
		
		public void getRices(Grocery grocery,UserRegister user) throws SQLException {
			do {
				System.out.println("1.Basmathi rice(1kg 70rs)");
				System.out.println("2.white  rice(1kg 50)");
				System.out.println("3.brown rice(1kg 80rs)");
				System.out.println("4.exit");
				choice=scan.nextInt();
				switch(choice) {
				case 1:
					priceCalculator("Basmathi rice",70,grocery,user);
					break;
				case 2:
					priceCalculator("white rice",50,grocery,user);
					break;
				case 3:
					priceCalculator("brown rice",80,grocery,user);
					break;
				}
			}while(choice!=4);
		}

}
