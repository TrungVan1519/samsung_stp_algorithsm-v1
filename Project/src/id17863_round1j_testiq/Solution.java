package id17863_round1j_testiq;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {
	
	/**
	 * Idea 
	 * 
	 * >>> print "YES" if
	 * 
	 * The 2x2 square has 4 same colors or 3 same colors, eg:
	 * |##| or |..| or |##| or |..|
	 * |##|    |..|	   |#.|	   |#.|
	 * 
	 * >>> otherwise, print "NO"
	 * 
	 * Solution
	 * >>> Duyệt hàng và cột từ 0 - 3 
	 * >>> Check tổng các phần tử trong hình vuông 2x2 co 3 ô giống màu hay không 
	 */
	
	static int testCase;
	
	static final int MAX_SIZE = 4;
	static char[][] arr;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id17863_round1j_testiq")));
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			readInput(sc);
			solve();
		}
	}

	private static void readInput(Scanner sc) {
		arr = new char[MAX_SIZE][MAX_SIZE];

		for (int i = 0; i < arr.length; i++) {
			String rowString = sc.next();
			for (int j = 0; j < rowString.length(); j++) {
				arr[i][j] = rowString.charAt(j);
			}
		}
	}

	private static void solve() {
		int count = 0;
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] != 2 * ('#' + '.')) {
					count++;
				}
			}
		}
		
		if (count > 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
