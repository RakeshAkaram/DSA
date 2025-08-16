package linkedList;

import java.util.HashMap;

public class LL017_IntersectionInY {
    public static void main(String[] args) {
        Node headOne = LL001_ConvertArrayToLL.convertToLL(new int[]{1,2,3,4,5,6});
        Node headTwo = LL001_ConvertArrayToLL.convertToLL(new int[]{7,8});
        Node tempHeadTwo=headTwo, tempHeadOne=headOne;
        //Comment below line to remove intersection
        tempHeadTwo.next.next=tempHeadOne.next.next.next;

        System.out.println("LL1:");
        LL001_ConvertArrayToLL.displayLL(headOne);
        System.out.println("\nLL2:");
        LL001_ConvertArrayToLL.displayLL(headTwo);

        System.out.println("\n1. Hashing Solution");
        Node intersectNode = usingHash(headOne,headTwo);
        displayIntersectionNode(intersectNode);

        System.out.println("\n2. Using Length solution");
        intersectNode=usingLength(headOne,headTwo);
        displayIntersectionNode(intersectNode);


        System.out.println("\n3. Reverse assigning the headers on reaching the end of the list");
        intersectNode=intersectionNode(headOne,headTwo);
        displayIntersectionNode(intersectNode);
    }

    private static void displayIntersectionNode(Node intersectNode) {
        if(intersectNode ==null) System.out.println("\nNo Intersection Node");
        else System.out.println("Intersection Node at: "+ intersectNode.data);
    }

    //1. Hashing solution
    private static Node usingHash(Node headOne, Node headTwo) {
        Node intersectNode = null;
        Node traversalOne=headOne, traversalTwo=headTwo;
        HashMap<Node,Integer> nodesCount =  new HashMap<>();
        while (traversalOne!=null){
            nodesCount.put(traversalOne,1);
            traversalOne=traversalOne.next;
        }
        while (traversalTwo!=null){
            if(nodesCount.get(traversalTwo)!=null && nodesCount.get(traversalTwo)==1){
                return traversalTwo;
            }
            traversalTwo=traversalTwo.next;
        }
        return intersectNode;
    }

    //2. Using Length solution
    private static Node usingLength(Node headOne, Node headTwo) {
        Node intersectNode = null;
        Node traversalOne=headOne, traversalTwo=headTwo;
        int lengthOne=findLength(traversalOne);
        int lengthTwo=findLength(traversalTwo);
        int noOfNodesFar=Math.abs(lengthTwo-lengthOne);
        if(lengthTwo>lengthOne) intersectNode = solution(headTwo,headOne,noOfNodesFar);
        else intersectNode = solution(headOne,headTwo,noOfNodesFar);
        return intersectNode;
    }

    private static int findLength(Node traversalOne) {
        int length=0;
        while(traversalOne!=null){
            length++;
            traversalOne=traversalOne.next;
        }
        return length;
    }

    private static Node solution(Node headTwo, Node headOne, int noOfNodesFar) {
        Node traversalOne=headOne, traversalTwo=headTwo;
        while(noOfNodesFar-->0){
            traversalTwo=traversalTwo.next;
        }
        while (traversalTwo!=null){
            if(traversalOne==traversalTwo) return traversalOne;
            traversalOne=traversalOne.next;
            traversalTwo=traversalTwo.next;
        }
        return null;
    }

    //3. Reverse assigning the headers on reaching the end of the list
    private static Node intersectionNode(Node headOne, Node headTwo) {
        Node intersectNode =null;
        Node traversalOne=headOne,traversalTwo=headTwo;
        while(traversalOne!=null || traversalTwo!=null){
            if(traversalOne==traversalTwo){
                intersectNode=traversalOne;
                break;
            }
            else if(traversalOne==null) {
                traversalOne = headTwo;
            }
            else if (traversalTwo==null) {
                traversalTwo=headOne;
            }
            traversalOne=traversalOne.next;
            traversalTwo=traversalTwo.next;
        }
        return intersectNode;
    }
}
