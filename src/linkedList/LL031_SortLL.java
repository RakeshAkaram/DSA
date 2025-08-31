package linkedList;

public class LL031_SortLL {
    public static void main(String[] args) {
        Node head = LL001_ConvertArrayToLL.convertToLL(new int[]{2,5,3,6,7,1,8,9,10,0,4});
        Node resultHead = mergeSort(head);
        LL001_ConvertArrayToLL.displayLL(resultHead);
    }

    private static Node mergeSort(Node head) {
        if(head==null || head.next==null) return head;
        Node mid = slowFastAlgo(head);
        Node newMid = mid;
        mid=mid.next;
        newMid.next=null;
        Node leftLL = mergeSort(head);
        Node rightLL =mergeSort(mid);
        return merge(leftLL,rightLL);
    }

    private static Node slowFastAlgo(Node head) {
        Node slow=head,fast=head;
        while (fast==null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    private static Node merge(Node head, Node nextHead) {
        Node resultHead = new Node(-1);
        Node tempHead = resultHead;
        Node headTemp1 = head;
        Node headTemp2 = nextHead;
        while (headTemp1!=null && headTemp2!=null){
            if(headTemp1.data<headTemp2.data){
                resultHead.next=headTemp1;
                headTemp1=headTemp1.next;
            }else{
                resultHead.next=headTemp2;
                headTemp2=headTemp2.next;
            }
            resultHead=resultHead.next;
        }
        while(headTemp1!=null){
            resultHead.next=headTemp1;
            headTemp1=headTemp1.next;
            resultHead=resultHead.next;
        }
        while(headTemp2!=null){
            resultHead.next=headTemp2;
            headTemp2=headTemp2.next;
            resultHead=resultHead.next;
        }
        return tempHead.next;
    }

}
