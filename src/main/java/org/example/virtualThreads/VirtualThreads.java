package org.example.virtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello Folksdev");
        };

        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();) {
            executorService.execute(task);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
