class Solution {
    public long solution(int a, int b) {

        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        return (long)(max + min) * (max - min + 1) / 2;
    }
}