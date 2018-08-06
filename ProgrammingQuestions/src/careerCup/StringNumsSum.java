package careerCup;

// Q: Given 2 strings representing very large numbers 
// (these are not representable as a BigInteger or other various type).
// Write a method for adding the two numbers and returning their sum.

public class StringNumsSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numA = "1123455432133";
		String numB = "34654654";
		
		String result = addStringNums(numA, numB);
		System.out.println("The sum is: " + result);
	}
	
	public static String addStringNums(String numA, String numB) {
		int lengthA = numA.length();
		int lengthB = numB.length();
		int countA = 1;
		int countB = 1;
		int carry = 0;
		String sum = "";
		
		// adding the digits from behind for both strings
		while (lengthA >= countA && lengthB >= countB) {
			// taking the last digit 
			int digitA = numA.charAt(lengthA-countA) - '0';
			int digitB = numB.charAt(lengthB-countB) - '0';
			
			// adding the two digits
			int digitSum = carry + digitA + digitB;
			
			// defining carry
			if (digitSum > 9) {
				carry = digitSum / 10;
			} else {
				carry = 0;
			}
			
			// adding to sum
			sum = "" + (char)(digitSum % 10 + '0') + sum;
			
			// iteration variables
			countA++;
			countB++;
		}
		
		// if lengthA > lengthB, some digits left in numA
		while (lengthA >= countA) {
			// taking the last digit 
			int digitA = numA.charAt(lengthA-countA) - '0';
			
			// adding with carry
			int digitSum = carry + digitA;
			
			// defining carry for next step
			if (digitSum > 9) {
				carry = digitSum / 10;
			} else {
				carry = 0;
			}
			
			// adding to sum
			sum = "" + (char)(digitSum % 10 + '0') + sum;
			
			// iteration variables
			countA++;
		}
		
		// if lengthB > lengthA, some digits left in numB
		while (lengthB >= countB) {
			// taking the last digit 
			int digitB = numB.charAt(lengthB-countB) - '0';
			
			// adding with carry
			int digitSum = carry + digitB;
			
			// defining carry for next step
			if (digitSum > 9) {
				carry = digitSum / 10;
			} else {
				carry = 0;
			}
			
			// adding to sum
			sum = "" + (char)(digitSum % 10 + '0') + sum;
			
			// iteration variables
			countB++;
		}
		
		// if carry is the only thing left
		if (carry == 1) {
			sum = "" + (char)(1 + '0') + sum;
		}
		
		return sum;
	}

}
