import java.util.*;
import java.util.stream.Collectors;

public class BFS {
    public static void bfs(int[][] graph, int startNode, boolean weighted){
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[graph.length];

        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            System.out.println(queue);

            if(weighted){
                for (int i = graph[node].length - 1; i > 0; i--) {
                    if (graph[node][i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            else {
                for (int i = 0; i < graph[node].length; i++) {
                    if (graph[node][i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }

    }
}
