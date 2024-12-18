package org.example.Exo12;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(SharedResource::addList, "Thread1");
        Thread thread2 = new Thread(SharedResource::removeList, "Thread2");
        Thread thread3 = new Thread(SharedResource::addList, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Liste final : "+SharedResource.liste);
    }
}
