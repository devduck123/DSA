import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 */
public class Meraki
{
	public static String checkIPValidity(String addressIP)
	{
        // initialize empty array of Strings
		String[] numbers = new String[4];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = "";
        }

		// partition IP address into 4 Strings by "."
		int counter = 0;

		for (int i = 0; i < addressIP.length(); i++) {
			if (!(addressIP.charAt(i) == '.')) {
				numbers[counter] += addressIP.charAt(i);
			}
			else {
				counter++;
				// increment to next String number
			}
		}

        int[] values = new int[4];
		for (int i = 0; i < numbers.length; i++) {
			values[i] = Integer.parseInt(numbers[i]);
            if (values[i] < 0 || values[i] > 255) {
                System.out.println("INVALID");
                System.exit(0);
            }
		}

		return "VALID";
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		// input for addressIP
		String addressIP = in.nextLine();
		
		String result = checkIPValidity(addressIP);
		System.out.print(result);
		
        // TEST CASES PASSED: 123.129.23.65 and 23.29.323.165
        // ONLY 11/16 TEST CASES PASSED 
	}
}
