import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;

public class DoublyLinkedList {
    private int length = 0;
    private Node head;
    private Node tail;

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

    DoublyLinkedList(){}

    DoublyLinkedList(int value){
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public Node getHead() {return head;}

    public void setHead(Node head) {this.head = head;}

    public Node getTail() {return tail;}

    public void setTail(Node tail) {this.tail = tail;}

    public void append(int value){
        if(isEmpty()){
            head = new Node(value);
            tail = head;
        }
        else{
            Node newNode = new Node(value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        Node removedNode = tail;
        if (isEmpty()) {
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            removedNode.prev = null;

        }
        length--;
        return removedNode;
    }

    public Node removeFirst(){
        if(isEmpty() || length == 1){
            return removeLast();
        }
        else {
            Node removedNode = head;
            head = head.next;
            head.prev = null;
            removedNode.next = null;
            length--;
            return  removedNode;
        }
    }

    public void prepend(int value){
        if(isEmpty()){
            append(value);
        }
        else{
            Node newNode = new Node(value);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public Node get(int index){
        if (index < 0 || index >= length) return null;

        Node temp;
        boolean forward = index < (length / 2);
        temp = forward ? head : tail;
        if (index == 0 || index == length-1) return temp;

        if (forward)
            for (int i = 0; i < index ; i++) temp = temp.next;
        else
            for (int i = length-1; i > index ; i--) temp = temp.prev;


        return temp;
    }

    public boolean set(int index, int value){
        if (index < 0 || index >= length) return false;
        Node temp = get(index);
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length) return false;
        if (index == 0 ){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = get(index);
        newNode.next = after;
        newNode.prev = before;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == 0 ) return removeFirst();
        if (index == length-1) return removeLast();
        Node removedNode = get(index);
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
        removedNode.next = null;
        removedNode.prev = null;
        length--;
        return removedNode;
    }

    public boolean isEmpty(){ return length == 0;}

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printListReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.prev;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    //  Extra methods for practice

    public void swapFirstLast(){
        if(length < 2) return;
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse(){
        if (length<2) return;
        Node currentNode = head;
        Node temp;
        while (currentNode != null){
            temp = currentNode.next;
            currentNode.next = currentNode.prev;
            currentNode.prev = temp;
            currentNode = temp;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean isPalindrome(){
        if (length == 0) return true;
        Node head = this.head;
        Node tail = this.tail;
        if(head.value != tail.value) return false;
        for (int i = 1; i < length / 2; i++) {
            head = head.next;
            tail = tail.prev;
            if(head.value != tail.value) return false;
        }
        return true;
    }

    public void swapPairs(){
        if(length < 2) return;
        if (length == 2){
            Node temp = head;
            head = tail;
            tail = temp;
            return;
        }
        Node currentNode = head;
        Node after = currentNode.next;
        Node before = currentNode.prev;
        Node after_after = after.next;
        head = head.next;
        tail = tail.prev;
        for (int i = 0; i <= length ; i++) {
            //  previous node next pointer should point to the after node because of swapping
            if (currentNode.prev != null){
                currentNode.prev.next = after;
            }
            // start swapping
            // connect current node pointers
            currentNode.next = after_after;
            currentNode.prev = after;
            // connect after node pointer
            after.next = currentNode;
            after.prev = before;
            //
            if (after_after == null) break; // for odd length of nodes

            after_after.prev = currentNode; // next node previous pointer should point to the current node because of swapping
            currentNode = after_after;
            after = currentNode.next;
            before = currentNode.prev; // for even length of nodes
            if (after == null) {
                tail = tail.next.next;
                break;
            }
            after_after = after.next;

        }

    }


}
