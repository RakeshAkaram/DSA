package trees.traversal;

public class Node {
    private Integer data;
    private Node left;
    private Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + (left!=null?left.getData():-1) +
                ", right=" + (right!=null?right.getData():-1) +
                '}';
    }

    public static Node dataPreparation(Integer[] arr) {
        Node[] nodes = new Node[arr.length+1];
        for(int i = 1; i<= arr.length; i++){
            nodes[i]=new Node(arr[i-1],null,null);
            //System.out.println(nodes[i]);
        }

        int i=1;
        while(2*i<= arr.length){
            int left = 2*i;
            int right = 2*i+1;
            if(nodes[i]!=null){
                nodes[i].setLeft(nodes[left]);
                if(right<= arr.length){
                    nodes[i].setRight(nodes[right]);
                }
            }
            //System.out.println(nodes[i]);
            i++;
        }
        return nodes[1];
    }
}
