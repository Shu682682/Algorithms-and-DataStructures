import java.io.*;
import java.util.*;

public class Task2 {
    //Build a sorting function to check for anagram words
    public static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) throws IOException {
        //Build hashtable for saving key words.
        HashTable hashTable=new HashTable();
        final String fileName= "prideAndPrejudice.txt";
       try{
           InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
           BufferedReader br = new BufferedReader(reader);
           String line;//Read txt line by line
           while((line= br.readLine())!=null){
               String[] words = line.split("[^a-zA-Z0-9]+");// Use the regular expression to split the line.
               for (String word : words) {
                   String sortedWord = sortString(word.toLowerCase());//Convert words to lowercase for easier searching.
                   if (!sortedWord.isEmpty()){
                       hashTable.insert(sortedWord);//Duplicates will not be inserted into the table.
                   }
               }
            }
           System.out.println("Anagram word:"+hashTable.size());

        } catch (Exception e) {
            System.out.println("Read file wrong");
            e.printStackTrace();
        }
    }
}

//Ref:https://www.w3schools.com/java/java_files_read.asp
//Ref:https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

