package trees.traversal;

import java.util.ArrayDeque;
import java.util.Queue;

import static trees.traversal.Node.dataPreparation;

public class MaxHeight {
    public static void main(String[] args) {
        Integer height=0;
        Integer arr[]={1,2,3,4,5,6,7,8,9};
        Node head = dataPreparation(arr);
        height = maxHeight(head);
        System.out.println("Height: "+height);
    }

    private static Integer maxHeight(Node node) {
        if(node==null) return 0;
        return 1+Math.max(maxHeight(node.getLeft()),maxHeight(node.getRight()));
    }
}
