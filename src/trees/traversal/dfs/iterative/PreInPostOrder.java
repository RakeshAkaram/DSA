package trees.traversal.dfs.iterative;

import trees.Node;

import java.util.*;

import static trees.Node.dataPreparation;

public class PreInPostOrder {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5};
        Node head = dataPreparation(arr);
        preInPostOrder(head);
    }

    private static void preInPostOrder(Node node) {
        Map<Integer, List<Integer>>  preInPostMap = new HashMap<>();
        preInPostMap.put(1,new ArrayList<>());
        preInPostMap.put(2,new ArrayList<>());
        preInPostMap.put(3,new ArrayList<>());

        Stack<Node> stack = new Stack<>();
        Map<Node,Integer> nodeNoOfVisitMap = new HashMap<>();
        stack.push(node);
        nodeNoOfVisitMap.put(node,1);
        while(!stack.isEmpty()){
            node = stack.pop();
            Integer count = nodeNoOfVisitMap.get(node);
            if(count.equals(1)){
                preInPostMap.get(1).add(node.getData());
                nodeNoOfVisitMap.put(node,2);
                stack.push(node);
                if(node.getLeft()!=null){
                    node=node.getLeft();
                    stack.push(node);
                    nodeNoOfVisitMap.put(node,1);
                }
            }else if(count.equals(2)){
                preInPostMap.get(2).add(node.getData());
                nodeNoOfVisitMap.put(node,3);
                stack.push(node);
                if(node.getRight()!=null){
                    node=node.getRight();
                    stack.push(node);
                    nodeNoOfVisitMap.put(node,1);
                }
            }else{
                preInPostMap.get(3).add(node.getData());
            }
        }
        System.out.println("PreOrder: "+preInPostMap.get(1));
        System.out.println("InOrder: "+preInPostMap.get(2));
        System.out.println("PostOrder: "+preInPostMap.get(3));
    }
}
