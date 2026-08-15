package trees;

public class Node {
    private Integer data;
    private Node left;
    private Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
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

    public static Node balanceTree(){
        Node node = new Node(1);

        node.setLeft(new Node(2));
        node.setRight(new Node(3));

        node.getLeft().setLeft(new Node(4));
        node.getLeft().setRight(new Node(5));

        node.getRight().setLeft(new Node(6));
        node.getRight().setRight(new Node(7));

        node.getLeft().getLeft().setLeft(new Node(8));
        node.getLeft().getLeft().setRight(new Node(9));

        node.getLeft().getRight().setLeft(new Node(10));
        node.getLeft().getRight().setRight(new Node(11));
        return  node;
    }

    public static Node unbalanced() {
        Node node = new Node(1);

        node.setLeft(new Node(2));
        node.setRight(new Node(3));

        node.getLeft().setLeft(new Node(4));
        node.getLeft().setRight(new Node(5));

        node.getLeft().getLeft().setLeft(new Node(6));

        node.getLeft().getLeft().getLeft().setLeft(new Node(7));

        node.getLeft().getLeft().getLeft().getLeft().setRight(new Node(8));
        return node;
    }

    public static Node diameter(){
        Node node = new Node(1);
        node.setLeft(new Node(2));
        node.setRight(new Node(3));

        node.getRight().setLeft(new Node(4));
        node.getRight().setRight(new Node(5));

        node.getRight().getLeft().setRight(new Node(6));

        node.getRight().getLeft().getRight().setLeft(new Node(7));

        node.getRight().getRight().setRight(new Node(8));
        node.getRight().getRight().getRight().setLeft(new Node(9));
        return node;
    }
}
