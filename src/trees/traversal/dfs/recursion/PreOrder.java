package trees.traversal.dfs.recursion;

import trees.traversal.Node;

import static trees.traversal.Node.dataPreparation;

public class PreOrder {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5,6,7,8,9,10};
        Node head = dataPreparation(arr);
        preOrder(head);
    }

    private static void preOrder(Node node) {
        if(node==null) return;
        System.out.print(node.getData()+" ");
        preOrder(node.getLeft());
        preOrder(node.getRight());//1 2 4 8 9 5 10 3 6 7
    }
}
