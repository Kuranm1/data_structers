import javax.swing.text.TabExpander;

public class Queue {
    private int length;
    private Node first;
    private Node last;
    class Node{
        public int value;
        public Node next;
        public Node prev;
        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }

    }
    Queue(){}

    Queue(int value){
        this.first = new Node(value);
        this.last = this.first;
        length++;
    }
    boolean isEmpty(){return length==0;}

    void enqueue(int value) {
        if (isEmpty()) {
            first = new Node(value);
            last = first;
        }
        else{
            last.next = new Node(value);
            last = last.next;
        }
        length++;
    }

    Node dequeue(){
        if (isEmpty()) return null;
        Node temp = first;
        if (length == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    void printQueue(){
        if (isEmpty()){
            System.out.println("Empty queue");
            return;
        }
        Node temp = first;
        System.out.println("---Queue---");
        while (temp!= null){
            System.out.println(temp.value);
            temp=temp.next;
        }
        System.out.println("length = "+length);
    }
}
