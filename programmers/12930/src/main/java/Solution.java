class Solution {
    String answer = "";
    public String solution(String s) {
        String [] wordArr = s.split(" ", -1);
        for(String elem : wordArr){
            convertedByRules(elem);
            answer += ' ';
        }
        answer = answer.substring(0, answer.length() -1);
        return answer;
    }

    public void convertedByRules(String s){
        for(int i = 0 ; i < s.length() ; i++) {
            char targetChar = s.charAt(i);
            if(Character.isAlphabetic(targetChar)) {
                if (i % 2 == 0) {
                    answer += Character.toUpperCase(targetChar);
                } else {
                    answer += Character.toLowerCase(targetChar);
                }
            }
        }
    }
}