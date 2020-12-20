import java.util.HashMap;
import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static final int MAX_INT_IN_ARRAY = 20;

    public static void main(String[] args) {
        int[] arrayToCount = getArrayToCount(10 + random.nextInt(100));
        System.out.println("Counting with array...");
        countItems(arrayToCount);
        System.out.println("----------------------");
        System.out.println("Counting with Map");
        countItemsUsingMap(arrayToCount);

    }

    public static int[] getArrayToCount(int size) {
        System.out.println("Building array of " + size + " elements");
        int[] arrayToCount = new int[size];
        for (int i = 0; i < size; i++) {
            arrayToCount[i] = random.nextInt(MAX_INT_IN_ARRAY) + 1;
        }
        return arrayToCount;
    }
    // Решение в лоб, как было указано в ТЗ
    public static void countItems(int[] arrayToCount) {
        int[] counter = new int[MAX_INT_IN_ARRAY];
        for (int i = 0; i < arrayToCount.length; i++) {
            counter[arrayToCount[i]-1]++;
        }
        for (int i = 0; i < counter.length; i++) {
            System.out.println("Number " + (i + 1) + " found in array " + counter[i] + " times.");
        }

    }

    // Решение с использованием Map, подойдет не только для чисел, но и для деревьев и любых других объектов
    public static void countItemsUsingMap(int[] arrayToCount) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        for (int i = 0; i < arrayToCount.length; i++) {
            if (counter.containsKey(arrayToCount[i])) {
                int count = counter.get(arrayToCount[i]);
                counter.put(arrayToCount[i], count + 1);
            } else {
                counter.put(arrayToCount[i], 1);
            }
        }
        counter.forEach((key,value) ->
                System.out.println("Number " + key + " found in array " + value + " times."));

    }
}
