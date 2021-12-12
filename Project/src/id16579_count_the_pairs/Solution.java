package id16579_count_the_pairs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import utils.MyPath;

public class Solution {
	
	/**
	 * Solution
	 * >>> Input arr
	 * >>> Sort arr manually or by using Arrays.sort()
	 * >>> Binary search "arr[i] + k" from arr manually or by using Arrays.binarySearch()
	 * >>> Summary to "result"
	 */
	
	static int testCase = 2;
	static int MAX_SIZE, k;
	static int[] arr;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id16579_count_the_pairs")));
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < testCase; i++) {
			readInput(sc);
			solve();
		}
		
		sc.close();
	}

	private static void readInput(Scanner sc) {
		MAX_SIZE = sc.nextInt();
		k = sc.nextInt();
		arr = new int[MAX_SIZE];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
	}

	private static void solve() {
		int res = 0;
		
		// sol1: manually
		for (int i = 0; i < arr.length; i++) {
			res += binarySearch(i, arr.length - 1, arr[i] + k);
		}
		
//		// sol2: use lib
//		for (int i = 0; i < arr.length; i++) {
//			if (Arrays.binarySearch(arr, arr[i] + k) >= 0) {
//				res++;
//			}
//		}
		
		System.out.println(res);
	}

	private static int binarySearch(int left, int right, int value) {
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2; // Prevent buffer overflow
			
			if (arr[mid] == value) {
				return 1;
			} else if (arr[mid] > value) {
				right = mid - 1;
			} else if (arr[mid] < value) {
				left = mid + 1;
			}
		}
		
		return 0;
	}
}
