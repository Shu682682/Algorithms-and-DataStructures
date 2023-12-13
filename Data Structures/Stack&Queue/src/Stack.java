
import java.util.Arrays;

public class Stack {
    //Attribute: use ArrayList to storage element
    int top;
    int size;
    int[] stack;

    Stack(){//Constructor
        top=-1;
        size=10;
        stack=new int[size];

    }
    public boolean isEmpty(){//check whether stack is empty
        return top==-1;
    }
    public boolean isFull(){//check whether stack is full
        return (top==size-1);
    }
    //push:pushes element in the stack.
    public int push(int data){
        if(isFull()){//check whether stack is full
            System.out.println("myStack is full.");
            return -1;
        }
        top++;
        stack[top] = data;
        return data;
    }
    //pop():removes the latest element from the stack and returns it.
    public int pop(){
        if(isEmpty()){
            System.out.println("myStack is empty.");
            return -1;
        }
        int res = stack[top];
        top--;
        return res;
    }
    //peek():returns the latest element from the stack without removing it
    public int peek(){
        return stack[top];
    }

    //size()returns the size of the stack
    public int size(){
        return top+1;
    }
    public void printAllStack(){//Only for testing to print all stack elements.
        int[] res=new int[size()];
        for (int i = 0; i <= top; i++) {
            res[i]=stack[i];
        }
        System.out.println("Print all stack element: "+Arrays.toString(res));
    }

    //Test Code
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(55);
        stack.push(65);
        System.out.println("Whether my stack is empty? "+stack.isEmpty());
        System.out.println("Whether my stack is full? "+stack.isFull());
        System.out.println("My stack size is "+stack.size);
        System.out.println("Peek element is "+stack.peek());
        System.out.println("Pop element is "+stack.pop());
        System.out.println("My stack size is "+stack.size());
        stack.printAllStack();
    }
}

//https://www.youtube.com/watch?v=i7SgAJHcx00
