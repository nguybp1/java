/*Assignment2.java
 *September 8, 2015
 *This java program calculates the wage of three employees
 */

//Import number format from text
import java.text.*;
//Import util for input
import java.util.*;

public class WageCalulation {
	public static void main(String[] args) {
		//declaring variables and initializing 
		double pay = 0.0, wage = 0.0;
		int hour = 0;
		String dollars;
		
		//for loop starting at 1 to make the Employee output easier
		for(int i = 1; i<4; i++){
			//Declaring an instance for scanner called in
			Scanner in = new Scanner(System.in);
			//Asking for hourly rate and storing it in pay
			System.out.printf("Enter hourly rate: ");
			pay = in.nextInt();
			//Asking for hourly rate and storing it in hour
			System.out.printf("Enter hours worked: ");
			hour =in.nextInt();
			//Dollar sign format
			NumberFormat sign = NumberFormat.getCurrencyInstance();
			//if and else statements for more than 40 hours.
			if (hour > 40 ){
				wage = (40 * pay) + (hour - 40) * pay * 1.5;
				dollars = sign.format(wage);
				System.out.println("Pay for Employee "+ i + " is " + dollars + "\n");
			} else {
				wage = (hour * pay);
				dollars = sign.format(wage);
				System.out.println("Pay for Employee "+ i + " is " + dollars + "\n");
			}
		}
	}
}
