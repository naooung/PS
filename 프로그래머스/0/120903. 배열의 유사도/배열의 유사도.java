import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        HashSet<String> set1 = new HashSet<>(Arrays.asList(s1));
        HashSet<String> set2 = new HashSet<>(Arrays.asList(s2));
        int before = set1.size() + set2.size();
        
        HashSet<String> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);
        
        return before - set.size();
    }
}