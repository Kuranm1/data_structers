import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    private Node invertBST(Node node){
        if(node == null) return null;
        Node temp = node.left;
        node.left = invertBST(node.right);
        node.right = invertBST(temp);
        return node;
    }

    public void invertBST(){
        invertBST(root);
    }


    // 0,1,2,3
    // 1,2,3,4
    private Node sortedArrayToBST(int[] nums, int start, int end){
        if(start > end) return null;
        int midIndex = start + (end-start)/2;
        Node node = new Node(nums[midIndex]);
        node.left = sortedArrayToBST(nums, start, midIndex-1);
        node.right = sortedArrayToBST(nums, midIndex+1,  end);
        return node;
    }
    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }


    private int minValue(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node.value;
    }

    public ArrayList<Integer> bfs (){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node.value);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return list;
    }

    private ArrayList<Integer> DFSPreOrder(Node node, ArrayList<Integer> list){
        if(node == null) return list;
        list.add(node.value);
        if(node.left != null) DFSPreOrder(node.left, list);
        if(node.right != null) DFSPreOrder(node.right, list);
        return list;
    }
    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> list = new ArrayList<>();
        list = DFSPreOrder(root, list);
        return list;
    }

    private ArrayList<Integer> DFSInOrder(Node node, ArrayList<Integer> list){
        if(node == null) return list;
        if(node.left != null) DFSInOrder(node.left, list);
        list.add(node.value);
        if(node.right != null) DFSInOrder(node.right, list);
        return list;
    }
    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> list = new ArrayList<>();
        list = DFSInOrder(root, list);
        return list;
    }


    private ArrayList<Integer> DFSPostOrder(Node node, ArrayList<Integer> list){
        if(node == null) return list;
        if(node.left != null) DFSPostOrder(node.left, list);
        if(node.right != null) DFSPostOrder(node.right, list);
        list.add(node.value);
        return list;
    }
    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> list = new ArrayList<>();
        list = DFSPostOrder(root, list);
        return list;
    }

}
