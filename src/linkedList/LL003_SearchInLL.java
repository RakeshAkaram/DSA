package linkedList;

public class LL003_SearchInLL {
    public static void main(String[] args) { 
        System.out.println("LL003_SearchInLL created.");
        Node head = LL001_ConvertArrayToLL.convertToLL(new int[]{1, 2, 3, 4, 5});
        LL001_ConvertArrayToLL.displayLL(head);
        int searchElement =7;

        boolean isPresent = searchInLL(head,searchElement);
        System.out.println("\nSearch in LL:"+isPresent);
    }

    private static boolean searchInLL(Node head, int searchElement) {
        Node temp=head;
        while(temp!=null){
            if(temp.data==searchElement){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
} 
