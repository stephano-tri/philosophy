import java.util.HashSet;
import java.util.LinkedHashSet;

class Solution {
    HashSet<HashSet<String>> rightIds = new HashSet<>();

    public void dfs(HashSet<String> ids, String[] userIds, String [] bannedIds){
        if(ids.size() == bannedIds.length){
            if(isBadList(ids,bannedIds)) {
                rightIds.add(new HashSet<>(ids));
            }
            return;
        }

        for(String el : userIds){
            if(ids.add(el)) {
                dfs(ids, userIds, bannedIds);
                ids.remove(el);
            }
        }
    }

    public boolean isBadList(HashSet<String> userIds, String[] bannedIds){
        int idx = 0;
        for(String elem : userIds){
            String bannedId = bannedIds[idx++];
            if(elem.length() != bannedId.length()){
                return false;
            }

            for(int i = 0 ; i < bannedId.length() ;i++){
                if(bannedId.charAt(i) == '*') {
                    continue;
                }

                if(elem.charAt(i) != bannedId.charAt(i)) {
                    return false;
                }
            }
        }

        //if it passes above for loop
        return true;
    }

    public int solution(String[] user_id, String[] banned_id) {
        dfs(new LinkedHashSet<>(), user_id , banned_id);
        return rightIds.size();
    }
}