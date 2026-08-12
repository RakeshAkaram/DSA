package trees.problems;

import trees.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class MaxHeight {
    public static void main(String[] args) {
        Integer height=0;
        Integer arr[]={1,2,3,4,5,6,7,8,9};

        Node head = Node.balanceTree();//dataPreparation(arr);

        height = maxHeight(head);
        System.out.println("Height: "+height);
        height = maxHeightIt(head);
        System.out.println("Iterative Height: "+height);
    }

    //1. Recursive solution --Time: O(N) and space: O(N)(skew tree)
    private static Integer maxHeight(Node node) {
        if(node==null) return 0;
        return 1+Math.max(maxHeight(node.getLeft()),maxHeight(node.getRight()));
    }
    //2. Iterative solution --Time: O(N) and space: O(N)(skew tree)
    private static Integer maxHeightIt(Node node) {
        Integer height = 0;
        Deque<Map.Entry<Node,Integer>> queue = new ArrayDeque<>();
        queue.addLast(Map.entry(node,1));
        while (!queue.isEmpty()){
            Map.Entry<Node, Integer> head = queue.removeFirst();

            Node currentNode = head.getKey();
            height = head.getValue();

            if(currentNode.getLeft()!=null)
                queue.addLast(Map.entry(currentNode.getLeft(),height+1));
            if(currentNode.getRight()!=null)
                queue.addLast(Map.entry(currentNode.getRight(),height+1));
        }
        return height;
    }
}
