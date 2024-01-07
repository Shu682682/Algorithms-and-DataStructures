public class Task1 {
    public static void main(String[] args) {
        String s1="ab";
        String s2 ="eidbaooo";
        String s3="eidbooa";
        boolean res=solution(s1,s3);
        System.out.println(res);
    }
    public static boolean solution(String s1, String s2){
        if(s1.length()>s2.length()) return false;
        int[] dic1=new int[26];
        int[] dic2=new int[26];
        for(int i=0;i<s1.length();i++){//Each time just need to check s1 length;
            dic1[s1.charAt(i)-'a']++;
            dic2[s2.charAt(i)-'a']++;
        }
        if(helper(dic1, dic2)) return true;
        for(int i=1;i<=s2.length()-s1.length();i++){
            dic2[s2.charAt(i-1)-'a']--;//remove left side
            dic2[s2.charAt(i+s1.length()-1)-'a']++;//add right side
            if(helper(dic1, dic2)) return true;//check s1=s2

        }
        return false;
    }
    private static boolean helper(int[] dic1, int[] dic2){//chcek whether s1=s2;
        for(int i=0;i<26;i++){
            if(dic1[i]!=dic2[i]) return false;
        }
        return true;
    }
}