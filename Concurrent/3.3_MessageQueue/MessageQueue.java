import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Ref:https://www.youtube.com/watch?v=d3xb1Nj88pw
public class MessageQueue {
	private static int n_ids;

    public static void main1(String[] args) {
		//ex3.3 Using BlockingQueue to solve thread issues
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
		Producer p1 = new Producer(queue, n_ids++);
		Consumer c1 = new Consumer(queue, n_ids++);

		new Thread(p1).start();
		new Thread(c1).start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
	    	e.printStackTrace();
		}
		p1.stop();

    }

	//ex3.3 Change the main method so that two consumer threads are created, both of them consuming messages from the single queue.
	public static void main2(String[] args) {
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
		Producer p1 = new Producer(queue, n_ids++);
		Consumer c1 = new Consumer(queue, n_ids++);
		Consumer c2 = new Consumer(queue, n_ids++);
		new Thread(p1).start();
		new Thread(c1).start();
		new Thread(c2).start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p1.stop();
		try {
			queue.put(new Message("stop"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//ex3.3 Change the main method so that, additionally to the two consumer threads of the previous point, two producer threads are created, both of them sending messages to the single queue.
	public static void main(String[] args) {
		BlockingQueue<Message> queue=new ArrayBlockingQueue<Message>(10);
		Producer p1 = new Producer(queue, n_ids++);
		Producer p2 = new Producer(queue, n_ids++);
		Consumer c1 = new Consumer(queue, n_ids++);
		Consumer c2 = new Consumer(queue, n_ids++);
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(c1).start();
		new Thread(c2).start();

		try{
			Thread.sleep(10000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		p1.stop();
		p2.stop();
	}

	//ex3.3 Change the main method so that N consumers and M producers are created. N and M should be given as command-line arguments to the program.
	//javac MessageQueue.java
	//java MessageQueue
	public static void main4(String[] args) {
		BlockingQueue<Message> queue=new ArrayBlockingQueue<Message>(10);
		if(args.length<2) {
			System.out.println("Enter producer(M) and consumer(N) amounts");
			return;
		}
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		ArrayList<Producer> Producers=new ArrayList<>();
		for(int i=0;i<M;i++){
			Producer p=new Producer(queue, n_ids++);
			Producers.add(p);
			new Thread(p).start();
		}
		for(int i=0;i<N;i++){
			new Thread(new Consumer(queue, n_ids++)).start();
		}
		try{
			Thread.sleep(10000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}

		for(int i=0;i<N-M;i++){
			try{
				queue.put(new Message("stop"));
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(int i=0;i<M;i++){
			Producers.get(i).stop();
		}

	}

}

