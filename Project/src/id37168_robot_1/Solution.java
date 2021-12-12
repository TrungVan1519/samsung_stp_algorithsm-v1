package id37168_robot_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int testCase;
	static int xRobot, yRobot;
	static int result;
	static int numberOfPos;
	
	static int robotDir;
	
	// position updating rules
	static int[] dx = { 0, -1, 0, 1 }; // row index
	static int[] dy = { -1, 0, 1, 0 }; // col index
	
	static enum DIR {
		LEFT, 	// 0
		UP,		// 1
		RIGHT,	// 2
		DOWN	// 3
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id37168_robot_1")));
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		for (int i = 1; i <= testCase; i++) {
			System.out.println("#" + i + " " + result);
			solve(sc);
		}
	}

	private static void solve(Scanner sc) {
		numberOfPos = sc.nextInt();
		int currentDir, nextDir;
		int txRobot, tyRobot;
		
		xRobot = sc.nextInt();
		yRobot = sc.nextInt();
		txRobot = sc.nextInt();
		tyRobot = sc.nextInt();
		currentDir = getDir(xRobot, yRobot, txRobot, tyRobot);
		
		for (int i = 0; i < numberOfPos; i++) {
			xRobot = txRobot;
			yRobot = tyRobot;
			txRobot = sc.nextInt();
			tyRobot = sc.nextInt();
			nextDir = getDir(xRobot, yRobot, txRobot, tyRobot);
			
			if ((currentDir + 1) % 4 == nextDir) {
				result++;
			}
			
			currentDir = nextDir;
		}
		
		System.out.println(result);
	}
	
	private static int getDir(int x1, int y1, int x2, int y2) {
		int dir = DIR.LEFT.ordinal(); // default is left
		
		if (x1 == x2 + 1 && y1 == y2) {
			dir = DIR.RIGHT.ordinal();
		} else if (x1 == x2 && y1 == y2 - 1) {
			dir = DIR.UP.ordinal();
		} else if (x1 == x2 && y1 == y2 + 1) {
			dir = DIR.DOWN.ordinal();
		}
		
		return dir;
	}
}
