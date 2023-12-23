public class Stack {
    private int height;
    Node top;
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

    public Stack(){}

    public Stack(int value){
        top = new Node(value);
        height++;
    }

    public void push(int value){
        if (isEmpty()){
            top = new Node(value);
        }else {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public boolean isEmpty(){ return height==0; }

    public Node pop(){
        if (isEmpty()) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public Node peek(){
        if (isEmpty()) return null;
        return top;
    }

    public void printStack(){
        if (isEmpty()) return;
        Node temp = top;
        System.out.println("Stack height:"+height);
        System.out.println("Stack values:");
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
