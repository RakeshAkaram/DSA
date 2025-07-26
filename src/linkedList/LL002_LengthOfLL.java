package linkedList; 
 
public class LL002_LengthOfLL { 
    public static void main(String[] args) { 
        System.out.println("LL002_LengthOfLL created.");
        Node head = LL001_ConvertArrayToLL.convertToLL(new int[]{1, 2, 3, 4, 5});
        LL001_ConvertArrayToLL.displayLL(head);

        int length = lenghtOfLL(head);
        System.out.println("\nLength of LL:"+length);
    }

    private static int lenghtOfLL(Node head) {
        Node temp = head;
        int count =0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
} 
