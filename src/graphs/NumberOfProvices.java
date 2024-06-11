package graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NumberOfProvices {

    static Map<Integer, Boolean> visited = new HashMap<>();
    static Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        //Step 1: Get Data from input.txt
            List<int[]>  data=getData();
        //Step 2: Convert to Adjacency List or Matrix
            transformToAdjList(data);
        //Step 3: Apply the Algorithm
           int count = numberOfProvince();
        System.out.println("Number of Provinces are: "+count);
    }

    private static int numberOfProvince() {
        int count=0;
        Queue<Integer> bfs=new LinkedList<>();

        for(Map.Entry<Integer, Boolean> nodeVisit:  visited.entrySet()){
            if(!nodeVisit.getValue()) {
                count++;
                bfs.add(nodeVisit.getKey());
                visited.put(nodeVisit.getKey(), true);
            }
            while(!bfs.isEmpty()){
                System.out.println("Adjacency List for "+bfs.peek()+" is "+adjList.get(bfs.peek()));
                for(Integer adjNodes: adjList.get(bfs.poll())) {
                    if(!visited.get(adjNodes)){
                        bfs.add(adjNodes);
                        visited.put(adjNodes, true);
                    }
                }
            }
        }
        return count;
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
        File file = new File("./src/graphs/input2.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String[] edgeSplit = scanner.nextLine().split(" ");
            data.add(new int[]{Integer.parseInt(edgeSplit[0]), Integer.parseInt(edgeSplit[1])});
        }
        return data;
    }
}
