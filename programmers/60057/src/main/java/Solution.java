import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for(int i = 1; i <= s.length() ; i++) {
            String[] tmpPattern = getPatternString(s, i);
//            System.out.println(Arrays.toString(tmpPattern));
//            System.out.println(compress(tmpPattern));
            if(answer > compress(tmpPattern).length()){
                answer = compress(tmpPattern).length();
            }
        }
        return answer;
    }

    public String[] getPatternString(String s, int refLength){
        ArrayList<String> result = new ArrayList<String>();

        for(int i = 0 ; i < s.length() ; i += refLength){
            if(i + refLength >= s.length())  {
                result.add(s.substring(i , s.length()));
                break;
            }
            else {
                result.add(s.substring(i, i + refLength));
            }
        }

        return result.toArray(new String[0]);
    }

    public String compress(String[] sArr) {
        int count = 1;
        String compressedString = "";
        for(int i = 0 ; i < sArr.length; i++){
            if(i == sArr.length - 1){
                if(count != 1) compressedString += ( Integer.toString(count) + sArr[i] );
                else compressedString += sArr[i];
                break;
            }

            if(sArr[i].equals(sArr[i+1])){
                count++;
            }

            else {
                if(count != 1){
                    compressedString += ( Integer.toString(count) + sArr[i] );
                    count = 1;
                }
                else {
                    compressedString += sArr[i];
                }
            }
        }
        return compressedString;
    }
}