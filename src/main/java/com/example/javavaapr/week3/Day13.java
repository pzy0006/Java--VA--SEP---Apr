package com.example.javavaapr.week3;

/**
 * --group by
 *
 * -- select department_id, count(*) as cnt
 * -- from hr.employees
 * -- where department_id is not null
 * -- group by department_id
 * -- having count(*) > 5
 *
 * -- rank()/dense_rank() over (order by column_name desc / asc)
 *
 * --practice: write query to retrieve 2nd highest salary in each department
 *
 * -- SELECT *
 * -- FROM (
 * --         SELECT e.department_id, e.salary, DENSE_RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rnk
 * --         FROM hr.employees e
 * -- )
 * -- WHERE rnk = 2
 *
 * -- select department_id, rank() over (ORDER BY salary DESC)
 * -- from employees
 * -- where rank = 2
 * -- group by department_id;
 *
 *
 * -- SELECT department_id, COUNT(*) AS emp_count
 * -- FROM (
 * --     SELECT e.department_id, e.salary,
 * --            DENSE_RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rnk
 * --     FROM hr.employees e
 * -- ) sub
 * -- WHERE rnk = 2
 * -- GROUP BY department_id;
 *
 * -- dept_id,  salary, emp_id
 * --   1         10      1
 * --   1         20      2
 *
 * --   2         10      3
 * --   2         50      4
 *
 * --   3         40      5
 *
 * --   group by dept_id  -> count(*)
 *
 *
 * --join
 *
 * -- emp table
 * -- emp_id dept_id
 * --  102       20
 *
 *
 * --  dept table
 * -- dept_id, name
 * --   20      IT
 *
 * --   result set
 * -- emp_id, first_name, last_name, depart_id, dept_name
 *
 * select * from hr.employees
 * select * from hr.departments
 *
 * --inner join vs outer join vs cross join
 *
 * select employee_id, first_name, last_name, e.department_id, department_name
 * from hr.employees e join hr.departments d on e.department_id = d.department_id
 *
 * select employee_id, first_name, last_name, e.department_id, department_name
 * from hr.employees e left join hr.departments d on e.department_id = d.department_id
 *
 * select employee_id, first_name, last_name, d.department_id, department_name
 * from hr.employees e right join hr.departments d on e.department_id = d.department_id
 *
 * select employee_id, first_name, last_name, d.department_id, department_name
 * from hr.employees e full join hr.departments d on e.department_id = d.department_id
 *
 * select employee_id, first_name, last_name, e.department_id, department_name
 * from hr.employees e, hr.departments d
 * where e.department_id = d.department_id
 *
 * -- cross join
 * -- A   B           ->
 * -- 1   4               1, 4
 * -- 2   5               1, 5
 * -- 3                   2, 4
 * --                     2, 5
 * --                     3, 4
 * --                     3, 5
 *
 * --practice: count employee number in each department , return dept_id, dept_name, count
 * SELECT COUNT(e.employee_id) AS emp_count,
 *        d.department_id,
 *        d.department_name
 * FROM hr.employees e RIGHT JOIN hr.departments d ON e.department_id = d.department_id
 * GROUP BY d.department_id, d.department_name;
 *
 *
 * --union, union all, intersect, minus/except
 *
 * select count(*)
 * from (
 *     select employee_id
 *     from hr.employees
 *     union
 *     select employee_id
 *     from hr.employees
 * )
 *
 * select count(*)
 * from (
 *     select employee_id
 *     from hr.employees
 *     union all
 *     select employee_id
 *     from hr.employees
 * )
 *
 *
 * select count(*)
 * from (
 *     select employee_id
 *     from hr.employees
 *     where employee_id < 150
 *     intersect
 *     select employee_id
 *     from hr.employees
 *     where employee_id > 140
 * )
 *
 * -- A minus B == A - shared(A, B)
 * select count(*)
 * from (
 *     select employee_id
 *     from hr.employees
 *     minus
 *     select employee_id
 *     from hr.employees
 *     where employee_id >= 150 or employee_id <= 140
 * )
 *
 * --interview quesitons
 * 1. join two table
 * 2. filter result set (age > 200, ... )
 * 3. 2nd highest salary
 * 4. Nth highest salary from employee table : return employee info + salary
 * 5. count employee number in each department
 * 6. show Nth highest salary in each department : return department_id, name, nth_salary
 *
 *
 * Index(B, B+ tree, Bitmap index, execution plan, hint..) + Transaction (MySQL isolation level)
 */