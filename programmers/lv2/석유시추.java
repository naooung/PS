import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int currentOil;
    
    public int solution(int[][] land) {
        int maxOil = 0;
        
        // 현재 위치에서 뽑을 수 있는 석유량 갱신
        for (int i = 0; i < land[0].length; i++) {
            currentOil = 0;
            int[][] visited = new int[land.length][land[0].length];
            
            for (int j = 0; j < land.length; j++)
                if (land[j][i] == 1 && visited[j][i] == 0)
                    bfs(j, i, land, visited);
            
            maxOil = Math.max(maxOil, currentOil);
        }
        return maxOil;
    }
    
    // 해당 행과 열에서 dfs시작
    public void bfs(int row, int col, int[][] land, int[][] visited) {
        visited[row][col] = 1;
        currentOil += 1;
        
        ArrayDeque<int[]> oil = new ArrayDeque<>();
        oil.add(new int[]{row, col});
        
        while (!oil.isEmpty()) {
            int[] spot = oil.pollFirst();
            int oilRow = spot[0];
            int oilCol = spot[1];
            
            for (int i = 0; i < 4; i++) {
                int currentRow = oilRow + dx[i];
                int currentCol = oilCol + dy[i];
                
                if (currentRow < visited.length && currentRow >= 0 && currentCol >= 0 && currentCol < visited[0].length
                   && land[currentRow][currentCol] == 1 && visited[currentRow][currentCol] == 0) {
                    oil.add(new int[]{currentRow,currentCol});
                    visited[currentRow][currentCol] = 1;
                    currentOil += 1;
                }
            }
        }
    }
}

/**
 * 열 반복문 수행하여 가장 많은 석유량 찾기 (max로 갱신)
 * 행만큼 반복문을 돌리면서 1이면 bfs하고 visited 처리
 */