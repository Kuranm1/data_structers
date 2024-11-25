public class RecursiveBinarySearchTree {
    public Node root;

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

    public Node getRoot() {
        return root;
    }

    RecursiveBinarySearchTree() {}

    RecursiveBinarySearchTree(int value) {
        this.root = new Node(value);
    }

    private void rInsert(Node node, int value){
        if(value < node.value) {
            if(node.left == null)
                node.left = new Node(value);
            else
                rInsert(node.left, value);
        }
       else if(value > node.value) {
           if(node.right == null)
               node.right = new Node(value);
           else
               rInsert(node.right, value);
        }
    }

    public void insert(int value) {
        if(root == null) this.root = new Node(value);
        rInsert(root, value);
    }

    private Node rDelete(Node node, int value){
        if (node == null) return null;

        if(value < node.value)
            node.left = rDelete(node.left, value);
        else if(value > node.value)
            node.right = rDelete(node.right, value);
        else {
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            else {
                node.value = minValue(node.right);
                node.right = rDelete(node.right, node.value);
            }
        }
        return node;
    }

    public void delete(int value){
        if(root == null) return;
        rDelete(root, value);
    }

    private boolean rContains(Node node, int value){
        if(node == null) return false;

        if(node.value == value) return true;

        if(value < node.value)
            return rContains(node.left, value);
        else
            return rContains(node.right, value);
    }

    public boolean contains(int value) {
        return rContains(root, value);
    }



    private int minValue(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node.value;
    }
}
