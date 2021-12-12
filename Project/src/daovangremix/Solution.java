package daovangremix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int T;
	static int R, C;
	static char[][] arr;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("daovangremix")));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			arr = new char[R][C];
			int goldInRows = 0, goldInCols = 0;
			
			// input
			for (int i = 0; i < R; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			// solve
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] == '0') {
						if (checkRow(i, j)) {
							goldInRows++;
						}
						if (checkCol(i, j)) {
							goldInCols++;
						}
					}
				}
			}
			
			int validRows = goldInRows / C;
			int validCols = goldInCols / R; 
			int result =  goldInRows + goldInCols - validRows * validCols ;
			System.out.println("#" + tc + " " + result);
		}
	}

	private static boolean checkRow(int i, int j) {
		int count = 0;
		
		for (int k = 0; k < C; k++) {
			if (arr[i][k] == '0') {
				count++;
			}
		}

		return count == C;
	}

	private static boolean checkCol(int i, int j) {
		int count = 0;
		
		for (int k = 0; k < R; k++) {
			if (arr[k][j] == '0') {
				count++;
			}
		}
		
		return count == R;
	}
}
