public class StackWithTwoQs {
    //Task4: Implement a Stack using only two instances of your implemented Queue class.
    //Insert in Q2 and move all elements from Q1 to Q2 and swap Q1 and Q2;
    Queue queueOne = new Queue(10);
    Queue queueTwo = new Queue(10);

    // push(x); //pushes x in the stack.
    public void push(int x) {
        queueTwo.enqueue(x);//Add new element in q2
        while (!queueOne.isEmpty()) {//If q1 is non-empty, q1 dequeue and add in q2
            queueTwo.enqueue(queueOne.dequeue());
        }
        Queue temp = queueOne;//swap q1 and q2
        queueOne = queueTwo;
        queueTwo = temp;
    }

    //pop():removes the latest element from the stack and returns it.
    public int pop() {
        if (queueOne.isEmpty())throw new RuntimeException("Queue is empty");
       return queueOne.dequeue();
    }

    //  peek():returns the latest element from the stack without removing it
    public int peek() {
        if (queueOne.isEmpty()) throw new RuntimeException("Queue is empty");
        return queueOne.poll();
    }

    //size():returns the size of the stack.
    public int size() {
        return queueOne.size();
    }

    //Test Code
    public static void main(String[] args) {
        StackWithTwoQs stack = new StackWithTwoQs();//[13579]
        stack.push(1);
        //stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        System.out.println("Current stack size:" + stack.size());
        System.out.println(stack.peek());
        System.out.println("Top element:" + stack.peek());
        while (stack.size() > 0) {
            int pop = stack.pop();
            System.out.println("Pop element: " + pop);//[9,7,5,3,1]
        }
    }
}


//Ref:https://www.youtube.com/watch?v=k04CALdmGLk
//Ref:https://www.youtube.com/watch?v=n3yHRcb7t9Q
