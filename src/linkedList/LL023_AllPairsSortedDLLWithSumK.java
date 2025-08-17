package linkedList;

public class LL023_AllPairsSortedDLLWithSumK {
    public static void main(String[] args) {
        NodeDLL head=LL006_ConvertArrayToDLL.convertArrayToDLL(new int[]{1,2,3,4,5,6,7,8});
        LL006_ConvertArrayToDLL.displayDLL(head);
        System.out.println();
        int sumK=6;
        allPairsSortedDLLWithSumK(head,sumK);
    }

    private static void allPairsSortedDLLWithSumK(NodeDLL head, int sumK) {
        NodeDLL leftIndexNode=head,rightIndexNode=head;
        while(rightIndexNode.rightNode!=null) rightIndexNode=rightIndexNode.rightNode;
        int pairCount=0;
        while(rightIndexNode!=leftIndexNode){
            int sum=leftIndexNode.data+rightIndexNode.data;
            if(sum==sumK){
                System.out.println("Pair: "+(++pairCount)+"\n\tNode1: "+leftIndexNode.data+"\n\tNode2: "+rightIndexNode.data);
                rightIndexNode=rightIndexNode.leftNode;
                leftIndexNode=leftIndexNode.rightNode;
            }
            else if (sum>sumK) {
                rightIndexNode=rightIndexNode.leftNode;
            } else if (sum<sumK) {
                leftIndexNode=leftIndexNode.rightNode;
            }
        }
    }
}
