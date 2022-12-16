public class ExistsPairInArrayGivenSum {

	public static void main(String[] jorge) {

		int[] arrayIntegers = {4,2,1,3,5,6,0,7,3};
		int givenSum = 6;

		System.out.println(existPair(arrayIntegers,givenSum));
	

	}

	static boolean existPair(int[] arrayIntegers, int givenSum) {
		for(int i =0; i < arrayIntegers.length-1; i++) {
			for(int x = i+1; x < arrayIntegers.length; x++) {
				if ((arrayIntegers[i]+arrayIntegers[x]) == givenSum) {
					//System.out.println(arrayIntegers[i]+"<>"+arrayIntegers[x]);
					return true;
				}

			}
		}
		return false;

	}
}
