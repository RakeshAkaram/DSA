package graphs.basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DetectCycleBFS {
    static private Map<Integer, ArrayList<Integer>> adjList=new HashMap<>();
    static private Map<Integer,Boolean> visited =new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        // step 1: getData
        getData();
        //step 2: detectCycleBFS
        boolean isCyclic = detectCycleBFS();
        if(isCyclic) System.out.println( "Cyclic Graph");
        else System.out.println("Non Cyclic Graph");
    }

    private static boolean detectCycleBFS(){
        Queue<Map.Entry<Integer,Integer>> queue = new LinkedList<>();
        // Assume that graph start with 1
        queue.add(new AbstractMap.SimpleEntry<>(1, -1)); // -1 is the parent to represent there is no parent node for 1
        visited.put(1,true); // 1 is made visited
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> nodeNParent = queue.poll();
            Integer key = nodeNParent.getKey();
            Integer parent = nodeNParent.getValue();
            for(Integer edge: adjList.get(key)){
                System.out.println("Edge: "+edge+" Key:"+key+" Parent: "+parent);
                if(visited.get(edge) && !Objects.equals(parent, edge)){ // unvisited node
                    return true;
                }
                else if(!visited.get(edge)){
                    queue.add(new AbstractMap.SimpleEntry<>(edge, key));
                    visited.put(edge,true);
                }
            }
        }
        return false;
    }

    static void getData() throws FileNotFoundException {
        //step 1: Read the file where the input is present
        File file = new File("./src/graphs/resources/input3.txt");

        //step 2: Read each line from that file using Scanner Object
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String[] edge = scanner.nextLine().split(" ");
            Integer key = Integer.parseInt(edge[0]);
            Integer value = Integer.parseInt(edge[1]);
            // Step 3: Put the data in the adjacency List for each node(i.e. Key)
            if(adjList.get(key)==null){
                ArrayList<Integer> edgeList = new ArrayList<>();
                edgeList.add(value);
                adjList.put(key,edgeList);
                //step 4: set the visited to false for each node
                visited.put(key,false);
            }
            else{
                adjList.get(key).add(value);
            }
        }
    }

}


/*
* 1-2
* 1-3
* 2-1
* 2-4
* 3-1
* 3-5
* 4-2
* 4-6
* 5-3
* 5-7
* 6-4
* 6-7
* 7-5
* 7-6*/