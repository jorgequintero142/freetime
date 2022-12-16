public class Anagram {

	public static void main(String[] jorge) {

		String first = "monkeys write ";
		String second = "new york times";

         	String result = String.format("'%s' y '%s'", first, second);

		first = order(first);
		second = order(second);

		if (first.equals(second)) {

			result +=" son anagramas ";
		} else {
			result += "no son anagramas"; 
		}

		System.out.println(result);

	}


	static String order(String str) {
		StringBuilder sb = new StringBuilder(str);
		for(int x=0; x<str.length(); x++) {
			for (int y=0; y<str.length(); y++ ) {
				if (str.charAt(x) > (str.charAt(y))) {
				char tmp = str.charAt(x);
				sb.setCharAt(x,str.charAt(y));
				sb.setCharAt(y,tmp);
				str = sb.toString();
				

				}			}	
		}

	return sb.toString();	
	}

}
