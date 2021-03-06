package bbtan2;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int T, size;
	static char[][] arr;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static enum DIR {
		LEFT, UP, RIGHT, DOWN
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("bbtan2")));
			Scanner sc = new Scanner(System.in);

			T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				size = sc.nextInt();
				
				arr = new char[size][size];
				int markedX = 0, markedY = 0;
				int score = 0, tmpScore = 0;

				// input
				for (int i = 0; i < size; i++) {
					String str = sc.next();
					for (int j = 0; j < str.length(); j++) {
						arr[i][j] = str.charAt(j);
					}
				}

				// solve
				// first col
				for (int i = 0; i < size; i++) {
					tmpScore = move(i, 0, DIR.RIGHT.ordinal());

					if (score < tmpScore) {
						score = tmpScore;
						markedX = i;
						markedY = 0;
					}
				}

				// last row
				for (int j = 0; j < size; j++) {
					tmpScore = move(size - 1, j, DIR.UP.ordinal());

					if (score < tmpScore) {
						score = tmpScore;
						markedX = size - 1;
						markedY = j;
					}
				}

				// last col
				for (int i = size - 1; i >= 0; i--) {
					tmpScore = move(i, size - 1, DIR.LEFT.ordinal());

					if (score < tmpScore) {
						score = tmpScore;
						markedX = i;
						markedY = size - 1;
					}
				}

				// first row
				for (int j = size - 1; j >= 0; j--) {
					tmpScore = move(0, j, DIR.DOWN.ordinal());

					if (score < tmpScore) {
						score = tmpScore;
						markedX = 0;
						markedY = j;
					}
				}

				System.out.println("#" + tc + " " + markedX + " " + markedY + " " + score);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int move(int x, int y, int ballDir) {
		int txBall = x, tyBall = y;
		int count = 0;

		while (!(txBall < 0 || txBall >= size || tyBall < 0 || tyBall >= size)) {
			if (arr[txBall][tyBall] == '\\') {
				count++;

				if (ballDir == DIR.RIGHT.ordinal() || ballDir == DIR.LEFT.ordinal()) {
					ballDir = turnRight(ballDir);
				} else if (ballDir == DIR.UP.ordinal() || ballDir == DIR.DOWN.ordinal()) {
					ballDir = turnLeft(ballDir);
				}
			} else if (arr[txBall][tyBall] == '/') {
				count++;

				if (ballDir == DIR.RIGHT.ordinal() || ballDir == DIR.LEFT.ordinal()) {
					ballDir = turnLeft(ballDir);
				} else if (ballDir == DIR.UP.ordinal() || ballDir == DIR.DOWN.ordinal()) {
					ballDir = turnRight(ballDir);
				}

			}

			txBall += dx[ballDir];
			tyBall += dy[ballDir];
		}

		return count;
	}

	static int turnLeft(int x) {
		return (x + 3) % 4;
	}

	static int turnRight(int x) {
		return (x + 1) % 4;
	}

	static int turnBack(int x) {
		return (x + 2) % 4;
	}
}
