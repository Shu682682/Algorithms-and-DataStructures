import java.io.*;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        final String fileName = "treeInput.txt"; // "./../treeInput.txt" for terminal use to output txt.
        try {
            BufferedReader objreader = new BufferedReader(new FileReader(fileName));
            String strLine;
            while ((strLine = objreader.readLine()) != null) {
                Character operationCode = strLine.charAt(0);
                int studentNumber = Integer.parseInt(strLine.substring(2, 9).trim());
                String lastName = strLine.substring(10, 19).trim();
                int homeDepartment = Integer.parseInt(strLine.substring(20, 24).trim());
                String program = strLine.substring(24, 27).trim();
                int year = Integer.parseInt(strLine.substring(28).trim());
                StudentRecords studentData = new StudentRecords(operationCode, studentNumber, lastName, homeDepartment, program, year);
                //Check if the operationCode is 'I' or 'D'. Insert student data for 'I' and delete for 'D'.
                if (operationCode == 'I') {
                    bst.insert(studentData);
                } else if (operationCode == 'D') {
                    bst.delete(studentData);
                }
            }
        } catch (Exception ex) {
            System.out.println("File read error" + ex.getMessage());
        }

        System.out.println("-----------------------InOrderTraversal------------------------");
        bst.inOrderTraversal(bst.root);
        System.out.println("-----------------------PreOrderTraversal-----------------------");
        bst.preOrderTraversal(bst.root);
        System.out.println("-----------------------PostOrderTraversal----------------------");
        bst.postOrderTraversal(bst.root);
        System.out.println("-----------------------LevelOrderTraversal----------------------");
        bst.levelOrderTraversal(bst.root);
    }
}

//Ref:https://www.youtube.com/watch?v=81PpYQ0AN_w
//Ref:https://www.youtube.com/watch?v=JsgqnTLjfps
//Ref:https://www.youtube.com/watch?v=_sjGU8nnCZM
//Ref:http://alrightchiu.github.io/SecondRound/binary-tree-traversalxun-fang.html
//Ref:https://chikuwa-tech-study.blogspot.com/2021/06/java-binary-search-tree.html
//Ref:https://www.youtube.com/watch?v=MXhKPnrWUTw(Reading file)
//Ref:https://www.learncode01.com/buffered-reader-in-java/