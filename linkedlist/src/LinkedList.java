public class LinkedList {
    class Node {
        public int value;
        public Node next;
        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private Node tail;
    private int length = 0;

    LinkedList(){
    }
    LinkedList(int value){
        head = new Node(value);
        tail = head;
        length = 1;
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public Node get(int index){
        Node foundNode = null;
        if (index >= 0 && index < length){
            foundNode = head;
            for (int i = 1; i <= index ; i++) {
                foundNode = foundNode.next;
            }
        }
        return foundNode;
    }

    public boolean set(int index, int value) {
        Node foundNode = get(index);
        if (foundNode != null) {
            foundNode.value = value;
            return true;
        }
        return false;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (isEmpty())
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        length++;
    }

    public Node removeLast(){
        if (isEmpty()) return null;
        Node lastNode = tail;
        if (this.length == 1) {
            head = null;
            tail = null;
        } else{
            Node newLastNode = get(length-2);
            newLastNode.next = null;
            tail = newLastNode;
        }
        length--;
        return lastNode;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        Node firstElement = null;
        if (!isEmpty()){
            firstElement = head;
            if (length == 1){
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            firstElement.next = null;
            length--;
        }
        return firstElement;
    }

    public void reverse(){
        Node pointer = head;
        head = tail;
        tail = pointer;
        Node nextNode;
        Node previousNode = null;
        for (int i = 0; i < length ; i++){
            nextNode = pointer.next; // hold the next node to be reversed
            pointer.next = previousNode; // reverse the node next pointer to point backward
            previousNode = pointer;  // move the previous node one step
            pointer = nextNode; // move the pointer one step
        }
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0)
            prepend(value);
        else if (index == length)
            append(value);
        else{
            Node newNode = new Node(value);
            Node temp = get(index-1);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index > length) return null;
        if (index == 0)  return removeFirst();
        if (index == length) return removeLast();
        Node removedElement = get(index);
        Node perElement = get(index-1);
        perElement.next = removedElement.next;
        removedElement.next = null;
        length--;
        return removedElement;
    }

    // Extra methods for practice (Leetcode)

    public  Node findMiddleNode() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        boolean hasLoop = false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                hasLoop = true;
                break;
            }
        }
        return hasLoop;
    }

    public Node findKthFromEnd(int n) {
        Node fast = head;
        Node slow = head;

        // Fast pointer will jump Nth times
        for (int i = 0; i < n; i++) {
            if (fast == null ) return null ;
            fast = fast.next;
        }

        // Slow,Faster pointers will move until the end of linked list
        // Slow pointer will point the Nth From end node
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public void partitionList(int x) {
        Node tempHead = head;
        Node firstListHead = null;
        Node firstListTail = null;
        Node secondListHead = null;
        Node secondListTail = null;

        while (tempHead != null){
            if (tempHead.value < x){
                if (firstListHead == null){
                    firstListHead = new Node(tempHead.value);
                    firstListTail = firstListHead;
                }else {
                    Node temp = firstListTail;
                    firstListTail = new Node(tempHead.value);
                    temp.next = firstListTail;
                }
            }else {
                if (secondListHead == null){
                    secondListHead = new Node(tempHead.value);
                    secondListTail = secondListHead;
                } else {
                    Node temp = secondListTail;
                    secondListTail = new Node(tempHead.value);
                    temp.next = secondListTail;
                }
            }
            tempHead = tempHead.next;
        }

        if (firstListHead == null){
            head = secondListHead;
        }
        else{
            firstListTail.next = secondListHead;
            head = firstListHead;
        }
    }

    public void removeDuplicatesFromSortedList() {
        Node pointer = head;
        while (pointer != null && pointer.next != null ){
            if (pointer.value == pointer.next.value){
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
    }

    public  int binaryToDecimal() {
        int result = 0 ;
        if (head == null) return result;

        int maxPowerValue = 0;
        int length = 0;

        Node temp = head;
        while (temp != null){
            temp = temp.next;
            length++;
        }

        maxPowerValue = (int) Math.pow(2, length-1);
        temp = head;
        while (temp != null){
            result +=  temp.value * maxPowerValue;
            maxPowerValue /= 2;
            temp = temp.next;
        }
        return result;
    }

    public void reverseBetween(int left, int right) {
        Node subListHead = head;

        Node previousSubListNode = subListHead;

        if (head == null) return;
        if (right - left <= 0) return;

        // Store Head of the sublist and the node before it
        for (int i = 1; i <= left; i++) {
            subListHead = subListHead.next;
            if(i == left-1) previousSubListNode = subListHead;
        }

        // Reverse Sublist
        Node subListTail = subListHead;
        Node after = subListHead.next;
        Node before = null;
        for (int i = 0; i < right-left; i++) {
            subListHead.next = before;
            before = subListHead;
            subListHead = after;
            if(after != null) after = after.next;
        }
        subListHead.next = before;
        if (left == 0) {
            head = subListHead;
            return;
        };
        previousSubListNode.next = subListHead;
        subListTail.next = after;

    }
    public boolean isEmpty(){
        return this.length == 0;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
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
}
