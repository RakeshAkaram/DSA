package graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DfsOnAdjList {

    static Map<Integer, Boolean> visited = new HashMap<>();
    static Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        List<int[]> data = getData();
        transformToAdjList(data);
        DfsAlgo();
    }

    private static void DfsAlgo() {
        Stack<Integer> dfsStack = new Stack<>();
        //TODO 1: start node (Take from user)
        dfsStack.push(1);
        visited.put(dfsStack.peek(), true);
        while (!dfsStack.isEmpty()) {
            Integer activeNode = dfsStack.pop();
            System.out.print(activeNode + " ");
            if (adjList.get(activeNode) != null) {
                for (Integer node : adjList.get(activeNode)) {
                    if (!visited.get(node)) {
                        dfsStack.push(node);
                        visited.put(node, true);
                    }
                }
            }
        }
    }

    static void transformToAdjList(List<int[]> data) {
        // Convert the data to adjacency List
        for (int[] p : data) {
            System.out.println("Edges Entered");
            System.out.println(p[0] + "-->" + p[1]);
            if (adjList.get(p[0]) != null) {
                adjList.get(p[0]).add(p[1]);
            } else {
                ArrayList<Integer> node = new ArrayList<>();
                node.add(p[1]);
                adjList.put(p[0], node);
            }
            visited.put(p[0], false);
            visited.put(p[1], false);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> map : adjList.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
    }

    static List<int[]> getData() throws FileNotFoundException {
        List<int[]> data = new ArrayList<>();
        File file = new File("./src/graphs/input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
                String[] edgeSplit = scanner.nextLine().split(" ");
                data.add(new int[]{Integer.parseInt(edgeSplit[0]), Integer.parseInt(edgeSplit[1])});
        }
        return data;
    }
}

