package linkedList;

import java.util.ArrayList;
import java.util.List;

public class LL012_OddEvenNodes {
    public static void main(String[] args) {
        Node head=LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5,6,7,8,9});
        LL001_ConvertArrayToLL.displayLL(head);
        List<Node> heads= evenOddLLs(head);
        System.out.println("\n***********ODD***************");
        LL001_ConvertArrayToLL.displayLL(heads.get(0));
        System.out.println("\n***********EVEN***************");
        LL001_ConvertArrayToLL.displayLL(heads.get(1));
    }

    private static List<Node> evenOddLLs(Node head) {
        List<Node> heads = new ArrayList<>();
        Node evenHead = null;
        Node oddHead = null;
        Node evenHeadTraversal=null, oddHeadTraversal=null;

        Node traversalHead = head;
        while (traversalHead!=null){
            if(evenHead==null || oddHead==null){
                oddHead=traversalHead;
                oddHeadTraversal=oddHead;
                if(traversalHead.next!=null){
                    evenHead=traversalHead.next;
                    evenHeadTraversal=evenHead;
                }
            }else{
                oddHeadTraversal.next=traversalHead;
                oddHeadTraversal=oddHeadTraversal.next;
                if(traversalHead.next!=null){
                    evenHeadTraversal.next=traversalHead.next;
                    evenHeadTraversal=evenHeadTraversal.next;
                }
            }
            traversalHead = traversalHead.next;
            oddHeadTraversal.next=null;
            if (traversalHead!= null){
                traversalHead = traversalHead.next;
                evenHeadTraversal.next=null;
            }
        }
        heads.add(oddHead);
        heads.add(evenHead);
        return heads;
    }
}
