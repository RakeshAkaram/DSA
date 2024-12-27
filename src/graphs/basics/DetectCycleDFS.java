package graphs.basics;

import graphs.FetchDataFromTxt;

import java.io.FileNotFoundException;
import java.util.*;

public class DetectCycleDFS {
    private static Map<Integer, ArrayList<Integer>> adjList ;
    private static Map<Integer,Boolean> visited ;
    public static void main(String[] args) throws FileNotFoundException {
        //step 1: getData()
        FetchDataFromTxt.getData("./src/graphs/resources/input3.txt");
        adjList=FetchDataFromTxt.getAdjList();
        visited=FetchDataFromTxt.getVisited();
        //step 2: DetectCycleDFS
        if(detectCycleDFS()) System.out.println("Graph is Cyclic");
        else System.out.println("Graph is not Cyclic");
    }

    private static boolean detectCycleDFS() {
        Stack<Map.Entry<Integer,Integer>>  stack = new Stack<>();
        //Assuming 1 as start node
        stack.push(new AbstractMap.SimpleEntry<>(1,-1));
        visited.put(1,true);
        while(!stack.isEmpty()){
            Map.Entry<Integer,Integer> currNode = stack.pop();

            Integer key = currNode.getKey();
            Integer parent = currNode.getValue();

            for(Integer edge: adjList.get(key)){
                System.out.println("Edge: "+edge+" Key:"+key+" Parent: "+parent);
                if(visited.get(edge) && !Objects.equals(parent, edge)){
                    return true; // Detected Cycle
                } else if (!visited.get(edge)) {
                    stack.add(new AbstractMap.SimpleEntry<>(edge,key));
                    visited.put(edge,true);
                }
            }
        }
        return false; // No Cycle Detected
    }
}
