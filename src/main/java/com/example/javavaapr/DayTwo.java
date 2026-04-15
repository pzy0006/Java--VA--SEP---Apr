package com.example.javavaapr;

import java.util.*;

public class DayTwo {
    /**
     *
     * @param args
     *
     *  Generic:
     *  this generic in java allows you to write classes/ methods/ interfaces that
     *  work with any data type
     *
     *   wildcard - > "?"
     *
     *              Object Class - top level
     *
     *                     | extends
     *                     Number  -second level
     *                     |
     *           Byte, Short, Integer, Long, Float, Double.. - last level
     *
     *
     *       Upper bounded wildcard - <? extends Number>
     *           means? -> this type, or any subclass of it
     *
     *
     *       Lower bounded wildcard -<? super Integer>, <? super Double>, <? super Float>...
     *           means? -> this type, or any superclass of it
     *             public  static double sum(List<? super Integer> list){
     *             this method can accept: List<Integer> , List<Number>, and List<Object>
     *
     *
     * Java Collections
     * ArrayList: it is a resizable array. (array: int[] -> fixed size)
     *  it is backed by a plain array of Object class
     *  it implements random access interface which allows you access any objects in your array list
     *  at the same speed - O(1)
     *resizing function:  new cap = old cap  + 0.5 old cap = 1.5 old cap
     *
     * ModCount : counts how many times the list has been modified
     *  Java will remember your expectedModCount and compare current ModCount with it
     *  if it is not equal, then you will receive an exception immediately
     *  if it is equal, then nothing will happen (Happy!!!)
     *
     *  fail fast - any bad thing happen to your system, and your system will give an exceptions
     *  fail safe -  you do not what happen in your system.
     *
     *
     * time complexity:
     * add(e) - O(1)
     * add at index - add(i,e) - O(N)
     * remove at index  - remove(i) - O(n)
     * get by Index - get(i) - O(1)
     * contains(e) - O(n)
     *
     * Stack + vector : two legacy collections
     * stack uses sychronized keyword to achieve thread safe(overhead, Array Deque is faster and commonly used not)
     * resize in stack is same as vector
     * resize for both: when you define capacity value, then the resize is new = Old + your value
     * if not, new = 1.5 old cap
     *
     * Linked List : stores each element in a separate node object,
     * each node holds the value + pointers(pre, and next)
     *
     * class Node<E>{
     *     E Item;
     *     Node<E> prev;
     *     Node<E> next;
     * }
     *
     *
     * <- [first element] -> <-[second element] -> <-[]
     *
     *                      Linked list                          Arraylist
     * Addfirst()               O(1)                                O(n)
     * addLast()                O(1)                                O(1)
     * add(i,e)                 O(n)                               O(n)
     * removeFirst()            O(1)                                O(n)
     * get(i)              O(n)                                     O(1)
     * Contains()           O(n)                                     O(n)
     *
     * ArrayList(A, B,C,D)
     * this is your memory space-> [A | B | C | D | ...] <- contiguous block
     *
     * LinkedList(A, B,C,D)
     * [Node A: prev, val, next]   <-> [Node B: prev, val, next] <->[Node C: prev, val, next] <->[Node D: prev, val, next]
     * somewhere in memory               somewhere in memory             somewhere in memory         somewhere in memory
     *
     *
     * Deque: it is double ended queue. FILO and FIFO
     *
     *
     * Priority Queue
     * in Java, the default priority queue is min heap, which means
     * every time you remove/add element, the lowest element will be the first one.
     *
     * Object[] for underlaying data structure.
     * [3, 5 , 10 ,7 , 9 , 15, 11]
     *               3 - top
     *              / \
     *             5 , 10
     *            /\   /\
     *           7 9   15 11
     * leftNode index = parent Node index * 2 + 1
     * rightNode index = parent node index * 2 + 2
     * parent node index = (child node index - 1) / 2
     *
     * siftUp() - keep min value at the top
     * siftDown() - keep max value at the top
     *
     *
     * offer()/add() - O(Logn)
     * poll() - O(Logn)
     * peek() O(1)
     * contains() - O(N)
     * remove(x) - O(N)
     *
     *
     * HashMap: key value pair data structure
     * operator: and: &, exclusive OR, inclusive OR, left shift, right shift
     *
     * \Node<K,V>[] table; -> [index 0] -[index 1] ....
     * after java 8: hashmap used linkedlist + red - black tree to store values so that
     * you have better performance.
     * Linked list ->  red - black tree
     * two conditions:
     *  1: a single bucket's chain reaches 9 nodes,
     *  2: the overall table cap is at least 64
     *
     *  red - black tree -> linked list
     *  this happens when the number of nodes in a three bin drops to 6 or fewer
     *
     *
     *  put process
     *   putVal(key, value):
     *    1: compute hash from key.hashcode(), then derive bucket index
     *              index = (n - 1) & hash
     *    2: if bucket is null (no collision):
     *        insert node directly
     *        jump to ....
     *
     *
     *    3: if bucket is not null(collision):
     *      1) if bucket is a red - black tree:
     *          search tree for duplicate key
     *          if duplicate found: replace it, done
     *          if no duplicate: insert new node into tree
     *      2) if bucket is a linked list:
     *          walk the list check each node for duplicate key
     *          if duplicate found: replace it, done
     *          if no duplicate: append new node at the end of the list
     *          check list length after appending:
     *              if length >= 9 AND table cap >= 64 -> convert it to red black tree
     *              if length >= 9 AND table cap < 64 -> trigger resize instead
     *
     *      4: if it was a duplicate key replacement  (step 3.1, 3.2)
     *              size does not increase, skip step 5
     *       5: increment size
     *          if size > threshold -> resize table  (double cap, rehash all entries)
     *
     *
     *              best case           worst case
     *     put      O(1)                    O(N)
     *     deletion  O(1)                    O(N)
     *     search   O(1)                    O(N)
     *
     *
     *
     *     TreeMap -> is a sorted map backed by a red black tree
     *     every key - value pair is stored as a node in the tree and the tree is
     *     always kept sorted by key
     *     node in treeMap
     *          key
     *          value
     *          left - pointer to left child (smaller keys)
     *          right - pointer to right child (lager keys)
     *          parent
     *          color - red or black for balancing
     *
     *
     *      how put works
     *      1: if tree is empty -> create root node, color it black, done
     *      2: start at root, walk down the tree:
     *          current key < node key -> go left
     *          current key > node key -> go right
     *          current key == node key -> replace it, done
     *
     *      3: insert new node at the empty spot found
     *      color it red initially
     *
     *      4: fix red - black violation (rotations + recoloring)
     *          at most 2 rotations need
     *
     *
     *     put() O(logN)
     *     get() O(logN)
     *     remove() O(logN)
     *     containsKey O(logN)
     *     containsValue O(N)
     *     ....
     *
     *     Tree map does not allow NULL value whereas you can only have one NULL in hashmap
     *
     *     Hashset: you cann't  have duplicate value in hashset
     *
     *     LinkedHashSet, LinkedHashMap - it is nothing but the order in which elements were inserted
     *
     *
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) {
            Printer<String> myString = new Printer<>();
            myString.setValue("Hello, this is Matthew from Antra");
            String myHello = myString.getValue();

            Printer<Integer> myInt = new Printer<>();
            myInt.setValue(100);

            List<String> list = new ArrayList<>();
            list.add("asjdkfhasdf");
            String s = list.get(0);
            list.set(1, "lkfjshgldks");

        LinkedList<String> ll = new LinkedList<>();
        ll.add("A");
        ll.get(1);
        ll.add(2,"B");


        Deque<String> deque = new LinkedList<>();
        deque.addFirst("asdfasdf");
        deque.addLast("asdfklfsdjgh");

        String first = deque.removeFirst();
        String last = deque.removeLast();

        for(String e: deque){

        }

        Iterator<String> iterator = deque.iterator();
        while(iterator.hasNext()){
            //.....
        }
        deque.add("jfjg");
        deque.offer("asdkjhfas");


        // you can do leet code  question called : build stack using deque


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);


    }
}
// Class level
class Printer<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static <T> T getFirstElement(List<T> list){
        return list.get(0);
    }

    public  static double sum(List<? extends Number> list){// this upper bounded wildcard
        // this method can accept List<Double>, List<Integer>, List<Short>.... the last level shown above
        double total = 0;
        for(Number n : list){
            total += n.doubleValue();
        }
        return total;
    }
}
