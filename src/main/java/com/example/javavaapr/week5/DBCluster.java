package com.example.javavaapr.week5;

/**
 *
 * CAP
 *  consistency
 *  availability
 *  partition tolerance
 *
 * CP -> Strong Consistency
 * AP -> Eventually Consistency (BASE)
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   Single Leader Cluster (Primary Secondary / Leader Follower / Master Slave..)
 *
 *     write/read                 read
 *        |                        |
 *      Leader      -           Follower , Follower
 *       |
 *      Standby DB
 *
 *    Read from follower: better performance + not always getting strong consistency result
 *    Read from Leader : always get newest update
 *
 *    write ack :
 *      1. leader only = Leader + 0 followers
 *      2. Leader + X Followers = user gets success response if Leader + X Followers have got newest update
 *    *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *    Multi Leader Cluster
 *
 *    Leader1           Leader2             Leader3
 *    /     \
 *  Follower1   2           ....
 *    *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   All Leader = Leaderless
 *
 *          node1(0)
 *
 *                      node2(10k)
 *
 *         node3(20k)
 *
 *
 *   Replica Factor: 2   (example, in node2, node3)
 *   Write Consistency : 1 ~ replica factor
 *          -> node1 -> node2
 *                   -> node3
 *   Read Consistency : 1 ~ replica factor
 *      RC = 1
 *          -> node1 -> read from fastest node(node2, node3)
 *      RC = 2
 *          -> node1 -> read data from fastest node
 *                      get hash value from another node
 *
 *  R(2) + W(1) > RF (2)
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   Sequential IO
 *   Cassandra :
 *   -> write -> memtable(memory)  -> SSTable(sorted string table / immutable)(disk)
 *         |
 *      commit log (disk)
 *
 *    t1: insert id, name    [id: 5, name: Tom]
 *    t2: update name to Alex [name: Alex]
 *
 *    id: 5
 *    name: {t1: Tom} or {t2: Alex}
 *
 *  -> read -> memtable -> blooming filter -> merge possible sstable -> return result
 *
 *      blooming filter
 *
 *      apple , banana,
 *      hashing1 [][][][true(banana hash)][][][][][true(apple hash)][][][][][]
 *      hashing2 [][][true(apple hash, banana hash)][][][][][][][][][][][]
 *      hashing3 [][true(banana hash)][][][][][][][][][][][][true(apple hash)]
 *
 *      array1[hash1(val)] && array2[hash2(val)] && array3[hash3(val)] == true
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   MongoDB cluster
 *
 *                      mongos(gateway) --    config service
 *                /         |           \
 *           sharding1     sharding2     sharding3
 *           primary        primary
 *           secondary      secondary
 *           secondary      secondary
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   Partition key / Sharding key : sharding location
 *   Sorted key / Clustered key : index column in each sharding
 *
 *
 *   Homework 4 (use AI)
 * 1. Terraform to deploy the structure (api gateway + lambda)
 *     main.tf
 *     variables.tf
 *     outputs.tf
 *     use module
 *     create diff folder
 * 2. add AWS Cognito to your infrastructure
 * 4. use EC2 to host spring boot file upload
 *      api gateway -> private vpc link -> VPC[ALB -> EC2]
 *      a. setup VPC
 *      b. setup subnet in VPC, configure NACL on subnet
 *      c. set up security group on EC2
 *
 *      spring boot file upload
 *      a. use AWS library / aws sde .. dependencies
 *      b. connect to your S3 -> generate pre-signed url -> return it to user
 * 5. use chat gpt to generate csv data, sensor data, upload data to s3 using pre-signed url
 *    setup a trigger -> to trigger the step function
 * 6. create aws glue (ETL)
 *      a. create workflow in aws glue
 *      b. create catalog + data source is from s3
 *      c. create diff jobs
 *          job1 -> load csv from s3 + clean it -> save it back to s3 -> pass file name to next job
 *          job2 -> load cleaned csv file -> convert it to parquet
 * 7. use Step function to orchestrate aws glue + sagemaker training (train your model, upload model to s3)
 *    after aws glue workflow is finished -> step function should trigger sagemaker training (read csv) -> generate model -> upload model to s3
 * 8. serve the model through sagemaker endpoint
 *
 * Deadline May26 10am EDT
 * Take aws screenshots -> convert to PDF
 * Push code + pdf to github
 */