package trees.problems;

import trees.Node;

import java.util.Stack;

public class Diameter {
    static Integer diameterH=0;
    public static void main(String[] args) {
        Node head = Node.diameter();
        Integer diameter = 0;
        diameter = diameterBT(head);
        System.out.println("Diameter: "+diameter);
        diameterH = height(head,diameterH);
        System.out.println("Diameter: "+diameterH);
    }

    private static Integer diameterBT(Node head) {
        Integer diameter = 0;
        if(head==null) return 0;
        diameter = Math.max(diameter,diameterBT(head.getLeft()));
        diameter = Math.max(diameter,diameterBT(head.getRight()));
        diameter = Math.max(diameter,maxHeight(head.getLeft())+maxHeight(head.getRight()));
        return diameter;
    }

    private static Integer maxHeight(Node node){
        if(node==null)
            return 0;
        return 1+Math.max(maxHeight(node.getLeft()),maxHeight(node.getRight()));
    }

    static int height(Node node,Integer diameterH) {
        if (node == null)
            return 0;

        int left = height(node.getLeft(),diameterH);
        int right = height(node.getRight(),diameterH);

        diameterH = Math.max(diameterH, left + right);

        return 1 + Math.max(left, right);
    }
}
