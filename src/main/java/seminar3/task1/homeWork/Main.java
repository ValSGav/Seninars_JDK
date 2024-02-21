package seminar3.task1.homeWork;


public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try {
            System.out.println(calc.divide(4, 5.0));
            System.out.println(calc.divide(4.0f, 5.0d));

            System.out.println(calc.sum(4, 5.0));
            System.out.println(calc.sum(4.0f, 5.08787878787878d));

            System.out.println(calc.substract(4, 5.2));
            System.out.println(calc.substract(4.0f, 5.777777777777d));

            System.out.println(calc.multiply(4, 5.3));
            System.out.println(calc.multiply(4.0f, 5.0d));

            System.out.println(calc.divide("su", 0));
            System.out.println(calc.divide(4.0f, 0));

        } catch (Exception e) {
            System.out.println("Возникала проблема" + e);
        }


        Integer[] arr1 = {1, 3, 5, 9};
        Integer[] arr2 = {1, 3, 5, 9};
        Integer[] arr2_2 = {1, 3, 5, 9, 7};
        Double[] arr3 = {1.0, 3.0, 5.0, 9.0};
        String[] arr4 = {"1", "3", "5", "9"};
        String[] arr5 = {"1", "3", "5", "9"};

        ArraysComparator aC = new ArraysComparator();

        System.out.println(aC.compareArrays(arr1, arr2));
        System.out.println(aC.compareArrays(arr1, arr2_2));
        System.out.println(aC.compareArrays(arr1, arr3));
        System.out.println(aC.compareArrays(arr1, arr4));
        System.out.println(aC.compareArrays(arr3, arr4));
        System.out.println(aC.compareArrays(arr4, arr5));


        Pair<Calculator, Integer> pair1 = new Pair<>(new Calculator(), 3);
        Pair<Calculator, String> pair2 = new Pair<>(new Calculator(), "musha");
        Pair<String[], String> pair3 = new Pair<>(new String[]{"12", "goda"}, "musha");

        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(pair3);

        System.out.println(pair1.getFirst());
        System.out.println(pair3.getSecond());


    }
}
