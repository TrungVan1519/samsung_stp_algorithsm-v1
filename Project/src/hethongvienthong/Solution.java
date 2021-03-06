package hethongvienthong;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int row, col;
	static char[][] arr;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("hethongvienthong")));
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = sc.nextInt();
				col = sc.nextInt();
				arr = new char[row][col];
				int count = 0;

				// input
				for (int i = 0; i < row; i++) {
					String str = sc.next();
					for (int j = 0; j < str.length(); j++) {
						arr[i][j] = str.charAt(j);
					}
				}
				MyPath.showMatrix(arr, row, col);

				// solve
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == 'A') {
							for (int range = 1; range <= 1; range++) {
								cover(i, j, range);
							}
						} else if (arr[i][j] == 'B') {
							for (int range = 1; range <= 2; range++) {
								cover(i, j, range);
							}
						} else if (arr[i][j] == 'C') {
							for (int range = 1; range <= 3; range++) {
								cover(i, j, range);
							}
						}
					}
				}
				MyPath.showMatrix(arr, row, col);

				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (arr[i][j] == 'H') {
							count++;
						}
					}
				}

				System.out.println("#" + tc + " " + count);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void cover(int x, int y, int range) {
		int tx = 0, ty = 0;
		
		for (int i = 0; i < 4; i++) {
			tx = x + dx[i] * range;
			ty = y + dy[i] * range;
			
			if (tx < 0 || tx > row - 1 || ty < 0 || ty > col - 1) {
				continue;
			}
			
			if (arr[tx][ty] == 'H') {
				arr[tx][ty] = 'X';
			}
		}
		
//		if (y + dy[0] * range >= 0 && arr[x + dx[0] * range][y + dy[0] * range] == 'H') {
//			arr[x + dx[0] * range][y + dy[0] * range] = 'X';
//		}
//		if (y + dy[2] * range <= col - 1 && arr[x + dx[2] * range][y + dy[2] * range] == 'H') {
//			arr[x + dx[2] * range][y + dy[2] * range] = ' ';
//		}
//		if (x + dx[1] * range >= 0 && arr[x + dx[1] * range][y + dy[1] * range] == 'H') {
//			arr[x + dx[1] * range][y + dy[1] * range] = 'X';
//		}
//		if (x + dx[3] * range <= row - 1 && arr[x + dx[3] * range][y + dy[3] * range] == 'H') {
//			arr[x + dx[3] * range][y + dy[3] * range] = 'X';
//		}
	}
}
