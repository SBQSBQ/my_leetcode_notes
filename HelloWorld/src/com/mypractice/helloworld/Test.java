package com.mypractice.helloworld;

import com.mypractice.dataStructure.CircularBuffer;
import com.mypractice.module.Player;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.testComparator();
//        test.testCircularBuffer();
//        test.testPriorityQueue();


    }

    private void testComparator() {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(5, "John", 29);
        Player player2 = new Player(5, "Roger", 22);
        Player player3 = new Player(5, "ASteven", 22);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        PlayerComparator pc = new PlayerComparator();
        PriorityQueue<Player> pqPlayer = new PriorityQueue<>(pc);

        pqPlayer.add(player1);
        pqPlayer.add(player2);
        pqPlayer.add(player3);

        for (int i = 0; i<3; i++) {
            System.out.println(pqPlayer.poll());
        }

        // java8 lambda
//        Comparator<Player> pc2 = (Player o1, Player o2) -> {
//            if (o1.getRanking() != o2.getRanking()) {
//                return Integer.compare(o1.getRanking(), o2.getRanking());
//            }
//            else if (o1.getAge() != o2.getAge()) {
//                return Integer.compare(o1.getAge(), o2.getAge());
//            }
//            else {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };

        // another way
        Comparator<Player> pc3 = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getRanking() != o2.getRanking()) {
                    return Integer.compare(o1.getRanking(), o2.getRanking());
                } else if (o1.getAge() != o2.getAge()) {
                    return Integer.compare(o1.getAge(), o2.getAge());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        };

        System.out.println("Before Sorting : " + footballTeam);
//        footballTeam.sort(pc2);
        System.out.println("After Sorting : " + footballTeam);
    }

    private void testPriorityQueue() {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);

        // Adding items to the pQueue using add()
        for(int i=0;i<3;i++){
            pq.add(i);
            pq.add(1);
        }

        for (int i = pq.size(); i >=0; i--) {
            System.out.println(pq.poll());
        }

    }

    private void testCircularBuffer() {
        CircularBuffer c = new CircularBuffer(3);

        // 环形put
        c.put(123);
        c.put(456);
        c.put(789);
        c.put(11111);
        c.print();

        System.out.println(c.get());
        System.out.println(c.get());
        System.out.println(c.get());

        c.remove();
        c.remove();
        c.print();

    }

}
