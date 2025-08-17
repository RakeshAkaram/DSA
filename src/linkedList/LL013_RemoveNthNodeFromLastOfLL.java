package linkedList;

import java.util.Scanner;

public class LL013_RemoveNthNodeFromLastOfLL {
    public static void main(String[] args) {
        Node head=LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5});
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Nth value");
        int n  = scanner.nextInt();
        head=removeNthNodeFromLast(head,n);
        LL001_ConvertArrayToLL.displayLL(head);
    }

    private static Node removeNthNodeFromLast(Node head, int n) {
        Node traversalNode=head;
        Node previousNode=null;
        Node currentNode=head;
        while (n-->0){
            if(traversalNode!=null) {
                traversalNode = traversalNode.next;
            }
            else{
                System.out.println("N is greater than the LL length");
                return head;
            }
        }

        while(traversalNode!=null){
            previousNode=currentNode;
            currentNode=currentNode.next;
            traversalNode=traversalNode.next;
        }
        if(previousNode!=null){
            previousNode.next=currentNode.next;
            currentNode.next=null;
        }else{
            head=currentNode.next;
        }
        return  head;
    }
}
