package task2;

import static task2.ArrayComparator.compareArrays;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {1, 2, 3, 4, 5};
        System.out.println(compareArrays(intArray1, intArray2));

        String[] strArray1 = {"apple", "banana", "orange"};
        String[] strArray2 = {"apple", "banana", "orange"};
        System.out.println(compareArrays(strArray1, strArray2));

        Double[] doubleArray1 = {1.5, 2.5, 3.5};
        Double[] doubleArray2 = {1.5, 2.5, 3.5};
        System.out.println(compareArrays(doubleArray1, doubleArray2));

        Character[] charArray1 = {'a', 'b', 'c'};
        Character[] charArray2 = {'a', 'b'};
        System.out.println(compareArrays(charArray1, charArray2));

    }
}
