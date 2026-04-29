package com.example.javavaapr.week3;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * reflection
 */
public class Day10 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        Day10Student stu = new Day10Student();
//        stu.setId(5);
//        System.out.println(stu.getId());
        Class<Day10Student> clazz = Day10Student.class;
        Constructor constructor = clazz.getConstructor();
        Day10Student stu = (Day10Student)constructor.newInstance();
//        System.out.println(Arrays.toString(clazz.getDeclaredFields()));
//        Field field = clazz.getDeclaredFields()[0];
//        field.setAccessible(true);
//        field.set(stu, 10);
//        Method method = clazz.getDeclaredMethod("getId", null);
//        System.out.println(method.invoke(stu, null));
        MyA annotation = (MyA)clazz.getDeclaredAnnotations()[0];
        System.out.println(annotation.value());


    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyA {
    String value() default "abc";
}

@MyA(value = "123")
class Day10Student {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Day10Student{" +
                "id=" + id +
                '}';
    }
}
