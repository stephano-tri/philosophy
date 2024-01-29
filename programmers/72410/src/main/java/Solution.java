import java.util.Locale;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        // level 1. convert it to lower case
        answer = new_id.toLowerCase(Locale.ROOT);
        System.out.println("lv1".concat(answer));

        String filteredAnswer = "";
        // level 2. eliminate other characters
        for(char ch : answer.toCharArray()){
            if(Character.isDigit(ch)|| Character.isLowerCase(ch) || ch == '-' || ch == '_' || ch == '.'){
                filteredAnswer += ch;
            }
        }

        System.out.println("lv2".concat(filteredAnswer));


        String dotFilteredAnswer = "";
        // level 3. eliminate . if occurs more than once
        int dotCnt = 0;
        for(int i = 0 ; i < filteredAnswer.length() ; i++){
            if(i != filteredAnswer.length() - 1 && filteredAnswer.charAt(i) == '.' && dotCnt >= 2 && filteredAnswer.charAt(i+1) != '.'){
                dotFilteredAnswer += '.';
                dotCnt = 0;
            }
            else if(filteredAnswer.charAt(i) == '.'){
                if(i != filteredAnswer.length() - 1 && filteredAnswer.charAt(i+1) != '.'){
                    dotFilteredAnswer += '.';
                }
                else {
                    dotCnt++;
                }
            }
            else {
                dotFilteredAnswer += filteredAnswer.charAt(i);
            }
        }

        System.out.println("lv3".concat(dotFilteredAnswer));

        //level 5. empty space
        if(dotFilteredAnswer.length() == 0){
            dotFilteredAnswer += 'a';
        }

        //level 4. eliminate front end dot
        if(dotFilteredAnswer.charAt(0) == '.'){
            dotFilteredAnswer = dotFilteredAnswer.substring(1);
        }
        if(dotFilteredAnswer.charAt(dotFilteredAnswer.length()-1) == '.'){
            dotFilteredAnswer = dotFilteredAnswer.substring(1);
        }


        if(dotFilteredAnswer.length() >= 16) {
            dotFilteredAnswer = dotFilteredAnswer.substring(0,15);
        }

        System.out.println("lv4".concat(dotFilteredAnswer));

        if(dotFilteredAnswer.charAt(dotFilteredAnswer.length()-1) == '.'){
            dotFilteredAnswer = dotFilteredAnswer.substring(0, dotFilteredAnswer.length()-1);
        }


        if(dotFilteredAnswer.length() <= 2){
            int targetIdx = dotFilteredAnswer.length() - 1;
            while(dotFilteredAnswer.length() != 3){
                dotFilteredAnswer += dotFilteredAnswer.charAt(targetIdx);
            }
        }

        return dotFilteredAnswer;
    }
}