package com.grocery.grocerydao;

import java.util.InputMismatchException;

public class Validation {

	public boolean Numbers(int number) {
		if(number<0) {
			System.out.println("negative number");
			return false;
		}
			return true;
		
	}
	public boolean Numbers(long number) {
		if(number<0) {
			System.out.println("negative number");
			return false;
		}
			return true;
	}
	
	public boolean cheakFloat(float number) {
		if(number<0) {
			System.out.println("negative number");
			return false;
		}
		return true;
	}
	
	public boolean stringValid(String str) {
		if(str.length()<=2 || str == "") {
			System.out.println("invalid input");
			return false;
		}
		return true;
	}
	
	public boolean name(String name) {
		try {
			if(name.matches("[a-zA-Z ]{2,15}")) {
				return true;
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public boolean password(String password) {
		try {
			if(password.matches("[a-zA-z0-9@#]{3,10}")) {
				return true;
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean address(String address) {
		try {
			if(address.matches("[a-zA-Z]{3,15}")) {
				return true;
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean mobile(String mobile) {
		try {
			if(mobile.matches("[0-9]{10}")) {
				return true;
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
