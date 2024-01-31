class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        dq(0,0, arr.length, arr);
        return answer;
    }
    public boolean areAllElementsSame(int x, int y, int size, int[][] targetArr){
        for(int i = x  ; i < x + size ; i++){
            for(int j = y ; j < y + size ; j++){
                if(targetArr[x][y] != targetArr[i][j]) return false;
            }
        }
        return true;
    }

    public void dq(int sX, int sY, int size, int[][] arr){
        if(areAllElementsSame(sX, sY, size, arr)){
            answer[arr[sX][sY]]++;
            return;
        }

        dq(sX,sY,size/2,arr);
        dq(sX,sY + size/2 , size/2 , arr);
        dq(sX + size/2 , sY , size/2, arr);
        dq(sX + size/2 , sY + size/2, size/2 , arr);

    }
}
