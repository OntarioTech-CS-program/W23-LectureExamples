package org.example;

public class TestThreadMain {
    public static void main(String [] args) {
        System.out.println("Starting thread_1...");
        //create a thread class instance
        Thread thread_1 = new ThreadDemo(15);
        //start the thread thread_1
        thread_1.start();
        try {
            //wait for thread_1 to die
            thread_1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Starting thread_2...");
        Thread thread_2 = new ThreadDemo(20);
        //start thread_2
        thread_2.start();
        System.out.println("main() is ending...");
    }
}