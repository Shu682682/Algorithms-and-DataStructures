public class Node {
    StudentRecords val;
    Node left;
    Node right;
    String key;
    int level;

    public Node(StudentRecords val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.key = val.lastName;
        this.level=0;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}

