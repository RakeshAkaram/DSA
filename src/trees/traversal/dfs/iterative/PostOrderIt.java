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
                Node currNode=stack.peek();
                if(currNode.getRight()!=null){
                    node = currNode.getRight();
                }else{
                    Node rootNode = stack.pop();
                    System.out.print(rootNode.getData()+" ");
                    while(!stack.isEmpty() && rootNode==stack.peek().getRight()){
                        rootNode=stack.pop();
                        System.out.print(rootNode.getData()+" ");
                    }

                }
            }
        }
    }
}


