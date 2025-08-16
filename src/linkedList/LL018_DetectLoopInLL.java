package linkedList;

import java.util.HashMap;

public class LL018_DetectLoopInLL {
    public static void main(String[] args) {
        Node head =  LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5,6,7,8,9});
        Node temp = head,temp1=head;
        while(temp.next!=null) temp=temp.next;
        temp.next=temp1.next.next.next;

        System.out.println("1. Using Hashing");
        boolean isLoopDetected =  detectLoopUsingHash(head);
        displayLoop(isLoopDetected);

        System.out.println("\n2. Using Slow and Fast Pointer");
        isLoopDetected =  detectLoop(head);
        displayLoop(isLoopDetected);

        //LL001_ConvertArrayToLL.displayLL(head);
    }

    private static void displayLoop(boolean isLoopDetected) {
        if(isLoopDetected) System.out.println("Detected Loop");
        else System.out.println("No Loop");
    }

    //1. Hashing solution
    private static boolean detectLoopUsingHash(Node head) {
        Node traversalNode=head;
        HashMap<Node,Integer> nodeMap = new HashMap<>();
        while (traversalNode.next!=null){
            if(nodeMap.get(traversalNode)!=null && nodeMap.get(traversalNode)==1) return true;
            nodeMap.put(traversalNode,1);
            traversalNode=traversalNode.next;
        }
        return false;
    }

    //2. Using "slow and fast Node" or "Hare and Rabbit" solution
    private static boolean detectLoop(Node head) {
        Node slowNode=head,fastNode=head;
        while (fastNode.next!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next.next;
            if(slowNode==fastNode) return true;
        }
        return false;
    }
}
