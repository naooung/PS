import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int result = 0;
        int nowNum = 0;
        Arrays.sort(score);
        
        for (int i = score.length - 1; i >= 0; i--) {
            nowNum++;
            // 상자에 최대 개수가 찼다면, 현재의 점수=최저점수
            if (nowNum == m) {
                result += (score[i] * m);
                nowNum = 0;
            }
        }
        
        return result;
    }
}