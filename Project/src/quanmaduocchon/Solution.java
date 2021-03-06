package quanmaduocchon;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static int T;
	
	static int size, K, M, D;
	static char[][] arr;
	static int[] Ks, Ms, Ds;

	// -1-2 -2-1 -21 -12 12 21 2-1 1-2
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:\\Users\\Admin\\Desktop\\STP-sample\\Project\\src\\quanmaduocchon\\input.txt"));
			Scanner sc = new Scanner(System.in);
			
			T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				int count = 0;
				int chosen = 0;
				size = sc.nextInt();
				K = sc.nextInt();
				M = sc.nextInt();
				D = sc.nextInt();

				arr = new char[size][size];
				Ks = new int[K * 2];
				Ms = new int[M * 2];
				Ds = new int[D * 2];

				// input
				for (int i = 0; i < Ks.length; i++) {
					Ks[i] = sc.nextInt();
				}

				for (int i = 0; i < Ms.length; i++) {
					Ms[i] = sc.nextInt();
				}

				for (int i = 0; i < Ds.length; i++) {
					Ds[i] = sc.nextInt();
				}

				// fill knights, others and doNots into arr
				for (int i = 0; i < Ks.length; i++) {
					if (i % 2 == 0 && i + 1 < Ks.length) {
						arr[Ks[i]][Ks[i + 1]] = 'K';
					}
				}

				for (int i = 0; i < Ms.length; i++) {
					if (i % 2 == 0 && i + 1 < Ms.length) {
						arr[Ms[i]][Ms[i + 1]] = 'P';
					}
				}

				for (int i = 0; i < Ds.length; i++) {
					if (i % 2 == 0 && i + 1 < Ds.length) {
						arr[Ds[i]][Ds[i + 1]] = 'X';
					}
				}

				// solve
				for (int i = 0; i < Ks.length; i++) {
					if (i % 2 == 0 && i + 1 < Ks.length) {
						if (count < check(Ks[i], Ks[i + 1])) {
							count = check(Ks[i], Ks[i + 1]);
							chosen = i;
						}
					}
				}

				System.out.println("#" + tc + " " + Ks[chosen] + " " + Ks[chosen + 1] + " " + count);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int check(int x, int y) {
		int count = 0;
		int tx = 0, ty = 0;
		for (int i = 0; i < 8; i++) {
			tx = x + dx[i];
			ty = y + dy[i];

			if (tx < 0 || tx > size - 1 || ty < 0 || ty > size - 1) {
				continue;
			}

			if (arr[tx][ty] == 'K' || arr[tx][ty] == 'P') {
				count++;
			}
		}
		return count;
	}
}
