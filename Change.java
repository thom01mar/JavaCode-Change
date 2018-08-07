/* 
    Name:         Mary Y. Yu
    Email:        thom01@gmail.com
    Compilation:  javac Change.java
    Execution:    java Change
    Dependencies: No known dependencies. 
    Description:  This Program accepts two numeric values from user input 
                  (amount due and amount tendered). Program calculates how 
                  much change user should receive. Change is broken down to 
                  $1 bills, quarters, dimes, nickels, and pennies such that 
                  the user will receive the leastamount of coins.  

*/

import java.util.Scanner;
import java.lang.Math;
class Change
{
    public static void main(String[] args)
    {
        String again = "y";                             // A sentinel to control the loop.
        
        // User controlled loop for multiple runs.
        while (again.equalsIgnoreCase("y"))
        {
            String input1 = " ", input2 = " ";
            int count1 = 0, count2 = 0;
            Scanner in = new Scanner(System.in);
            System.out.print("\n\n");

            // The try & catch to handle "NumberFormatException" exception,
            try                                                 // The try block.
            {
                // User input on amount due and entry checked for non-numberic characters.
                // User prompted to re-enter if entry has non-numeric characters.                
                System.out.print(" Enter the amount due in dollars(example: 2.02): $");
                input1 = in.nextLine();
                while (count1 < input1.length())
                {
                    for (int i = 0; i<input1.length(); i++)        
                    {
                        if (Character.isDigit(input1.charAt(i)) || input1.charAt(i) == '.')
                        {
                            count1 += 1;
                        }                    
                    }
                    if (count1 < input1.length())
                    {
                        count1 = 0;
                        System.out.print(" Error! Re-enter amount due in dollars (example: 2.02): $");
                        input1 = in.nextLine();
                    }
                }
                Double amt_due = Double.parseDouble(input1);     // Input string converted to double.
                
                // User input on amount tendered and entry checked for non-numberic characters.
                // User prompted to re-enter if entry has non-numeric character(s)
                System.out.print("\n Enter the amount tendered in dollars(example 1.02): $");
                input2 = in.nextLine();
                while (count2 < input2.length())
                {
                    for (int i = 0; i<input2.length(); i++)        
                    {
                        if (Character.isDigit(input2.charAt(i)) || input2.charAt(i) == '.')
                        {
                            count2 += 1;
                        }
                    }
                    if (count2 < input2.length())
                    {
                        count2 = 0;
                        System.out.print(" Error! Re-enter amount tendered in dollars (example 1.02): $");
                        input2 = in.nextLine();
                    }
                }
                Double amt_tdr = Double.parseDouble(input2);     //Input String converted to double.
                
                // Calculating change. To preserve accuracy and ease for break down to dollar bills and 
                // coins, change is multiply by 100 before converting to integer (in cents)
                // Calculation uses division and modulo operation
                Double ch = amt_tdr - amt_due;                   // Calcuating change or amount owed/short.
                int cts = (int) Math.round(ch *100);            // Convert to Integer & rounds up.
                if (ch > 0)                                     // Part of then if-else statement for change.
                 {
                    System.out.printf("\n Your change is: $%.2f." + 
                                       " Here's the break down on your change:\n", ch);
                    if (cts >= 100)                              // The if statement & its statements block 
                    {                                            // that calculates number of dollar bills.
                        int ch_dol = cts/100;
                        System.out.println (" " + ch_dol + " dollar bill(s)");  // Display number of bills.
                        cts = cts%100;                
                    }           
                    if (cts >= 25)                               // The if statement & its statements block
                    {                                            // that calculates number of "quarter" coins.                
                        int ch_qtr = cts/25;                      
                        System.out.println (" " + ch_qtr + " quarter(s)");      // Display number of quarters.
                        cts = cts%25;           
                    }
                    if (cts >= 10)                               // The if statement & its statements block
                    {                                            // that calculates number of "dime" coins.                
                        int ch_dime = cts/10;
                        System.out.println (" " + ch_dime + " dim(s)");         // Display number of dimes.
                        cts = cts%10;                                       
                    }
                    if (cts >= 5)                                // The if statement & its statements block
                    {                                            // that calculates number of "nickel" coins.               
                        int ch_nick = cts/5;
                        System.out.println (" " + ch_nick + " nickel(s)");      // Display number of nickels.
                        cts = cts%5;      
                    }
                    if (cts > 0)                                 // The if statement & its statements block
                    {                                            // for the remaining, number of "penny" coins.                
                        System.out.println (" " + cts + " pennies");          // Display number of pennies.
                    }
                }    
                else                                             // Part of the if-else statement for no change
                {                                                // or amount owed/short.
                    if (cts == 0 || cts > -1)
                    {
                        System.out.println("\n You have no change.");               // Display no change,
                    }
                    else
                    {
                        System.out.printf("\n insufficient amount tendered." + 
                                          " You are short of $%.2f.\n", Math.abs(ch)); // Display amount owed/short.               
                    }
                }
                //System.out.println();
            }       
            catch (NumberFormatException e)                      // The catch part of the exception handling.
            {
                System.out.println("\n Input error!");
            }
            
            // User is prompted to continue or end when change is successfully made or when an exception is thrown.
            System.out.println();
            System.out.print(" Do you want to do this again? (Enter 'Y' to continue, 'N' to end) ");
            again = in.nextLine();
        }
    }    

}
