package marhan;

public class TreeMirrorTest {
    public static Node mirror(Node node){
        if(node== null){
            return null;
        }
        Node leftNode = node.left;
        Node rightNode = node.right;
        node.right=mirror(leftNode);
        node.left= mirror(rightNode);

        return node;
    }

    public static void main(String[] args){
        Node node = new Node(3);
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        node.left = node1;
        node1.left = node2;
        node2.left = node3;
        printNodes(node);
        System.out.println("After mirror");
       mirror(node);
       printNodes(node);
    }

    private static void printNodes(Node node) {
      if(node== null){
          return;
      }

        printNodes(node.left);
        System.out.print(" " +node.data);
        printNodes(node.right);

    }

}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
