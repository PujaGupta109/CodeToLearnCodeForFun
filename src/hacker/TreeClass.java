package hacker;

import java.util.Scanner;


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

   public void decode(String s, Node root) {
        char[] arr = s.toCharArray();
        Node node = root;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<arr.length; i++){
            if(arr[i]=='0'){
                node = node.left;
            }else{
                node = node.right;
            }
            if(isLeafNode(node)){
                sb.append(node.data);
                node=root;
            }
        }
        System.out.println(sb);


    }
    public boolean isLeafNode(Node node){
       return (node.left == null && node.right ==null);
    }

    public static boolean checkBST(Node root) {
        if (root == null) {
            return true;
        } else
            return ((root.left==null || root.left.data <= root.data) && (root.right == null || root.right.data > root.data) && checkBST(root.left) && checkBST(root.right));
    }
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
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        Node lca = root;
        while(lca!=null){
            if(v1<lca.data && v2 <lca.data){
                lca = lca.left;
            } else if(v1> lca.data && v2>lca.data){
                lca = lca.right;
            } else {
                return lca;
            }
        }
        return null;
    }



    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data > root.data) {
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
       // int height = height(root);
       System.out.println(checkBST(root));
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