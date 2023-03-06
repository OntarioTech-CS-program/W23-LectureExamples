package org.example;

//class implements Runnable interface
class RunnableDemo implements Runnable {
    private String message;
    //class constructor
    public RunnableDemo(String message) {
        this.message = message;
    }
    //run method
    public void run() {
        while(true) {
            System.out.println(message);
        }
    }
}
