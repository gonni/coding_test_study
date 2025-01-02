package com.example;

import java.util.*;

class AntiRockets {
  public int solution(int[][] rockets) {
    Arrays.sort(rockets, (a, b) -> Integer.compare(a[1], b[1]));
    
    for (int[] rocket : rockets) {
      System.out.println(Arrays.toString(rocket));
    }

    int towers = 0;
    int lastIntercept = Integer.MIN_VALUE;

    for (int[] rocket : rockets) {
      int start = rocket[0];
      int end = rocket[1];
      
      if (start > lastIntercept) {
        towers++;
        lastIntercept = end;
      }
    }

    return towers;
  }
  
  public static void main(String[] args) {
    System.out.println("Hello world!");

    AntiRockets solution = new AntiRockets();
    int[][] rockets = {
        {1, 4}, 
        {2, 5}, 
        {3, 6}, 
        {7, 8}
    };

    System.out.println("Answer => " + solution.solution(rockets)); 
  }
}
