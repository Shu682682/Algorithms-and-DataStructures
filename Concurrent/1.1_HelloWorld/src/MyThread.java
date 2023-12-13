import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class MyThread implements Runnable {
    private static int count=0;
    private final int threadId;

    public MyThread() {//ex1.1 Use synchronized function to ensure that MyThread is safely and uniquely assigned a threadId.
        synchronized (MyThread.class) {
            this.threadId = count++;
        }
    }


    public void run () {
        while (!Thread.currentThread().isInterrupted()) {
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println("Hello World! I'm thread" + threadId + ". The time is " +  time.format(formatter) + ".");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Stop " + threadId);
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}



