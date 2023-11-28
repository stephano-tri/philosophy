import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char gameType = st.nextToken().charAt(0);

        ArrayList<String> gamers = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            gamers.add(br.readLine());
        }

        int userOffset = 0;
        switch (gameType){
            case 'Y':
                userOffset = 2;
                break;
            case 'F':
                userOffset = 3;
                break;
            case 'O':
                userOffset = 4;
                break;
        }

        int totalGame = 0;

        int userCount = 1;

        Set<String> set = new HashSet<>();
        for(String user : gamers){
            if(!set.contains(user)){
                set.add(user);
                userCount++;
            }

            if(userCount == userOffset){
                totalGame++;
                userCount = 1;
            }
        }
        System.out.println(totalGame);
    }
}
