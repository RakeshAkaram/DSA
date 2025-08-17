package linkedList;

public class LL027_RotateLLByK {
    public static void main(String[] args) {
        Node head=LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5,6});
        int rotateByK=27;
        LL001_ConvertArrayToLL.displayLL(head);
        System.out.println("\nAfter rotation: ");
        head = rotateLLByKNodes(head,rotateByK);
        LL001_ConvertArrayToLL.displayLL(head);
    }

    private static Node rotateLLByKNodes(Node head, int rotateByK) {
        Node traversalNode=head;
        int length=1;
        while(traversalNode.next!=null){
            length++;
            traversalNode=traversalNode.next;
        }
        int remainder=length - rotateByK%length; //Main point
        if(remainder!=0){
            traversalNode.next=head;
            traversalNode=head;
        }
        while (--remainder>0){
            traversalNode=traversalNode.next;
        }
        head=traversalNode.next;
        traversalNode.next=null;
        return head;
    }
}
