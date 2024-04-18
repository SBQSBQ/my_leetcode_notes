package com.mypractice.helloworld;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int maxLength = 0;
        int left = 0;
        int right = 1;

        while (right < s.length()) {
            String substring = s.substring(left, right);
            String nextChar = String.valueOf(s.charAt(right));
            if (!substring.contains(nextChar)) {
                right += 1;
                maxLength = Math.max(maxLength, right - left);
            } else {
                left += 1;
            }
        }
        return maxLength;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        boolean isEven = ((length1 + length2) % 2 == 0);
        int median = (length1 + length2) / 2;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : nums1) {
            queue.add(i);
        }
        for (int i : nums2) {
            queue.add(i);
        }

        for (int i = 0; i < median - 1; i++) {
            queue.poll();
        }

        if (isEven) {
            return (double) (queue.poll() + queue.poll()) /2;
        }
        else {
            queue.poll();
            return queue.poll();
        }
    }

    int[] visited;
    ArrayList<Integer> nodeStack;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> nodeAndDestiny = new HashMap<>();
        ArrayList<Integer> temp;

        for (int[] prerequisite : prerequisites) {
            if (nodeAndDestiny.containsKey(prerequisite[1])) {
                temp = nodeAndDestiny.get(prerequisite[1]);
            }
            else {
                temp = new ArrayList<>();
            }
            temp.add(prerequisite[0]);
            nodeAndDestiny.put(prerequisite[1], temp);
        }

        visited = new int[numCourses];
        nodeStack = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                if (!dfs(nodeAndDestiny, i)) {
                    return false;
                }
            }

        }

        return  true;
    }

    private boolean dfs(HashMap<Integer, ArrayList<Integer>> allArrows, int node) {
        visited[node] = 1;
        ArrayList<Integer> nodeToCheck = allArrows.get(node);
        if (nodeToCheck == null) {
            nodeStack.add(node);
            visited[node] = 2;
            return true;
        } else {
            for (Integer i : nodeToCheck) {
                if (visited[i] == 0) {
                    boolean result = dfs(allArrows, i);
                    if (! result) {
                        return false;
                    }
                }
                else if (visited[i] == 1) {
                    return false;
                }
            }
        }
        nodeStack.add(node);
        visited[node] = 2;

        return true;
    }

    int[][] globalGrid;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        globalGrid = grid;
        int maxArea = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, findAreaAndSink(i, j, 0));
            }
        }
        return maxArea;
    }

    private int findAreaAndSink(int i, int j, int currentArea) {
        if (i >= globalGrid.length) {
            return currentArea;
        }
        if (j > globalGrid[0].length) {
            return currentArea;
        }

        if (globalGrid[i][j] == 0) {
            return currentArea;
        }
        else {
            globalGrid[i][j] = 0;
            currentArea += 1;
            currentArea = findAreaAndSink(i+1, j, currentArea);
            currentArea = findAreaAndSink(i, j+1, currentArea);
        }
        return currentArea;
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtracking(combinations, phoneMap, digits, "");

        return combinations;
    }

    private void backtracking(List<String> combinations, Map<Character, String>phoneMap, String digits, String currentComb) {
        if (digits.isEmpty()) {
            combinations.add(currentComb);
            return;
        }
        Character nextDigit = digits.charAt(0);
        String optionChar = phoneMap.get(nextDigit);
        for (int i = 0; i < optionChar.length(); i++) {
            backtracking(combinations, phoneMap, digits.substring(1, digits.length()), currentComb + optionChar.charAt(i));
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 1 && candidates[0] != target) {
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> currentN = new ArrayList<>();
        backtracking3(ret, candidates, target, currentN);

        return ret;
    }

    private void backtracking3(List<List<Integer>> ret, int[] candidates, int target, List<Integer> current) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            Collections.sort(current);
            if (!ret.contains(current)) {
                ret.add(new ArrayList<>(current));
            }
            return;
        }

        for(int i = 0; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtracking3(ret, candidates, target - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 1 && candidates[0] != target) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> currentN = new ArrayList<>();
        backtracking4(ret, candidates, target, currentN, 0);

        return ret;
    }

    private void backtracking4(List<List<Integer>> ret, int[] candidates, int target, List<Integer> current, int beginIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> newCurrent = new ArrayList<>(current);
            // Collections.sort(newCurrent);
            // if (!ret.contains(newCurrent)) {
            //     ret.add(new ArrayList<>(newCurrent));
            // }
            ret.add(new ArrayList<>(newCurrent));
            return;
        }

        for(int i = beginIndex; i < candidates.length; i++) {
            if (i > beginIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                current.add(candidates[i]);
                backtracking4(ret, candidates, target - candidates[i], current, i + 1);
                current.remove(current.size() - 1);
            } else {
                break;
            }
        }
    }
}