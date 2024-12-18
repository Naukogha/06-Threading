package org.example.Exo13;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public class SharedObjectWithLock {
        ReentrantLock lock = new ReentrantLock();


        public void perform() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+" a acquis le verrou et utilise l'imprimante");
            } finally {
                lock.unlock();
            }
        }

    }
}
