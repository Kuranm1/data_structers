
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

        System.out.println("=========Delete=========");
        rBST.delete(1);
        System.out.println("Root: " + rBST.getRoot().value);
        System.out.println("\nRoot->Right: " + rBST.getRoot().right.value);

        System.out.println("========Invert==========");
        rBST.insert(1);
        rBST.invertBST();
        System.out.println("Root: " + rBST.getRoot().value);
        System.out.println("\nRoot->Left: " + rBST.getRoot().left.value);
        System.out.println("\nRoot->Right: " + rBST.getRoot().right.value);

        System.out.println("========Sorted array to BST==========");
        rBST.sortedArrayToBST(new int[] {1,2,3});
        System.out.println("Root: " + rBST.getRoot().value);
        System.out.println("\nRoot->Left: " + rBST.getRoot().left.value);
        System.out.println("\nRoot->Right: " + rBST.getRoot().right.value);

        System.out.println("=========BFS Traversal========");
        System.out.println(rBST.bfs());

        System.out.println("=========DFS Inorder Traversal========");
        System.out.println(rBST.DFSInOrder());

        System.out.println("=========DFS Preorder Traversal========");
        System.out.println(rBST.DFSPreOrder());

        System.out.println("=========DFS Postorder Traversal========");
        System.out.println(rBST.DFSPostOrder());

    }
}