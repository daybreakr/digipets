package com.daybreakr.digipet.utilities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExecutors {
    private static final ExecutorService IO_EXECUTOR = Executors.newSingleThreadExecutor();

    public static void runOnIoThread(Runnable runnable) {
        if (runnable != null) {
            IO_EXECUTOR.execute(runnable);
        }
    }
}
