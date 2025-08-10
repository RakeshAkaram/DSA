package linkedList;

public class LL010_ReverseLL {
    public static void main(String[] args) {
        int nums[]={1,2,34,5,23};
        Node head = LL001_ConvertArrayToLL.convertToLL(nums);
        LL001_ConvertArrayToLL.displayLL(head);
        System.out.println();
        Node newHead = reverseLL(head);
        LL001_ConvertArrayToLL.displayLL(newHead);
        System.out.println();
        Node newHead1 = reverseLL1(newHead);
        LL001_ConvertArrayToLL.displayLL(newHead1);
        System.out.println();
        System.out.println("Recursion");
        Node recHead = recursionReverseLL(newHead1);
        LL001_ConvertArrayToLL.displayLL(recHead);
    }

    private static Node recursionReverseLL(Node head) {

        return head;
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
