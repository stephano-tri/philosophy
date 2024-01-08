import java.util.*;

class Solution {
    class Pair {
        int x;
        int y;
        int dir;

        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
        public void setDir(int dir){
            this.dir = dir;
        }

        public Pair(int x , int y, int dir){
            setX(x);
            setY(y);
            setDir(dir);
        }
    }

    int[][] map;
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0 ,-1};
    int secondDx[] = {2, 1, 0, -1, -2, -1, 0, 1};
    int secondDy[] = {0, 1, 2, 1 , 0 , -1, -2, -1};
    Queue<Pair> people = new LinkedList<>();

    public void makeAdjanceyList(String[] places){
        map = new int[5][5];
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                map[i][j] = places[i].charAt(j);
            }
        }
    }

    public Boolean isThereAPersonAround(int x, int y){
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0  || nx >= 5 || ny < 0 || ny >= 5){
                continue;
            }

            if(map[nx][ny] == 'P'){
                return false;
            }
        }
        return true;
    }

    public void checkTwoDepthPerson(int x, int y){
        for(int i = 0 ; i < 8 ; i ++){
            int nx = x + secondDx[i];
            int ny = y + secondDy[i];

            if (nx < 0  || nx >= 5 || ny < 0 || ny >= 5){
                continue;
            }

            if(map[nx][ny] == 'P'){
                people.offer(new Pair(nx,ny,i));
            }
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = {1 , 1  , 1 , 1 , 1};
        int mapIdx = 0;
        // to make adjancey-list
        for (String[] place : places) {
            makeAdjanceyList(place);

            // now check one depth or two depth person (Manhattan distance under or equal 2)
            for (int i = 0 ; i < map.length ; i++){
                for (int j = 0 ; j < map[i].length ; j++){
                    if(map[i][j] == 'P'){
                        if(!isThereAPersonAround(i,j)) {
                            answer[mapIdx] = 0;
                            break;
                        }
                        checkTwoDepthPerson(i , j);
                    }
                    while(!people.isEmpty()){
                        Pair suspicious = people.poll();
                        switch(suspicious.dir){
                            case 0:
                                if(map[i + 1][j] != 'X') answer[mapIdx] = 0;
                                break;
                            case 1:
                                if(map[i + 1][j] != 'X' || map[i][j +1] != 'X') answer[mapIdx] = 0;
                                break;
                            case 2:
                                if(map[i][j+1] != 'X') answer[mapIdx] = 0;
                                break;
                            case 3:
                                if(map[i-1][j] != 'X' || map[i][j+1] != 'X') answer[mapIdx] = 0;
                                break;
                            case 4:
                                if(map[i-1][j] != 'X') answer[mapIdx] = 0;
                                break;
                            case 5:
                                if(map[i-1][j] != 'X' || map[i][j-1] != 'X') answer[mapIdx] = 0;
                                break;
                            case 6:
                                if(map[i][j-1] != 'X') answer[mapIdx] = 0;
                                break;
                            case 7:
                                if(map[i][j-1] != 'X' || map[i+1][j] != 'X') answer[mapIdx] = 0;
                                break;
                        }
                    }
                    people.clear();
                }
            }
            ++mapIdx;
        }

        return answer;
    }
}