package linkedList;

public class LL022_DeleteAllOccurenceInDLL {
    public static void main(String[] args) {
        NodeDLL head=LL006_ConvertArrayToDLL.convertArrayToDLL(new int[]{2,2,1,3,2,1,2,2,5,6,2});
        LL006_ConvertArrayToDLL.displayDLL(head);
        int key=2;
        System.out.println("\nAfter Deleting all the occurrences:");
        head = deleteAllOccurrencesoOfKey(head,key);
        LL006_ConvertArrayToDLL.displayDLL(head);
    }

    private static NodeDLL deleteAllOccurrencesoOfKey(NodeDLL head, int key) {
        NodeDLL traversalNode=head, nextNode=null;
        while(traversalNode!=null){
            nextNode = traversalNode.rightNode;
            if(traversalNode.data==key){
                if(traversalNode.rightNode!=null){
                    traversalNode.rightNode.leftNode=traversalNode.leftNode;
                }
                if(traversalNode.leftNode!=null)
                    traversalNode.leftNode.rightNode=traversalNode.rightNode;
                else head=nextNode;  // Don't forget to update the head
            }
            traversalNode=nextNode;
        }
        return head;
    }
}
