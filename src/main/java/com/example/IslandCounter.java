package com.example;

public class IslandCounter {
  static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static int n, m;

  public static void dfs(int[][] grid, int x, int y) {
      // 경계 체크
      if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0) {
          return;
      }

      // 현재 땅 방문 처리
      System.out.println("-> visited: " + x + ", " + y);
      grid[x][y] = 0;

      // 4방향 탐색
      for (int[] direction : directions) {
          dfs(grid, x + direction[0], y + direction[1]);
      }
  }

  public static int numIslands(int[][] grid) {
      n = grid.length;
      m = grid[0].length;

      int count = 0;

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (grid[i][j] == 1) { // 새로운 섬 발견
                  count++;
                  dfs(grid, i, j);
              }
          }
      }

      return count;
  }

  public static void main(String[] args) {
      int[][] grid = {
          {1, 1, 0, 0, 0},
          {1, 1, 0, 0, 0},
          {0, 0, 1, 0, 0},
          {0, 0, 0, 1, 1}
      };

      System.out.println(numIslands(grid)); // 출력: 3
  }
}