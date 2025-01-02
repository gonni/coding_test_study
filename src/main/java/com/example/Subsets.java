package com.example;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, result);
            path.remove(path.size() - 1); // 백트래킹
        }
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
