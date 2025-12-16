import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Payslip {

	public static void main(String[] args) {
		// this program reads the information from a farm worker and prints out a payslip
		Scanner sc = new Scanner(System.in);
		
		//Header
		System.out.println("===============================");
		System.out.println("CORCORANS FRUIT FARM PAY SYSTEM");
		System.out.println("===============================");
		
		//Request for employees information
		System.out.print("input your first name:");
		String name = sc.next();
		System.out.printf("Dear %2s, Welcome to Corcorans Fruit Farm Pay System \nInput you PPS Number:", name);
		String ppsNumber = sc.next();
		
		//Request for the number of every fruit picked
		System.out.println("Number of strawberry picked:");
		int numberOfStrawberry = sc.nextInt();
		System.out.println("Number of blueberry picked:");
		int numberOfBlueberry = sc.nextInt();
		System.out.println("Number of raspberry picked:");
		int numberOfRaspberry = sc.nextInt();
		System.out.println("Number of blackcurrant picked:");
		int numberOfBlackcurrant = sc.nextInt();
		sc.close();
		
		//Total number of fruits
		int totalNumberOfFruits = (numberOfStrawberry + numberOfBlueberry + numberOfRaspberry + numberOfBlackcurrant);

		//Calculate the amount earned for every type of fruit
		double amountEarnedForStrawberries = (0.08 * numberOfStrawberry);
		double amountEarnedForBlueberries = (0.06 * numberOfBlueberry);
		double amountEarnedForRaspberries = (0.05 * numberOfRaspberry);
		double amountEarnedForBlackcurrant = (0.05 * numberOfBlackcurrant);
		
		//Total amount earned before bonus
		double grossPay = (amountEarnedForStrawberries + amountEarnedForBlueberries + amountEarnedForRaspberries + amountEarnedForBlackcurrant);
		
		//Calculate bonus
		byte bonus;
		if (totalNumberOfFruits > 1500) {			
			bonus = 50;
		}
		else {
			bonus = 0;
		}
		//Overall Gross Pay
		double overallGrossPay = grossPay + bonus;
		
		//Calculate the USC
		double uscTax;
		if (overallGrossPay > 600) {
			uscTax = overallGrossPay * 0.05;
		}
		else if (overallGrossPay >= 400) {
			uscTax = overallGrossPay * 0.03;
		}
		else {
			uscTax = 0;
		}
		
		//Calculate Income Tax
		double incomeTax;
        if (overallGrossPay > 450)
            incomeTax = overallGrossPay * 0.40;
        else if (overallGrossPay >= 300)
            incomeTax = overallGrossPay * 0.20;
        else {
            incomeTax = 0;
        }
		//Calculate Total Deductions
		double totalDeductions = uscTax + incomeTax;
		
		//Calculate Net Pay
		double netPay = overallGrossPay - totalDeductions;
		
		//Pay slip Number Generator
		Random payslipNumGenerator = new Random();
		int payslipNum = payslipNumGenerator.nextInt(1000);
		DecimalFormat payslipFormat = new DecimalFormat("0000");
		String formatedPayslipNum = payslipFormat.format(payslipNum);
		
		//Money format
		DecimalFormat money = new DecimalFormat("0.00");
		
		//Printing the Pay Slip
		System.out.println("\t\t\t\t\t\t\t\t\tPay slip:" + formatedPayslipNum);
		System.out.println("Name:\t\t" + name);
		System.out.println("PPS Number:\t" + ppsNumber + "\n");
		System.out.println("Fruit Details" + "\n");
		System.out.printf("Strawberries:\t\t\t\t%4d\t\t\t\t€%4s\n" , numberOfStrawberry , money.format(amountEarnedForStrawberries));
		System.out.printf("Blueberries:\t\t\t\t%4d\t\t\t\t€%4s\n" , numberOfBlueberry , money.format(amountEarnedForBlueberries));
		System.out.printf("Raspberries:\t\t\t\t%4d\t\t\t\t€%4s\n" , numberOfRaspberry , money.format(amountEarnedForRaspberries));
		System.out.printf("Blackcurrants:\t\t\t\t%4d\t\t\t\t€%4s\n" , numberOfBlackcurrant , money.format(amountEarnedForBlackcurrant));
		System.out.printf("\t\t\t\t\t\t\t\t\t=====\n");
		System.out.printf("Total Units Picked:\t\t\t%4d\n" , totalNumberOfFruits);
		System.out.println("Gross Pay:\t\t\t\t\t\t\t\t€" + money.format(grossPay) + "\n");
		if(bonus > 0) {
			System.out.println("Bonus Paid:\t\t\t\t\t\t\t\t€" + money.format(bonus) + "\n");
		}
		if(bonus > 0) {
			System.out.println("Overall Gross Pay:\t\t\t\t\t\t\t€" + money.format(overallGrossPay)+ "\n");
		}
		System.out.println("Deductions");
		System.out.printf("USC:€%3s\t\t\t\t\tIncome Tax:\t€%3s\n" , money.format(uscTax) , money.format(incomeTax));
		System.out.println("Total Deductions:\t\t\t\t\t\t€" + money.format(totalDeductions));
		System.out.println("Net Pay:\t\t\t\t\t\t\t€" + money.format(netPay));

    }
}