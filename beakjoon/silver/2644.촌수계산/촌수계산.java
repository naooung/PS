import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int a;
    static int b;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int result;
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];  
        for (int i = 0; i < list.length; i++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            list[parent].add(child);
            list[child].add(parent);
        }

        visited = new boolean[n + 1];
        result = 0;
        find = false;
        bfs(a);

        System.out.println(find ? result : -1);
    }

    // start가 전역변수 b까지 도달하기까지 거리 result를 구하는 함수
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int nodes = q.size();

            for (int i = 0; i < nodes; i++) {
                int current = q.poll();

                for (int next : list[current]) {
                    // 이미 방문은 pass
                    if (visited[next]) 
                        continue;

                    // b 도달하면 결과 반환
                    if (next == b) {     
                        result++;
                        find = true;
                        return;
                    }

                    // 도달 못하면 노드 push
                    visited[next] = true;
                    q.add(next);
                }
            }
            result++; 
        }
    }
}  