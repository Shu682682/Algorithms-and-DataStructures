public class TrafficController {
    public volatile boolean bridge=false;
    //ex2.2 use synchronized to confirm only one thread can run during this period.
    public void enterLeft() throws InterruptedException{
        synchronized (this){
            while(bridge){
                wait();
            }
            bridge=true;//let the thread wait.
        }
    }
    public void enterRight() throws InterruptedException {
        synchronized (this){
            while(bridge){
                wait();
            }
            bridge=true;
        }
    }
    //ex2.2 use synchronized function to confirm thread safety and use notifyAll to evoke other waiting method.
    public void leaveLeft() throws InterruptedException {
        synchronized (this){
            notifyAll();
            bridge=false;
        }
    }
    public void leaveRight() throws InterruptedException {
        synchronized (this){
            notifyAll();
            bridge=false;
        }
    }

}