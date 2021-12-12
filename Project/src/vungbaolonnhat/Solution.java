package vungbaolonnhat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int T;
	static int h, w, m, n;
	static int[][] arr;
	static int[][] subArr;
	
	public static void main(String[] args) throws FileNotFoundException {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("vungbaolonnhat")));
			Scanner sc = new Scanner(System.in);
			
			T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				h = sc.nextInt();
				w = sc.nextInt();
				m = sc.nextInt();
				n = sc.nextInt();
				
				arr = new int[m][n];
				subArr = new int[h][w];
				
				// input
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						arr[i][j] = sc.nextInt(); 
					}
				}
				
				// solve
				int sum = 0;
				int offsetH = 0, offsetW = 0;
				
				while(true) {
					for (int i = 0; i < h; i++) {
						for (int j = 0; j < w; j++) {
							subArr[i][j] = arr[i + offsetH][j + offsetW];
						}
					}
					
					if (sum < sumMatrix(subArr, h, w)) {
						sum = sumMatrix(subArr, h, w);
					}
					
					offsetW++;
					if (offsetW > n-w) {
						offsetW = 0; // reset offsetW
						
						offsetH++;
						if (offsetH > m-h) {
							break;
						}
					}
				}
	
				System.out.println("#" + tc + " " + sum);
			}
		} catch (Exception e) {
			return;
		}
	}
	
	static int sumMatrix(int[][] arr, int h, int w) {
		int sum = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if ((i == 0 || i == h-1 || j == 0 || j == w-1) && arr[i][j] % 2 == 0) {
					sum += arr[i][j];
				}
			}
		}
		return sum;
	}
}
