package org.example;

public class ThreadDemo  extends Thread {
    private int number;
    //class constructor
    public ThreadDemo(int number) {
        this.number = number;
    }
    //run method => execution code for thread
    public void run() {
        int counter = 0;
        int numInt = 0;
        //prints the number till specified number is reached, starting from 10
        do {
            numInt = (int) (counter + 10);
            System.out.println(this.getName() + " prints " + numInt);
            counter++;
        } while(numInt != number);
        System.out.println("** Correct! " + this.getName() + "printed " + counter + " times.**");
    }
}
