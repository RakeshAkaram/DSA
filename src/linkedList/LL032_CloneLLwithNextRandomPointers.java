package linkedList;

import java.util.HashMap;

public class LL032_CloneLLwithNextRandomPointers {
    public static void main(String[] args) {
        NodeNRP head = prepareNodeNRPData();
        NodeNRP tempHead = head;
        NodeNRP.displayNodeNRP(tempHead);
        System.out.println("*****************solution1******************************");
        //Solution1: Using HashMap
        NodeNRP solution1 = usingHashMap(tempHead);
        NodeNRP.displayNodeNRP(solution1);
        System.out.println("*****************solution2******************************");
        //Solution 2: In Place of LL making the temp nodes stay in between
        tempHead = head;
        NodeNRP solution2 =inPlaceLL(head);
        NodeNRP.displayNodeNRP(solution2);
    }

    private static NodeNRP inPlaceLL(NodeNRP head) {
        NodeNRP temp=head;
        while (temp!=null){
            NodeNRP nextNode = temp.next;
            temp.next=new NodeNRP(temp.data,null,nextNode);
            temp=nextNode;
        }
        temp=head;
        NodeNRP resultHead=head.next;
        NodeNRP tempHead=head.next;
        while (temp!=null){
            if(temp.random!=null)
                temp.next.random=temp.random.next;
            temp=temp.next.next;

            //reassign the next with new formed nodes.
            if(tempHead.next!=null){
                tempHead.next=tempHead.next.next;
                tempHead=tempHead.next;
            }
        }
        return resultHead;
    }

    private static NodeNRP usingHashMap(NodeNRP head) {
        NodeNRP result=new NodeNRP(-1);
        NodeNRP tempResult=result;
        NodeNRP temp=head;
        HashMap<NodeNRP,NodeNRP> map=new HashMap<>();
        //step 1: Create new nodes and insert tin HashMap with old node as key and new node as value
        while (temp!=null){
            tempResult.next = new NodeNRP(temp.data);
            tempResult=tempResult.next;
            map.put(temp,tempResult);
            temp=temp.next;
        }
        //step 2: Lets assign Random pointers
        temp=head;
        tempResult=result.next;
        while (temp!=null){
            if(temp.random !=null){
                tempResult.random = map.get(temp.random);
            }
            temp=temp.next;
            tempResult=tempResult.next;
        }
        return result.next;
    }

    private static NodeNRP prepareNodeNRPData() {
        NodeNRP node1 = new NodeNRP(7);
        NodeNRP node2 = new NodeNRP(10);
        NodeNRP node3 = new NodeNRP(21);
        NodeNRP node4 = new NodeNRP(17);
        NodeNRP node5 = new NodeNRP(11);

        node1.next=node2;
        node1.random=null;

        node2.next=node3;
        node2.random=node1;

        node3.next=node4;
        node3.random=node5;

        node4.next=node5;
        node4.random=node3;

        node5.next=null;
        node5.random=node1;

        return node1;
    }
}
class NodeNRP{ //NRP - Next & Random Pointer
    int data;
    NodeNRP next;
    NodeNRP random;

    public NodeNRP(int data, NodeNRP random, NodeNRP next) {
        this.data = data;
        this.random = random;
        this.next = next;
    }

    public NodeNRP(int data) {
        this.data = data;
    }

    public static void displayNodeNRP(NodeNRP head){
        NodeNRP temp=head;
        while (temp!=null){
            System.out.println("Data:"+temp.data+"\n\tNext: "+
                    (temp.next!=null?temp.next.data:-999)+"\n\tRandom: "+(temp.random!=null?temp.random.data:-999));
            temp=temp.next;
        }
    }
}
