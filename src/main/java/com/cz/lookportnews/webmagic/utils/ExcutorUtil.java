package com.cz.lookportnews.webmagic.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorUtil  {
    public static ExecutorService executorService = Executors.newCachedThreadPool();


    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public void shutDown(){
        executorService.shutdown();
    }

}
