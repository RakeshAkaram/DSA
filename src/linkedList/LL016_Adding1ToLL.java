package linkedList;

public class LL016_Adding1ToLL {
    public static void main(String[] args) {
        Node head=LL001_ConvertArrayToLL.convertToLL(new int[]{});//
        Node traversalNode=head;
        if(add1ToLL(head)==1){
            Node newNode=new Node(1,head);
            head=newNode;
        }
        LL001_ConvertArrayToLL.displayLL(head);
    }
    //Using Recursion - T(N)=O(N) Space = O(1)
    private static int add1ToLL(Node traversalNode) {
        if(traversalNode==null) return 1;
        int carry=add1ToLL(traversalNode.next);
        int val=traversalNode.data+carry;
        if(val==10){
            traversalNode.data=0;
            carry=1;
        }else {
            traversalNode.data=val;
            return 0;
        }
        return carry;
    }
}
