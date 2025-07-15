import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        // 테스트케이스만큼 반복
        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();

            // Map에 (의상 종류, 해당 종류의 의상 개수) 저장
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                // 종류에 따른 개수 저장
                // 동일한 의상 종류가 있다면 그 종류의 value 값을 하나 증가
                String kind = st.nextToken();
                if (clothes.containsKey(kind))
                    clothes.put(kind, clothes.get(kind) + 1);
                else 
                    clothes.put(kind, 1);
            }

            // 조합 계산: (각 종류별 의상수 + 1)한 것을 다 곱해준다
            int result = 1;
            for (int count : clothes.values())
                result *= (count + 1);

            System.out.println(result - 1);
        }
    }
}

/**
 * headgear 수 = 2, eyewear 수 = 1 일 때
 * 결과가 왜 5일까? 
 * (2 + 1) * (1 + 1) - 1 = 5
 * 
 * 종류가 headgear인 의상이 2개 있을 때 선택지는 (1번 의상, 2번 의상, 안입음) = 3개
 * 종류가 eyewear인 의상이 1개 있을 때 선택지는 (1번 의상 + 안입음) = 2개
 * 근데! 둘 다 안 입을 때는 제외해주어야 하므로 result - 1해주어야 함
 */