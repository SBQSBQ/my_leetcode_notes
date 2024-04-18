package com.mypractice.helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        solu.trap();
    }
    public int trap() {
        int[] heightMock = new int[]{0,1,0,2,1,0,1,3,2,1,1,2,1};
        List<Integer> height = Arrays.stream(heightMock).boxed().toList();

        List<Integer> heightDiff = new ArrayList<>();
        heightDiff.add(0 - heightMock[0]);
        for (int i = 1; i < heightMock.length; i++) {
            heightDiff.add(heightMock[i-1] - heightMock[i]);
        }
        System.out.println(heightDiff);
        System.out.println(height);

        List<Integer> bottomIndex = new ArrayList<>();
        List<Integer> topIndex = new ArrayList<>();
        int i = 0;
        while(i < heightDiff.size()-1) {
//            if (heightDiff.get(i) == 0) {
//                i+= 1;
//                continue;
//            }
            if (heightDiff.get(i) > 0) {
                if (heightDiff.get(i + 1) <= 0) {
                    bottomIndex.add(i);
                }
            } else if (heightDiff.get(i) < 0) {
                continue;
            }
            i += 1;
        }
        System.out.println(bottomIndex);

        int sum = 0;

        for (Integer index : bottomIndex) {
            int left = index - 1;

        }
        return 0;
    }
}
