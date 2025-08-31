package linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LL030_MergeKSortedLL {
    public static void main(String[] args) {
        List<Node> nodeList = prepareDataLL();

        /*Node solution1 = mergeKSortLL(nodeList);
        System.out.println("Solution 1:");
        LL001_ConvertArrayToLL.displayLL(solution1);*/

        System.out.println("\nSolution 2:");
        Node solution2 = priorityQueue(nodeList);
        LL001_ConvertArrayToLL.displayLL(solution2);
    }

    private static Node priorityQueue(List<Node> nodeList) {
        PriorityQueue<Node> pq=new PriorityQueue<>((o1, o2) -> o1.data-o2.data);
        Node resultHead=new Node(-1);
        Node temp=resultHead;
        for(Node node:nodeList){
            pq.add(node);
        }
        while(!pq.isEmpty()){
            Node leastNode = pq.peek();
            temp.next=leastNode;
            temp=temp.next;
            pq.remove();
            if(leastNode.next!=null)
                pq.add(leastNode.next);
        }
        return resultHead.next;
    }
    //Solution 1: High time complexity
    private static Node mergeKSortLL(List<Node> nodeList) {
        Node resultHead=null;
        if(!nodeList.isEmpty() && nodeList.size()>1){
            resultHead = mergeLLs(nodeList.get(0),nodeList.get(1));
        }
        for(int i=2;i<nodeList.size();i++){
            resultHead =  mergeLLs(nodeList.get(i),resultHead);
        }
        return resultHead;
    }

    //Solution 2: Using PriorityQueue


    private static List<Node> prepareDataLL() {
        List<Node> nodeList = new ArrayList<>();
        Node head1 = LL001_ConvertArrayToLL.convertToLL(new int[]{4,8,10});
        Node head2 = LL001_ConvertArrayToLL.convertToLL(new int[]{3,6});
        Node head3 = LL001_ConvertArrayToLL.convertToLL(new int[]{2,5,7});
        Node head4 =  LL001_ConvertArrayToLL.convertToLL(new int[]{1,9,11});
        nodeList=List.of(head1,head2,head3,head4);
        return nodeList;
    }
    private static Node mergeLLs(Node head, Node nextHead) {
        Node resultHead = new Node(-1);
        Node tempHead = resultHead;
        Node headTemp1 = head;
        Node headTemp2 = nextHead;
        while (headTemp1!=null && headTemp2!=null){
            if(headTemp1.data<headTemp2.data){
                resultHead.next=headTemp1;
                headTemp1=headTemp1.next;
            }else{
                resultHead.next=headTemp2;
                headTemp2=headTemp2.next;
            }
            resultHead=resultHead.next;
        }
        while(headTemp1!=null){
            resultHead.next=headTemp1;
            headTemp1=headTemp1.next;
            resultHead=resultHead.next;
        }
        while(headTemp2!=null){
            resultHead.next=headTemp2;
            headTemp2=headTemp2.next;
            resultHead=resultHead.next;
        }
        return tempHead.next;
    }
}


