/*FCTRL2 - Small factorials
#math #big-numbers

You are asked to calculate factorials of some small positive integers.
Input

An integer t, 1<=t<=100, denoting the number of testcases, followed by t lines, 
each containing a single integer n, 1<=n<=100.
Output

For each integer n given at input, display a line with the value of n!
Example
Sample input:

4
1
2
5
3

Sample output:

1
2
120
6

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class java_SmallFactorials {
	static BigInteger factorial;

	public static int factorialCalculate(int Num) {
		factorial = BigInteger.valueOf(Num);
		
		
		for (int i = 1; i < Num; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(Num - i));

		}
		System.out.println(factorial);
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
			Queue<Integer> fifo = new LinkedList<Integer>(); // implementing the
																// fifo for
																// gettin
																// pramaters

			while (i < num) {
				line = buf.readLine();
				fifo.add(Integer.parseInt(line));

				i++;
			}

			while (!fifo.isEmpty()) {

				int Num = fifo.remove();

				factorialCalculate(Num);

			}
			System.out.println("");
			

		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}