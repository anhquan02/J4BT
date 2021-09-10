package utils;

public class HelperUtils {
	private HelperUtils() {
		// TODO Auto-generated constructor stub
	}

	public static boolean checkNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
