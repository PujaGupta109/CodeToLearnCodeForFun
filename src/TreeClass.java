import java.util.*;


class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeClass {

    public static int height(Node root) {

        if ((root == null) || (root.left == null && root.right == null)) {
            return 0;
        }
        int lHeight = 0, rHeight = 0;
        Node nextLeft = root.left;
        Node nextRight = root.right;
        lHeight = 1 + height(nextLeft);
        rHeight = 1 + height(nextRight);
        return (Math.max(lHeight, rHeight));
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        // printTree(root);
        int height = height(root);
        System.out.println(height);
    }

    private static void printTree(Node root) {
        if (root != null) {
            System.out.println(root.data);
            if (root.left != null)
                root = root.left;
            printTree(root);
            if (root != null)
                root = root.right;
            printTree(root);
        }
    }
}