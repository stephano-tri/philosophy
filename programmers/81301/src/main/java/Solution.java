import java.util.Arrays;

class Solution {
    public int convert2Number(String s){
        String[] countList = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        return Arrays.asList(countList).indexOf(s);
    }

    public int solution(String s) {
        int answer = 0;
        String stringAnswer = "";

        for(int i = 0 ; i < s.toCharArray().length ; i++){
            String numberAlphabet = "";
            if(Character.isAlphabetic(s.charAt(i))){
                // when face init status
                while(Character.isAlphabetic(s.charAt(i))){
                    numberAlphabet += s.charAt(i);
                    if(i == s.toCharArray().length - 1) break;
                    if(!Character.isAlphabetic(s.charAt(i+1))){
                        break;
                    }
                    else {
                        if(!numberAlphabet.isEmpty() && convert2Number(numberAlphabet) != -1) {
                            break;
                        }
                        i++;
                    }
                }
                stringAnswer += convert2Number(numberAlphabet);
            } else {
              stringAnswer += s.charAt(i);
            }
        }
        return Integer.parseInt(stringAnswer);
    }
}