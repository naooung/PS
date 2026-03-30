import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < 6; i++)
            set.add(win_nums[i]);

        // 일치하는 개수, 일치하지 않는 개수, 0 개수
        int same = 0, different = 0, zero = 0;
        for (int i = 0; i < 6; i++) {
            int lotto = lottos[i];
            if (lotto == 0) {
                zero++; continue;
            }
            if (set.contains(lotto)) {
                same++; continue;
            }
            else {
                different++; continue;
            }
        }
        
        int[] result = new int[2];
        // 최고 순위: 6 - 일치하는 개수 - 0 개수 (0이 다 맞다고 가정)
        int max = 7 - same - zero;
        result[0] = (max == 7) ? 6 : max;
        
        // 최저 순위: 일치하지 않는 개수 + 0 개수 (0이 다 틀리다고 가정)
        // 또는 최고 순위 + 0 개수
        int min = different + zero + 1;
        result[1] = (min == 7) ? 6 : min;
        
        return result;
    }
}