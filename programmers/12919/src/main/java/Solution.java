class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            for (char elem : s.toCharArray()) {
                if (!Character.isDigit(elem)) return false;
            }
            return true;
        } else {
            return false;
        }
    }
}