package linkedList;

public class LL028_MergeTwoSortedLists {
    public static void main(String[] args) {
        Node headOne= LL001_ConvertArrayToLL.convertToLL(new int[]{2,4,6,7});
        System.out.println("First List: ");
        LL001_ConvertArrayToLL.displayLL(headOne);

        Node headTwo=LL001_ConvertArrayToLL.convertToLL(new int[]{1,3,5,8,9});
        System.out.println("\nSecond List: ");
        LL001_ConvertArrayToLL.displayLL(headTwo);

        Node resultHead=mergeTwoSortedLists(headOne,headTwo);
        System.out.println("\nFinal List: ");
        LL001_ConvertArrayToLL.displayLL(resultHead);

    }

    private static Node mergeTwoSortedLists(Node oneHead, Node twoHead) {
        Node headOne = oneHead,headTwo = twoHead;
        Node resultHead=new Node(-1);
        Node traversalHead=resultHead;
        while (headOne!=null && headTwo!=null){
            if(headOne.data<headTwo.data){
                traversalHead.next=headOne;
                headOne=headOne.next;
            }
            else{
                traversalHead.next=headTwo;
                headTwo=headTwo.next;
            }
            traversalHead = traversalHead.next;
        }
        while (headOne!=null){
            traversalHead.next=headOne;
            headOne=headOne.next;
            traversalHead = traversalHead.next;
        }
        while (headTwo!=null){
            traversalHead.next=headTwo;
            headTwo=headTwo.next;
            traversalHead = traversalHead.next;
        }
        return resultHead.next;
    }
}
