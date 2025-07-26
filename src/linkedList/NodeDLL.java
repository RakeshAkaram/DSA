package linkedList;

public class NodeDLL {
    int data;
    NodeDLL leftNode;
    NodeDLL rightNode;

    public NodeDLL(int data, NodeDLL leftNode, NodeDLL rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public NodeDLL(int data) {
        this.data = data;
        this.leftNode=null;
        this.rightNode=null;
    }

}
