package id37191_robot_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int testCase;
	static int desX, desY, MOVEMENT_SIZE;
	static char[] robotA, robotB;
	static boolean robotAFinished, robotBFinished;
	static int txRobotA, tyRobotA, txRobotB, tyRobotB;

	static int dirRobotA, dirRobotB;

	// position updating rules
	static int[] dx = { -1, 0, 1, 0 }; // row index
	static int[] dy = { 0, 1, 0, -1 }; // col index

	static enum DIR {
		LEFT, // 0
		UP, // 1
		RIGHT, // 2
		DOWN // 3
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id37191_robot_2")));
		Scanner sc = new Scanner(System.in);

		testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			robotAFinished = false;
			robotBFinished = false;
			readInput(sc);
			System.out.print("#" + i + " ");
			solve();
		}
	}

	private static void readInput(Scanner sc) {
		desX = sc.nextInt();
		desY = sc.nextInt();

		MOVEMENT_SIZE = sc.nextInt();
		robotA = new char[MOVEMENT_SIZE];
		robotB = new char[MOVEMENT_SIZE];

		String robotAMovementString = sc.next();
		for (int i = 0; i < robotAMovementString.length(); i++) {
			robotA[i] = robotAMovementString.charAt(i);
		}

		String robotBMovementString = sc.next();
		for (int i = 0; i < robotBMovementString.length(); i++) {
			robotB[i] = robotBMovementString.charAt(i);
		}
	}

	private static void solve() {
		txRobotA = 0;
		tyRobotA = 0;
		dirRobotA = DIR.UP.ordinal();
		for (int i = 0; i < robotA.length; i++) {
			if (txRobotA == desX && tyRobotA == desY) {
				robotAFinished = true;
				break;
			}

			if (robotA[i] == 'C') {
				txRobotA += dx[dirRobotA];
				tyRobotA += dy[dirRobotA];
			} else if (robotA[i] == 'L') {
				dirRobotA = turnLeft(dirRobotA);
				txRobotA += dx[dirRobotA];
				tyRobotA += dy[dirRobotA];
			} else if (robotA[i] == 'R') {
				dirRobotA = turnRight(dirRobotA);
				txRobotA += dx[dirRobotA];
				tyRobotA += dy[dirRobotA];
			} else if (robotA[i] == 'B') {
				dirRobotA = turnBack(dirRobotA);
				txRobotA += dx[dirRobotA];
				tyRobotA += dy[dirRobotA];
			} else if (robotA[i] == 'W') {
				dirRobotA = DIR.LEFT.ordinal();
				txRobotA--;
			} else if (robotA[i] == 'N') {
				dirRobotA = DIR.UP.ordinal();
				tyRobotA++;
			} else if (robotA[i] == 'E') {
				dirRobotA = DIR.RIGHT.ordinal();
				txRobotA++;
			} else if (robotA[i] == 'S') {
				dirRobotA = DIR.DOWN.ordinal();
				tyRobotA--;
			}
		}

		txRobotB = 0;
		tyRobotB = 0;
		dirRobotB = DIR.UP.ordinal();
		for (int i = 0; i < robotB.length; i++) {
			if (txRobotB == desX && tyRobotB == desY) {
				robotBFinished = true;
				break;
			}

			if (robotB[i] == 'C') {
				txRobotB += dx[dirRobotB];
				tyRobotB += dy[dirRobotB];
			} else if (robotB[i] == 'L') {
				dirRobotB = turnLeft(dirRobotB);
				txRobotB += dx[dirRobotB];
				tyRobotB += dy[dirRobotB];
			} else if (robotB[i] == 'R') {
				dirRobotB = turnRight(dirRobotB);
				txRobotB += dx[dirRobotB];
				tyRobotB += dy[dirRobotB];
			} else if (robotB[i] == 'B') {
				dirRobotB = turnBack(dirRobotB);
				txRobotB += dx[dirRobotB];
				tyRobotB += dy[dirRobotB];
			} else if (robotB[i] == 'W') {
				dirRobotB = DIR.LEFT.ordinal();
				txRobotB--;
			} else if (robotB[i] == 'N') {
				dirRobotB = DIR.UP.ordinal();
				tyRobotB++;
			} else if (robotB[i] == 'E') {
				dirRobotB = DIR.RIGHT.ordinal();
				txRobotB++;
			} else if (robotB[i] == 'S') {
				dirRobotB = DIR.DOWN.ordinal();
				tyRobotB--;
			}
		}

		if (robotAFinished && robotBFinished) {
			System.out.println("Good game!");
		} else if (robotAFinished && !robotBFinished) {
			System.out.println("Team A win");
		} else if (!robotAFinished && robotBFinished) {
			System.out.println("Team B win");
		} else {
			String result = calculateDistance(txRobotA, tyRobotA, desX, desY) + " "
					+ calculateDistance(txRobotB, tyRobotB, desX, desY);
			System.out.println(result);
		}
	}

	private static int turnLeft(int x) {
		return (x + 3) % 4;
	}

	private static int turnRight(int x) {
		return (x + 1) % 4;
	}

	private static int turnBack(int x) {
		return (x + 2) % 4;
	}

	private static String calculateDistance(int x1, int y1, int x2, int y2) {
		return new DecimalFormat("#0.000").format(Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
	}
}
