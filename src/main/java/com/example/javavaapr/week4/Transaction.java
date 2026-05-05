package com.example.javavaapr.week4;

/**
 * Lock:
 *      Write Lock(exclusive lock) : block read + write lock
 *      Read Lock(share lock) : block read lock
 * Write lock : update, insert, delete , select...for update
 * Read lock : select .. for share
 * No lock : select
 *
 *
 * Example
 *
 * Begin tx
 * update
 * insert
 * insert
 * ..
 * Commit tx
 *
 *
 * Transaction:
 *      Property
 *      Atomicity
 *      Consistency
 *      Isolation Level
 *          MySQL: Read Uncommitted, Read Commit, Repeatable Read, Serializable
 *          Oracle: Read Committed, Serializable, Read Only
 *
 *          Read Uncommitted : select uncommitted data
 *          Read Committed :
 *              case1
 *                      user1                           user2
 *              select * -> result set 1
 *                                                  another user insert / update / delete + commit tx
 *              select * -> result set 2
 *              result set 1 != result set 2
 *
 *              case2
 *                      user1                           user2
 *              select * -> result set 1
 *                                                  another user begin tx
 *                                                  insert / update / delete
 *              select * -> result set 2
 *              result set 1 == result set 2
 *                                                  commit
 *
 *          Repeatable Read
 *                      user1                           user2
 *              select * -> result set 1
 *                                                  another user insert / update / delete + commit tx
 *              select * -> result set 2
 *              result set 1 == result set 2
 *
 *         Serializable
 *              all select statements are using share lock / read lock
 *
 *      Durability
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 * MVCC
 * id, name, rowid, tx_id, rollback pointer
 *  1,  Alex, yyy ,  2   ,   |
 *                           |
 *                           1 ,  Tom,  xxx ,  1   ,    null
 *
 *
 * read view = committed tx id list / range
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *  Optimistic lock
 *
 *  example:
 *      id, salary
 *      1 ,   10
 *
 *  user1          begin tx     select salary = 10      salary++         update salary = 11   commit
 *                  |               |                       |               |                   |
 *          ================================================================================================> timeline
 *                          |                   |                   |               |                   |
 *  user2               begin tx            select salary = 10      salary++      update salary = 11    commit
 *
 *      id, salary,  version
 *      1 ,   10  ,  number/timestamp
 *
 *  user1          begin tx     select salary = 10      salary++         update salary = 11   commit
 *                                   version = 1                         version = 2
 *                                                                       where version = 1
 *                  |               |                       |               |                   |
 *          ================================================================================================> timeline
 *                          |                   |                   |               |                   |
 *  user2               begin tx            select salary = 10      salary++      update salary = 11   get exception
 *                                              version = 1                       version = 2
 *                                                                                where version = 1
 *
 *
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *\
 * 1. what is transaction in db
 * 2. what is ACID
 * 3. what are isolation levels in mysql / oracle
 * 4. diff read committed vs repeatable read
 * 5. what is optimistic lock / how do you handle lost update issue / how do you avoid overwrite issue
 */