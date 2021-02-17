package HW4;

import java.util.Iterator;

public class LinkIterarotApp {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.insertFirst("aa");
        list.insertFirst("bb");
        list.insertFirst("cc");
        list.insertFirst("dd");
        list.insertFirst("ee");
        MyIteratorInterface<String> iter = (MyIteratorInterface<String>) list.iterator();
        System.out.println("has next: "+iter.hasNext()); // true
        System.out.println("current: "+iter.getCurrent()); // ee
        System.out.println("next: "+iter.next());// aa bb cc dd <- [ee]
        System.out.println("current: "+iter.getCurrent()); // dd
        iter.remove();
        System.out.println("current:" + iter.getCurrent()); // cc
        iter.insertAfter("after");
        iter.insertBefore("before");
        iter.reset();
        System.out.println("reset iterator*************************");
        while (iter.hasNext()) System.out.println(iter.next());


        System.out.println("**********************");
        for(String s: list) System.out.println(s);


    }
}
