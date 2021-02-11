package HW2;

import java.util.Random;

public class execution {
    public static void main(String[] args) throws CloneNotSupportedException {

        MyArray<Integer> template = new MyArray<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            template.add(random.nextInt(1000));
        }

        MyArray<Integer> bubble = template.clone();
        MyArray<Integer> select = template.clone();
        MyArray<Integer> insert = template.clone();

        //bubble sort time
        long start = System.nanoTime(), end;
        bubble.bubbleSort();
        end = System.nanoTime();
        System.out.println("bubble sort:" + (end - start));

        //select sort time
        start = System.nanoTime();
        select.selectSort();
        end = System.nanoTime();
        System.out.println("select sort:" + (end - start));

        //select sort time
        start = System.nanoTime();
        insert.insertSort();
        end = System.nanoTime();
        System.out.println("insert sort:" + (end - start));
    }
}
