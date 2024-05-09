package com.grocery.groceryDAO;

import java.util.Scanner;

import com.grocery.model.UserRegister;

public class AbtractImplementation extends Abstract{
	Scanner scan=new Scanner(System.in);
	UserRegister userregister=new UserRegister();

	@Override
	void getDetails() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Enter your name:");
			String name=scan.nextLine();
			if(name.matches("[a-zA-Z]{3,15}")) {
				userregister.setName(name);
				break;
			}
			System.out.println("please enter valid name");
		}
		while(true) {
			System.out.println("Enter your address:");
			String address=scan.next();
			if(address.matches("[a-zA-Z]{3,15}")) {
				userregister.setAddress(address);
				break;
			}
			System.out.println("please enter valid address");
		}
		while(true) {
			System.out.println("Enter the mobile:");
			String mobile=scan.next();
			if(mobile.matches("[0-9]{10}")) {
				userregister.setMobile(mobile);
				System.out.println("your product will delivered at tomorrow");
				break;
			}
			System.out.println("please enter valid mobile");
		}
		
	}
	

}
