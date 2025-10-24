package com.cars.Controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.cars.Validator.emailValidator;
import com.cars.dao.usersDao;
import com.cars.entity.Users;

public class UserController {
	static Scanner scan = new Scanner(System.in);
	static usersDao ud = new usersDao();

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		boolean exit =false;
		
		while(!exit) {
		
		System.out.println("\nWelcome to Car App");
		System.out.println("\n1.Register User\n2.Login\n3.Forgot Password\n4.Logout");
		System.out.print("Enter Your Choice: ");
		int choice = scan.nextInt();
		scan.nextLine();

		switch (choice) {
		
		// User Registration
		case 1: {
			System.out.println("-------User Registration-------");
			System.out.print("Enter the User Id: ");
			int uid = scan.nextInt();
			scan.nextLine();
			System.out.print("\nEnter the UserName: ");
			String uname = scan.nextLine();
			System.out.print("\nEnter the Email Id: ");
			String mail = scan.nextLine();
			if(emailValidator.emailValidate(mail)) {
				System.out.print("\nEnter Mobile No: ");
				long mobo = scan.nextLong();
				scan.nextLine();
				System.out.print("\nEnter the Address: ");
				String address = scan.nextLine();
				System.out.print("\nEnter the Password: ");
				String pass = scan.nextLine();
				if(emailValidator.pwdValidate(pass)) {
					Users us = new Users();
					us.setU_id(uid);
					us.setU_name(uname);
					us.setU_email(mail);
					us.setU_mobileno(mobo);
					us.setU_address(address);
					us.setU_password(pass);

					try {
						ud.registerUser(us);
					} catch (SQLException e) {

						e.printStackTrace();
					}

					
				}
				else {
					System.out.println("Password Contains atleast one UpperCase , One Special Character and Numbers");
					
				}
					
				}
				
			else System.out.println("Its Not in Gmail Format");
			
		}
			break;
			
			//Login Page
		case 2: {
			System.out.print("\nEnter Your Email: ");
			String mail = scan.nextLine();
			if(emailValidator.emailValidate(mail)) {
				
				System.out.print("Enter Your Password: ");
				String pass = scan.nextLine();
				if(emailValidator.pwdValidate(pass)) {
					try {
						int rs = ud.Login(mail, pass);
						if(rs!=0) {
							System.out.println("Loading......💭");
							Thread.sleep(2000);
							CarController.carsDtails();
						}
						else {
							System.out.println("wrong credentials or invalid user..");
						}
						
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}
				else System.out.println("Password Contains atleast one UpperCase , One Special Character and Numbers");
				
				
				

			}else System.out.println("Email Format Doesn't Match");
			

		}
			break;
			
			//Forgot Password with OTP

		case 3: {

			System.out.print("Enter Your Email: ");
			String mail = scan.nextLine();
			if(emailValidator.emailValidate(mail)) {
				
				String verify = ud.forgotPassword(mail);
				if (mail.equals(verify)) {
					System.out.println("OTP Generating....👻");
					Thread.sleep(2000);
					int num = (int) (Math.random() * 1000000);
					Thread.sleep(1000);
					System.out.println("Your OTP: " + num);
					System.out.print("Enter Your OTP: ");
					int otp = scan.nextInt();
					scan.nextLine();
					if (num == otp) {
						System.out.print("Enter Your New Password: ");
						String pass = scan.nextLine();
						if(emailValidator.pwdValidate(pass)) {
							ud.changePassword(mail, pass);
						}
						else System.out.println("Password Contains atleast one UpperCase , One Special Character and Numbers");
						
					} else {
						System.out.println("Incorrect OTP try it once again");
					}

				} else {
					System.out.println("User Not Found , Please Check Your Email Properly");
				}
				
			}else System.out.println("Email Format Doesn't Match");
			

		}
			break;

			// Logout
		case 4: {
			System.out.println("Logout Successfully....");
			ud.closeConnection();
			System.out.println("Thank You For Visiting Our App");
			exit=true;
		}
			break;

		default: {
			System.out.print("\nEnter a Valid Choice! ");
		}
			break;
		}
		}
scan.close();
	}


}
