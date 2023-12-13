import java.util.Scanner;

public class Main {
    private static final int MAX_THREADS = 10000;
    private static Thread[] threads = new Thread[MAX_THREADS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ended = false;
        enterOptions();
        int threadIndex = 0;

        while (!ended) {
            System.out.print("Enter an option: ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            char option = input.charAt(0);

            switch (option) {
                //ex1.1 check whether a is over maxthreads, if not run the thread.
                case 'a':
                    if (threadIndex < MAX_THREADS) {
                        threads[threadIndex] = new Thread(new MyThread());
                        threads[threadIndex].start();
                        System.out.println("Starting thread " + threadIndex);
                        threadIndex++;
                    } else {
                        System.out.println("Reached the upper limit of thread count.");
                    }
                    break;
                //ex1.1 use thread.interrupt to interrupt thread, if the threadID invalid throw error
                case 'b':
                    try {
                        int threadNum = Integer.parseInt(input.substring(1).trim());
                        if (threadNum < threadIndex) {
                            threads[threadNum].interrupt();
                            System.out.println("Stopping thread " + threadNum);
                        } else {
                            System.out.println("Thread does not exist.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid thread number.");
                    }
                    break;
                    //ex1.1 check wehter thread[i] is null then use thread.interrupt function to interrupt all threads.
                case 'c':
                    for (int i = 0; i < threadIndex; i++) {
                        if (threads[i] != null) {
                            threads[i].interrupt();
                        }
                    }
                    ended = true;
                    System.out.println("Stopping all threads and exiting program.");
                    break;
                default:
                    System.out.println("Invalid option. Please select from the options.");
            }
        }
    }

    public static void enterOptions() {
        System.out.println("Here are your options:");
        System.out.println("a - Create a new thread");
        System.out.println("b - Stop a given thread (e.g. 'b 2' kills thread 2");
        System.out.println("c - Stop all threads and exit this program");
    }
}