
class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    static void dfs(int count, int health, int[][] dungeons) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            
            // 던전 입장 가능 조건 - 방문 X + 최소 필요 피로도보다 현재 체력이 클 때
            if (!visited[i] && dungeons[i][0] <= health) {
                // 현재 방문처리하고 dfs
                visited[i] = true;
                dfs(count+1, health - dungeons[i][1], dungeons);
                
                // 다시 미방문 처리
                visited[i] = false;
            }
        }
    }
}