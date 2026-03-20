import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // map에 name과 yearning 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);
        
        // photo 순회하면서 map에 get + 값이 있으면 결과 배열에 더하기
        int[] result = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0 ; j < photo[i].length; j++) {
                
                if (map.get(photo[i][j]) != null)
                    result[i] += map.get(photo[i][j]);
            }
        }
        
        return result;
    }
}