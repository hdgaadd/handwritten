package CollectionsFloor;

import java.util.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        /*TreeMap<Integer, Integer> t = new TreeMap<>((a,b)-> b-a);//Comparator只能根据key排序
        t.put(0,1);
        t.put(6,6);          //treemap在添加元素时会排序元素
        t.put(17,17);
        t.put(3,99);
        t.put(16,16);
        System.out.println(t.toString());


        Iterator<Map.Entry<Integer,Integer>> i= t.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry<Integer,Integer> next=i.next();
            System.out.println(next);
        }
        HashMap<Integer, Integer> t1 = new HashMap<>();
        Queue<Object> objects = new LinkedList<>();*/
        ArrayDeque<Integer> integers = new ArrayDeque<>(1);
        integers.add(1);
        integers.add(2);
        System.out.println(integers);
        Deque<Integer> deque=new LinkedList<>();


        /*int h;
        for(Integer i=0;i<36;i++){
            System.out.println(((h = i.hashCode()) ^ (h >>> 16))&15);
        }*/
        /*HashMap<Integer, Integer> t = new HashMap<>();
        t.put(0,1);
        t.put(6,6);
        t.put(17,17);
        t.put(3,3);
        t.put(16,16);
        System.out.println(t);*/
    }
}
