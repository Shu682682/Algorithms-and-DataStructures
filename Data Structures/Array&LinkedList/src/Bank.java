import java.util.HashSet;
import java.util.LinkedList;

public class Bank {
    //Task1
    //Attribute
    int id;
    String name;
    String address;
    String socialSecurity;
    double initialDepositAmount;

    //Constructor
    public Bank(String name, String address, String socialSecurity, double initialDepositAmount) {
        this.name = name;
        this.address = address;
        this.socialSecurity = socialSecurity;
        this.initialDepositAmount = initialDepositAmount;
    }
    //Node class
    public static class Node {
        Bank user;
        Node next;

        public Node(Bank user) {
            this.user = user;
            this.next = null;
        }
    }

    public static class MyLinkedList {
        Node head;
        int dataID;
        int size;

        public MyLinkedList() {//put user in it
            head = null;
            dataID = 1;
            size = 1;
        }

        public void printUsers() {//For test code to print
            Node current = head;
            while (current != null) {
                System.out.println("User ID:" + current.user.id + ", Name:" + current.user.name + ", Address:" + current.user.address + ", SocialSecurity:" + current.user.socialSecurity + ", InitialDepositAmount:" + current.user.initialDepositAmount);
                current = current.next;
            }
        }

        private HashSet<Integer> userID = new HashSet<>();//Avoid duplicate ID

        //Task2 Add User
        public void addUser(Bank user) {
            if (head == null) {
                head = new Node(user);
                return;
            }
            Node new_user = new Node(user);
            user.id = dataID;
            Node current_user = head;
            while (current_user.next != null) {//next user ID assigned
                if (current_user.user.id == dataID) {//if current ID already been used find next ID;
                    dataID++;
                    user.id = dataID;
                }
                if (current_user.user.id + 1 != current_user.next.user.id) {//if user has been deleted,user id need to assigned for new user
                    new_user.user.id = current_user.user.id + 1;
                    Node temp = current_user.next;
                    current_user.next = new_user;
                    new_user.next = temp;
                    return;
                }
                current_user = current_user.next;
            }
            //add new user into LinkedList
            current_user.next = new_user;
            dataID++;
            size++;
            userID.add(dataID);
        }

        public Bank getUser(int id) {//get user data
            if (id < 0 || id >= size) {
                System.out.println("Cannot find the Userid: " + id);
                return null;
            }
            Node current = head;
            while (current != null) {
                if (current.user.id == id) {
                    return current.user;//return user detail
                }
                current = current.next;
            }
            return null;
        }

        //Task3 Delete User
        public void deleteUser(int id) {
            if (head == null) {//check whether the list is null
                System.out.println("Cannot find the User ID: " + id);
                return;
            }
            Node current = head;
            Node prev = null;
            if (current != null && current.user.id == id) {//check id and head
                head = current.next;//if id is correct, connect list to the next list;
                return;
            }
            while (current != null && current.user.id != id) {//keep tracking
                prev = current;
                current = current.next;
            }
            prev.next = current.next;//tracking
            System.out.println("Cannot find the User id:" + id);

        }

        //Task-4: Write a method/function payUserToUser(payer ID, payee ID, amount)
        public void payUsertoUser(int payerID, int payeeID, int amount) {
            Bank payer = getUser(payerID);
            Bank payee = getUser(payeeID);

            if (payer == null || payee == null) {//check is user exist
                System.out.println("No User data!");
                return;
            }
            if (payer.initialDepositAmount >= amount) {//if exist process payment change
                payer.initialDepositAmount -= amount;
                payee.initialDepositAmount += amount;
            } else {
                System.out.println("Insufficient balance");//insufficient output
            }
        }

        //Task-5: Write a method/function getMedianID() that returns the median of all the account IDs.
        //I use fast and slow pointers to find the median.
        public float getMedianID() {
            if (head == null) return 0;
            Node slow = head;
            Node fast = head;
            Node prev = null;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }
            if (fast == null) {
                return (float) (prev.user.id + slow.user.id) / 2;

            } else {
                return slow.user.id;
            }
         //   return (float) size / 2; Also can use size/2 since the size increases as users are added.

        }

        //Task-6: Write a method/function mergeAccounts(ID1, ID2) that merges two accounts into one.
        public void mergeAccounts(int ID1, int ID2) {
            Node current = head;
            if (getUser(ID1) == null || getUser(ID2) == null) {//check user data
                System.out.println("Accounts not found.");
                return;
            }
            Bank acc1 = null;
            Bank acc2 = null;
            while (current != null) {//check all linked list to find the ID1 and ID2 user
                if (current.user.id == ID1) {
                    acc1 = current.user;
                } else if (current.user.id == ID2) {
                    acc2 = current.user;
                }
                current = current.next;
            }
            //Check if both users have the same user data. If they do, add the initial deposit.
            if (acc1.name.equals(acc2.name) && acc1.address.equals(acc2.address) && acc1.socialSecurity.equals(acc2.socialSecurity)) {
                acc1.initialDepositAmount += acc2.initialDepositAmount;
                deleteUser(ID2);
            }

        }

        //Task-7:mergeBanks(bankOfOrangeCounty, bankOfLosAngeles)
        public MyLinkedList mergeBanks(MyLinkedList bankOfOrangeCounty, MyLinkedList bankOfLosAngeles) {
            Node current = bankOfOrangeCounty.head;
            Node current2 = bankOfLosAngeles.head;
            if (current == null) return bankOfLosAngeles;
            if (current2 == null) return bankOfOrangeCounty;
            //If the Bank of Los Angeles has users, reset their user IDs to 0, so it can use addUser function to assign them new ID.
            while (current2!=null) {
                current2.user.id = 0;
                bankOfOrangeCounty.addUser(current2.user);
                current2 = current2.next;
            }
            return bankOfOrangeCounty;
        }
    }
}



//Ref:https://www.youtube.com/watch?v=k9r80o_DeK4
//Ref:http://alrightchiu.github.io/SecondRound/linked-list-xin-zeng-zi-liao-shan-chu-zi-liao-fan-zhuan.html
//Ref:https://chikuwa-tech-study.blogspot.com/2021/05/java-linked-list.html




