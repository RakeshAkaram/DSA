package linkedList;

import java.util.Scanner;

public class LL005_InsertInLL {
    public static void main(String[] args) { 
        System.out.println("LL005_InsertInLL created.");
        Node head = LL001_ConvertArrayToLL.convertToLL(new int[]{1, 2, 3, 4});
        LL001_ConvertArrayToLL.displayLL(head);

        Scanner scanner = new Scanner(System.in);
        boolean existFlag= false;
        while(!existFlag){
            System.out.println("\n***********Insertion At************");
            System.out.println("1. HEAD\n2. LAST\n3. POSITION\n4. VALUE\n5. EXIT");
            System.out.println("**********************************");
            System.out.println("Choose the option: ");
            int option = scanner.nextInt();
            int value = 0;
            if(option<5 && option>0){
                System.out.println("Enter the value to insert");
                value = scanner.nextInt();
            }
            if(head==null){
                head = new Node(value);
            }else{
                switch (option){
                    case 1:
                        head = insertAtHead(head,value);
                        break;
                    case 2:
                        head = insertAtLast(head,value);
                        break;
                    case 3:
                        System.out.println("Enter the position");
                        int position=scanner.nextInt();
                        head = insertAtPosition(head,position,value);
                        break;
                    case 4:
                        System.out.println("Enter the search value");
                        int searchValue=scanner.nextInt();
                        head = insertAtValue(head,value,searchValue);
                        break;
                    case 5: existFlag=true; break;
                    default:
                        System.out.println("Enter a valid option");
                }
            }
            LL001_ConvertArrayToLL.displayLL(head);
        }
    }

    //insert at the head
    private static Node insertAtHead(Node head, int value) {
        Node traversalHead = head;
        Node node = new Node(value);
        if(traversalHead!=null){
            head=node;
            node.next=traversalHead;
        }
        return head;
    }
    //insert at the last
    private static Node insertAtLast(Node head, int value) {
        Node traversalHead = head;
        while (traversalHead.next!=null){
            traversalHead=traversalHead.next;
        }
        Node node = new Node(value);
        traversalHead.next=node;
        return head;
    }
    //insert in a position
    private static Node insertAtPosition(Node head, int position, int value) {
        Node traversalHead=head;
        int lengthLL=0;
        while(position>1){
            if(traversalHead!=null){
                traversalHead=traversalHead.next;
                position--;
                lengthLL++;
            }else{
                System.out.println("Position provided is greater than the length "+lengthLL+" of the LL");
                return head;
            }
        }
        Node nextNode=traversalHead.next;
        Node newNode = new Node(value);
        traversalHead.next=newNode;
        newNode.next=nextNode;
        return head;
    }
    //insert at a value
    private static Node insertAtValue(Node head, int value, int searchValue) {
        Node traversalNode=head;
        while(traversalNode!=null){
            if(traversalNode.data==searchValue){
                Node newNode =  new Node(value,traversalNode.next);
                traversalNode.next =newNode;
                return head;
            }
            traversalNode=traversalNode.next;
        }
        System.out.println("Search value not found");
        return head;
    }
} 
