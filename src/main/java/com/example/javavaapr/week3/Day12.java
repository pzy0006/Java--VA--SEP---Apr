package com.example.javavaapr.week3;

/**
 * ThreadPool Size
 *
 * 1. IO task : 80% io + 20% cpu = (1 / 20%) * cpu number + 1
 * 2. CPU task : Cpu core + 1
 */

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture
 */
class CFTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + " : before test");
        CompletableFuture<Integer> res = test();
        res.join();
        System.out.println(Thread.currentThread() + " : after test");
    }

    public static CompletableFuture<Integer> test() {
        List<CompletableFuture<Integer>> futureList = new ArrayList<>();
        futureList.add(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 5;
        }));
        futureList.add(CompletableFuture.supplyAsync(() -> 10));
        return CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]))
                .thenApply(VOID -> futureList.stream().map(CompletableFuture::join).reduce(0, Integer::sum))
                .orTimeout(2000, TimeUnit.MILLISECONDS);
    }
}

/**
 * -- select *
 * -- from hr.employees
 *
 * -- select first_name as fn, last_name as ln
 * -- from hr.employees
 *
 * -- SELECT first_name AS fn, last_name AS ln
 * -- FROM hr.employees
 *
 * -- select *
 * -- from hr.employees
 * -- where employee_id > 120 and employee_id < 150
 *
 * -- select *
 * -- from hr.employees
 * -- where employee_id < 120 or employee_id > 150
 *
 * --aggregation function: max , min , avg , count , sum
 *
 * -- select max(salary)
 * -- from hr.employees
 *
 * -- select count(*)
 * -- from hr.employees
 *
 * -- select count(COMMISSION_PCT)
 * -- from hr.employees
 *
 * -- select *
 * -- from (select * from hr.employees)
 *
 * -- select e.employee_id, e.salary
 * -- from hr.employees e
 * -- where e.salary > (select avg(salary) from hr.employees)
 *
 * --practice1
 * --retrieve 2nd highest salary from employees table
 * -- SELECT SALARY
 * -- FROM HR.EMPLOYEES
 * -- ORDER BY SALARY DESC
 * -- OFFSET 1 ROW FETCH NEXT 1 ROW ONLY;
 *
 * -- select * from (Select * from employees order by salary desc limit 2) order by salary asc limit 1
 *
 * -- select max(e.salary)
 * -- from hr.employees e
 * -- where e.salary < (select max(salary) from hr.employees)
 *
 * -- select max(e.salary)
 * -- from hr.employees e
 * -- where e.salary < 24000
 *
 * --rank() vs dense_rank() and window function
 * -- select *
 * -- from (
 * --         select e.*, dense_rank() over (order by e.salary desc) as rank
 * --         from hr.employees e
 * --      )
 * -- where rank = 2
 *
 * -- select e1.salary
 * -- from hr.employees e1
 * -- where 1 = (select count(distinct(salary)) from hr.employees e2 where e1.salary < e2.salary)
 *
 *
 * tomorrow: group by , join, left join, right join .. index
 *
 * from next week:
 *     rahul: 10:30 EDT ~ 12:30 EDT
 *             office hour (?)
 *             mock section (everyone needs to join)
 *     afternoon: 2pm - 4pm edt
 */