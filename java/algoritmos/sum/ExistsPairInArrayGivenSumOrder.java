import java.util.Arrays;
public class ExistsPairInArrayGivenSumOrder {

        public static void main(String[] jorge) {

                int[] arrayIntegers = {4,2,1,3,5,6,0,7,3};
                int givenSum = 6;

                System.out.println(existPair(arrayIntegers,givenSum));


        }

	static boolean existPair(int[] arrayIntegers, int givenSum) {
	    
	    int l = 0;
	    int r = arrayIntegers.length-1;
	    // sort	
	    Arrays.sort(arrayIntegers);
	    while(l<r) {
		int resultTmp = arrayIntegers[l]+arrayIntegers[r];

		if (resultTmp == givenSum) {
			return true;
		} else if (resultTmp>givenSum) {
			r--; 
		} else {
			l++;
		}
	   }
	   return false;
	}
}
