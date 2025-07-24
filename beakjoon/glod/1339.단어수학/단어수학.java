import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int len = word.length();

            // 알파벳이 있는 자리수의 값을 10의 제곱으로 계산
            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);

                int t = (int) Math.pow(10, len - j - 1);
                map.put(c, map.getOrDefault(c, 0) + t);
            }
        }

        // 내림차순 정렬 -> reverseOrder()
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        // 큰 것부터 9 할당
        int num = 9, sum = 0;
        for (int l : list) {
            sum += (l * num);
            num--;
        }

        System.out.println(sum);
    }
}