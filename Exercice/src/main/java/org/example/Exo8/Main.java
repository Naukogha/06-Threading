package org.example.Exo8;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static int nonAtomic = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread[] atomicThreads = createAtomicThreads();
        for (Thread thread : atomicThreads) thread.start();
        for (Thread thread : atomicThreads) thread.join(); // Attendre la fin de tous les threads
        System.out.println("Valeur finale atomique : "+atomicInteger.get());
    }


    private static Thread[] createAtomicThreads(){
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
        }
        return threads;
    }
}
