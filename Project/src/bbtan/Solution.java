package bbtan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static enum DIR {
		LEFT, UP, RIGHT, DOWN
	};

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("bbtan")));
		Scanner sc = new Scanner(System.in);

		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];

			int ballDir = DIR.RIGHT.ordinal();
			int txBall = 0, tyBall = 0;
			int count = 0;

			// input
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// solve
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					System.out.println(txBall + "," + tyBall);

					if (txBall < 0 || txBall > N - 1 || tyBall < 0 || tyBall > N - 1) {
						break;
					}

					if (arr[txBall][tyBall] == '0') {
						txBall += dx[ballDir];
						tyBall += dy[ballDir];
					} else if (arr[txBall][tyBall] == '\\') {
						count++;

						if (ballDir == DIR.RIGHT.ordinal() || ballDir == DIR.LEFT.ordinal()) {
							ballDir = turnRight(ballDir);
						} else if (ballDir == DIR.UP.ordinal() || ballDir == DIR.DOWN.ordinal()) {
							ballDir = turnLeft(ballDir);
						}

						txBall += dx[ballDir];
						tyBall += dy[ballDir];
					} else if (arr[txBall][tyBall] == '/') {
						count++;

						if (ballDir == DIR.RIGHT.ordinal() || ballDir == DIR.LEFT.ordinal()) {
							ballDir = turnLeft(ballDir);
						} else if (ballDir == DIR.UP.ordinal() || ballDir == DIR.DOWN.ordinal()) {
							ballDir = turnRight(ballDir);
						}

						txBall += dx[ballDir];
						tyBall += dy[ballDir];
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}
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
