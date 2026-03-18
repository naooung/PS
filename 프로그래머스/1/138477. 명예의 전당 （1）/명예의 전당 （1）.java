import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {

        int[] rank = new int[k];
        Arrays.fill(rank, -1);
        int[] result = new int[score.length];
        
        for (int i = 0; i < score.length; i++) {
            
            for (int j = 0; j < k; j++) {
                if (score[i] > rank[j]) { // 현재 점수가 랭킹보다 높으면 뒤로 밀기
                    
                    for (int a = k - 1; a > j; a--)
                        rank[a] = rank[a - 1];
                    
                    rank[j] = score[i];
                    break;
                }
            }
            for (int j = k - 1; j >= 0; j--) {
                if (rank[j] != -1) {
                    result[i] = rank[j];
                    break;
                }
            }
        }
        
        return result;
    }
}