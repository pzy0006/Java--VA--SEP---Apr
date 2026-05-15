package com.example.javavaapr.week5;

/**
 * Message Queue
 * Queue model
 * Producer1                                Consumer1[m1]
 * Producer2    [][][][][][][][][m1]        Consumer2
 * Producer3                                Consumer3
 *
 * Pub-Sub model
 * Producer1                                Consumer1[m1]
 * Producer2    [][][][][][][][][m1]        Consumer2[m1]
 * Producer3                                Consumer3[m1]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Kafka
 *                                          Consumer Group1
 * producer     T1P1[][][][][][][][m1]      Consumer1 p1
 *              T1P2[][][][][][][][m2]      Consumer2 p2
 *                                          Consumer3(standby)
 *                                          Consumer4(standby)
 *
 *                                          Consumer Group2
 *                                          Consumer5 p1 + p2
 *
 * hash("key") -> hashing -> index of the partition
 * 1. how to ensure message order in kafka
 * 2. what is partition + offset
 * 3. what is consumer group
 * 4. what is re-balance
 * 5. how do we create pub-sub in kafka
 * 6. broker
 *
 *          broker1  T1P1(Leader)
 *                   T1P2(Follower)
 *
 *          broker2  T1P1(Follower)
 *                   T1P2(Leader)
 *
 *          broker3  T1P1(Follower)
 *                   T1P2(Follower)
 * 7. producer ACK
 *      0:
 *      1: message must be committed on Leader node
 *      All: message must be committed on all brokers
 *    consumer ACK
 *      exact one:
 *      at least one:
 *          pull message
 *          consumer process message
 *          consumer commit message
 *      at most one
 *          pull message
 *          consumer commit message
 *          consumer process message
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Change Data Capture + Outbox pattern
 *
 *   user
 *    |
 *  service  -  message queue
 *    |
 *   DB
 *
 *  service wants to commit data in DB, and send message to mq
 *
 *
 *   user
 *    |
 *  service
 *    |
 *   DB ->  message queue
 *
 *   1. service commit data + message in DB
 *      DB
 *      data table (normal data)
 *      outbox table (messages)
 *
 *      begin tx
 *      insert data to data table
 *      insert message to outbox table
 *      commit tx
 *  2. CDC service keeps pushing messages from outbox table to message queue
 *      cdc send message to queue
 *      commit mq tx
 *      cdc update db
 *      cdc commit db tx
 *
 *
 *
 *  DB  <- CDC service -> push the changes to message queue -> consumer / audit
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * SAGA pattern
 *
 *      s1  -> mq ->  s2
 *      db1           db2
 *
 *     s1:
 *     1. begin tx
 *        -10 db1
 *        commit tx
 *        cdc send message to mq
 *     2. begin tx
 *        insert balblablla to db2
 *        error / rollback / exception -> it fails -> rollback queue (mq) -> +10 in DB1
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 */