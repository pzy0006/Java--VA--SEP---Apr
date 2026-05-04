package com.example.javavaapr.week4;
//
//B tree
//
//        root []
//
//        insert 10
//
//        root [10]
//
//        insert 20
//
//        root [10, 20]
//
//        insert 30
//
//        root    [20]
//        /   \
//        [10]   [20, 30]
//
//        insert 5
//
//        root    [20]
//        /   \
//        [5, 10]   [20, 30]
//
//        insert 40
//
//        root    [20,  30 ]
//        /   |     \
//        [5, 10]  [20]   [30, 40]
//
//        insert 50
//
//        root         [30]
//        /   \
//        [20]     [30, 40]
//        /   |      |     \
//        [5, 10]  [20]   [30]  [40, 50]
//
//        ============================================================================================================
//
//        B+ tree
//
//        root         [30]
//        /   \
//        [20]     [30, 40]
//        /   |      |     \
//        [5, 10]<->[20]<->[30]<->[40, 50]
//        rowid
//        |
//        |
//        |
//        ---------------->  table
//        id, name        rowid, txid, rollback pointer
//
//
//
//        index access path
//        1. index unique scan
//        2. index range scan
//        3. index full scan
//        4. index fast full scan
//        full table scan
//        join strategy
//        1. merge sort join
//        2. nested loop join
//        for(int i = 0; i < n; i++) {
//        for(int j = 0; j < m; j++) {
//        if(A[i] == B[j]) {
//        //...
//        }
//        }
//        }
//        3. hash join
//        [][][][][][][][] buckets
//        get hashing value from the key
//        hashing value + length of buckets => index
//        perform join in each bucket
//
//        --index unique scan
//        select *
//        from hr.employees
//        where employee_id = 202 or employee_id = 203
//
//        --index range scan
//        select *
//        from hr.employees
//        where employee_id >= 202 and employee_id <= 203
//
//        --index full scan
//        select *
//        from hr.employees
//        order by employee_id
//
//        select employee_id
//        from hr.employees
//
//        select /*+ full(e) */ *
//        from hr.employees e
//        order by employee_id
//
//        select  /*+ index(e) */ *
//        from hr.employees e
//
//        select /*+ leading(e) index(d) use_merge(d e) parallel(10) */ employee_id, first_name, last_name, department_name
//        from hr.employees e join hr.departments d on e.department_id = d.department_id
//
//
//        =====================================================================================================================
//        Bitmap index
//        How Oracle works

//Bitmap index
//
//id, state  rowid      |      rowid,   NJ, NY, VA
// 1,  NJ                               1 , 0 , 0
// 2,  NY                               0 , 1 , 0
// 3,  NJ                               1 , 0 , 0
// 4,  VA                               0 , 0 , 1
//
//
// NJ : 1010
// NY : 0100
// VA : 0001
//
// in NJ or NY :  1010 | 0100 = 1110
// in NJ and NY:  1010 & 0100 = 0
//
//
//1. how to optimize sql query
//2. what is explain plan / execution plan
//3. when to use b+ tree
//4. when to use bitmap index
//5. when should we use index
//6. when should not we use index
//7. what hints do you know
//8. what are diff index access path, diff between index access path and full table scan