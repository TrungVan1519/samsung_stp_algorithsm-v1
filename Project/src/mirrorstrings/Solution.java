package mirrorstrings;

import java.io.FileInputStream;
import java.util.Scanner;

import utils.MyPath;

public class Solution {

	static String str, sub;
	static int len, count;
	
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(MyPath.getAbsoltePath("mirrorstrings")));
			Scanner sc = new Scanner(System.in);

			int T = sc.nextInt();
			for (int tc = 0; tc < T; tc++) {
				str = sc.next();
				sub = "";
				len = 0;
				count = 0;
				int lastIndex = 0;

				for (int i = 0; i < str.length(); i++) {
					for (int j = str.length() - 1; j >= i ; j--) {
						if (str.charAt(i) == str.charAt(j)) {
							String cut = str.substring(i, j + 1);
							if (isSymmetric(cut) && cut.length() > sub.length()) {
								sub = cut;
							}
						}
					}
				}
				
				len = sub.length();
				
				if (len > 1) {
					while (lastIndex != -1) {
						lastIndex = str.indexOf(sub, lastIndex);
						if (lastIndex != -1) {
							count++;
							lastIndex += sub.length();
						}
					}
				} else {
					count = str.length();
				}

				System.out.println(len + " " + count);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static boolean isSymmetric(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
