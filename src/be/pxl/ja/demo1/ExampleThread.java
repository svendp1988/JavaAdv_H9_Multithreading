package be.pxl.ja.demo1;

public class ExampleThread extends Thread {
    @Override
    public void run() {
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
        System.out.println("ExampleThread is called: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread exampleThread = new ExampleThread();

        exampleThread.start();
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
        System.out.println("Main thread is called: " + Thread.currentThread().getName());
    }
}
