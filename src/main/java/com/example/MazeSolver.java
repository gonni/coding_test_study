package com.example;

public class MazeSolver {
  static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static int n, m;
  static int shortestPath = Integer.MAX_VALUE;

  public static void dfs(int[][] maze, boolean[][] visited, int x, int y, int steps) {
      // 종료 조건: 목표 지점 도달
      if (x == n - 1 && y == m - 1) {
          shortestPath = Math.min(shortestPath, steps);
          return;
      }

      // 방문 체크
      visited[x][y] = true;

      // 4방향 탐색
      for (int[] direction : directions) {
          int newX = x + direction[0];
          int newY = y + direction[1];

          if (newX >= 0 && newY >= 0 && newX < n && newY < m && maze[newX][newY] == 1 && !visited[newX][newY]) {
              dfs(maze, visited, newX, newY, steps + 1);
          }
      }

      // 백트래킹 (다른 경로 탐색을 위해 방문 해제)
    //   visited[x][y] = false;
  }

  public static int solveMaze(int[][] maze) {
      n = maze.length;
      m = maze[0].length;

      boolean[][] visited = new boolean[n][m];
      dfs(maze, visited, 0, 0, 1);

      return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
  }

  public static void main(String[] args) {
      int[][] maze = {
          {1, 0, 1, 1, 1},
          {1, 0, 1, 0, 1},
          {1, 1, 1, 0, 1},
          {0, 0, 0, 0, 1},
          {1, 1, 1, 1, 1}
      };

      System.out.println(solveMaze(maze)); // 출력: 9
  }
}
