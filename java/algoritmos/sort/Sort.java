public class Sort {

    /**
     * Algorithm to sort an array of integers
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        int[] elements = {2, 7, 3, 9, 4, 1, 5, 6, 2};
        for (int i = 0; i < elements.length; i++) {
            for (int x = 0; x < elements.length; x++) {
                if (elements[i] < elements[x]) {
                    System.out.println("Current array.....");
                    print(elements);

                    int tmp = elements[x];
                    elements[x] = elements[i];
                    elements[i] = tmp;

                    System.out.println("Sorting.....");
                    Thread.sleep(2000);
                    print(elements);
                    System.out.println("");
                }
            }
        }

        System.out.println("Result: ");
        print(elements);
    }


    private static void print(int[] elements) throws Exception {
        System.out.print(" { ");
        for (int i : elements) {
            System.out.print(i + ",");
            Thread.sleep(100);
        }
        System.out.println(" }");
    }
}
