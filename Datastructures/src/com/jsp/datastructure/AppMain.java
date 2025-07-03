package com.jsp.datastructure;

import java.util.Scanner;

import com.jsp.datastructure.controller.AccountController;
import com.jsp.datastructure.dto.Account;
import com.jsp.datastructure.dto.AccountDTO;

public class AppMain 
{
	private static final Scanner sc = new Scanner(System.in);
	private static final AccountController controller = new AccountController();

	public static void main(String[] args) 
	{
		int choice;

		while (true) 
		{
			showMenu();
			choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) 
			{
				case 1:
					createAccount();
					break;
				case 2:
					readAccount();
					break;
				case 3:
					updateAccount();
					break;
				case 4:
					deleteAccount();
					break;
				case 5:
					System.out.println("Exiting... Thank you!");
					sc.close();
					System.exit(0);
				default:
					System.out.println("❗ Invalid choice. Please try again.");
			}
		}
	}

	private static void showMenu() 
	{
		System.out.println("\n*********************Account Management **********************************");
		System.out.println("1. Create Account");
		System.out.println("2. Read Account");
		System.out.println("3. Update Account");
		System.out.println("4. Delete Account");
		System.out.println("5. Exit");
		System.out.println("\n**************************************************************************");
		System.out.print("Enter your choice: ");
	}

	private static void createAccount() 
	{
		AccountDTO dto = new AccountDTO();

		System.out.print("Enter Name: ");
		dto.setUserName(sc.nextLine());

		System.out.print("Enter Account Number: ");
		dto.setAccountNumber(sc.nextLine());

		System.out.print("Enter Balance: ");
		dto.setBalance(sc.nextDouble());
		sc.nextLine();

		System.out.print("Enter Email: ");
		dto.setEmail(sc.nextLine());

		System.out.print("Enter IFSC: ");
		dto.setIfscCode(sc.nextLine());

		System.out.print("Enter Country: ");
		dto.setCountry(sc.nextLine());

		System.out.print("Enter City: ");
		dto.setCity(sc.nextLine());

		System.out.print("Enter Pincode: ");
		dto.setPincode(sc.nextLine());

		controller.create(dto);
		System.out.println("Account Created Successfully.");
	}

	private static void readAccount() 
	{
		AccountDTO dto = new AccountDTO();

		System.out.print("Enter Account Number to Read: ");
		dto.setAccountNumber(sc.nextLine());

		Account acc = controller.read(dto);
		if (acc != null) 
		{
			System.out.println("Account Details:");
			System.out.println("Name: " + acc.getUserName());
			System.out.println("Email: " + acc.getEmail());
			System.out.println("Balance: " + acc.getBalance());
			System.out.println("City: " + acc.getCity());
		}
		else
		{
			System.out.println("Account Not Found.");
		}
	}

	private static void updateAccount() 
	{
		AccountDTO dto = new AccountDTO();

		System.out.print("Enter Account Number to Update: ");
		dto.setAccountNumber(sc.nextLine());

		System.out.print("Enter Updated Name: ");
		dto.setUserName(sc.nextLine());

		System.out.print("Enter Updated Balance: ");
		dto.setBalance(sc.nextDouble());
		sc.nextLine();

		System.out.print("Enter Updated Email: ");
		dto.setEmail(sc.nextLine());

		System.out.print("Enter Updated IFSC: ");
		dto.setIfscCode(sc.nextLine());

		System.out.print("Enter Updated Country: ");
		dto.setCountry(sc.nextLine());

		System.out.print("Enter Updated City: ");
		dto.setCity(sc.nextLine());

		System.out.print("Enter Updated Pincode: ");
		dto.setPincode(sc.nextLine());

		boolean isUpdated = controller.update(dto);
		System.out.println(isUpdated ? "Account Updated." : "Account Not Found.");
	}

	private static void deleteAccount() 
	{
		AccountDTO dto = new AccountDTO();

		System.out.print("Enter Account Number to Delete: ");
		dto.setAccountNumber(sc.nextLine());

		boolean isDeleted = controller.delete(dto);
		System.out.println(isDeleted ? "Account Deleted." : "Account Not Found.");
	}
}
