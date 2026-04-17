package com.example.javavaapr;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Daythree {
    /**
     *Java 8 new features:
     * 1: functional interface,
     * 2: lambda function
     * 3: stream api
     * 4: method reference
     * 5: optional
     *
     * questions:
     * how you can answer questions like a senior developer
     * Java 17 new features
     *
     * Java 21 new feature:
     *  virtual thread
     *
     *
     * Java 8 new features:
     * 1: functional interface
     *  in this functional interface, we have only one abstract method.
     *  you can add annotation @FuntionalInteface to your interface, but you do not have to
     *  can we have multiple method with default/ static? yes - you can - still valid ad functional interface
     *
     * common example:
     * runnable
     * callable
     * comparator : used in sorting java collections
     * Consumer
     * predicate - return true or false
     * ....
     *
     *
     *  example:
     *  @FunctionalInterface
     * public interface Callable<V> {
     *     /**
     *      * Computes a result, or throws an exception if unable to do so.
     *      *
     *      * @return computed result
     *      * @throws Exception if unable to compute a result
     *          V call() throws Exception;
     *      *
     * }
     *
     *
     * 2: Lambda expression :
     * it is a concise way to implement an function interface
     * it is an anonymous function  - function does not have function name, no class, can be
     * passed around lke a value
     *
     * 4 Scenarios to use lambda:
     * 1: no parameter  syntax: () -> System.out.print("hello, this is my first lambda");
     * 2: one parameter Syntax: (n) -> 2*n
     * 3: multiple parameter   syntax: (a,b) -> a + b
     * 4: multiple lines:      syntax: (n)->{
     *                                              int res = n +2;
     *                                              return res;
     *                                      }
     *
     *
     * 3: Stream api
     * It allows you to perform aggregate operations on java collections of elements...
     *  pipeline styling - step1: filter out ,  step2: sort,  step3: peek the first one
     *
     *  stream api, we have two types of function:
     *  1: intermediate function
     *          1: filter() - keep matching element: if employee.age> 20 && employee.age<30
     *          2: map() - transform elements: emloyee.getFirst.toUppercase();
     *          3:sorted() - sort elements
     *          4: distinct() - remove duplicates
     *          5: limit/skip()
     *          6: peek() -- check the first element
     *          7: flatmap()... flatten nested streams....
     *  2: terminal function
     *          1: collect() - gather all element into java collection
     *          2: forEach() -  loop earch element
     *          3:count() -  count element
     *          4:max/min() - return max/min element
     *          ....
     *  why ??????
     *  if you are using for loop/ while loop, like traditional way to deal with your java collection
     *  you are changing the original data collection
     *  but with stream api, you are not modifying the original data collection
     *  check below example
     * List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
     *         numbers.stream().filter(n -> n % 2 == 0)
     *                 .forEach(System.out::println);
     *
     *         for(int num : numbers){
     *             System.out.println(num);
     *         }
     *
     *
     * Collections vs stream api
     * 1: collections are data structures that store data in memory, whereas stream api
     * processes data in a functional way without storing data in memory
     * 2: Collections can be modified by adding,removing, whereas stream api
     * does not modify the original data but create a new stream with the result of the operations
     *
     * 3: collections provides methods for accessing and iterating elements, whereas stream api
     * provides a set of operations that you can use to process your data.
     *
     * what if your data set is very huge????
     * Java 8 offers parallel stream api that split the work into smaller streams that be processed in
     * parallel.
     *
     * syntax: names.parallelStream() and intermedia functions and terminal functions are same with stream api
     *
     *
     * 4: optional
     * null pointer exception
     * we can use optional in java to handle situation where a value may or may not be present.
     * -> eliminating the need for null checks and avoiding NullPointerException
     *
     * class BankAccount{
     *     private String accoutNumber;
     *     private Optional<Double> balance;
     *     Private Optional<String> password;
     * }
     *
     * IsPresent() vs IfPresent()
     * ispresent - check null value, return true if value is present, if value is null return false
     * '  public boolean isPresent() {
     *         return value != null;
     *     }
     * IfPresent() - take an action if the value is present, if the value is null then do not anything
     * public void ifPresent(Consumer<? super T> action) {
     *         if (value != null) {
     *             action.accept(value);
     *         }
     *     }
     *
     * Method reference: short version of lambda expression
     * the syntax: uses the double colon operator-> ::
     * 1: static method reference
     * when you call a static method, you can use it
     *          // this is lambda way
     *         Function<String, Integer> lambda = s -> Integer.parseInt(s); 
     *         // this method reference
     *         Function<String, Integer> ref = Integer::parseInt;
     *
     *  
     *  2: Instance method of a particular object
     *  when you want to call a method on an existing object
     *  syntax: object:: instanceMethodName
     *  list.forEach(System.out::println);
     *
     *  3: it refers to method that belongs to a the parameter of the lambda
     *  className:: instanceMethodName
     *  list.stream().map(String::toUpperCase)
     *  4: you can call constructor to create a new object
     *  List<String> list  = new ArrayList <>();
     *  List<String> list = ArrayList::new;
     *
     *
     *  maybe interviwer ask you
     *  1: what is functional interface?
     *      one abstract method - yes
     *      give an example - yes
     *      first thing you need to answer:
     *      1: it is an interface that has only one abstract method
     *      2: you can use @Functioninterface annotation to mark it - class level
     *      3: lambda function is good to mention
     *      4: give an example - example you just come up with, or example you did in your project
     *
     *
     *   2: what is stream api?
     *      1: process collections of data  in functional style - yes
     *      2: two types of function : give examples about functions - yes
     *      3: do not modify the original collection - yes - different between java collection and stream api
     *      4: pro tip: function interface, lambda function, and stream api - shows together  -
     *              tell the interviewer about function interface,  lambda function your know.
     *              you do not have to mention the defination about function interface / lambda,
     *              just mention keywords
     *    3: optional
     *    4: lambda expression
     *
     *
     *    Walmart -
     *    what are java 8 features
     *    what are java 17 new features
     *    what are java 21 new features
     *
     *    Java 17 new features
     *    1: sealed class -  restricted inheritance
     *      this is traditional way
     *      abstract class Car{}
     *      class Toyota extends Car{}
     *      class BMW extends Car{}
     *      class Banana extends Car{} - this is allowed!!!!!!
     *
     *      new way - using sealed and permits keyword to restricted inheritance
     *      public sealed class Car permits BWM,Toyota, Mazda{}
     *      class Toyota extends Car{} -> allowed
     *      class BMW extends Car{} -> allowed
     *      class Banana extends Car{} -> NOT ALLOWED!!!!!! - > compile error!!!!!
     *
     *     2: Record
     *     A record is a special kind of classs desinged to a immutable data carrier.
     *     instead of writing boilerplate code (like equals, hashcode, toString, getters, setters,...)
     *     public record User(Long id, String username, String email){}
     *
     *
     *
     *    Java 21 new features
     *    virtual thread is game changer!!!!
     *    what is a thread in java?
     *      a thread is the smallest unit of execution in java program .
     *      it is heavy, and managed by operating system, like MAC, Windows...
     *
     *      your Java code - new Thread() - thread.start() - JVM - makes a system call - operating sysmte
     *      - makes a system call will create OS thread (allocate memory, add env, add to OS scheduler)
     *      - OS scheduler decides when and where the thread runs -> CPU
     *      Managed by OS
     *
     *
     *    what is a virtual thread in java?
     *    *****it is an object, stored in memory(heap), managed by JVM*******
     *    your java code - new Thread() - thread.start() - JVM Scheduler (fully managed by JVM, virtual thread created)
     *    - mounts virtual thread onto a carrier thread
     *    - carrier thread talk to OS scheduler
     *
     *    one carrier thread could have as many as virtual thread
     *    M - N relation
     *
     *    carrier thread is just regular thread that the JVM uses to execute virtual threads.
     *
     *    virtual thread 1   virtual thread 2 ...  virtual thread N
     *                              |
     *                      carrier thread 1, ....  carrier thread M where N >> M
     *                       |
     *                       CPU core
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *     
     *
     *
     *

     *


     *
     *
     *
     *
     */
    public static void main(String[] args) {
       // List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
//        numbers.stream().filter(n -> n % 2 == 0)
//                .forEach(System.out::println);
//
//        for(int num : numbers){
//            System.out.println(num);
//        }

//        List<String> names = List.of("bmw", "toyota", "mazda");
//        names.stream()
//                .map(String::toUpperCase)
//                .forEach(System.out::println);
//
//
//        List<Integer> numbers = List.of(2,1,4,6,3,4,7,8,22,0,8);
//        numbers.stream().sorted().forEach(System.out::println);
//        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
//
//
//        numbers.stream().distinct().forEach(System.out::println);
//
//        List<String> longName = names.stream()
//                .filter(s -> s.length() > 3)
//                .collect(Collectors.toList());


        Optional<String> myName = Optional.of("Matthew");
        if(myName.isPresent()){
            System.out.println(myName.get());
        }

        myName.ifPresent(n-> System.out.println(n));
        

       


    }


}
