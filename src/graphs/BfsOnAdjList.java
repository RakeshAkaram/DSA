package graphs;

import java.util.*;

public class BfsOnAdjList {
    static Map<Integer,ArrayList<Integer>> adjList=new HashMap<>();
    static Map<Integer,Boolean> visited=new HashMap<>();
    public static void main(String[] args) {
        //Consider the start Index is 1
        int startNode=1;
        Queue<Integer> bfsQueue=new LinkedList<>();
        bfsQueue.add(startNode);
        visited.put(startNode,true);
        while(!bfsQueue.isEmpty()){
            Integer nodeTofindItsAdj=bfsQueue.poll();
            System.out.print(nodeTofindItsAdj+" ");
            for(Integer adjNode: adjList.get(nodeTofindItsAdj)){
                if(!visited.get(adjNode)){
                    bfsQueue.add(adjNode);
                    visited.put(adjNode,true);
                }
            }
        }
    }
    // To Prepare the adjacency Dummy  List
    // 1--> 2,3
    // 2--> 1,4
    // 3--> 1,4
    // 4--> 2,3
    static {
        System.out.println("In Static");
        ArrayList<Integer> node1=new ArrayList<>();
        //node1.add(2);
        node1.add(3);
        adjList.put(1,node1);
        visited.put(1,false);

        ArrayList<Integer> node2=new ArrayList<>();
        //node2.add(1);
        node2.add(4);
        adjList.put(2,node2);
        visited.put(2,false);

        ArrayList<Integer> node3=new ArrayList<>();
        node3.add(1);
        node3.add(4);
        adjList.put(3,node3);
        visited.put(3,false);

        ArrayList<Integer> node4=new ArrayList<>();
        node4.add(2);
        node4.add(3);
        adjList.put(4,node4);
        visited.put(4,false);

    }
}
