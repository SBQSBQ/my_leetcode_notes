package com.mypractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> records = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> tempRecord;
            if (records.containsKey(nums[i])) {
                tempRecord = records.get(nums[i]);
            } else {
                tempRecord = new ArrayList<>();
            }
            tempRecord.add(i);
            records.put(nums[i], tempRecord);

        }

        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if(records.containsKey(rest)) {
                if (rest != nums[i]) {
                    return new int[]{i, records.get(rest).get(0)};
                } else if (rest == nums[i] && records.get(rest).size() > 1) {
                    return new int[]{i, records.get(rest).get(1)};
                }
            }
        }
        return null;
    }
}
