package org.example.Exo11;



public class BankAccount {
    static class IdGenerator{
        private static int id = 0;

        public static int generateId(){
            return id++;
        }
    }

    private static final Object lock = new Object();
    long solde = 0;
    Thread[] threads = new Thread[5];

    void deposit(){

    }

    void withdraw()throws InterruptedException {
        IdGenerator.id = 0;
        Thread[] threads = createThreads(() -> {
            
        });
        runThreads(threads);
        System.out.println("Valeur finale du compteur avec synchronisation : "+ IdGenerator.id);
    }

    // Methode pour créer des threads
    private static Thread[] createThreads(Runnable task){
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
        }
        return threads;
    }
    //Methode pour demarrer et attendre la fin de mes threads
    private static void runThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }
}
