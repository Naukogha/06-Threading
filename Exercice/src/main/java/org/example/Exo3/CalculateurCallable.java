package org.example.Exo3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculateurCallable  {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            return "Thread '" + Thread.currentThread().getName() + "' a terminé.";
        };
        Future<String> result = executor.submit(callable);
        System.out.println(result.get());
        executor.shutdown();
    }
}
