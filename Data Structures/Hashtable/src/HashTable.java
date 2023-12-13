import java.util.ArrayList;
import java.util.List;

public class HashTable {
    //HashTable: A fixed-size array or list.
    private int capacity=10000000;
    private String[] table;
    private int size;
    public HashTable() {//number of Size
        this.size = 0;
        this.table = new String[capacity];
    }

    //hash(x): A hash function that converts a string x to an integer, i.e., index in the hashtable.
    private int hash(String key) {//Reducing collisions and searching time.
        int hash = 7;//Use a non-zero initial number to address the hash issue.
        for (int i = 0; i < key.length(); i++){
            hash = 37 * hash + key.charAt(i);//ASCII code-based hash calculation method.
        }
        hash %= capacity;
       if (hash < 0){
           hash += capacity;
       }
       return hash;
    }
    //insert(x):  Insert string x to the HashTable in the index returned by hash(x).
    public void insert(String key) {
        if (key == null) throw new IllegalArgumentException("Key or Value data is null!");
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].equals(key)) return;
            index = (index + 1) % capacity;//Solving collisions issue
        }
        table[index] = key;
        size++;
    }
    //size():  Returns the size of the elements, i.e., the number of keys.
    public int size(){
        return size;
    }

    //Test Code
    public static void main(String[] args) {
        HashTable table=new HashTable();
        table.insert("Apple");
        table.insert("Eat");
        table.insert("Ate");
        table.insert("Dog");
        System.out.println("Table size is:"+table.size());
        System.out.println("Table element include: "+table);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<table.length;i++){
            if(table[i]!=null){
                sb.append(table[i]+" ");
            }
        }
        return sb.toString();
    }
}


//Ref:https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html
//Ref:https://www.lavivienpost.net/hash-table-implementation/
//Ref:https://www.shawndsilva.com/blog/computer%20science%20fundamentals/hash-table-explained-and-implemented-in-java-part-1


