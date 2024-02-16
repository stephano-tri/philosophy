import java.util.*;

class Solution {
    List<String> equation = new ArrayList<String>();
    List<String> postfixEquation = new ArrayList<String>();
    Stack<String> numbers = new Stack<String>();
    Stack<String> operators = new Stack<String>();
    List<Long> results = new ArrayList<Long>();

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
        if(sb.length() > 0) equation.add(sb.toString());
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
        //first convert infix to postfix
        for(int i = 0 ; i < equation.size() ; i++){
            if(i % 2 == 0){
                postfixEquation.add(equation.get(i));
            }
            else {
                if(operators.size() > 0) {
                    if(priorOpers.indexOf(operators.peek()) <= priorOpers.indexOf(equation.get(i))) {
                        while (operators.size() > 0 && priorOpers.indexOf(operators.peek()) <= priorOpers.indexOf(equation.get(i))) {
                            postfixEquation.add(operators.pop());
                        }
                        operators.add(equation.get(i));
                        continue;
                    }

                    if(priorOpers.indexOf(operators.peek()) > priorOpers.indexOf(equation.get(i))){
                        operators.add(equation.get(i));
                    }

                }
                else {
                    operators.push(equation.get(i));
                }
            }
        }

       while(!operators.isEmpty()){
            postfixEquation.add(operators.pop());
       }

        // do calculate postfix equation

        for(String curr : postfixEquation){
            boolean isNumber = true;
            for(int i = 0 ; i < curr.length(); i ++){
                if(!Character.isDigit(curr.charAt(i))){
                    isNumber = false;
                }
            }

            if(isNumber){
                numbers.push(curr);
            }
            else {
                String ln = numbers.pop();
                String rn = numbers.pop();
                    switch (curr) {
                        case "+":
                            numbers.push(String.valueOf(Long.parseLong(rn) + Long.parseLong(ln)));
                            break;
                        case "-":
                            numbers.push(String.valueOf(Long.parseLong(rn) - Long.parseLong(ln)));
                            break;
                        case "*":
                            numbers.push(String.valueOf(Long.parseLong(rn) * Long.parseLong(ln)));
                            break;
                    }
                }
        }

        results.add(Math.abs(Long.parseLong(numbers.pop())));
        System.out.println(postfixEquation);
        System.out.println(results);
        postfixEquation.clear();
    }

    public long solution(String expression) {
        long answer = 0;

        String[] initOpers = new String[3];
        boolean[] visited = new boolean[3];

        setElements(expression);
        dfs(defaultOpers, initOpers, 0 , visited );

        for(List<String> elem : priorityOpers){
            calc(elem);
            System.out.println(elem);
        }
        results.sort(Collections.reverseOrder());
        return results.get(0);
    }
}