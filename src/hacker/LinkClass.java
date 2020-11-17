package hacker;


import java.util.HashSet;
import java.util.Set;

public class LinkClass {

    public static void main(String[] args) {
        SingleEndedLink link1 = new SingleEndedLink(1);
        SingleEndedLink link2 = new SingleEndedLink(2);
        SingleEndedLink link3 = new SingleEndedLink(3);
        SingleEndedLink link4 = new SingleEndedLink(1);
        SingleEndedLink link5 = new SingleEndedLink(2);
        SingleEndedLink link6 = new SingleEndedLink(6);
        link1.next = link2;
        link2.next = link3;
        link3.next = link4;
        link4.next = link5;
        link5.next = link6;
        printLinks(link1);
        SingleEndedLink head = removeDuplicateFromLink(link1);
        System.out.println("After modifications");
        printLinks(head);
    }

    private static SingleEndedLink removeDuplicateFromLink(SingleEndedLink head) {
        SingleEndedLink node = head;
        SingleEndedLink prevNode = null;
        Set<Integer> integerSet = new HashSet<Integer>();
        while (node != null) {
            if (!integerSet.contains(node.data)) {
                integerSet.add(node.data);
                prevNode = node;
                node = node.next;
            } else {
                prevNode.next = node.next;
                node = node.next;
            }
        }
        return head;
    }

    private static void printLinks(SingleEndedLink head) {
        SingleEndedLink node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

}

class SingleEndedLink {
    int data;
    SingleEndedLink next;

    public SingleEndedLink(int data) {
        this.data = data;
        this.next = null;
    }
 
    @Override
    public String toString() {
        return "" + data;
    }
}
