package toandflo;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("toandflo")));
			Scanner sc = new Scanner(System.in);

			while(true) {
				int cols = sc.nextInt();
				
				if (cols == 0) {
					break;
				}
				
				String str = sc.next();
				int rows = str.length() / cols;
				char[][] arr = new char[rows][cols];
				
				// input
				int index = 0;
				for (int i = 0; i < rows; i++) {
					if (i % 2 == 0) {
						for (int j = 0; j < cols; j++) {
							arr[i][j] = str.charAt(index);
							if (index < str.length()) {
								index++;
							}
						}
					} else {
						for (int j = cols - 1; j >= 0; j--) {
							arr[i][j] = str.charAt(index);
							if (index < str.length()) {
								index++;
							}
						}
					}
				}
				
				// solve
				String result = "";
				for (int j = 0; j < cols; j++) {
					for (int i = 0; i < rows; i++) {
						result += arr[i][j];
					}
				}
				
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
