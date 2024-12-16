package org.example.Exo1;

public class MonPremierThread extends Thread {
    private final String threadName;

    public MonPremierThread(String threadName ) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0;i <= 10;i++){
            System.out.println(threadName+ " Compteur "+i);
        }
        System.out.println(threadName + " terminé");
    }
}
