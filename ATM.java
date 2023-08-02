// ATM INTERFACE

import java.util.Scanner;

public class ATM 
{
    // Array to store user IDs of different users
    static int[] userIds = { 2001, 2002, 2003, 2004, 2005 };

    // Array to store pins of different users
    static int[] pin = { 1102, 6112, 2109, 1938, 1995 };
    
    // Array to store initial balances of different users
    static int[] balance = { 10000, 5000, 20000, 1500, 9999999 };

    // variables to store deposit and withdrawal amount of users
    static long deposit, withdraw;

    // variables to store user choice
    static int ch, k;
    static char transaction = 'y';

    public static void main(String[] args) 
    {
        // create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n********* Hello! Welcome to ATM Service *************");
        // Verify user ID
        int UidIndex = -1;
        System.out.print("ENTER YOUR USER ID: ");
        int GUserId = scanner.nextInt();

        // Clear the input buffer
        scanner.nextLine();

        // Check if the entered user ID matches any of the stored user IDs
        for (int i = 0; i < userIds.length; i++) 
        {
            if (GUserId == userIds[i]) 
            {
                UidIndex = i;
                break;
            }
        }

        if (UidIndex != -1) 
        {
            System.out.println("YOUR USER ID IS VERIFIED!");

            // to check whether the given ATM pin is valid or not
            // Store the index of the matched pin
            int pinIndex = -1; 
            System.out.print("\nENTER YOUR SECRET PIN NUMBER: ");
            int GPin = scanner.nextInt();

            // Check if the entered pin matches any of the stored pins
            for (int i = 0; i < pin.length; i++) 
            {
                if (GPin == pin[i]) 
                {
                    pinIndex = i;
                    break;
                }
            }

            if (pinIndex != -1) 
            {
                System.out.println("YOUR PIN MATCHED!");

                k=0;
                do 
                {
                    // Statements to select the user input
                    System.out.println("\n*************************************************");
                    System.out.println("Please select your choice!");
                    System.out.println("1. Balance Enquiry");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");
                    System.out.println("***********************?***************************");
                    System.out.print("\nEnter your choice: ");

                    // Reading user choice
                    ch = scanner.nextInt();

                    // Switch case for user choices
                    switch (ch) 
                    {
                        // check balance
                        case 1:
                            System.out.println("\nTransaction History");
                            System.out.println("YOUR ACCOUNT BALANCE IN Rs : " + balance[pinIndex]);
                            break;

                        // withdrawal amount
                        case 2:
                            System.out.print("\nENTER THE AMOUNT TO WITHDRAW: ");
                            withdraw = scanner.nextLong();
                            if (withdraw % 100 != 0) 
                            {
                                System.out.println("\nPLEASE ENTER THE AMOUNT IN MULTIPLES OF 100");
                            } 
                            else if (withdraw > (balance[pinIndex] - 500)) 
                            {
                                System.out.println("\nINSUFFICIENT BALANCE! Please enter another amount");
                            } 
                            else 
                            {
                                balance[pinIndex] -= withdraw;
                                System.out.println("\nPLEASE COLLECT YOUR CASH");
                                System.out.println("YOUR CURRENT ACCOUNT BALANCE IS " + balance[pinIndex]);
                            }
                            break;

                        // Deposit amount
                        case 3:
                            System.out.print("\nENTER THE AMOUNT TO DEPOSIT: ");
                            deposit = scanner.nextLong();
                            balance[pinIndex] += deposit;
                            System.out.println("YOUR ACCOUNT BALANCE IS " + balance[pinIndex]);
                            break;

                        // Money transfer
                        case 4:
                            System.out.print("\nENTER THE USER ID TO TRANSFER MONEY: ");
                            int userID = scanner.nextInt();
                            int userIndex = -1; // Store the index of the matched user ID
                            for (int i = 0; i < userIds.length; i++) 
                            {
                                if (userID == userIds[i]) 
                                {
                                    userIndex = i;
                                    break;
                                }
                            }

                            if (userIndex != -1 && userIndex != pinIndex) 
                            {
                                System.out.print("ENTER THE AMOUNT TO TRANSFER: ");
                                long transferAmount = scanner.nextLong();
                                if (transferAmount <= 0) 
                                {
                                    System.out.println("INVALID TRANSFER AMOUNT! Please enter a positive amount.");
                                } 
                                else if (transferAmount > balance[pinIndex]) 
                                {
                                    System.out.println("INSUFFICIENT BALANCE! Transfer amount exceeds your balance.");
                                } 
                                else 
                                {
                                    balance[pinIndex] -= transferAmount;
                                    balance[userIndex] += transferAmount;
                                    System.out.println("MONEY TRANSFER SUCCESSFUL!");
                                    System.out.println("YOUR CURRENT ACCOUNT BALANCE IS " + balance[pinIndex]);
                                }
                            } 
                            else 
                            {
                                System.out.println("INVALID USER ID! Please enter a valid user ID.");
                            }
                            break;

                        case 5:
                            System.out.println("\nTHANK YOU FOR USING OUR ATM SERVICE");
                            break;

                        default:
                            System.out.println("\nINVALID CHOICE");
                    }

                    System.out.print("\nDO YOU WISH TO HAVE ANOTHER TRANSACTION? (y/n): ");
                    scanner.nextLine(); // Clear the input buffer
                    // Reading user transaction
                    transaction = scanner.nextLine().charAt(0);
                    if (transaction == 'n' || transaction == 'N')
                        k = 1;
                } while (k == 0);
            } 
            else 
            {
                System.out.println("INVALID PIN! Please enter a valid PIN.");
            }
        } 
        else 
        {
            System.out.println("INVALID USER ID! Please enter a valid user ID.");
        }
        System.out.println("\n******* THANKS FOR USING OUR ATM SERVICE*****\n\n");

        // close the Scanner
        scanner.close();
    }
}
