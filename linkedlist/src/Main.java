public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(7);
        linkedList.prepend(2);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.set(0,7));
        System.out.println(linkedList.insert(2,9));
        linkedList.reverse();
        linkedList.printAll();
    }
}
