package dominremix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int row, col, count, T;
	static char[][] arr;

	// 0-1 -1-1 -10 -11 01 11 10 1-1
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("dominremix")));
			Scanner sc = new Scanner(System.in);

			T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = sc.nextInt();
				col = sc.nextInt();
				arr = new char[row][col];
				count = 0;

				// input
				for (int i = 0; i < row; i++) {
					String str = sc.next();
					for (int j = 0; j < str.length(); j++) {
						arr[i][j] = str.charAt(j);
					}
				}

				// solve
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == '.') {
							check(i, j);
						}
					}
				}
				
				System.out.println("Case #" + tc + ": " + count);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void check(int x, int y) {
		int tx = 0, ty = 0;
		for (int i = 0; i < 8; i++) {
			tx = x + dx[i];
			ty = y + dy[i];
			
			if (tx < 0 || tx > row - 1 || ty < 0 || ty > col - 1) {
				continue;
			}
			
			if (arr[tx][ty] == '*') {
				count++;
			}
		}
	}
}
