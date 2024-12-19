package org.example.Exo20;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int threadCount = 10000;
        int sleep = 100;

        long[] nativThreadResult = nativ(threadCount, sleep);
        long[] virtualThreadResult = virtuel(threadCount, sleep);

        System.out.println("Threads natifs :");
        System.out.println("Temps d'exécution : " + nativThreadResult[0] + " ms");
        System.out.println("Consommation mémoire : " + nativThreadResult[1] + " bytes");

        System.out.println("Threads virtuels :");
        System.out.println("Temps d'exécution : " + virtualThreadResult[0] + " ms");
        System.out.println("Consommation mémoire : " + virtualThreadResult[1] + " bytes");

        System.out.println("Différences :");
        System.out.println("Temps : " + (nativThreadResult[0] - virtualThreadResult[0]) + " ms");
        System.out.println("Mémoire : " + (nativThreadResult[1] - virtualThreadResult[1]) + " bytes");
    }

    public static long[] nativ (int threadCount, int sleep){
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i < threadCount; i++) {
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                thread.start();
            }
        }catch (OutOfMemoryError | Exception e){
            System.out.println("Erreur avec les threads natif");
        }

        long endTime = System.currentTimeMillis();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        return new long[]{(endTime - startTime), (memoryAfter - memoryBefore)};
    }


    public static long[] virtuel (int threadCount, int sleep){
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i < threadCount; i++) {
                executor.execute(() -> {
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }

        long endTime = System.currentTimeMillis();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        return new long[]{(endTime - startTime), (memoryAfter - memoryBefore)};
    }

}
