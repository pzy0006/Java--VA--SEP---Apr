package com.example.javavaapr.week6;

/**
 *  redis
 *      pro
 *      1. good performance
 *      2. frequently accessed data
 *      3. temporary data
 *      cons
 *      1. strong consistency between cache and db
 *
 *
 *      server - cache
 *        |
 *       DB
 *      1. cache aside
 *          read:
 *              a. read from cache
 *              b. if find the data -> return it
 *              c. if cannot find the data -> load the data from db, save to cache(TTL)
 *          write:
 *              a. remove data from cache
 *              b. update database
 *      2. read / write through
 *          server - cache - DB
 *
 *
 *      Redis cluster
 *      hash slot : 20k
 *      Leader      Leader      Leader          Leader
 *      1 ~ 5k      5k ~ 10k    10k ~ 15k       15k ~ max
 *     followers..
 *
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Git
 *
 *  Main ---------------------------------1.0                   production env
 *                                          \
 *  Release Branch -------------------------1.0-----1.1------1.2-------2.0 uat/release env
 *
 *  Development Branch ----------------------------------------------------------------------- dev env
 *                                \             /PR
 *  Feature Branch                 ------------  local env (laptop)
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  CI/CD
 *  PR -> DEV branch -> trigger CI/CD pipeline (jenkins/ codebuild codedeploy/gitlab)
 *      1. build
 *      2. test (unit test, some integration test)
 *      3. report (Sonarqube) : code coverage(Jacoco) / sanity check ...
 *      4. package : docker image + push to docker repository(ECR)
 *      5. deploy : ECS / EKS
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  docker
 *      1. dockerfile
 *          FROM (pull jvm from xxx docker repository )
 *          (?) mvn clean package...
 *          WORKDIR ..
 *          COPY app.jar xx
 *          EXPOSE ...
 *          ENTRY ['java', '-jar', 'app.jar']
 *      2. docker image
 *      3. docker container
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  ECS
 *      1. task definition
 *          EC2 / Fargate(serverless)
 *          docker image location
 *          size
 *          ALB / load balancer
 *          health check
 *          cloudmap
 *          cloudwatch
 *      2. service 1 - m task
 *         horizontal scaling
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  agile : concept
 *  scrum : impl of agile
 *      backlog(TODO list)
 *      sprint : 2 weeks
 *      Jira (platform / software)
 *      1. sprint planning meeting
 *          difficulty level : 1, 2, 3, 5, 8
 *          time : 1 point = 2h / 4h / 8h
 *      2. backlog refinement meeting
 *      3. daily stand up
 *      4. retrospective meeting (review meeting)
 *      5. demo review
 * daily work
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   Team Size (3 ~ 8) people
 *
 *   manager
 *   full stack developers
 *   scrum master(?)
 *   QA(?)
 *   BA(?)
 *   dev ops team(?)
 *   shared DBA
 */