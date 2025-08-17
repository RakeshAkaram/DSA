package linkedList;

import java.util.HashMap;

public class LL024_AllPairsDLLWithSumK {
    public static void main(String[] args) {
        NodeDLL head=LL006_ConvertArrayToDLL.convertArrayToDLL(new int[]{1,9,3,4,5,6,8,7,2});
        LL006_ConvertArrayToDLL.displayDLL(head);
        System.out.println();
        int sumK=9;
        allPairsDLLWithSumK(head,sumK);
    }

    private static void allPairsDLLWithSumK(NodeDLL head, int sumK) {
        NodeDLL traversalNode=head;
        HashMap<Integer,Integer> nodeMap=new HashMap<>();
        int pairCount=0;
        while (traversalNode!=null){
            int currentValue=traversalNode.data;
            int remaining=Math.abs(sumK-currentValue);
            if(nodeMap.get(remaining)!=null){
                System.out.println("\nPair Count: "+(++pairCount)+"\n\tNode 1: "+traversalNode.data+"\n\tNode 2: "+remaining);
                int count=nodeMap.get(remaining);
                if(count>1)
                    nodeMap.put(remaining,nodeMap.get(remaining)-1); //To include duplicates
                else
                    nodeMap.remove(remaining);
            }
            else {
                nodeMap.merge(currentValue, 1, Integer::sum);
            }
            traversalNode=traversalNode.rightNode;
        }
    }
}
