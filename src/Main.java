import java.util.HashMap;
import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static final int MAX_INT_IN_ARRAY = 20;

    public static void main(String[] args) {
        int[] arrayToCountFromTask = new int[]{
                5,1,5,2,2,4,1,4,5,1,5,3,2,4,4,4,5,1,3,4,2,2,1,2,4,
                4,4,5,4,3,5,4,4,5,5,1,4,1,5,3,1,4,5,3,3,4,2,2,4,4,
                5,5,1,1,1,4,5,5, 4,4,2,4,3,1,3,3,1,1,3,1,3,4,4,3,2,
                2,1,3,4,4,2,3,4,2,4,4,1,4,4,4,2,1,2,4,1,5,2,2,5,4,2,
                2,3,1,5,5,3,5,3,1,4,5,4,2,1,3,1,2,1,4,1,3,4,2,2,5,2,
                3,1,1,2,3,3,4,4,2,4,1,2,2,2,5,1,5,1,2,2,1,3,3,4,3,5,
                3,5,1,2,1,3,3,2,4,1,4,3,5,1,2,1,2,3,2,1,3,
                2,2,4,3,2,1,5,1,4,5,4,4,5,5,4,2,3,5,1,3,4,
                3,2,4,5,2,5,2,4,1,4,5,2,3,3,4,4,3,5,2,2,3,5,1,2,4,3,4,4,3,2,2,1,4,5,5,1,5,
                2,4,5,5,4,2,2,1,5,1,3,4,2,4,2,2,4,3,5,2,2,4,4,4,5,5,2,5,5,2,5,1,1,5,5,4,1,
                2,4,1,2,2,5,4,5,1,5,4,4,5,5,5,3,3,4,3,3,5,
                3,2,2,2,2,2,1,2,5,2,3,4,3,5,5,2,4,5,3,4,3,1,3,2,1,1,5,4,
                4,2,3,1,3,4,2,4,1,3,5,1,5,3,5,2,3,4,4,1,3,1,5,5,1,2,2,1,3,1,
                5,1,2,2,1,5,1,3,3,2,1,3,2,5,1,1,2,3,5,5,4,3,1,3,3,1,5,4,2,3,4
        };
        System.out.println("Решение задачи как в ТЗ:");
        countItems(arrayToCountFromTask);
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
            System.out.print(counter[i] + " ");
//            System.out.println();
//            System.out.println("Альтернативный вывод:");
//            System.out.println("Number " + (i + 1) + " found in array " + counter[i] + " times.");
        }
        System.out.println();

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
