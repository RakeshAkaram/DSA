package linkedList;

import java.util.Scanner;

public class LL008_InsertInDLL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;
        NodeDLL head = null;
        while (!exitFlag){
            System.out.println("\n***********Insertion At************");
            System.out.println("1. HEAD\n2. LAST\n3. POSITION\n4. VALUE\n5. EXIT");
            System.out.println("**********************************");
            System.out.println("Choose the option: ");
            int option = scanner.nextInt();
            System.out.println("Provide the value");
            int value= scanner.nextInt();
            if(head==null){
                head = new NodeDLL(value);
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
                        int position = scanner.nextInt();
                        head = insertAtPosition(head,value,position);
                        break;
                    case 4:
                        System.out.println("Enter the search value");
                        int searchValue=scanner.nextInt();
                        head = insertAtValue(head,value,searchValue);
                        break;
                    case 5:
                        exitFlag= true;
                        break;
                    default:
                        System.out.println("Entered the wrong option");


                }
            }
            LL006_ConvertArrayToDLL.displayDLL(head);
            System.out.println();
        }
    }

    private static NodeDLL insertAtHead(NodeDLL head, int value) {
        NodeDLL traversalNode = head;
        if(traversalNode!=null){
            head = new NodeDLL(value,null,traversalNode);
            traversalNode.leftNode = head;
        }
        return head;
    }

    private static NodeDLL insertAtLast(NodeDLL head, int value) {
        NodeDLL traversalNode = head;
        while(traversalNode.rightNode !=null){
            traversalNode=traversalNode.rightNode;
        }
        traversalNode.rightNode = new NodeDLL(value,traversalNode,null);
        return head;
    }

    private static NodeDLL insertAtPosition(NodeDLL head, int value, int position) {
        NodeDLL traversalNode = head;
        int length=0;
        while(--position>0){
            length++;
            if(traversalNode!=null){
                traversalNode=traversalNode.rightNode;
            }else {
                System.out.println("Postiion is greater than the length "+length+" of the DLL");
                return head;
            }
        }
        if(traversalNode!=null){
            NodeDLL newNode= new NodeDLL(value,traversalNode,traversalNode.rightNode);
            NodeDLL nextNode = traversalNode.rightNode;
            traversalNode.rightNode = newNode;
            if(nextNode!=null)
                nextNode.leftNode = newNode;
        }else System.out.println("End of the List");
        return head;
    }

    private static NodeDLL insertAtValue(NodeDLL head, int value, int searchValue) {
        NodeDLL traversalNode = head;
        while (traversalNode!=null){
            if(traversalNode.data==searchValue){
                NodeDLL newNode= new NodeDLL(value,traversalNode,traversalNode.rightNode);
                NodeDLL nextDll= traversalNode.rightNode;
                traversalNode.rightNode=newNode;
                if(nextDll!=null)
                    nextDll.leftNode=newNode;
                return head;
            }
            else{
                traversalNode=traversalNode.rightNode;
            }
        }
        System.out.println("Search Value not found");
        return head;
    }
}
