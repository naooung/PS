import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        
        // targets에 해당하는 keymap을 찾기 위해 keymap 순회
        for (int i = 0 ; i < targets.length; i++) {
            
            for (int j = 0 ; j < targets[i].length(); j++) {
                int min = 101;
                
                // 모든 keymap을 순회하면서 targets[i].charAt(j) 위치 찾기
                for (int k = 0; k < keymap.length; k++) {
                    int index = keymap[k].indexOf(targets[i].charAt(j));
                    
                    // keymap 중에 문자열이 있으면 min과 비교하여 넣기
                    if (index != -1)
                        min = Math.min(index + 1, min);
                }
                
                if (min == 101) {
                    result[i] = -1;
                    break;
                }
                
                result[i] += min;
            }
        }
        
        return result;
    }
}