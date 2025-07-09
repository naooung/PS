import java.io.*;
import java.util.*;

public class Main {
  private static int n;
  private static StringTokenizer st;
  private static Node node[];
  private static HashSet<Integer> friend;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    friend = new HashSet<>();
    // 학번별 동기 노드 생성
    n = Integer.parseInt(br.readLine());
    node = new Node[n + 1];
    for (int i = 1; i <= n; i++)
      node[i] = new Node();

    // 친구 리스트 저장
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      node[a].addFriend(b);
      node[b].addFriend(a);
    }

    // 상근이(1)부터 시작해서 친구 혹은 친구의 친구만 탐색
    find(1, 0);

    System.out.println(friend.size());
  }

  public static void find(int start, int depth) {
    // 종료 조건: 친구의 친구까지만 탐색
    if (depth == 2)
      return;

    for (int i = 0; i < node[start].friends.size(); i++) {
      int friendIndex = node[start].friends.get(i);

      if (friendIndex == 1)
        continue;
      else
        find(friendIndex, depth + 1);

      friend.add(friendIndex);
    }
  }
}

class Node {
  ArrayList<Integer> friends;

  public Node() {
    friends = new ArrayList<>();
  }

  public void addFriend(int i) {
    if (!friends.contains(i))
        friends.add(i);
  }
}