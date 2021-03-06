package id37144_pacman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.MyPath;

public class Solution {
	
	static int T;
	
	static int size, length;
	static int[][] arr; // map
	static char[] pacman, ghost;
	
	// direction depends on "L", "R" and "C"
	static int dirPacman, dirGhost;
	
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
		System.setIn(new FileInputStream(MyPath.getAbsoltePath("id37144_pacman")));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			readInput(sc);
			System.out.print("#" + i + " ");
			solve();
		}
	}

	private static void readInput(Scanner sc) {
//	    pacDir = 3;
//	    ghostDir = 1;
	    dirPacman = DIR.DOWN.ordinal();
	    dirGhost = DIR.UP.ordinal();
	    
		size = sc.nextInt();
		length = sc.nextInt();
		
		arr = new int[size][size];
		pacman = new char[length];
		ghost = new char[length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// PACMAN MOVEMENT
		String pacMoveString = sc.next();
		for (int i = 0; i < pacMoveString.length(); i++) {
			pacman[i] = pacMoveString.charAt(i);
		}

		// GHOST MOVEMENT
		String ghostMoveString = sc.next();
		for (int i = 0; i < ghostMoveString.length(); i++) {
			ghost[i] = ghostMoveString.charAt(i);
		}
	}

	private static void solve() {
	    int txPacman = 0, tyPacman = 0;
	    int txGhost = size - 1, tyGhost = size - 1;
	    long pacGold = 0, ghostGold = 0;
	 
	    for (int i = 0; i < length; i++) {
	        // PACMAN
	        if (pacman[i] == 'C') {
	            txPacman += dx[dirPacman];
	            tyPacman += dy[dirPacman];
	        }
	        else if (pacman[i] == 'L') {
	            dirPacman = turnLeft(dirPacman);
	            txPacman += dx[dirPacman];
	            tyPacman += dy[dirPacman];
	 
	        }
	        else if (pacman[i] == 'R') {
	        	dirPacman = turnRight(dirPacman);
	            txPacman += dx[dirPacman];
	            tyPacman += dy[dirPacman];
	        }
	 
	        // GHOST
	        if (ghost[i] == 'C') {
	            txGhost += dx[dirGhost];
	            tyGhost += dy[dirGhost];
	        }
	        else if (ghost[i] == 'L') {
	        	dirGhost = turnLeft(dirGhost);
	            txGhost += dx[dirGhost];
	            tyGhost += dy[dirGhost];
	        }
	        else if (ghost[i] == 'R') {
	        	dirGhost = turnRight(dirGhost);
	            txGhost += dx[dirGhost];
	            tyGhost += dy[dirGhost];
	        }
	 
	 
	        if (txPacman == txGhost && tyPacman == tyGhost) {
	            break;
	        } else {
	            pacGold += arr[txPacman][tyPacman];
	            arr[txPacman][tyPacman] = 0;
	            ghostGold += arr[txGhost][tyGhost];
	            arr[txGhost][tyGhost] = 0;
	        }
	    }
	 
	    System.out.println(pacGold + " " + ghostGold);
	}
	
	private static int turnLeft(int x) {
	    return (x + 3) % 4;
	}
	 
	private static int turnRight(int x) {
	    return (x + 1) % 4;
	}
}
