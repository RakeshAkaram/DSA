package trees.traversal.dfs;

import trees.traversal.Node;

import static trees.traversal.Node.dataPreparation;

public class Inorder {
    public static void main(String[] args) {
       Integer arr[]={1,2,3,4,5,6,7,8,9,10};
        Node head = dataPreparation(arr);
        inorder(head);
    }

    private static void inorder(Node node) {
        if(node==null)
            return;
        inorder(node.getLeft());
        System.out.println(node.getData());
        inorder(node.getRight());
    }
}
