public class Test {

    public static void main(String[] args) {
        Bank.MyLinkedList bankOfOrangeCounty=new Bank.MyLinkedList();
        Bank.MyLinkedList bankOfLosAngles= new Bank.MyLinkedList();
        Bank user10 = new Bank( "Charlie", "Irvine", "122233", 1000);
        Bank user8 = new Bank( "Rebecca", "CostMesa", "123477", 500);
        Bank user9 = new Bank( "Bob", "Santa Ana", "224357", 3400);
        bankOfLosAngles.addUser(user10);
        bankOfLosAngles.addUser(user8);
        bankOfLosAngles.addUser(user9);
        System.out.println("------------------------LosBank User Detail-----------------------------------------------");
        Bank.Node currNode=bankOfLosAngles.head;
        while (currNode  != null) {
           Bank currentUser = currNode.user;
            System.out.println("LosBank User info: ID:" + currentUser.id + ", Name:" + currentUser.name + ", SocialSecurity:" + currentUser.socialSecurity + ", Balance:" + currentUser.initialDepositAmount);
            currNode  = currNode .next;
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------------OCBank User Detail------------------------------------------------");

        Bank user1 = new Bank("Andy", "Irvine", "123456", 1000);
        Bank user2 = new Bank( "Sophie", "CostMesa", "123477", 500);
        Bank user3 = new Bank( "Nana", "Santa Ana", "224357", 3400);
        Bank user4 = new Bank( "Kevin", "Irvine", "234123", 200);
        Bank user5 = new Bank("David", "OrangeCity", "456789", 4800);
        Bank user6 = new Bank("David", "OrangeCity", "456789", 4800);
        Bank user7 = new Bank("Tiffany", "OrangeCity", "456321", 1500);
        bankOfOrangeCounty.addUser(user1);
        bankOfOrangeCounty.addUser(user2);
        bankOfOrangeCounty.addUser(user3);
        bankOfOrangeCounty.addUser(user4);
        bankOfOrangeCounty.addUser(user5);
        bankOfOrangeCounty.addUser(user6);
        bankOfOrangeCounty.addUser(user7);
        bankOfOrangeCounty.printUsers();

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------Delete User--------------------------------------------------");
        bankOfOrangeCounty.deleteUser(1);
        System.out.println("User:"+bankOfOrangeCounty.getUser(1));
        Bank user11 = new Bank("Zoey", "OrangeCity", "23389", 2200);
        bankOfOrangeCounty.addUser(user11);
        bankOfOrangeCounty.printUsers();
        System.out.println("OCBank user ID:" + user11.id + ", Name:" + user11.name + ", SocialSecurity:" + user11.socialSecurity+ ", initialDeposit:" + user11.initialDepositAmount);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("-------------------------Get Median Number------------------------------------------------");
        float medianID=bankOfOrangeCounty.getMedianID();
        System.out.println("OCBank user median ID number is:"+medianID);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("--------------------------User Pay User --------------------------------------------------");
        System.out.println("User:"+bankOfOrangeCounty.getUser(3).name+" who initial Deposit is USD:"+bankOfOrangeCounty.getUser(3).initialDepositAmount+" pay 200 to "+bankOfOrangeCounty.getUser(4).name);
        bankOfOrangeCounty.payUsertoUser(3, 4, 200);
        System.out.println("User:"+bankOfOrangeCounty.getUser(3).name+" balance is USD  "+bankOfOrangeCounty.getUser(3).initialDepositAmount);
        System.out.println("User:"+bankOfOrangeCounty.getUser(2).name+" pay 2000 to "+bankOfOrangeCounty.getUser(5).name+" who initial Deposit is:"+bankOfOrangeCounty.getUser(5).initialDepositAmount);
        bankOfOrangeCounty.payUsertoUser(2, 5, 2000);
        System.out.println("User:"+bankOfOrangeCounty.getUser(4).name+" New balance is USD:"+bankOfOrangeCounty.getUser(5).initialDepositAmount);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("---------------------------Merge Account--------------------------------------------------");
        bankOfOrangeCounty.mergeAccounts(4,5);
        bankOfOrangeCounty.mergeAccounts(2,1);
        System.out.println("Merge Account Name:"+bankOfOrangeCounty.getUser(4).name+" account balance is:"+bankOfOrangeCounty.getUser(4).initialDepositAmount);
        System.out.println("Merge Account Name:"+bankOfOrangeCounty.getUser(2).name+" account balance is:"+bankOfOrangeCounty.getUser(2).initialDepositAmount);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("----------------------Current OC Bank User------------------------------------------------");
        bankOfOrangeCounty.printUsers();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("----------------------Current Los Bank User-----------------------------------------------");
        bankOfLosAngles.printUsers();
        System.out.println("--------------------------Merge Bank------------------------------------------------------");
        // Bank.MyLinkedList merge=new Bank.MyLinkedList();
        bankOfOrangeCounty.mergeBanks(bankOfOrangeCounty,bankOfLosAngles);
        bankOfOrangeCounty.printUsers();

       //  BankOfOrangeCounty.Node mergeBanks=bankOfOrangeCounty.mergeBanks(bankOfOrangeCounty,bankOfLosAngles);

    }

}
