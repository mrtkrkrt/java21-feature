package org.example.virtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtulThreadss {

    public static void main(String[] args) {

        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello Folksdev");
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
