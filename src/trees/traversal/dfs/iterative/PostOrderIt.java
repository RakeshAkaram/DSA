package trees.traversal.dfs.iterative;

import trees.Node;

import java.util.Stack;

import static trees.Node.dataPreparation;

public class PostOrderIt {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5,6,7,8};
        Node head = dataPreparation(arr);
        postOrderIt(head);
    }

    private static void postOrderIt(Node node) {
        Stack<Node> stack = new Stack<>();
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node = node.getLeft();
            }else{
                node = stack.peek();
                if(node.getRight()!=null) {
                    node = node.getRight();
                }else{
                    Node temp = stack.pop();
                    System.out.print(temp.getData()+" ");
                    while(!stack.isEmpty() && temp == stack.peek().getRight()){
                        temp = stack.pop();
                        System.out.print(temp.getData()+" ");
                    }
                }
            }
        }
    }
}
