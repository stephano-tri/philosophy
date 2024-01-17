class Solution {
    public int solution(int n) {
        int answer = 0;
        return Integer.parseInt(conversion(n,3),3);
    }

    public String conversion(int n, int base){
        int targetNumber = n;
        String converted = "";
        while(targetNumber > 0){
            converted += Integer.toString(targetNumber % base);
            targetNumber /= base;
        }
        return converted;
    }
}