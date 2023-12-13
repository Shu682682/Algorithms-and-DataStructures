

import java.util.Arrays;

public class Queue {
    int[] queue;//arraylist
    int front;//start point
    int rear;//final point
    int size;

    public Queue(int sizeOfArray) {
        queue = new int[sizeOfArray];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    //enqueue(element):enqueue element in the queue.
    public boolean enqueue(int element) {
        boolean res = false;
        if (rear != queue.length - 1) {
            rear++;
            queue[rear] = element;
            size++;
            res = true;
        }
        return res;
    }
    //dequeue():remove and return the earliest element from the queue.
    public int dequeue() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        int res = 0;
        if (size != 0) {
            res=queue[0];
            for(int i=0;i<queue.length-1;i++){
                queue[i]=queue[i+1];
            }
            size--;
            rear--;
        }
        return res;
    }

    //poll():returns the earliest element without removing it.
    public int poll() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        int res=0;
        if (!isEmpty()&&front<queue.length) {
            res = queue[0];
        }
        return res;
    }
    //size():returns the size of the queue.
    public int size() {
        return size;
    }
    //return All Queue element
    public void allqueue() {//Only for testing to print all queue elements.
        int[] res=new int[queue.length+1];
        int index=0;
        for (int i : queue) {
            res[index]=i;
            index++;
        }
        System.out.println("Print all my queue element:"+Arrays.toString(res));
    }

    //Test Code
    public static void main(String[] args) {
        Queue queue =new Queue(10);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        queue.enqueue(30);
        queue.allqueue();
        System.out.println("Whether myQueue is empty? "+queue.isEmpty());
        System.out.println("My Queue size is :"+queue.size());
        System.out.println("Delete element: "+queue.dequeue());
        System.out.println("Poll element: "+queue.poll());
        queue.allqueue();
    }
}

