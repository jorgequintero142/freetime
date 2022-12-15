public class Palindrome {

	public static void main(String[] jorge) {

		String originalText = "dabale arroz a la Zorra el abad";
		// remove spaces and continue using the same variable
		String result =  String.format("Is '%s' a palindrome? ", originalText);
		originalText = originalText.replace(" ", "");
		String reverse = reverseString(originalText);
		//Show the result
		System.out.println(result + originalText.equalsIgnoreCase(reverse));

	}

	static String reverseString(String txt) {
		String reverse = "";
		for (int i = txt.length() - 1; i >= 0; i--) {
			reverse += txt.charAt(i);
		}
		return reverse;
	}
}
