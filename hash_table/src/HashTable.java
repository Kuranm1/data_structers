import java.util.ArrayList;

public class HashTable {
    private int size = 7; // prime number for fewer collisions
    private Node[] dataMap;
    class Node{
        String key;
        int value;
        Node next;
        Node prev;
        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashTable(){
        dataMap = new Node[size];
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null)
            dataMap[index] = newNode;
        else{
            Node temp = dataMap[index];
            while (temp.next != null){
                if (temp.key.equals(key)){
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public Integer remove(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp != null){
            if (temp.key.equals(key)){
                if (temp.prev == null)
                    dataMap[index] = temp.next;
                else {
                    temp.prev.next = temp.next;
                    temp.prev = null;
                    temp.next = null;
                }
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public Integer get(String key){
        Node temp = dataMap[hash(key)];
        while(temp != null){
            if (temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return null;
    }

    public ArrayList<String> keys(){
        ArrayList<String> keys = new ArrayList<>();
        for (Node node: dataMap) {
            while (node != null){
                keys.add(node.key);
                node = node.next;
            }
        }
        return keys;
    }

    private int hash(String key){
        int hash = 0;
        for (char c: key.toCharArray()) {
            hash = (hash + (int) c * 23) % dataMap.length; // 23 prime number for more random & module length gives us result 0..length-1
        }
        return hash;
    }

    void printTable(){
        for (int i = 0; i < size; i++) {
            System.out.println("============");
            System.out.println("index "+i+":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("Key= "+temp.key+", Value= "+temp.value);
                temp = temp.next;
            }
        }
    }

}
