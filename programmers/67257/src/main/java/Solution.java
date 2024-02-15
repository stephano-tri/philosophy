import java.util.*;

class Solution {
    List<String> equation = new ArrayList<String>();
    Stack<String> numbers = new Stack<String>();
    Stack<String> operators = new Stack<String>();

    List<List<String>> priorityOpers = new ArrayList<>();

    String[] defaultOpers = {"*", "+", "-"};


    public void setElements(String expression){
        StringBuilder sb = new StringBuilder();
        for(char elem : expression.toCharArray()){
            if(Character.isDigit(elem)){
                sb.append(elem);
            }
            else {
                equation.add(sb.toString());
                sb.setLength(0);
                equation.add("" + elem);
            }
        }
    }

    public void dfs(String[] opers, String[] output , int depth, boolean[] visited){
        if(depth == 3){
            priorityOpers.add(List.of(output));
            return;
        }
        for(int i = 0 ; i < 3 ; i ++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = opers[i];
                dfs(opers, output, depth + 1 , visited);
                visited[i] = false;
            }
        }
    }

    public void calc(List<String> priorOpers){
        for(int i = 0 ; i < equation.size(); i++){
            if(numbers.size() == 2 && operators.size() == 1){
                int lo = priorOpers.indexOf(operators.get(0));
                int ro = priorOpers.indexOf(equation.get(i));

                if(lo < ro) {
                    // just
                }
                else {

                }
            }

            if(i % 2 == 0){
                numbers.push(equation.get(i));
            }
            else {
                operators.push(equation.get(i));
            }

        }
    }

    public long solution(String expression) {
        long answer = 0;

        String[] initOpers = new String[3];
        boolean[] visited = new boolean[3];

        setElements(expression);
        dfs(defaultOpers, initOpers, 0 , visited );


        return answer;
    }
}