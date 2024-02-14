class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};

        int max_iter = brown + yellow;

        for(int i = 3 ; i < max_iter ; i++){
            int col = i;
            int row = max_iter / col;

            if(row < 3) continue;

            if(row >= col) {
                if((row - 2) * (col - 2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }

        return answer;
    }
}