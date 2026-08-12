package trees.traversal.dfs.recursion;

import trees.traversal.Node;

import static trees.traversal.Node.dataPreparation;

public class PostOrder {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5,6,7,8,9,10};
        Node head = dataPreparation(arr);
        postOrder(head);
    }

    private static void postOrder(Node node) {
        if(node==null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getData()+" ");
    }
}
