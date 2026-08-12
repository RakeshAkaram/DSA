package trees.traversal.bfs;

import trees.traversal.Node;

import java.util.ArrayDeque;
import java.util.Deque;

import static trees.traversal.Node.dataPreparation;

public class LevelOrder {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5,6,7,8,9,10};
        Node head = dataPreparation(arr);
        levelOrder(head);
    }

    private static void levelOrder(Node node) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(node);
        while(!queue.isEmpty()){
            Node currNode = queue.removeFirst();
            System.out.print(currNode.getData()+" ");
            if(currNode.getLeft()!=null) queue.addLast(currNode.getLeft());
            if(currNode.getRight()!=null) queue.addLast(currNode.getRight());
        }
    }
}
