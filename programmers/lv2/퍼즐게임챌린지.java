import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        // 난이도의 최댓값
        int maxDiff = 1;
        for (int i = 0; i < n; i++)
            maxDiff = Math.max(maxDiff, diffs[i]);

        // 모든 퍼즐을 실패하지 않고 바로 했을 때 시간
        long base = 0;
        for (int i = 0; i < n; i++)
            base += times[i];
        long total1 = base;
        
        // 실패하면 드는 시간 배열에 순차적으로 저장
        long[] needTime = new long[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            int diff = diffs[i];
            int prev = (i == 0 ? 0 : times[i - 1]);
            long cost = (long) times[i] + prev;

            if (diff > 1) 
                total1 += (long) (diff - 1) * cost; 
            needTime[diff] += cost;
        }
        if (total1 <= limit) return 1;
        
        long save = 0; // 1 올리면 줄어드는 소요 시간 (최대로 초기화해서 점점 줄어듦)
        for (int diff = 2; diff <= maxDiff; diff++) 
            save += needTime[diff];

        // 숙련도를 올리면서 초과 시간을 줄인다
        long over = total1 - limit; // 줄여야 되는 시간
        int level = 1;
        while (over > 0) {
            if (save <= 0) 
                break;
            over -= save; 
            level++;  
            save -= needTime[level]; // 숙련도 올리면 그 난이도의 퍼즐은 실패 X
        }

        return level; 
    }
}

/**
 * 숙련도 1부터 제한시간 차이 계산
 * 숙련도 1일 때랑 limit이랑 비교해서 줄여야 하는 시간까지 숙련도를 올리면서 계산
 */