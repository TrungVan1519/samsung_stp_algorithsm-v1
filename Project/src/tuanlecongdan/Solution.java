package tuanlecongdan;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int T, R, C;
	static char[][] arr;
	static int markedX, markedY;
	static int count, tmpCount;
	static int result;

	// 0-1 -1-1 -10 -11 01 11 10 1-1
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("tuanlecongdan")));
			Scanner sc = new Scanner(System.in);

			R = sc.nextInt();
			C = sc.nextInt();
			arr = new char[R][C];
			markedX = -1;
			markedY = -1;
			count = 0;
			tmpCount = 0;
			result = 0;

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
					if (arr[i][j] == '.') {
						tmpCount = check(i, j);
						if (count < tmpCount) {
							count = tmpCount;
							markedX = i;
							markedY = j;
						}
					}
				}
			}
			
			if (markedX != -1 && markedY != -1) {
				arr[markedX][markedY] = 'o';
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] == 'o') {
						result += check(i, j);
					}
				}
			}
			
			result /= 2;
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int check(int x, int y) {
		int tx = 0, ty = 0;
		int count = 0;
		for (int i = 0; i < dx.length; i++) {
			tx = x + dx[i];
			ty = y + dy[i];

			if (tx < 0 || tx > R - 1 || ty < 0 || ty > C - 1) {
				continue;
			}

			if (arr[tx][ty] == 'o') {
				count++;
			}
		}
		return count;
	}
}
