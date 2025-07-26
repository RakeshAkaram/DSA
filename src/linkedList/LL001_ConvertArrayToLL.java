package linkedList;

public class LL001_ConvertArrayToLL {
    public static void main(String[] args) {
        int nums[]={1,2,34,5,23};
      Node head = convertToLL(nums);
      displayLL(head);
    }

    public static void displayLL(Node head) {
        Node temp =  head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public static Node convertToLL(int[] nums) {
        boolean firstNode= true;
        Node head=null,temp=null;
        for(int num:nums){
            Node newNode = new Node(num);
            if(firstNode){
                firstNode = false;
                head=newNode;
            }else{
                temp.next=newNode;
            }
            temp=newNode;
        }
        return head;
    }

}
