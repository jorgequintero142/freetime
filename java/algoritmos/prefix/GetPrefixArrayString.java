
public class GetPrefixArrayString {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arrayStr = { "developer", "devr", "dev", "development" };
		System.out.println(getPrefix(arrayStr));
	}

	/**
	 * 
	 * @param arrayStr
	 * @return
	 */
	private static String getPrefix(String[] arrayStr) {
		int length = arrayStr.length;
		if (length == 0) {
			return "";
		} else if (length == 1) {
			return arrayStr[0];
		}
		int lastPosition = 0;
		int elementValidLenght = arrayStr[0].length();
		iterate: for (int i = 0; i <= elementValidLenght; i++) {
			String tmp = arrayStr[0].substring(0, i);

			for (int e = 0; e < length; e++) {
				if (i <= arrayStr[e].length() && tmp.equals(arrayStr[e].substring(0, i))) {
					continue;
				} else {
					break iterate;
				}
			}

			lastPosition = i;
		}
		return arrayStr[0].substring(0, lastPosition);
	}
}
