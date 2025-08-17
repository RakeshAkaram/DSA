package linkedList;

public class LL025_RemoveDuplicatesSortedDLL {
    public static void main(String[] args) {
        NodeDLL head=LL006_ConvertArrayToDLL.convertArrayToDLL(new int[]{1,1,1,2,2,3,4,4,4,4});
        LL006_ConvertArrayToDLL.displayDLL(head);
        System.out.println("\nAfter duplicates are removed");
        removeDuplicates(head);
        LL006_ConvertArrayToDLL.displayDLL(head);
    }

    private static void removeDuplicates(NodeDLL head) {
        NodeDLL traversalNode=head.rightNode,markedNode=head;
        while(traversalNode!=null){
            if(markedNode.data==traversalNode.data){
                markedNode.rightNode=traversalNode.rightNode;
                if(traversalNode.rightNode!=null){
                    traversalNode.rightNode.leftNode=markedNode;
                }
            }else {
                markedNode=traversalNode;
            }
            traversalNode = traversalNode.rightNode;
        }
    }
}
