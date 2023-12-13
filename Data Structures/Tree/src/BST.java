import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {
    Node root;
    public BST( ) {
        this.root = null;
    }

    public Node insert(StudentRecords val) {
        if (this.root == null) {
            this.root = new Node(val);
            return this.root;
        }
        return insert(this.root, val);
    }
    public void delete(StudentRecords val){
        root=delete(root, val);
    }

    //Insert Node:using compareTo method to compare lastName Character and recursion function to insert.
    private Node insert(Node root, StudentRecords val) {
            if (root == null) return new Node(val);
            else {
                if (val.lastName.compareTo(root.val.lastName)<=0) {
                    root.left = insert(root.left, val);
                } else {
                    root.right = insert(root.right, val);
                }
            }
            return root;
        }

    //Search Node:Using recursion to search students' data.
    private Node search(Node root, StudentRecords val) {
        if (root == null || root.val == val) return root;
        if (val.lastName.compareTo(root.val.lastName) <0) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    //Delete Node:Using recursion to find student and delete node.
    private Node delete(Node root, StudentRecords val) {
        if (root == null) return root;
        if (val.lastName.compareTo(root.val.lastName) < 0) {
            root.left = delete(root.left, val);
        }
        else if (val.lastName.compareTo(root.val.lastName) > 0) {
            root.right = delete(root.right, val);
        }
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            Node min = findMin(root.right);
            root.val = min.val;
            root.right = delete(root.right, min.val);
        }
        return root;
    }

   private Node findMin(Node node) {//Support delete function to find min node
        while (node.left != null) node = node.left;
        return node;
    }

    //Depth-first traversal
    //InOrderTraversal
    public void inOrderTraversal(Node root) {//Left->Root->Right
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }
    //PreOrderTraversal
     public void preOrderTraversal(Node root) {//Root->Left->Right
        if (root != null) {
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    //PostOrderTraversal
    public void postOrderTraversal(Node root) {//Left->Right->Root
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    // Breadth-first traversal
    // LevelOrderTraversal: Utilizing a queue for processing.
    public void levelOrderTraversal(Node root) {
        if (root == null) return;
        List<String> output=new ArrayList<>();
        Queue<Node> levelQueue = new LinkedList<>();
        int level = 0;
        root.level = level;
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            level++;
            Node current_node = levelQueue.poll();
            output.add(current_node.toString() + " - level: " + current_node.level + "\n");
            if (current_node.left != null) {
                current_node.left.level = level;
                levelQueue.add(current_node.left);
            }
            if (current_node.right != null) {
                current_node.right.level = level;
                levelQueue.add(current_node.right);
            }
        }
        System.out.println(output);
    }

    //Test Code
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(new StudentRecords('I', 1234567, "Jenny", 123, "MKT", 1));
        bst.insert(new StudentRecords('I', 1234555, "Kevin", 234, "JDK", 2));
        bst.insert(new StudentRecords('I', 1234555, "Annie", 234, "JDK", 2));
        bst.insert(new StudentRecords('I', 8500453, "Banks", 0251, "EST", 1));

        System.out.println("Pre-order traversal:");
        bst.preOrderTraversal(bst.root);
        System.out.println("---------------------------------------");
        System.out.println("In-order traversal:");
        bst.inOrderTraversal(bst.root);
        System.out.println("---------------------------------------");
        System.out.println("Post-order traversal:");
        bst.delete(bst.root, new StudentRecords('A', 1234567, "Jenny", 123, "MKT", 1));
        bst.postOrderTraversal(bst.root);
        System.out.println("---------------------------------------");
        System.out.println("Level-order traversal:");
        bst.levelOrderTraversal(bst.root);
    }
}

