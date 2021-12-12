package id42_adding_reversed_numbers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int testCase;
	static int first, second, tmpFirst, tmpSecond, tmpSum;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id42_adding_reversed_numbers")));
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			readInput(sc);
			solve();
		}
		
		sc.close();
	}

	private static void readInput(Scanner sc) {
		first = sc.nextInt();
		second = sc.nextInt();
	}

	private static void solve() {
		tmpFirst = reverse(first);
		tmpSecond = reverse(second);
		tmpSum = tmpFirst + tmpSecond;
		
		System.out.println(reverse(tmpSum));
	}

	private static int reverse(int number) {
		int result = 0;
		int tmp;
		
		while (number > 0) {
			tmp = number % 10;
			result = result * 10 + tmp;
			number /= 10;
		}
		
		return result;
	}
}
