package task3;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(10, "Hello");
        System.out.println(pair1);
        System.out.println("First element: " + pair1.getFirst());
        System.out.println("Second element: " + pair1.getSecond());

        Pair<Double, Character> pair2 = new Pair<>(3.14, 'A');
        System.out.println(pair2);
        System.out.println("First element: " + pair2.getFirst());
        System.out.println("Second element: " + pair2.getSecond());

        RecordPair<String,Integer> pair = new RecordPair<>("Text", 100);
        System.out.println(pair);
    }
}
