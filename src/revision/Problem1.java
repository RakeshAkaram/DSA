package revision;
//Linked List: L21 Reverse Nodes in K groups
public class Problem1 {
    public static void main(String[] args) {
        //Test Data
        int arr[] = {1,2,3,4,5,6,7,8};
        Node head = createLL(arr);
        displayLL(head);
        int k=5;
        System.out.println("\nRESULT");
        Node newHead = kGrouping(head,k);
        displayLL(newHead);
    }

    private static Node kGrouping(Node head,int k) {
        Node currHead = head;
        Node finalHead = null;
        while(currHead!=null){
            int p=k;
            Node prevNode = null;
            Node firstHeadNode = null;
            while(p>0 && currHead!=null){
                Node nextNode = currHead.next;
                currHead.next=prevNode;
                prevNode=currHead;
                if(firstHeadNode==null)
                    firstHeadNode=prevNode;
                currHead= nextNode;
                p--;
            }
            if(finalHead==null){
                finalHead = prevNode;
            }
            p=k;
            Node indexNode = currHead;
            Node prevIndexNode = null;
            while(p>1){
                if(indexNode!=null){
                    prevIndexNode = indexNode;
                    indexNode = indexNode.next;
                    p--;
                }else{
                    break;
                }
            }
            //assert firstHeadNode != null;
            if(indexNode!=null) {
                assert firstHeadNode != null;
                firstHeadNode.next = indexNode;
            }
            else {
                firstHeadNode.next = prevIndexNode;
            }
        }
        return finalHead;
    }

    private static Node createLL(int[] arr) {
        Node head = new Node(arr[0],null);
        Node prevNode = head;
        for(int i=1;i<arr.length;i++){
            Node currNode = new Node(arr[i],null);
            prevNode.next = currNode;
            prevNode=currNode;
        }
        return head;
    }

    public static void displayLL(Node node){
        Node head = node;
        while(head!=null) {
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.print("null");
    }
}
class Node{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}