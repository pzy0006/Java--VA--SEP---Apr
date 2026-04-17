package com.example.javavaapr;

import java.sql.Time;
import java.util.concurrent.*;

public class DayFour {
    /**
     *
     * @param args
     *
     * when you are building a large system - more users, more modules...
     * what can go wrong with your large system?
     * 1: resource exhaustion(cpu is limited!!!!)
     *  Imagine that spinning up a new thread for every incoming request -> expensive  for CPU!!!!!
     * 2: race condition:
     *      when two threads read and write the same data(shared resource) at the same time,
     *      the result depends on which one gets there first  - and that order is not guaranteed.
     * 3: Deadlock: two threads, each holding a resources that other one needs.
     *      Thread A holding resource B, for next step/ task, Thread A needs resource A
     *      Thread B holding resource A for next ste/task, Thread B needs  resource B
     *      your service/system just freezes
     *  4: performance imbalance.  more threads does not always give you better performance
     *      too few thread it makes your cpu idle, too more threads it makes your cpu too busy to switch taks
     *
     *
     *   how to solve it
     *
     *   executorService
     *   completable Future
     *   1: runAsync
     *          (Runnable):
     *          (Runnable, executor)
     *   2:supplyAsync
     *          (Supplier):
     *          (Supplier, Executor)
     *    runAysnc vs supplyAsync is about whether your task(s) return a value
     *
     *
     *    do we use Executors to create thread pool: NO!!!!!
     *    the biggest issue for executors class is that the default thread pools use  an unbounded queue (this queue is
     *    used to store tasks that are waiting for cpu resource to deal with).
     *    what do you mean by an unbounded queue: it means your queue does not have size, you can
     *    have as many as tasks you can have like, 1M , 10M ......
     *
     *    what do your team configure instead?
     *    you need to consider key decisions: like how many core threads to keep alive, what the max
     *    thread count is, how large the queue can grow, how long idle threads should survive,
     *    to improve user experience: you need to design rejection policy: give a feedbakc to user
     *    says'hi there, we are receiving a lot requests, please try later"
     *
     *    Thread pool Executor  class is your answer!!!!
     *
     *     ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue)
     *
     *
     *    Corepoolsize: The number of threads that are always kept alive in the pool
     *                  Even when there no tasks
     *
     *      maximumPoolSize: the max # of threads the pool can ever create,
     *      TimeUnit: once the pool scales beyond the core size, any extra threads that
     *      sit idle for more than some time (seconds) will be automatically destroyed
     *      and then back the value of Corepoolsize
     *      workQueue: this is tasks waiting room. when all core threads are busy,
     *      new tasks line up here instead of immediately creating new threads
     *
     *
     *
     *      real example
     *      you have ecommerce platform
     *      you want to check all exported orders for 2025
     *
     *      your FrontEnd Buton -> user click "check all exported orders for 2025"
     *      1: you send post request to api/v1/orders/export/{2025}
     *      2:backend controller
     *          1: instantly hands off the job, return something to user, like say"our system is doing you request now, please wait"
     *      3: Threadpool Executor
     *              corePoolSize =4
     *              maxPoolSize =8
     *              queue size = 100
     *              if queue is full - reject with "hi there, we have too much request, please wait!"
     *              if slot is available -> assign to worker thread
     *      4: worker thread (one of 4 - 8)
     *          1: query database (paginated)
     *          2: assemble data
     *          3: upload to object(excel, world, diff type of file) storage
     *          4: save download link to database
     *      5: mark your task is complete
     *      6: you can download it
     *
     *
     *
     *
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//        System.out.println(completableFuture.get());
//
//        System.out.println("###############################");
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        },executorService);
//        System.out.println(completableFuture1.get());
//
//        executorService.shutdown();

//        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "Hello, this is my first CompletableFuture";
//        });
//        System.out.println(completableFuture2.get());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 60L,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(100)
        );



    }
}
