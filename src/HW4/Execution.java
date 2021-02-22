package HW4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Execution {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        MyLinkedList<String> list = new MyLinkedList<>();
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

//        System.out.println(stack.size());
//        while (!stack.isEmpty()) System.out.println(stack.pop());

        list.insertFirst("1");
        list.insertFirst("2");
        list.insertFirst("3");
        list.insertFirst("4");
        list.insertFirst("55");
        for(String s: list) System.out.println(s);

//        System.out.println(list.size());
//        System.out.println(list.removeFirst());
//        System.out.println(list.getFirst());
//        list.remove("2");
//        list.display();

        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
//        System.out.println(" size "+ queue.size());
//        queue.remove();
//        while (!queue.isEmpty()) System.out.println(queue.remove());



    }
}
