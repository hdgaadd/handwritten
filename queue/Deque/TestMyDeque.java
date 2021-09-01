package CollectionsFloor.queue.Deque;

import CollectionsFloor.queue.Queue.MyLinkedList;
import CollectionsFloor.queue.Queue.MyDeque;

public class TestMyDeque {
    public static void main(String[] args) {
        //双端队列
        MyDeque<Integer> myQueue2=new MyLinkedList<Integer>();
        myQueue2.add(1);
        myQueue2.add(2);
        myQueue2.add(3);
        myQueue2.addFirst(6);
        myQueue2.addLast(7);
        System.out.println(myQueue2);
        System.out.println(myQueue2.peek());
        System.out.println(myQueue2.poll());
        System.out.println(myQueue2.poll());
        System.out.println(myQueue2);
    }
}
