package linkedList;

import java.util.HashMap;

public class LL019_LengthOfLoopLL {
    public static void main(String[] args) {
        Node head =  LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5,6,7,8,9});
        Node temp = head,temp1=head;
        while(temp.next!=null) temp=temp.next;
        temp.next=temp1.next.next.next;

        System.out.println("1. Using Hashing");
        int isLoopDetected =  lenghtOfLoopUsingHash(head);
        System.out.println("Length: "+isLoopDetected);

        System.out.println("\n2. Using Slow and Fast Pointer");
        isLoopDetected =  lenghtOfLoop(head);
        System.out.println("Length: "+isLoopDetected);

    }
    //1. Using Hashing
    private static int lenghtOfLoopUsingHash(Node head) {
        Node traversalNode=head;
        int count=0;
        HashMap<Node,Integer> nodeMap=new HashMap<>();
        while (traversalNode.next!=null){
            count++;
            if(nodeMap.get(traversalNode)!=null) return count-nodeMap.get(traversalNode);
            nodeMap.put(traversalNode,count);
            traversalNode=traversalNode.next;
        }
        return 0;
    }

    //2. Using Slow and Fast Pointer
    private static int lenghtOfLoop(Node head) {
        Node slowNode=head,fastNode=head;
        while(fastNode.next!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next.next;
            if(slowNode==fastNode){
                int count=0;
                while (fastNode!=null){
                    count++;
                    fastNode=fastNode.next;
                    if(fastNode==slowNode) return count;
                }
                return count;
            }
        }
        return 0;
    }
}
