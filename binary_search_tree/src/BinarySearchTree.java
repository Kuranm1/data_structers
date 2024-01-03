public class BinarySearchTree {

    Node root;
    class Node{
        public int value;
        public Node right;
        public Node left;
        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", right=" + right +
                    ", left=" + left +
                    '}';
        }
    }

    public BinarySearchTree(){}

    public boolean insert(int value){
        if (root==null){
            root = new Node(value);
            return true;
        }

        Node temp = root;
        boolean inserted = false;

        while(!inserted){
            if (temp.value == value) break;

            if (temp.value > value){
                if(temp.left == null){
                    temp.left = new Node(value);
                    inserted = true;
                }
                temp = temp.left;
            } else{
                if (temp.right == null){
                    temp.right = new Node(value);
                    inserted = true;
                }
                temp = temp.right;
            }
        }

        return inserted;
    }

    public boolean contains(int value){
        Node temp = root;
        while (temp != null){
            if (temp.value == value) return true;
            temp = (value > temp.value) ? temp.right : temp.left;
        }
        return false;
    }
}
