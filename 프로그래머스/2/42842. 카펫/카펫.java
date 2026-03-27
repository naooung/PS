class Solution {
    public int[] solution(int brown, int yellow) {
        
        if (yellow == 1) return new int[]{3, 3};
        
        for (int i = 1; i <= yellow / 2; i++) {
            if (yellow % i != 0) continue;
            int x = i;
            int y = yellow / i;
            
            if (brown == (2 + x) * (2 + y) - yellow) {
                return new int[]{2 + y, 2 + x};
            }
        }
        return new int[]{0, 0};   
    }
}