package trees.problems;

import trees.Node;

import java.util.Stack;

public class IdenticalTree {
    public static void main(String[] args) {
        Node head1 = Node.unbalanced();
        Node head2 = Node.balanceTree();
        if(identicalTree(head1,head2))
            System.out.println("Identical");
        else System.out.println("Not Identical");
    }

    private static boolean identicalTree(Node head1, Node head2) {
        //using preorder
        Boolean isMatch=false;
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(head1);
        stack2.push(head2);
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            Node node1=stack1.pop();
            Node node2=stack2.pop();

            if(node1.getRight()!=null && node2.getRight()!=null){
                Node right1 = node1.getRight();
                Node right2 = node2.getRight();
                if(right1.getData()!=right2.getData()) return false;
                stack1.push(right1);
                stack2.push(right2);
            }else{
                if(!(node1.getRight()==null && node2.getRight()==null))
                    return false;
            }

            if(node1.getLeft()!=null && node2.getLeft()!=null){
                Node left1 = node1.getLeft();
                Node left2 = node2.getLeft();
                if(left1.getData()!=left2.getData()) return false;
                stack1.push(left1);
                stack2.push(left2);
            }else{
                if(!(node1.getLeft()==null && node2.getLeft()==null))
                    return false;
            }
        }
        if(!(stack1.isEmpty() && stack2.isEmpty())) return false;
        return true;
    }
}
