package linkedList;

public class LL026_ReverseKSizeGroup {
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5,6,7,8,9,10,11};
        int k=3;
        System.out.println("Initial Array");
        Node head = LL001_ConvertArrayToLL.convertToLL(nums);
        LL001_ConvertArrayToLL.displayLL(head);
        System.out.println("\nAfter Reverse by K");
        Node newHead = reverseLLDK(head,k);
        LL001_ConvertArrayToLL.displayLL(newHead);
    }

    private static Node reverseLLDK(Node head,int k) {
        Node curr=head;
        Boolean firstPrevFlag = true;
        Node firstPrev = null;
        //Repeat until the current becomes null
        //For each K group apply ReverseLL code
        //Store the new head obtained in first reverse that would be last node of first reverse
        //Assign the prevHead->next to the kth node from current node or the last node if the number of nodes are less than k.
        while(curr!=null){
            Node prev=null;
            int count=0;
            Node currHead = curr;
            while(curr!=null && count!=k){
                Node nextNode = curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextNode;
                count++;
            }
            if(firstPrevFlag){
                firstPrevFlag = false;
                firstPrev = prev;
            }
            count=0;
            Node ctrav = curr;
            Node ptrav = null;
            while(ctrav!=null && count<k){
                ptrav=ctrav;
                ctrav=ctrav.next;
                count++;
            }
            currHead.next=ptrav;
        }
        return firstPrev;
    }
}
