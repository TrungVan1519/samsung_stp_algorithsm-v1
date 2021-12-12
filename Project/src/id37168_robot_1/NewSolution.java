package id37168_robot_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class NewSolution {

	static int testCase;
	static int numberOfPos;
	static int[][] arr;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id37168_robot_1")));
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		for (int i = 1; i <= testCase; i++) {
			readInput(sc);
			System.out.print("#" + i + " ");
			solve();
		}
	}
	
	private static void readInput(Scanner sc) {
		numberOfPos = sc.nextInt();
		arr = new int[numberOfPos][2];
		
		for (int j = 0; j < numberOfPos; j++) {
			arr[j][0] = sc.nextInt();
			arr[j][1] = sc.nextInt();
		}
	}
	
	private static void solve() {
		int currentDir, nextDir;
		int result = 0;
		
		currentDir = getDir(arr[0][0], arr[0][1], arr[1][0], arr[1][1]);
		for (int i = 1; i < numberOfPos - 1; i++) {
			nextDir = getDir(arr[i][0], arr[i][1], arr[i+1][0], arr[i+1][1]);
			
			if ((currentDir + 1) % 4 == nextDir) {
				result++;
			}
			
			currentDir = nextDir;
		}
		
		System.out.println(result);
	}

	private static int getDir(int x1, int y1, int x2, int y2) {
		int dir= 0; // default is left
		
		if (x1 == x2 && y1 == y2 - 1) {
			dir = 1;
		} else if (x1 == x2 - 1 && y1 == y2) {
			dir = 2;
		} else if (x1 == x2 && y1 == y2 + 1) {
			dir = 3;
		}
		
		return dir;
	}
}
