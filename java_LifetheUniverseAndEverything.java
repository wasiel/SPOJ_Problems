/*Life, the Universe, and Everything
#basic #tutorial #ad-hoc-1

Your program is to use the brute-force approach in order to find the Answer to Life, the Universe, and Everything. More precisely... rewrite small numbers from input to output. Stop processing input after reading in the number 42. All numbers at input are integers of one or two digits.

Example

Input:
1
2
88
42
99

Output:
1
2
88

Information

If you have some troubles with your code, you can take a look in the forum, you'll find the answer, 
only for this problem, in various languages.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class java_LifetheUniverseAndEverything{ //Remember before put it to the spoj editor change the name of the class to MAIN
	public static void main(String[] args) {
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while ((line = buf.readLine()) != null) {
				if (!line.equals("42")) {
					System.out.println(line);
				} else {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
