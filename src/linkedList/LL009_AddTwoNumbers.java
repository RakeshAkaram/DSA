package linkedList;

public class LL009_AddTwoNumbers {
    public static void main(String[] args) {
       Node numberOneHead = LL001_ConvertArrayToLL.convertToLL(new int[]{9,9,1});
       Node numberTwoHead = LL001_ConvertArrayToLL.convertToLL(new int[]{9,9,9,9});

       Node resultHead = addNumbers(numberOneHead,numberTwoHead);
       LL001_ConvertArrayToLL.displayLL(resultHead);
    }

    private static Node addNumbers(Node numberOneHead, Node numberTwoHead) {
        int carry=0;
        Node resultNode=null;
        Node traversalNode=null;
        while (numberOneHead!=null || numberTwoHead!=null){
            int oneValue =  numberOneHead!=null?numberOneHead.data:0;
            int twoValue = numberTwoHead!=null?numberTwoHead.data:0;
            if(resultNode==null){
                int addedValue = oneValue+twoValue;
                if(addedValue>=10){
                    carry = 1;
                    addedValue=addedValue-10;
                }
                else carry=0;
                resultNode = new Node(addedValue);
                traversalNode=resultNode;
            }else{
                int addedValue = oneValue+twoValue+carry;
                if(addedValue>=10){
                    carry = 1;
                    addedValue=addedValue-10;
                }else carry=0;
                traversalNode.next=new Node(addedValue);
                traversalNode=traversalNode.next;
            }
            numberOneHead=numberOneHead!=null?numberOneHead.next:null;
            numberTwoHead=numberTwoHead!=null?numberTwoHead.next:null;
        }
        if(carry==1)
            traversalNode.next = new Node(1);
        return resultNode;
    }
}
