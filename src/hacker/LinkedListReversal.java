package hacker;

public class LinkedListReversal {

    public static Link reverseLinkedList(Link link){
        Link nextLink = link.next;
        Link prevLink = null;
        Link linkToReturn= link;
        while(nextLink!=null){
            linkToReturn = nextLink;
            linkToReturn.next =nextLink.prev;
                    nextLink = nextLink.next;


                                }
         link = prevLink;
        link.next = prevLink.prev;
        Link temp = prevLink;
        while(prevLink!=null){
            temp.next = temp.prev;
            prevLink = prevLink.prev;

        }




        return null;
    }

}

class Link{
    int value;
    Link next;
    Link prev;

    public Link(int value){
        this.value = value;
        next = null;
        prev = null;
    }
}
