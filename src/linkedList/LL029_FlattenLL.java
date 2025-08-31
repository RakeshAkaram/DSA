package linkedList;

import java.util.Arrays;

public class LL029_FlattenLL {
    public static void main(String[] args) {
        NodeFlat  head = prepareData();
        NodeFlat resultHead = flattenLL(head);
        displayFlatLL(resultHead);
    }

    public static void displayFlatLL(NodeFlat resultHead) {
        NodeFlat tHead=resultHead;
        while (tHead!=null){
            System.out.print(tHead.data+"->");
            tHead=tHead.next;
        }
        System.out.print("null");
    }

    private static NodeFlat flattenLL(NodeFlat head) {
        if(head==null || head.leftNode==null)
            return head;
        NodeFlat nextHead = flattenLL(head.leftNode);
        NodeFlat resultHead = mergeLLs(head,nextHead);
        return resultHead;
    }

    private static NodeFlat mergeLLs(NodeFlat head, NodeFlat nextHead) {
        NodeFlat resultHead = new NodeFlat(-1);
        NodeFlat tempHead = resultHead;
        NodeFlat headTemp1 = head;
        NodeFlat headTemp2 = nextHead;
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

    private static NodeFlat prepareData() {
        NodeFlat head1 = NodeFlat.singleLL(new int[]{1,5,8});
        NodeFlat head2 = NodeFlat.singleLL(new int[]{2,4});
        NodeFlat head3 = NodeFlat.singleLL(new int[]{3,6});
        NodeFlat head4 = NodeFlat.singleLL(new int[]{7,9,10});
        head1.leftNode=head2;
        head2.leftNode=head3;
        head3.leftNode=head4;
        return head1;
    }
}

class NodeFlat{
    int data;
    NodeFlat leftNode;
    NodeFlat next;

    public NodeFlat(int data, NodeFlat next, NodeFlat leftNode) {
        this.data = data;
        this.next = next;
        this.leftNode = leftNode;
    }

    public NodeFlat(int data) {
        this.data = data;
    }
    public static NodeFlat singleLL(int [] values){
        NodeFlat head = new NodeFlat(-1);
        NodeFlat temp=head;
        for (int val:values){
            temp.next =  new NodeFlat(val);
            temp = temp.next;
        }
        LL029_FlattenLL.displayFlatLL(head.next);
        System.out.println();
        return head.next;
    }
}

