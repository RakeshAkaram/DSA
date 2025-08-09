package linkedList;

import java.util.Scanner;

public class LL004_DeleteInLL {
    public static void main(String[] args) { 
        System.out.println("LL004_DeleteInLL created.");
        boolean exitFlag= false;
        Scanner scanner =new Scanner(System.in);

        Node head = LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5});

        while(true){
            System.out.println("****************DELETE AT***********************");
            System.out.println("1. HEAD\n2. LAST\n3. POSITION\n4. VALUE\n5. EXIT");
            System.out.println("************************************************");
            System.out.println("Choose an option");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    head = deleteAtHead(head);
                    break;
                case 2:
                    head = deleteAtLast(head);
                    break;
                case 3:
                    System.out.println("Enter the position");
                    int position = scanner.nextInt();
                    head =  deleteAtPosition(head,position);
                    break;
                case 4:
                    System.out.println("Enter the value");
                    int value =  scanner.nextInt();
                    head = deleteAtValue(head,value);
                    break;
                case 5:
                    exitFlag=true;
                    break;
                default:
                    System.out.println("Invalid option. Choose the valid option");
            }
            if(exitFlag) break;
            LL001_ConvertArrayToLL.displayLL(head);
            System.out.println();
        }
    }

    private static Node deleteAtHead(Node head) {
        Node traversalHead = head;
        if(traversalHead!=null)
            head=traversalHead.next;
        else System.out.println("Linked List is empty");
        return head;
    }

    private static Node deleteAtLast(Node head) {
        Node traversalNode = head;
        Node prevNode = null;
        if(traversalNode!=null){
            while(traversalNode.next!=null){
                prevNode = traversalNode;
                traversalNode=traversalNode.next;
            }
            if(traversalNode.equals(head)) return null;
            else prevNode.next=null;
        }
        else System.out.println("Linked List is empty to delete at Last");
        return head;
    }

    private static Node deleteAtPosition(Node head, int position) {
        Node traversalNode = head;
        Node previousNode = null;
        int length = 0;

        while (position>1){
            position--;
            if(traversalNode!=null){
                previousNode=traversalNode;
                traversalNode=traversalNode.next;
                length++;
            }
            else {
                System.out.println("Position is exceeding the length "+ length +" of the Linked List");
                return head;
            }
        }
        if(previousNode!=null && traversalNode!=null){
            previousNode.next = traversalNode.next;
        }
        else if(previousNode==null && traversalNode!=null){
            head =  traversalNode.next;
        }
        else{
            System.out.println("End of the list. Nothing to delete");
        }
        return head;
    }

    private static Node deleteAtValue(Node head, int value) {
        Node traversalNode = head;
        Node previousNode = null;
        while (traversalNode!=null){
            if(traversalNode.data==value){
                if(previousNode==null) {
                    head = traversalNode.next;
                }
                else {
                    previousNode.next = traversalNode.next;
                }
                return head;
            }
            else {
                previousNode = traversalNode;
                traversalNode= traversalNode.next;
            }
        }
        System.out.println("Value is not found in the linked List");
        return head;
    }
} 
