package linkedList;

import java.util.Scanner;

public class LL007_DeleteInDLL {
    public static void main(String[] args) {
        NodeDLL head = LL006_ConvertArrayToDLL.convertArrayToDLL(new int[]{1,2,3,4,5});

        Scanner scanner = new Scanner(System.in);
        boolean exitFlag= false;

        while(!exitFlag){
            System.out.println("\n***********Delete At************");
            System.out.println("1. HEAD\n2. LAST\n3. POSITION\n4. VALUE\n5. EXIT");
            System.out.println("**********************************");
            System.out.println("Choose the option: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    head = deleteAtHead(head);
                    break;
                case 2:
                    head= deleteAtLast(head);
                    break;
                case 3:
                    System.out.println("Enter the position");
                    int position = scanner.nextInt();
                    head =  deleteAtPostion(head,position);
                    break;
                case 4:
                    System.out.println("Enter the value");
                    int value= scanner.nextInt();
                    head=deleteAtValue(head,value);
                    break;
                case 5:
                    exitFlag=true;
                    break;
                default:
                    System.out.println("Wrong Option Choosen");
            }
            LL006_ConvertArrayToDLL.displayDLL(head);
        }
    }

    private static NodeDLL deleteAtHead(NodeDLL head) {
        NodeDLL traversalNode=head;
        if(traversalNode!=null){
            head = traversalNode.rightNode;
            head.leftNode=null;
        }
        return head;
    }

    private static NodeDLL deleteAtLast(NodeDLL head) {
        NodeDLL traversalNode=head;
        NodeDLL previousNode=null;
        if(traversalNode!=null){
            while(traversalNode.rightNode!=null){
                previousNode=traversalNode;
                traversalNode=traversalNode.rightNode;
            }
            if(previousNode!=null)
                previousNode.rightNode=null;
            else return null;
            traversalNode.leftNode=null;
        }
        else System.out.println("DLL is empty");
        return head;
    }

    private static NodeDLL deleteAtPostion(NodeDLL head, int position) {
        NodeDLL traversalNode = head;
        NodeDLL previousNode = null;
        int length=0;
        while(--position>0){
            if(traversalNode!=null){
                length++;
                previousNode= traversalNode;
                traversalNode=traversalNode.rightNode;
            }
            else {
                System.out.println("Postion is greater than the length "+length+" of the DLL");
                return head;
            }
        }
        if(previousNode!=null && traversalNode!=null){
                previousNode.rightNode=traversalNode.rightNode;
                traversalNode=traversalNode.rightNode;
                if(traversalNode!=null)
                    traversalNode.leftNode=previousNode;

        }
        else if(previousNode==null && traversalNode!=null){
            head=traversalNode.rightNode;
        }
        else System.out.println("Nothing to delete. End of DLL");
        return head;
    }

    private static NodeDLL deleteAtValue(NodeDLL head, int value) {
        NodeDLL traversalNode= head;
        NodeDLL previousNode=null;
        while(traversalNode!=null){
            if(traversalNode.data==value){
                if(previousNode!=null){
                    previousNode.rightNode=traversalNode.rightNode;
                    if(traversalNode.rightNode!=null){
                        traversalNode=traversalNode.rightNode;
                        traversalNode.leftNode=previousNode;
                    }
                }
                else {
                    head=traversalNode.rightNode;
                    if(traversalNode.rightNode!=null){
                        traversalNode=traversalNode.rightNode;
                        traversalNode.leftNode=previousNode;
                    }
                }
                return head;
            }
            else{
                previousNode=traversalNode;
                traversalNode=traversalNode.rightNode;
            }
        }
        System.out.println("Search Value not found");
        return head;
    }

}
