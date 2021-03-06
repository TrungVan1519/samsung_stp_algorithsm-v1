package utils;

public class MyPath {
	private static String prefix = "C:\\Users\\Admin\\Desktop\\STP\\Project\\src\\";

	public static String getAbsoltePath(String packageName) {
		return prefix + packageName + "\\input.txt";
	}

	public static void showMatrix(int[][] arr, int h, int w) {
		String tmp = "";
		for (int i = 0; i < h; i++) {
			tmp += "\n";
			for (int j = 0; j < w; j++) {
				tmp += arr[i][j] + "\t";
			}
		}
		System.out.println(tmp);
	}

	public static void showMatrix(char[][] arr, int h, int w) {
		String tmp = "";
		for (int i = 0; i < h; i++) {
			tmp += "\n";
			for (int j = 0; j < w; j++) {
				tmp += arr[i][j] + "\t";
			}
		}
		System.out.println(tmp);
	}
}
