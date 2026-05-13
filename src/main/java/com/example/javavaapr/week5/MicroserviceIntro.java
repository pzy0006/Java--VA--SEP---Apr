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
 * 3. discovery service(spring cloud eureka + ribbon... AWS CloudMap)
 *
 *      serviceA  ->  serviceB(ip1, ip2, ip3, ip4)
 *            \
 *            discovery service
 *            serviceA: [ipX:portX]
 *            serviceB: [ip1:port1,  ip2:port2]
 *
 *      1. start serviceB node  / serviceA node
 *      2. node sends request to discovery service
 *      3. node register node info (ip, port, name) in discovery service
 *
 *      serviceA send http request http://serviceB/...
 *      1. service A query discovery service (find ip by "serviceB" name)
 *      2. discovery service returns [ip1:port1,  ip2:port2] to serviceA
 *      3. service A pick one of the ip , replace the http request endpoint
 *         http://serviceB/...  =>   http://ip2:port2/...
 *
 *
 * 4. config service (spring cloud config, AppConfig+SecretManager)
 *      1. save all properties in git repository
 *      2. start spring boot client -> it fetches properties from spring cloud config server
 *
 *      why we use it
 *      1. reload new updates during runtime without re-deployment
 *      2. help application encrypt / manage sensitive properties
 *
 *      spring cloud config git repo
 *          XXX-application-dev.properties
 *              username=ENC(XASDFASDFASDASDFASERASEFASDFASDFAS)
 *
 *      XXX-application spring boot loads properties at beginning (runtime)
 *      spring cloud config service sends decrypted username to XXX-application
 *
 * 5. circuit breaker (Hystrix, resilience4j..)
 *      serviceA -> serviceB
 *      1. in last X requests, Y requests fail
 *          change circuit breaker status / state
 *          open
 *              in last X requests, Y requests fail -> change status to close
 *          close
 *              service A will not send request to serviceB
 *              service A will return default method value / default response to user
 *              in the background -> serviceA checks serviceB health status
 *                          if serviceB still not responding -> keep "close" status
 *                          if serviceB is back -> we will change status to half open
 *          half open
 *              let X % request visit service B
 *              if any requests / Y % requests get timeout -> change status back to close
 *              if it's fine for Z mins..-> change status to open
 *
 * 6. message queue intro
 *      kafka
 *      rabbit mq , active mq
 *      sqs , sns
 *      ..
 *
 *      user uploads file
 *           |
 *         service1 -  queue - service2
 *           |
 *          DB
 *
 *      service1
 *      1. upload file to s3 + save metadata to DB
 *      2. publish uploaded message / status to queue
 *
 *      service2
 *      1. keep polling messages from queue
 *      2. do jobs based on message
 *
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
 *  8. deployment / ci, cd
 */