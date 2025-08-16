package linkedList;

public class LL015_PalindromeLL {
    public static void main(String[] args) {
        Node head=LL001_ConvertArrayToLL.convertToLL(new int[]{1});//1,2,3,2,1
        if(head.next==null || checkPalindromeOrNot(head)) System.out.println("Is a Palindrome");
        else System.out.println("Not a Palindrome");

    }
    private static boolean checkPalindromeOrNot(Node head) {
        Node traversalNode=head;
        //Find the middle Node
        Node slowNode=head;
        Node fastNode= head;
        while(fastNode!=null){
            slowNode = slowNode.next;
            if(fastNode.next!=null)
                fastNode = fastNode.next.next;
            else
                break;
        }
        System.out.println(slowNode.data);
        //Reverse the list from middle node to endNode
        Node previousNode = null;
        Node nextNode=null;
        while(slowNode!=null){
            nextNode=slowNode.next;
            slowNode.next=previousNode;
            previousNode=slowNode;
            slowNode=nextNode;
        }
        //then start comparing from the head of the LL with the middle head
        while(previousNode!=null){
            assert traversalNode != null;
            if(previousNode.data==traversalNode.data){
                previousNode=previousNode.next;
                traversalNode=traversalNode.next;
            }else{
                return false;
            }
        }
        return  true;
    }
}
