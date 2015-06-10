package io.belov.memory;

import io.belov.soyuz.utils.thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by fbelov on 11.06.15.
 */
public class MemoryConsumer {

    private static final Logger log = LoggerFactory.getLogger(MemoryConsumer.class);

    public void consume(int threadsCount, Runnable action) {
        log.info("Creating {} threads", threadsCount);

        ExecutorService threadPool = Executors.newFixedThreadPool(threadsCount);
        Collection<Future> futures = new ArrayList<>();

        for (int i = 0; i < threadsCount; i++) {
            futures.add(threadPool.submit(action));
        }

        futures
                .stream()
                .forEach((future) -> {
                    try {
                        future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });

        MemoryLogger.log();
    }

}
