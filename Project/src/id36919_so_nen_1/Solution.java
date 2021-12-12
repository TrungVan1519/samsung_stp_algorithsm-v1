package id36919_so_nen_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int testCase;
	static long number;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id36919_so_nen_1")));
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		for (int i = 1; i <= testCase; i++) {
			readInput(sc);
			System.out.print("#" + i + " ");
			solve();
		}
	}

	private static void readInput(Scanner sc) {
		number = sc.nextLong();
	}
	
	private static void solve() {
		long result = 10; // jump into the first while loop 
		
		while (result > 9) {
			result = 0; // reset result
			while (number > 0) {
				result += number % 10;
				number /= 10;
			}
			number = result;
		}
		
		System.out.println(result);
	}

	private static void solve(long number) {
		long result = 0;
		
		while (number > 0) {
			result += number % 10;
			number /= 10;
		}

		if (result > 9) {
			solve(result);
			return;
		}
		
		System.out.println(result);
	}
}
