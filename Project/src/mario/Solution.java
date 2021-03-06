package mario;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int T, row;
	static int txMario, tyMario;
	static char[][] arr;
	static char[] marioMovement;
	static boolean check;
	static long count;

	static int[] dx = { -1, -1, -1 };
	static int[] dy = { -1, 0, 1 };

	static int marioDir;

	static enum DIR {
		UP_LEFT, UP, UP_RIGHT
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("mario")));
			Scanner sc = new Scanner(System.in);

			T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				row = sc.nextInt();
				arr = new char[row][5];

				// input
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < 5; j++) {
						arr[i][j] = sc.next().charAt(0);
					}
				}

				String str = sc.next();
				marioMovement = new char[str.length()];
				for (int i = 0; i < str.length(); i++) {
					marioMovement[i] = str.charAt(i);
				}

				// solve
				check = true;
				count = 0;
				txMario = row; // mario is out of the map at this point
				tyMario = 2;
				marioDir = DIR.UP.ordinal();
				for (int i = 0; i < marioMovement.length; i++) {
					if (marioMovement[i] == 'C') {
						marioDir = DIR.UP.ordinal();
					} else if (marioMovement[i] == 'L') {
						marioDir = DIR.UP_LEFT.ordinal();
					} else if (marioMovement[i] == 'R') {
						marioDir = DIR.UP_RIGHT.ordinal();
					}

					txMario += dx[marioDir];
					tyMario += dy[marioDir];
					
					// (Dữ liệu đầu vào đảm bảo Mario chỉ di chuyển trong phạm vi trên cầu) nen khong can check nam ngoai arr
					// Nhung the deo nao bai nay van phai check -__- cay vl
					// case 1
//					if (txMario < 0 || txMario > row - 1 || tyMario < 0 || tyMario > 5 - 1) {
//						break;
//					}
					// case 2
					if (txMario < 0 || tyMario < 0) {
						break;
					}

					if (arr[txMario][tyMario] == '2') {
						check = false;
						break;
					}

					if (arr[txMario][tyMario] == '1') {
						count++;
					}
				}

				if (check) {
					System.out.println("#" + tc + " YES" + " " + count);
				} else {
					System.out.println("#" + tc + " NO");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
