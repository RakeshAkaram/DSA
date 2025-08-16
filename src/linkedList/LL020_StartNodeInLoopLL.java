package linkedList;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

public class LL020_StartNodeInLoopLL {
    public static void main(String[] args) {
        Node head =  LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5,6,7,8,9});
        Node temp = head,temp1=head;
        while(temp.next!=null) temp=temp.next;
        temp.next=temp1.next.next.next;

        System.out.println("1. Using Hashing");
        Node startNode =  startNodeInUsingHash(head);
        String msg =startNode!=null? "Node: "+startNode.data: "No Loop";
        System.out.println(msg);

        System.out.println("\n2. Using Slow and Fast Pointer");
        startNode =  StartNodeInLoop(head);
        msg =startNode!=null? "Node: "+startNode.data: "No Loop";
        System.out.println(msg);
    }
    //2. Using Slow and Fast Pointer
    private static Node StartNodeInLoop(Node head) {
        Node slowNode=head,fastNode=head;
        while (fastNode.next!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next.next;
            if(slowNode==fastNode) {
                fastNode=head;
                while (fastNode.next!=null){
                    if(slowNode==fastNode) return slowNode;
                    slowNode=slowNode.next;
                    fastNode=fastNode.next;
                }
            }
        }
        return null;
    }

    //1. Using Hashing
    private static Node startNodeInUsingHash(Node head) {
        Node traversalNode=head;
        HashMap<Node,Integer> nodeMap = new HashMap<>();
        while (traversalNode.next!=null){
            if(nodeMap.get(traversalNode)!=null && nodeMap.get(traversalNode)==1) return traversalNode;
            nodeMap.put(traversalNode,1);
            traversalNode=traversalNode.next;
        }
        return null;
    }
}
