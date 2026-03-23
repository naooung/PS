import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int row = park.length;
        int col = park[0].length;

        // seat 배열 초기화 
        int[][] seat = new int[row][col];
        for (int j = 0; j < col; j++) 
            seat[0][j] = (park[0][j].equals("-1")) ? 1 : 0;
        for (int i = 0; i < row; i++)
            seat[i][0] = (park[i][0].equals("-1")) ? 1 : 0;
        
        // 오른쪽 아래 모서리를 기준으로 만들 수 있는 가장 큰 정사각형 저장
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // 돗자리를 깔 수 있는 경우, 가장 큰 정사각형 저장
                if (park[i][j].equals("-1")) 
                    seat[i][j] = Math.min(Math.min(seat[i - 1][j], seat[i - 1][j - 1]), seat[i][j - 1]) + 1;
                // 돗자리를 깔 수 없는 경우, 0 저장
                else seat[i][j] = 0;
            }
        }
        
        // 공원 전체에서 가장 큰 정사각형 찾기
        int max = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) 
                if (max < seat[i][j]) max = seat[i][j];
        
        // 가지고 있는 돗자리 크기와 비교 (초기값: -1)
        int result = -1;
        for (int a = 0; a < mats.length; a++) {
            if (mats[a] > max) continue;
            else if (result < mats[a]) result = mats[a];
        }
        
        return result;
    }
}