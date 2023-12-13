import java.util.concurrent.*;

public class Main3 {

   private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addProc(HighLevelDisplay d) {

	// Add a sequence of addRow operations with short random naps.
        for(int i=0;i<15;i++){
            d.addRow("CI-952"+i);
            nap(1000);
        }

   }

    private static void deleteProc(HighLevelDisplay d) {
	
	//Add a sequence of deletions of row 0 with short random naps.
        for(int i=0;i<15;i++){
            d.deleteRow(0);
            nap(4000);
        }
    }

    public static void main(String [] args) {
	final HighLevelDisplay d = new JDisplay2();
    //2.1 use synchronized function and run first thread.
	new Thread () {
	    public synchronized void run() {
		addProc(d);
	    }
	}.start();

    //2.1 use synchronized function and run second thread.
	new Thread () {
	    public synchronized void run() {
		deleteProc(d);
	    }
	}.start();

    }
}