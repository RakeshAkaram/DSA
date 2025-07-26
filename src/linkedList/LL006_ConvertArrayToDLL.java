package linkedList; 
 
public class LL006_ConvertArrayToDLL { 
    public static void main(String[] args) { 
        System.out.println("LL006_ConvertArrayToDLL created.");
        int[] nums={1,2,3,4,5};
        NodeDLL  head = convertArrayToDLL(nums);
        displayDLL(head);
    }

    private static void displayDLL(NodeDLL head) {
        NodeDLL temp=head;
        while (temp.rightNode!=null){
            System.out.print(temp.data+"->");
            temp=temp.rightNode;
        }
        System.out.print(temp.data+"->null");
        System.out.println();
        while (temp.leftNode!=null){
            System.out.print(temp.data+"<-");
            temp=temp.leftNode;
        }
        System.out.print(temp.data+"->null");
    }

    private static NodeDLL convertArrayToDLL(int[] nums) {
        boolean firstNode=true;
        NodeDLL head = null,tempHead=null;
        for(int num:nums){
            if(firstNode){
                firstNode=false;
                head=new NodeDLL(num);
                tempHead=head;
            }
            else{
                NodeDLL newNode=new NodeDLL(num,tempHead,null);
                tempHead.rightNode=newNode;
                tempHead=tempHead.rightNode;//newNode
            }
        }
        return head;
    }
} 
