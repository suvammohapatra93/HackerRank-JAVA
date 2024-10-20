
//HACKERRANK -> Prime Checker 

import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import static java.lang.System.in;

class Prime {
	// Method to check primes and print them
	public void checkPrime(int... arr) {
		for (int num : arr) {
			if (isPrime(num)) {
				System.out.print(num + " ");
			}
		}
		System.out.println(); // Move to the next line after printing all primes
	}

	// Helper method to check if a number is prime
	private boolean isPrime(int n) {
		if (n < 2)
			return false; // Numbers less than 2 are not prime
		if (n == 2)
			return true; // 2 is the only even prime number
		if (n % 2 == 0)
			return false; // Eliminate even numbers greater than 2
		// Check divisibility up to the square root of n
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}

public class PrimeChecker {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());

			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
