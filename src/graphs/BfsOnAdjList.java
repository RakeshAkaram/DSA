package graphs;

import java.security.Key;
import java.util.*;

public class BfsOnAdjList {
    static Map<Integer,ArrayList<Integer>> adjList=new HashMap<>();
    static Map<Integer,Boolean> visited=new HashMap<>();
    public static void main(String[] args) {
        getData();
        //Consider the start Index is 1
        int startNode=1;
        Queue<Integer> bfsQueue=new LinkedList<>();
        bfsQueue.add(startNode);
        visited.put(startNode,true);
        while(!bfsQueue.isEmpty()){
            Integer nodeFindItsAdj=bfsQueue.poll();
            System.out.print(nodeFindItsAdj+" ");
            for(Integer adjNode: adjList.get(nodeFindItsAdj)){
                if(!visited.get(adjNode)){
                    bfsQueue.add(adjNode);
                    visited.put(adjNode,true);
                }
            }
        }
    }
   static void  getData(){
        Scanner sc=new Scanner(System.in);
        List<int []> data=new ArrayList<>();
        System.out.println("Enter the number of the Edges:");
        int edges=sc.nextInt();

        System.out.println("Enter the connected edge data as U V");
        while(edges>0){
            int u=sc.nextInt();
            int v=sc.nextInt();
            data.add(new int[]{u,v});
            edges--;
        }
        // Convert the data to
        for (int [] p: data){
            System.out.println("Edges Entered");
            System.out.println(p[0] +"-->"+ p[1]);
            if(adjList.get(p[0])!=null){
                adjList.get(p[0]).add(p[1]);
            }
            else {
                ArrayList<Integer> node=new ArrayList<>();
                node.add(p[1]);
                adjList.put(p[0],node);
            }
            visited.put(p[0],false);
            visited.put(p[1],false);
        }
        for(Map.Entry<Integer,ArrayList<Integer>> map: adjList.entrySet()){
            System.out.println(map.getKey() +" : "+map.getValue());
        }
    }
}
