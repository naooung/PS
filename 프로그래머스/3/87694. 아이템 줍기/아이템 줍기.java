import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] field = new int[102][102];
        boolean[][] visited = new boolean[102][102];

        // 직사각형이 있는 모든 곳을 1로 변경 (좌표 2배)
        for (int i = 0; i < rectangle.length; i++) {
            for (int x = rectangle[i][0] * 2; x <= rectangle[i][2] * 2; x++)
                for (int y = rectangle[i][1] * 2; y <= rectangle[i][3] * 2; y++) 
                    field[x][y] = 1;
        }

        // 내부는 2 이상으로 바꾸고, 테두리만 1로 남기기
        for (int i = 0; i < rectangle.length; i++) {
            for (int x = rectangle[i][0] * 2 + 1; x < rectangle[i][2] * 2; x++)
                for (int y = rectangle[i][1] * 2 + 1; y < rectangle[i][3] * 2; y++) 
                    field[x][y]++;
        }
        
        // 캐릭터의 위치에서 아이템까지 1을 따라 이동
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.x == itemX * 2 && node.y == itemY * 2)
                return node.dist / 2;
            
            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                // 테두리 1인 곳만 이동
                if (!visited[nx][ny] && field[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, node.dist + 1));
                }
            }
        }
        return 0;
    }
    
    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}