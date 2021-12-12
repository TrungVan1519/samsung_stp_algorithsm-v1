package id36933_he_thong_phan_tich_rem_cua;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {
	
	static int T;
	static int m, n;
	static int row, col;
	static int[][] window;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id36933_he_thong_phan_tich_rem_cua")));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			m = sc.nextInt();
			n = sc.nextInt();
			row = 5*m + 1;
			col = 5*n + 1;
			window = new int[row][col];
			int[] types = new int[5];
			
			// input
			for (int i = 0; i < 5*m + 1; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					window[i][j] = str.charAt(j); 
				}
			}
			
			// solve: check cot dau tien cua moi o cua so thay vi check toan bo 4 hang va 4 cot cua o cua so
			int index;
			for (int i = 1; i < row; i+=5) {
				for (int j = 1; j < col; j+=5) {
					index = 0; // gia su ban dau la type0
					for (int k = i; k < i + 5; k++) {
						if (window[k][j] == '*') {
							index++;
						}
					}
					types[index]++;
				}
			}
			
//			for (int j = 1; j < col; j+=5) {
//				for (int i = 1; i < row; i+=5) {
//					index = 0; // gia su ban dau la type0
//					for (int k = i; k < i + 5; k++) {
//						if (window[k][j] == '*') {
//							index++;
//						}
//					}
//					types[index]++;
//				}
//			}
			
			// print result
			String result = "";
			for (int i = 0; i < types.length; i++) {
				result += types[i] + " ";
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
