package trees.traversal.dfs.iterative;

import trees.Node;

import java.util.Stack;

import static trees.Node.dataPreparation;

public class InOrderIt {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5,6};
        Node head = dataPreparation(arr);
        System.out.println("Optimal Approach");
        optimalApproach(head);
        System.out.println("\nMy Approach");
        inOrderIt(head);
    }

    private static void optimalApproach(Node node) {
        Stack<Node> stack = new Stack<>();
        //stack.push(node);
        while (node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.getLeft();
            }
            node = stack.pop();
            System.out.print(node.getData()+" ");
            node = node.getRight();
        }
    }

    //Solution 1: My own Approach
    //Disadvantages: modifying the actual tree. So, state of the tree is gone.
    private static void inOrderIt(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            if(node.getRight()==null && node.getLeft()==null){
                System.out.print(node.getData()+" ");
            }else{
                Node left = node.getLeft();
                Node right = node.getRight();
                node.setRight(null); node.setLeft(null); // Here: modifying the actual tree
                if(right!=null) stack.push(right);
                stack.push(node);
                if(left!=null) stack.push(left);
            }
        }
    }
}
