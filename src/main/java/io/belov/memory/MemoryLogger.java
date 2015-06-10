package io.belov.memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fbelov on 11.06.15.
 */
public class MemoryLogger {

    private static final Logger log = LoggerFactory.getLogger(MemoryLogger.class);

    public static void log() {
        int mb = 1024*1024;

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        //Print used memory
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        //Print free memory
        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);

        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);

        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
    }

}
