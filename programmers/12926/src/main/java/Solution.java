import java.util.ArrayList;

class Solution {
    public String solution(String s, int n) {
        String answer = "";

        ArrayList<Character> lowerAlphabet = new ArrayList<Character>();
        ArrayList<Character> upperAlphabet = new ArrayList<Character>();

        for(char a = 'a' ; a <= 'z' ; a++){
            lowerAlphabet.add(a);
            upperAlphabet.add((char) (a + ('A' - 'a')));
        }

        for(char elem : s.toCharArray()){
            if(elem != ' ') {
                boolean isUpper = Character.isUpperCase(elem);
                if(isUpper){
                    answer = getString(n, answer, upperAlphabet, elem);
                }
                else {
                    answer = getString(n, answer, lowerAlphabet, elem);
                }
            }
            else {
                answer += ' ';
            }
        }

        return answer;
    }

    private String getString(int n, String answer, ArrayList<Character> lowerAlphabet, char elem) {
        int srcIdx = lowerAlphabet.indexOf(elem);
        int ceaserCnt = n;
        if(srcIdx + n > 25){
            ceaserCnt = srcIdx + n - 26;
            answer += lowerAlphabet.get(ceaserCnt);
        }
        else {
            answer += lowerAlphabet.get(srcIdx + ceaserCnt);
        }
        return answer;
    }
}