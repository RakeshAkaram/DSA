package linkedList;

public class LL014_Sort012InLL {
    public static void main(String[] args) {
        Node head = LL001_ConvertArrayToLL.convertToLL(new int[]{1,0,2,2,1,0,0,0,2,1,1});//
        LL001_ConvertArrayToLL.displayLL(head);
        head=sort012LL(head);
        System.out.println();
        LL001_ConvertArrayToLL.displayLL(head);
    }

    private static Node sort012LL(Node head) {
        Node oneIndex=null,twoIndex=null,zeroIndex=null;
        Node oneHead=null,twoHead=null,zeroHead=null;
        Node temp = head;
        while (temp!=null){
            if(temp.data==0){
                if(zeroHead==null){
                    zeroHead=temp;
                    zeroIndex=temp;
                }else{
                    zeroIndex.next=temp;
                    zeroIndex=zeroIndex.next;
                }
            }
            if(temp.data==1){
                if(oneHead==null){
                    oneHead=temp;
                    oneIndex=temp;
                }else{
                    oneIndex.next=temp;
                    oneIndex=oneIndex.next;
                }
            }
            if(temp.data==2){
                if(twoHead==null){
                    twoHead=temp;
                    twoIndex=temp;
                }else{
                    twoIndex.next=temp;
                    twoIndex=twoIndex.next;
                }
            }
            temp=temp.next;
        }
        if(zeroHead==null && oneHead==null) return twoHead;
        else if(zeroHead==null) return oneHead;
        else {
            zeroIndex.next=oneHead;
            oneIndex.next=twoHead;
            if(twoHead!=null) twoIndex.next=null;
            return zeroHead;
        }
    }

    /*private static Node sort012LL(Node head) {
        Node zeroIndex=null,oneHead=head,twoHead=head;
        while (twoHead.next!=null){
            twoHead=twoHead.next;
        }
        Node previousOne=null;
        while (oneHead!=null){
            if(oneHead.data==1){
                oneHead=oneHead.next;
            }
            else if (oneHead.data == 0) {
                if(zeroIndex==null){
                    zeroIndex = oneHead;
                    head.next = oneHead.next;
                    Node temp = oneHead.next;
                    oneHead.next=head;
                    head=zeroIndex;
                    oneHead=temp;
                }
                else{
                    Node temp=zeroIndex.next;
                    zeroIndex.next=oneHead;
                    zeroIndex=oneHead;
                    zeroIndex.next=temp;
                    temp.next=oneHead.next;
                    oneHead=oneHead.next;
                }
            }
            else if(oneHead.data == 2){

            }
        }
        return head;
    }*/
}
