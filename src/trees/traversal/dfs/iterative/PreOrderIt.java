package trees.traversal.dfs.iterative;

import trees.Node;

import java.util.Stack;

import static trees.Node.dataPreparation;

public class PreOrderIt {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5,6,7,8,9,10};
        Node head = dataPreparation(arr);
        preOrderIt(head);
    }

    private static void preOrderIt(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            System.out.print(currNode.getData()+" ");
            if(currNode.getRight()!=null) stack.push(currNode.getRight());
            if(currNode.getLeft()!=null) stack.push(currNode.getLeft());

        }
    }
}
