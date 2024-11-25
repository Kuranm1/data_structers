
public class Main {
    public static void main(String[] args) {

        RecursiveBinarySearchTree rBST = new RecursiveBinarySearchTree();
        rBST.insert(2);
        rBST.insert(1);
        rBST.insert(3);

                /*
            THE LINES ABOVE CREATE THIS TREE:
                         2
                        / \
                       1   3
        */


        System.out.println("Root: " + rBST.getRoot().value);
        System.out.println("\nRoot->Left: " + rBST.getRoot().left.value);
        System.out.println("\nRoot->Right: " + rBST.getRoot().right.value);

        System.out.println("==================");
        rBST.delete(1);
        System.out.println("Root: " + rBST.getRoot().value);
        System.out.println("\nRoot->Right: " + rBST.getRoot().right.value);


    }
}