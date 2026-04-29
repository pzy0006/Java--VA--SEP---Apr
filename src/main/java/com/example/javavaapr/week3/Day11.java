package com.example.javavaapr.week3;

/**
 *  CPU     CPU
 *  L1      L1
 *  L2      L2
 *  L3      L3
 *   |
 *  Shared memory
 *
 *
 *  volatile i++
 *  1. read
 *  2. update
 *  3. write
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Singleton
 */
class EagerLoadingSingleton {
    private static final EagerLoadingSingleton instance = new EagerLoadingSingleton();
    private EagerLoadingSingleton() {}
    public static EagerLoadingSingleton getInstance() {
        return instance;
    }
}
class DoubleCheckLazyLoading {
    private volatile static DoubleCheckLazyLoading instance;

    private DoubleCheckLazyLoading() {
        if(instance != null) {
//            throw ..
        }
    }

    public static DoubleCheckLazyLoading getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckLazyLoading.class) {
                if(instance == null) {
                    instance = new DoubleCheckLazyLoading();
                }
            }
        }
        return instance;
    }
}
enum OrderStatus {
    PENDING, XX;
}
class SingletonTest {
    public static void main(String[] args) {
//        OrderStatus status = OrderStatus.PENDING;
    }
}
/**
 * java multithreading
 *
 * Synchronized + volatile (built in)
 * Reentrant lock based on volatile + CAS + LockSupport(let thread wait / notify)
 * AtomicInteger.. based on CAS + while
 *
 * CAS (object, field, expected value, new value)
 * for the field inside this object
 *  -> if real value == expected value
 *      -> we assign new value to it
 *          -> success -> return true
 *          -> fail -> return false
 *  -> if not -> return false
 */

interface Day11Service {
    int get();
    void print();
}

class Day11ServiceImpl implements Day11Service {
    @Override
    public int get() {
        return 10;
    }

    @Override
    public void print() {
        System.out.println("this is print function");
    }
}

class Day11ServiceImplSub extends Day11ServiceImpl implements Day11Service {
    @Override
    public int get() {
        System.out.println("before");
        int val = super.get();
        System.out.println(val);
        System.out.println("after");
        return val;
    }

    @Override
    public void print() {
        System.out.println("before");
        super.print();
        System.out.println("after");
    }
}

class Day11ServiceInterceptor implements Day11Service {
    private final Day11Service service;

    public Day11ServiceInterceptor(Day11Service service) {
        this.service = service;
    }

    @Override
    public int get() {
        System.out.println("before");
        int val = service.get();
        System.out.println(val);
        System.out.println("after");
        return val;
    }

    @Override
    public void print() {
        System.out.println("before");
        service.print();
        System.out.println("after");
    }
}


class Day11Test {
    public static void main(String[] args) {
//        Day11Service s = new Day11ServiceImplSub();
//        s.get();
//        s.print();

        Day11Service s2 = new Day11ServiceInterceptor(new Day11ServiceImpl());
        s2.print();
    }
}

/**
 *  Dynamic Proxy
 */

class Day11InvocationHandlerImpl implements InvocationHandler {
    private final Day11Service service;

    public Day11InvocationHandlerImpl(Day11Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = method.invoke(service, args);
        System.out.println(method);
        System.out.println(res);
        System.out.println("after");
        return res;
    }
}
class DPTest {
    public static void main(String[] args) {
        Day11Service realImpl = new Day11ServiceImpl();
        Day11Service proxy = (Day11Service) Proxy.newProxyInstance(
                DPTest.class.getClassLoader(),
                new Class[]{Day11Service.class},
                new Day11InvocationHandlerImpl(realImpl)
        );
        proxy.print();
    }
}

/**
 * RDBMS: Mysql, Oracle, Postgre, SQL Server
 * Nosql:
 *     json/bson : MongoDB
 *     column db : Cassandra
 *     key-value db : DynamoDB
 *     time series db : prometheus(?)
 * In-memory RDBMS: H2, Derby ..
 * Cache : Redis / Memcache / local server cache / CDN
 * Object Storage : S3
 * File System: EFS, Hadoop(?)
 * Graph DB :
 * Vector DB : OpenSearch(AWS), pgvector(?) in postgre
 */