package id2_prime_generator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int testCase;
	static int first, second;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id2_prime_generator")));
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			readInput(sc);
			solve();
			System.out.println();
		}
		
		sc.close();
	}

	private static void readInput(Scanner sc) {
		first = sc.nextInt();
		second = sc.nextInt();
	}

	private static void solve() {
		for (int i = first; i <= second; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
