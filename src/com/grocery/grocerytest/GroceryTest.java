package com.grocery.grocerytest;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.grocery.grocerydao.GroceryImplementation;
import com.grocery.grocerydao.InterfaceImplementaion;
import com.grocery.model.Grocery;
import com.grocery.model.UserRegister;
import com.grocery.util.Crud;

public class GroceryTest {
	//static ArrayList<UserRegister> userCredentialsList = new ArrayList<>();


	public static void main(String[] args) throws SQLException {
		int choice = 0;
		char buy;
		int a = 0;
		Scanner scan=new Scanner(System.in);
		GroceryImplementation groceryimpl=new GroceryImplementation();
		Crud connect=new Crud();
		InterfaceImplementaion ii=new InterfaceImplementaion();
		UserRegister user=new UserRegister();
		Grocery grocery=new Grocery();
		System.out.println("WELCOME TO GROCERY SHOP \n");
		while(true) {
			System.out.println("1.customer");
			System.out.println("2.admin \n");
			while(scan.hasNext()) {
				try {
					a=scan.nextInt();
					break;
				}
				catch(InputMismatchException e) {
					System.out.println("please enter a number");
					scan.nextLine();
				}
			}
			switch(a) {
			case 1:
				do {
					System.out.println("1.Register");
					System.out.println("2.Login \n");
					while(scan.hasNext()) {
						try {
							choice=scan.nextInt();
							break;
						}
						catch(InputMismatchException e) {
							System.out.println("please enter a number");
							scan.nextLine();
						}
					}

				}while(choice>2);
				switch(choice) {
				case 1:
					ii.getuserDetails(user,connect);
					//System.out.println(details);
					if(ii.loginCredencial(connect,user)) {
						do {
							System.out.println("\nEnter the option:");
							System.out.println("1.buy products");
							System.out.println("2.get account details");
							System.out.println("3.Update account");
							System.out.println("4.Delete account");
							System.out.println("5.Exit");
							while(scan.hasNext()) {
								try {
									choice=scan.nextInt();
									break;
								}
								catch(InputMismatchException e) {
									System.out.println("please enter a number");
									scan.nextLine();
								}
							}
							switch(choice) {
							case 1:
								do {
									groceryimpl.productList();
									choice=scan.nextInt();
									switch(choice) {
									case 1:
										groceryimpl.getDryFruits(grocery,user);
										break;
									case 2:
										groceryimpl.getSnacks(grocery,user);
										break;
									case 3:
										groceryimpl.getCookingOil(grocery,user);
										break;
									case 4:
										groceryimpl.getBeverages(grocery,user);
										break;
									case 5:
										groceryimpl.getSpices(grocery,user);
										break;
									case 6:
										groceryimpl.getRices(grocery,user);
										break;
									case 7:
										groceryimpl.getBiscuit(grocery,user);
										break;
									default :
										System.out.println("please enter 1 to 6");
										break;
									}
									System.out.println("do you want to buy any other products(y/n):");
									buy=scan.next().charAt(0);
								}while(buy == 'y');
								groceryimpl.getBill(user,grocery);
								groceryimpl.getDiscount(grocery);
								groceryimpl.makePayment(grocery,connect,user);
								break;
							case 2:
								ii.getaccount(connect,user);
								break;
							case 3:
								ii.updateAccount(connect,user);
								break;
							case 4:
								ii.deleteAccount(connect);
								break;
							case 5:
								break;
						}
						}while(choice!=5);
					}
					break;
				case 2:
					if(ii.loginCredencial(connect,user)) {
						do {
							System.out.println("\nEnter the option:");
							System.out.println("1.buy products");
							System.out.println("2.get account details");
							System.out.println("3.Update account");
							System.out.println("4.Delete account");
							System.out.println("5.Exit");
							while(scan.hasNext()) {
								try {
									choice=scan.nextInt();
									break;
								}
								catch(InputMismatchException e) {
									System.out.println("please enter a number");
									scan.nextLine();
								}
							}
							switch(choice) {
							case 1:
								do {
									groceryimpl.productList();
									choice=scan.nextInt();
									switch(choice) {
									case 1:
										groceryimpl.getDryFruits(grocery,user);
										break;
									case 2:
										groceryimpl.getSnacks(grocery,user);
										break;
									case 3:
										groceryimpl.getCookingOil(grocery,user);
										break;
									case 4:
										groceryimpl.getBeverages(grocery,user);
										break;
									case 5:
										groceryimpl.getSpices(grocery,user);
										break;
									case 6:
										groceryimpl.getRices(grocery,user);
										break;
									case 7:
										groceryimpl.getBiscuit(grocery,user);
										break;
									default :
										System.out.println("please enter 1 to 6");
										break;
									}
									System.out.println("do you want to buy any other products(y/n):");
									buy=scan.next().charAt(0);
								}while(buy == 'y');
								groceryimpl.getBill(user,grocery);
								groceryimpl.getDiscount(grocery);
								groceryimpl.makePayment(grocery,connect,user);
								break;
							case 2:
								ii.getaccount(connect,user);
								break;
							case 3:
								ii.updateAccount(connect,user);
								break;
							case 4:
								ii.deleteAccount(connect);
								break;
							case 5:
								break;
							}
						}while(choice!=5);
					}
					break;
				}
				break;

			case 2:
				int b = 0;
				if(ii.adminLoginCredencial(connect,user)) {
					do {
					System.out.println("\nEnter the option:");
					System.out.println("1.view all accounts");
					System.out.println("2.Update account");
					System.out.println("3.Delete account");
					System.out.println("4.view transaction history");
					System.out.println("5.Exit");
					try {
						b=scan.nextInt();
					}catch(InputMismatchException e) {
						System.out.println("please enter a number");
					}

					switch(b) {
					case 1:
						ii.getAccounts(connect);
						break;
					case 2:
						ii.updateAccount(connect, user);
						break;
					case 3:
						ii.deleteAccount(connect);
						break;
					case 4:
						ii.paymentHistory(connect);
						break;
					case 5:
						break;
					}
					}while(b!=5);
				}
				break;
			default:
				System.out.println("Invalid choice .please enter 1 or 2");
				continue;
			}
			break;
		}
		scan.close();
	}
}
			
		









		
//		choice=scan.nextInt();
//		switch(choice) {
//		case 1:
//			ii.getuserDetails(user,connect);
//			//System.out.println(details);
//			if(ii.loginCredencial(connect,user)) {
//				do {
//					groceryimpl.productList();
//					choice=scan.nextInt();
//					switch(choice) {
//					case 1:
//						groceryimpl.getDryFruits(grocery,user);
//						break;
//					case 2:
//						groceryimpl.getSnacks(grocery,user);
//						break;
//					case 3:
//						groceryimpl.getCookingOil(grocery,user);
//						break;
//					case 4:
//						groceryimpl.getBeverages(grocery,user);
//						break;
//					case 5:
//						groceryimpl.getSpices(grocery,user);
//						break;
//					case 6:
//						groceryimpl.getRices(grocery,user);
//						break;
//					case 7:
//						groceryimpl.getBiscuit(grocery,user);
//						break;
//					default :
//						System.out.println("please enter 1 to 7");
//						break;
//					}
//					System.out.println("do you want to buy any other products(y/n):");
//					buy=scan.next().charAt(0);
//				}while(buy == 'y');
//				groceryimpl.getBill(user,grocery);
//				groceryimpl.getDiscount(grocery);
//				groceryimpl.makePayment();
//				scan.close();
//			}
//			//connect.getDetails();
//			break;
//		case 2:
//			if(ii.loginCredencial(connect,user)) {
//				do {
//					groceryimpl.productList();
//					choice=scan.nextInt();
//					switch(choice) {
//					case 1:
//						groceryimpl.getDryFruits(grocery,user);
//						break;
//					case 2:
//						groceryimpl.getSnacks(grocery,user);
//						break;
//					case 3:
//						groceryimpl.getCookingOil(grocery,user);
//						break;
//					case 4:
//						groceryimpl.getBeverages(grocery,user);
//						break;
//					case 5:
//						groceryimpl.getSpices(grocery,user);
//						break;
//					case 6:
//						groceryimpl.getRices(grocery,user);
//						break;
//					case 7:
//						groceryimpl.getBiscuit(grocery,user);
//						break;
//					default :
//						System.out.println("please enter 1 to 6");
//						break;
//					}
//					System.out.println("do you want to buy any other products(y/n):");
//					buy=scan.next().charAt(0);
//				}while(buy == 'y');
//				groceryimpl.getBill(user,grocery);
//				groceryimpl.getDiscount(grocery);
//				groceryimpl.makePayment();
//				scan.close();
//			}
//			break;
//		case 3:
//			ii.updateAccount(connect);
//			break;
//		case 4:
//		ii.deleteAccount(connect);
//			break;
//		case 5:
//			ii.getAccounts(connect);
//			break;
//		}
//		
	


