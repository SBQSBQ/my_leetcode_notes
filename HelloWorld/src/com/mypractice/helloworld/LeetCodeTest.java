package com.mypractice.helloworld;

import java.util.List;

public class LeetCodeTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input1 = new int[]{10,1,2,7,6,1,5};

        List<List<Integer>> ret = solution.combinationSum2(input1, 8);
        System.out.println(ret);
    }
}
