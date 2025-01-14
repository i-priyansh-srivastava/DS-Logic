package linkedList;
public class LinkedList {
    class Node{
        int val;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int item){
        Node nn=new Node();
        nn.val=item;
        if(size==0){
            head=nn;
            tail=nn;
            size++;
        }
        else{
            nn.next=head;
            head=nn;
            
        }
        size++;
    }
    public void addLast(int item){
        if(size==0){
            addFirst(item);
        }
        else {
            Node nn=new Node();
            nn.val=item;
            tail.next=nn;
            tail=nn;
            size++;
        }
    }
    public void Display(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+" -> ");
            curr=curr.next;
        }
        System.out.println("null");
    }

    public void addAtIndex(int k,int item) throws Exception{
        if(k==0)
            addFirst(item);
        else if(k==size)
            addLast(item);
        else{
            Node nn=new Node();
            nn.val=item;
            Node k_1th=GetNode(k-1);
            nn.next=k_1th.next;
            k_1th.next=nn;
            size++;
        }
    }

    public Node GetNode(int k) throws Exception{
        if(k<0 || k>=size){
            throw new Exception("Out of range");
        }

        Node temp=head;
        for(int i=0;i<k;i++)
        {
            temp=temp.next;
        }
        return temp;
    }


    public int getFirst(){
        return head.val;
    }
    public int getLast() {
        return tail.val;
    }
    public int getAtindex(int k) throws Exception {
        return GetNode(k).val;
    }

    public int removeFirst(){
        Node temp=head;
        if(size==1){
            head=null;
            tail=null;
            size--;
        }
        else
        {
            head=head.next;
            temp.next=null;
            size--;
        }
        return temp.val;
    }

    public int removeLast()throws Exception{
        if(size==1)
            return removeFirst();
        else{
            Node prev=GetNode(size-2);
            int rv=tail.val;
            tail=prev;
            tail.next=null;
            size--;
            return rv;
        }
    }

    public int removeAtIndex(int k) throws Exception{
        if(k==0)
            return removeFirst();
        else if(k==size-1)
            return removeLast();
        else{
            Node curr=GetNode(k);
            Node prev=GetNode(k-1);
            prev.next=curr.next;
            curr.next=null;
            return curr.val;
        }
    }
}
