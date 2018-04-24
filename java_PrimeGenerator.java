
/*Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!
Input

The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.
Output

For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.
Example

Input:
2
1 10
3 5

Output:
2
3
5
7

3
5

Warning: large Input/Output data, be careful with certain languages (though most should be OK if the algorithm is well designed)
Information
After cluster change, please consider PRINT as a more challenging problem. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.*;

public class java_PrimeGenerator { // Remember before put it to the spoj editor
									// change the name of the class to MAIN
	// static int sqrtPrimes[];
	static Boolean array[];
	static Boolean arrayPrime[];
	static List<Integer> sqrtPrimes = new ArrayList<Integer>();

	public static int prime_generator(int firstNum, int lastNum) {
		int size = (int) Math.sqrt(lastNum);

		int divideInt;// size is the sqrt value of the greater number
		array = new Boolean[size + 1];
		arrayPrime = new Boolean[(lastNum - firstNum) + 1];

		// Initialization a workshop array, assume all numbers are prime
		// numbers(only assume!!!)
		for (int i = 0; i < size; i++) {
			array[i] = true;

		}
		for (int i = 0; i < (lastNum - firstNum) + 1; i++) {
			arrayPrime[i] = true;

		}

		// mark non-primes <= n using Sieve of Eratosthenes
		for (int factor = 2; factor * factor <= lastNum; factor++) {

			// if factor is prime, then mark multiples of factor as nonprime
			// suffices to consider mutiples factor, factor+1, ..., n/factor
			if (array[factor]) {
				sqrtPrimes.add(sqrtPrimes.size(), factor); // save all prime
															// numbers smaller
															// than sqrt of
															// greater number on
															// the list
				for (int j = factor; factor * j <= size; j++) {
					array[factor * j] = false;
				}
			}
		}
		
		// Segmented sieve of erathones part
		for (int i = 0; i < sqrtPrimes.size(); i++) {
			divideInt = firstNum / sqrtPrimes.get(i);
			divideInt = divideInt * sqrtPrimes.get(i);

			while (divideInt <= lastNum) {

				if (divideInt >= firstNum && divideInt != sqrtPrimes.get(i)) {
					arrayPrime[divideInt - firstNum] = false;

				}
				divideInt += sqrtPrimes.get(i);
				
			}

		

		}
		//print prime numbers
		for (int x = 0; x < (lastNum - firstNum) + 1; x++) {
			if (arrayPrime[x]) {
				if ((x + firstNum) > 1) {
					System.out.println(x + firstNum);
				}
			}

		}
		return 0;
	}

	public static void main(String[] args) {

		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			String line;
			// Get number of the test cases block
			line = buf.readLine();
			int num = Integer.parseInt(line);
			int i = 0;
			Queue<Integer> fifo = new LinkedList<Integer>(); //implementing the fifo for gettin pramaters

			while (i < num) {

				line = buf.readLine();
				String[] parts = line.split(" ");
				fifo.add(Integer.parseInt(parts[0]));
				fifo.add(Integer.parseInt(parts[1]));

				i++;
			}

			while (!fifo.isEmpty()) {

				int firstNum = fifo.remove();
				int lastNum = fifo.remove();
				prime_generator(firstNum, lastNum);

			}

		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
