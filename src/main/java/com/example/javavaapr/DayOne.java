package com.example.javavaapr;

import java.util.ArrayList;
import java.util.List;

public class DayOne {
    /**
     *
     *
     * Day 1
     * Object: two properties
     *      1: state: current data
     *      2: behaviors:
     *
     * OOP
     * 1: polymorphism  it means: one name, many behaviors
     * In java it means : the same method name can behave differently depending on the situation
     *  Overloading: same method name, but different parameters
     *      different names:
     *         1: different number of parameters
     *         2: differernt types of parameters
     *         3: different order of parameters
     *
     *  class Calculator{
     *
     *      int add(int a, int b){
     *          return a + b;
     *      }
     *      int add(int a, int b, int c){
     *          return a + b + c;
     *      }
     *  }
     *
     *  Overriding: same name and happens bewteen parent class and child class.
     *  class Animal{
     *      void makeSound(){
     *
     *
     *      }
     *  }
     *
     *  class Dog extends Animal{
     *          @Override
     *          void makeSound(){
     *              ....
     *          }
     *  }
     *
     * In java, can data members be overridden?
     *  No, data members cannot be overridden.
     *
     *  2: Encapsulation:
     *      protect its own data and control how that data is accessed or modified
     *   in java
     *   data(field) are kept private
     *   class BanckAccount{
     *       private String firstName;
     *       private double balance;
     *       //getter and setter for your all private fields
     *   }
     *
     *   3: Abstraction
     *      hiding implementation of your method
     *      In java, we two keywords: abstract and interface
     *      abstract class: (is - a) represents what something is and is used to share code and state
     *      interface: represents what something can do (can - do) and is used to define contracts and
     *      capabilities.
     *
     *                              abstract                        interface
     *      keyword             abstract                                interface
     *      inheritance         extends                                 implements
     *      constructor         allowed                                 not allowed
     *      member variables    instance variable allowed               only constants (public static, private)
     *      regular method          allowed                             default, static, private
     *      multiple inheritance    not                                 yes
     *
     *
     *    4: Inheritance
     *          classes can be created from your parent class(other class) by using inheritance

     *     the diamond problem
     *               A Class
     *              / \
     *              B  C
     *              |   |
     *                D
     *                Java does not support multiple inheritance of c lasses mainly to avoid
     *                complexity and ambiguity
     *         Class A{}
     *         class B  extends A{}
     *         class C  extends A{}
     *         class D extends B, C{} -> you are not allowed to do so..
     *
     *         interface A{}
     *         interface C{}
     *         interface d{}
     *         class B implements A,C,D this is allowed in java
     *
     *
     *
     *
     *
     *         in primitive type
     *         byte, short, int, long, float, double -> 6
     *         boolean, char
     *
     *
     *         wrapper types: wrapper types offer more functions compare to primitive type
     *         byte -> Byte
     *         short -> Short
     *         int -> Integer
     *         long -> Long
     *         float -> Float
     *         double -> Double
     *         char -> Character
     *         boolean -> Boolean
     *
     *
     *         be careful the range of your wrapper type when you trying to compare the value
     *
     *         Autoboxing vs Unboxing
     *         Autoboxing -> primitive type to wrapper type
     *         int -> Integer
     *         double -> Double
     *         Unboxing -> wrapper type to primitive type
     *         Integer -> int
     *         Double -> double
     *
     *
     *                  primitive type               wrapper type
     *                      actual value                     object reference: address
     *  NUll?                   No                              Yes
     *  has method              No                              Yes, many functions
     *
     *  String vs StringBuilder vs String Buffer
     *  String is immutable(not able to change)
     *  Stringbuilder and String Buffer are mutable, buffer are thread safe
     *
     *
     *  String pool : memory area where java stores shared string literals to
     *  save memory and improve performance
     *
     *  without String pool:
     *  String str1 = "Java"
     *  String str2 = "Java"
     *  String str3 = "Java"
     *  str1 , 2 and 3 are different object
     *
     *  with string pool
     *  only one "Java" is shared and stored -> leads save memory
     *  str1, 2 and 3 are pointing same address
     *
     *  String str1 = new String("Java")
     *  String str2 = new String("Java")
     *  str1 == str2 -> false -> it creates new objects (str1 and str 2 are different) in heap memory
     *
     *  Why string is immutable?
     *  changing one (str1) would  affect all others(str2, str3)
     *
     *  access modifiers
     *                      same class,    same package,   subclass (different package)    other classes
     *  private                 YES             NO              NO                              NO
     *  default                 Yes             Yes             No                              No
     *  protected               Yes               Yes           yes                         No
     *  public                  Yes             Yes                Yes                      Yes
     *
     *
     *
     *  "This" and "Super" in Java
     *  This :
     *          1: refer to current object's filed
     *             class Person{
     *                 String name;
     *                 Person(String name){
     *                     this.name = name;
     *                 }
     *             }
     *             Person person = new Person("Matthew")
     *             person.printName()
     *          2: call current class method
     *          class Person{
     *              void showMyName(){
     *                  this.print();
     *              }
     *              void print(){
     *                  System.out.print("my Name");
     *              }
     *          }
     *          3: call another constructor in the same class
     *              class Person{
     *                  String name;
     *                  int age;
     *                  Person(String name){
     *                      this(name, 0);
     *                  }
     *                  Person(String name, int age){
     *                      this.name = name;
     *                      this.age = age;
     *                  }
     *              }
     *
     *           4: pass current object as parameter
     *           class Test{
     *               void show(Test t){
     *                   sout("method call")
     *               }
     *               void call(){
     *                   show(this);
     *               }
     *           }
     *           5: return "this"
     *           class Person{
     *      *                  private String name;
     *      *                  private int age;
     *      *                  Person(String name){
     *      *                      this(name, 0);
     *      *                  }
     *      *                  Person(String name, int age){
     *      *                      this.name = name;
     *      *                      this.age = age;
     *      *                  }
     *
     *                          public Person setAge(int age){
     *                              this.age = age;
     *                              return this;
     *                          }
     *                          public Person setName(String name){
     *                              this.name = name;
     *                              return this;
     *                          }
     *      *              }
     *              Person.setAge(19).setName("John").set........
     *
     *      Supper:
     *      points to parent object
     *      call parent's functions
     *       call parent's constructor
     *       access parent field
     *
     *
     *       class Parent{
     *           String name = "Parent"
     *       }
     *       class Child extends Parent{
     *           String name = "Child";
     *           void show(){
     *               sout(super.name)
     *           }
     *       }
     *
     *      this vs super: "this" refers to current object, used for current classs members
     *                      "supper" refers to parent object, used for parent calss members
     *
     *
     *      Does Java use "Pass-by-value" or "Pass-by-reference" ?
     *      Java uses "pass by value"
     *
     *      for a parameter of a primitive type, the actual value is passed
     *
     *      for a parameter of an object(wrapper type), the value of the parameter contains
     *      a reference to an object. the value of reference(0x123456) is passed to your method.
     *
     *
     *      static vs non static
     *      static: it means that member belongs to class itself.
     *      it can be used for class, variable, block and method
     *
     *      facts about static
     *          1: non static variable cannot be accessed within the static class
     *          2: all static classes are nested classes\
     *          3: a static class or method is shared, it may has concurrent problem
     *       non static: we must use "new" keyword to create it.
     *
     *
     *
     *       Exception:
     *       Throwable calss is the root class of all errors and expcetions in java
     *       anything that can be thrown using throw or caught using catch
     *       must be a subclass of throwable
     *
     *       Object -
     *          Throwable -
     *              Error -outofMemory, StackOverFlow
     *              Exception
     *                  - runtimeexception
     *
     *         checked exception and unchecked exception
     *          checked: happening in compile time, if we do not used catch block or throw(s)
     *              we will receive unhandle exception.
     *
     *           unchecked exception
     *           it happens in runtime.
     *
     *
     *
     *         throws vs throw vs try - catch - finally block
     *                          throws                                   throw                             try - catch - finally block
     *   purpose        declare possible exception              throw an exception manually             handle exception
     *     where used  method                                   method body/ block                          code block
     *
     */
    public static void main(String[] args) {
        byte a = 10;
        short b = 100;
        int c = 1000;

        Integer i1 = 12; // 0X123456 [-128,127]
        Integer i2 = 12; // 0X123456
            // == here is trying to compare addresses of i1 and i2
        // 0X123456,
        System.out.println(i1 == i2); // true

        Integer i3 = 333; // 0X123457
        Integer i4 = 333; // 0X123458
        System.out.println(i3 == i4); // false

            //show();
    }
//    void show(){
//        System.out.println("Hello");
//    }
}
