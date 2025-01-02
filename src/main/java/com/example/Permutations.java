package com.example;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (!path.contains(num)) {
                path.add(num);
                dfs(nums, path, result);
                path.remove(path.size() - 1); // 백트래킹
            }
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}