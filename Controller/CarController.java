package com.cars.Controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.cars.dao.carsDao;
import com.cars.entity.Cars;

public class CarController {
	static carsDao cd = new carsDao();
	static Scanner scan = new Scanner(System.in);

	public static void carsDtails() throws SQLException {
		boolean exit=false;
		while(!exit) {
		System.out.println("\n-------Cars Details-------");
		System.out.println(
				"\n1.Add Car Details\n2.Update Car Details\n3.Fetch All Cars\n4.Fetch Car by Name\n5.Delete Car\n6.Count Car By Colour\n7.Exit");
		System.out.print("Enter Your Choice: ");
		int choice = scan.nextInt();
		scan.nextLine();
		switch (choice) {
		
		// Car Details
		case 1: {
			System.out.print("\nEnter Car Id: ");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.print("\nEnter Car Name: ");
			String name = scan.nextLine();
			System.out.print("\nEnter Car Colour: ");
			String colour = scan.nextLine();
			System.out.print("\nEnter Car Model: ");
			String model = scan.nextLine();
			System.out.print("\nEnter Car Type: ");
			String type = scan.nextLine();
			System.out.print("\nEnter Car Number: ");
			String number = scan.nextLine();
			System.out.print("\nEnter Car Price: ");
			double price = scan.nextDouble();
			Cars c = new Cars();
			c.setC_id(id);
			c.setC_name(name);
			c.setC_colour(colour);
			c.setC_model(model);
			c.setC_type(type);
			c.setC_no(number);
			c.setC_price(price);
			try {
				cd.addCarDetails(c);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
			break;

			//Update Car
		case 2: {
			System.out.print(
					"\n1.Update by Name\n2.Update by Colour\n3.Update by Model\n4.Update by Type\n5.Update by Number\n6.Update by Price");
			System.out.print("\nEnter Your Choice: ");
			int opt = scan.nextInt();
			scan.nextLine();
			switch (opt) {

			// Update Car by Name
			case 1: {
				System.out.println("-----Updating by Car Name-----");
				System.out.print("Enter New Car Name: ");
				String name = scan.nextLine();
				System.out.print("Enter Car Id: ");
				int id = scan.nextInt();
				try {
					cd.updateCarByName(name, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
				break;

				//Update Car by Colour
			case 2: {
				System.out.println("-----Updating by Car Colour-----");
				System.out.print("Enter New Car Colour: ");
				String colour = scan.nextLine();
				System.out.print("Enter Car Id: ");
				int id = scan.nextInt();
				try {
					cd.updateCarByColour(colour, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
				break;
				
				//Update Car by Model

			case 3: {
				System.out.println("-----Updating by Car Model-----");
				System.out.print("Enter New Car Model: ");
				String model = scan.nextLine();
				System.out.print("Enter Car Id: ");
				int id = scan.nextInt();
				try {
					cd.updateCarByModel(model, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
				break;
				
				//Update Car by Type

			case 4: {
				System.out.println("-----Updating by Car Type-----");
				System.out.print("Enter New Car Type: ");
				String type = scan.nextLine();
				System.out.print("Enter Car Id: ");
				int id = scan.nextInt();
				try {
					cd.updateCarByType(type, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
				break;
				
				//Update Car by Number

			case 5: {
				System.out.println("-----Updating by Car Number-----");
				System.out.print("Enter New Car Number: ");
				String num = scan.nextLine();
				System.out.print("Enter Car Id: ");
				int id = scan.nextInt();
				try {
					cd.updateCarByNumber(num, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
				break;
				
				//Update Car by Price

			case 6: {
				System.out.println("-----Updating by Car Price-----");
				System.out.print("Enter New Car Price: ");
				double price = scan.nextDouble();
				System.out.print("Enter Car Id: ");
				int id = scan.nextInt();
				try {
					cd.updateCarByPrice(price, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
				break;

			default: {
				System.out.println("Enter a Valid Choice");
			}
				break;
			}

		}
			break;
			
			
			//Fetch All Cars
		case 3:{
			System.out.println("-----Fetch All Cars-----");
			Cars c=new Cars();
			try {
				cd.fetchCars(c);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}break;
		
		//Fatch Car By Name
		
		case 4:{
			System.out.println("-----Fetch Car By Name-----");
			System.out.print("Enter Your Car Name: ");
			String name=scan.nextLine();
			try {
				cd.fetchCarByName(name);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}break;
		
		//Delete the Car
		
		case 5:{
			System.out.println("-----Delete Car-----");
			System.out.print("Enter the Car Name: ");
			String name = scan.nextLine();
			System.out.print("Enter Car Id: ");
			int id = scan.nextInt();
			try {
				cd.deleteCar(name, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}break;
		
		//Count Car based on Colour
		
		case 6:{
			System.out.println("-----Count Car By Colour-----");
			System.out.print("Enter the Car Colour: ");
			String colour=scan.nextLine();
			try {
				cd.countCarByColour(colour);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}break;
		
		case 7:{
//			try {
//				cd.closeConnection();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			
			boolean rs=cd.closeConnection();
			if(rs) {
				exit=rs;
			}
			else {
				exit=rs;
			}
			
		}break;
		

		default:{
			System.out.print("\nEnter a Valid Choice! ");
		}
			break;
		}
	}
		
//		scan.close();

	}
	

}
