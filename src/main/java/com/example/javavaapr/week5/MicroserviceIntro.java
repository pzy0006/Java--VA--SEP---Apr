package com.example.javavaapr.week5;


/**
 * vertical scaling: more cpu, more disk, more memory ...
 * horizontal scaling: deploy more nodes / more servers
 *
 *
 *      LB
 *     /   \   \
 *  T1     T2  T3
 *
 * Monolithic
 * pros
 * 1. easy to setup
 * 2. request / function call between modules are fast
 * cons
 * 1. everything / all codes / modules sit in one project
 * 2. cannot use diff languages
 * 3. deployment
 *
 * Microservice
 *          user
 *          |
 *      api gateway - service3(node6)
 *         |
 *      service1(node1, node2)
 *         |
 *      service2(node3, node4, node5)  -  mq - service6
 * pros
 * 1. scalability
 * 2. message queue
 * 3. handle more request ..
 * 4. diff languages in diff nodes / services
 * 5. easier to deploy new version
 *
 * cons
 * 1. complex + boundary
 * 2. better fault tolerance
 * 3. more monitors
 *      application monitors
 *      latency monitors
 *      app performance monitors
 *      db monitors
 *      message queue monitors
 *      log monitors..
 *      ..
 *
 * How do we design microservice/ what do we need to consider when we design microservices
 * 1. api gateway
 *      a. centralized entry
 *      b. redirect request to diff services based on headers..endpoints..
 *      c. log request info
 *      d. redirect request to security service
 *      e. get global unique id
 *          1. for global transaction
 *          2. request flow(co-relation id / trace id)
 *
 *         long 64 bits
 *         [.........][2 ~ 3 bits machine id ][2 ~ 3 bits process id][2 ~ 3 bits thread id][5 ~ 10 sequence id]
 *          timestamp
 *
 * 2. centralized security service
 *      a. AWS Cognito
 *      b. Lambda Authorizer
 *      c. customized security center / provider
 *
 *      for applications
 *      a. spring security -> send request -> security provider(cognito / other providers)
 *      b. spring security uses public key to verify jwt , get scope from jwt / read , load scope from DB
 *
 * 3. discovery service
 * 4. config service
 * 5. circuit breaker
 * 6. message queue intro
 * 7. take care of global transactions
 *       insert1    insert2    insert3
 *        |         |           |
 *      DB1        DB2         DB3
 *
 *     begin db1 tx
 *     insert1
 *
 *     begin db2 tx
 *     insert2
 *
 *     begin db3 tx
 *     insert3
 *     commit db3 tx -> success
 *
 *     commit db2 tx -> fail
 *  8. deployment / ci, cd intro
 */