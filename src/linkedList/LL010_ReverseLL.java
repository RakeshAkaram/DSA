package linkedList;

public class LL010_ReverseLL {
    static Node actualHead;
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        System.out.println("Initial Array");
        Node head = LL001_ConvertArrayToLL.convertToLL(nums);
        LL001_ConvertArrayToLL.displayLL(head);
        System.out.println("\nAfter Reverse 1");
        Node newHead = reverseLL(head);
        LL001_ConvertArrayToLL.displayLL(newHead);
        System.out.println("\nAfter Reverse 2");
        Node newHead1 = reverseLL1(newHead);
        LL001_ConvertArrayToLL.displayLL(newHead1);
        System.out.println("\nAfter Reverse 3 by Recursion");

        recursionReverseLL(newHead1);
        LL001_ConvertArrayToLL.displayLL(actualHead);
        System.out.println();
    }

    private static Node recursionReverseLL(Node head) {
        if(head.next==null){
            actualHead=head;
            return head;
        }
        else{
            Node previousNodeInReverse = recursionReverseLL(head.next);
            previousNodeInReverse.next=head;
            head.next=null;
            return previousNodeInReverse.next;
        }
    }

    private static Node reverseLL1(Node newHead) {
        Node currentNode=newHead,previousNode=null,nextNode=null;
        while (currentNode!=null){
            nextNode=currentNode.next;
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return previousNode;
    }

    private static Node reverseLL(Node head) {
        Node currentNode=head,previousNode=null,nextNode=null;
        previousNode=currentNode;
        currentNode=currentNode.next;
        nextNode=currentNode.next;
        previousNode.next=null;
        currentNode.next=previousNode;
        while (nextNode!=null){
            previousNode=currentNode;
            currentNode=nextNode;
            nextNode=nextNode.next;
            currentNode.next=previousNode;
        }
        return currentNode;
    }



}
