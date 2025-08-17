package linkedList;

public class LL021_DeleteMiddleNodeLL {
    public static void main(String[] args) {
        Node head=LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5,6,7});
        LL001_ConvertArrayToLL.displayLL(head);
        System.out.println("\n1. Using length of LL");
        deleteUsingLength(head);
        LL001_ConvertArrayToLL.displayLL(head);
        System.out.println("\n2. Using slow and fast node");
        deleteMiddleNode(head);
        LL001_ConvertArrayToLL.displayLL(head);
    }

    //1. Using length of LL
    private static void deleteUsingLength(Node head) {
        Node traversalNode=head;
        int length=0;
        while (traversalNode!=null){
            length++;
            traversalNode=traversalNode.next;
        }

        int middleIndex=(length/2);
        traversalNode=head;
        if(middleIndex>0){
            while (--middleIndex>0){
                traversalNode=traversalNode.next;
            }
            traversalNode.next=traversalNode.next.next;
        }
    }
    //2. Using slow and fast node
    private static void deleteMiddleNode(Node head) {
        Node slowNode=head,fastNode=head;
        boolean skipOnce=true;
        while(fastNode!=null && fastNode.next!=null){
            if(skipOnce){
                skipOnce=false;
            }else {
                slowNode=slowNode.next;
            }
            fastNode=fastNode.next.next;
        }
        if(slowNode.next!=null)
            slowNode.next=slowNode.next.next;
    }
}
