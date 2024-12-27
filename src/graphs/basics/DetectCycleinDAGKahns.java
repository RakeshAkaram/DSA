package graphs.basics;

import graphs.FetchDataFromTxt;

import java.io.FileNotFoundException;
import java.util.*;
// NOTE: This Solution solves Course Schedule-I and Course Schedule-II problem
public class DetectCycleinDAGKahns {
    public static void main(String[] args) throws FileNotFoundException {
        //Step 1: Fetch DAG data
        FetchDataFromTxt.getData("src/graphs/resources/DAG.txt");
        Map<Integer, Integer> inDegreeList = FetchDataFromTxt.getInDegreeList();
        Map<Integer, ArrayList<Integer>> adjList = FetchDataFromTxt.getAdjList();
        //Step 2: Algo part
        KahnsCycleDetect(inDegreeList,adjList);
    }

    private static void KahnsCycleDetect(Map<Integer, Integer> inDegreeList, Map<Integer, ArrayList<Integer>> adjList) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> solnOrder = new ArrayList<>();
        //Step 1: get all the nodes with in degree 0
        Set<Integer> nodes = adjList.keySet();
        for(Integer node: nodes){
            if(inDegreeList.get(node)==null)
                deque.addLast(node);
        }
        //Step 2: BFS algo
        while(!deque.isEmpty()){
            Integer topNode = deque.removeFirst();
            solnOrder.add(topNode);
            ArrayList<Integer> adjNodeList = adjList.get(topNode);
            if(adjNodeList!=null){
                for(Integer adjNode:adjNodeList){
                    inDegreeList.compute(adjNode,(k,degree)->degree-1);
                    if(inDegreeList.get(adjNode)==0){
                        inDegreeList.remove(adjNode);
                        deque.push(adjNode);
                    }
                }
            }
        }
        if(!inDegreeList.isEmpty()) System.out.println("Cycle Exists");
        else{
            System.out.println("Cycle does not exist");
            System.out.print("Order: ");
            for (Integer nodeOrder: solnOrder)
                System.out.print(nodeOrder+" ");
        }
    }
}
