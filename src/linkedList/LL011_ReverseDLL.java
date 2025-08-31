package linkedList;

public class LL011_ReverseDLL {
    public static void main(String[] args) {
        NodeDLL head=LL006_ConvertArrayToDLL.convertArrayToDLL(new int[]{1,2,3,4,5});
        LL006_ConvertArrayToDLL.displayDLL(head);
        System.out.println("\n After Reverse");
        head=reverseDLL(head);
        LL006_ConvertArrayToDLL.displayDLL(head);
    }

    private static NodeDLL reverseDLL(NodeDLL head) {
        NodeDLL tempHead=head;
        while (tempHead.rightNode!=null){ //Time Complexity = O(n), no extra space
            NodeDLL temp = tempHead.leftNode;
            tempHead.leftNode=tempHead.rightNode;
            tempHead.rightNode=temp;
            tempHead=tempHead.leftNode;
        }
        NodeDLL temp = tempHead.leftNode;
        tempHead.leftNode=tempHead.rightNode;
        tempHead.rightNode=temp;
        return tempHead;
    }

}
