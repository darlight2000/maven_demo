package site.isscloud.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.Future;

@Component
public class AsyncTask {
    @Async
    public Future<String> asyncTask1() {
        System.out.println(LocalDateTime.now()+": task 1 started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now()+": task 1 finished");
        return new AsyncResult<String>("task1-result:Ok");
    }

    @Async
    public Future<String> asyncTask2() {
        System.out.println(LocalDateTime.now()+": task 2 started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now()+": task 2 finished");
        return new AsyncResult<String>("task2-result:Ok");
    }
}
