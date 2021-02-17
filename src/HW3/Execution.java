package HW3;

public class Execution {

    public static void main(String[] args) {
        Dequeue<Integer> test = new Dequeue<>(5);
        test.insert(1);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insertFirst(5);
        test.insert(6);

        for (int i = 0; i < test.size(); i++) {
            System.out.println("order: "+test.peek());
        }

        System.out.println("size"+test.size());
        System.out.println("peek"+test.peek());
        System.out.println("peek last "+test.peekLast());
        System.out.println("remove last"+test.removeLast());

        while (!test.isEmpty()){
            System.out.println(test.remove());
        }
        System.out.println("end of dequeue");


    }
}
