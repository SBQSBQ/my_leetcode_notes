package com.mypractice.helloworld;

import com.mypractice.module.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getRanking() != o2.getRanking()) {
            return Integer.compare(o1.getRanking(), o2.getRanking());
        }
        else if (o1.getAge() != o2.getAge()) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
