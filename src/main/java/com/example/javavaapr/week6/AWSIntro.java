package com.example.javavaapr.week6;

/**
 *  Region
 *      Infra fault tolerance recovery process
 *      1. active active
 *      2. active passive
 *      3. warm standby
 *      4. pilot light
 *  Zone
 *  IAM
 *      role / policy
 *  VPC
 *      NACL (network access control list) (stateless)
 *      subnet
 *          private subnet
 *          public subnet -> internet gateway
 *      route table
 *      vpc endpoint
 *
 *  EC2
 *      types
 *          1. on demand
 *          2. reserved
 *          3. scheduled
 *          4. spot
 *      ASG (auto scaling group)
 *      Security Group (stateful)
 *      EBS (storage)
 *      AMI
 *      IAM
 *
 *  Lambda
 *      1. 15 minutes maximum running time
 *      2. cold start
 *      3. limitation on memory / cpu / disk
 *      4. limitation on code base size / layers size
 *      5. max concurrent requests:  1000 (?)
 *
 *  ALB (application -> layer 7)
 *      1. in one region
 *  NLB (network -> layer 4)
 *
 *  Cloudwatch
 *      log
 *      metric
 *      alert
 *      event bridge
 *  CloudTrail
 *      audit
 *  X ray
 *  CloudMap: discovery service
 *  CloudFront: CDN
 *      1. edge location
 *      2. CDN -> S3
 *  CloudFormation
 *  SQS
 *      1. visibility timeout
 *      2. FIFO: order
 *      3. Standard: faster + no order
 *  SNS
 *      sns -> sqs
 *          -> sqs
 *  Appsync: microservice configuration service
 *  AWS Connect
 *      1. phone call flow
 *      2. chat flow
 *
 *      [prompt: hi this is xxx, thanks for calling xxxx]
 *        |
 *      [recording for xxx]
 *        |
 *      [can you input your last 4 digit ssn] -> lambda -> DB
 *        |yes                  |no
 *        next                repeat this process
 *        |
 *      in queue [waiting for next available agents]
 *        |
 *      answer the call
 *        |
 *      transfer your call to another depart [put your call into another queue]
 *
 *  AWS Lex / Polly / Transcribe
 *  AWS SageMaker
 *  S3
 *      1. built in index based on prefix name of your file
 *      2. immutable
 *      3. version
 *      4. encryption
 *          a. s3 default encrypt key
 *          b. get key from KMS
 *          c. pass the key in request header
 *      5. lifecycle hook
 *      6. cross region replicate
 *  S3 Glacier
 *      1. archived data
 *      2. Bulk / standard / expedite
 *
 *  Secret Manager
 *      1. DB username password
 *      2. ..
 *  Route53
 *      1. DNS
 *      2. Load balancing cross diff region
 *      3. health check for each region
 *  RDS
 *      1. oracle / mysql / postgre
 *      2. multi zone deployment
 *      3. standby : availability
 *      4. deploy more read node for read performance
 *  Aurora
 *      1. mysql / postgre
 *      2. more expensive than RDS
 *      3. every thing is better than RDS
 *  Dynamodb
 *      1. partition key + sorted key = primary key
 *      2. key - value pair db
 *      3. global secondary index (separate table)
 *  ElasticCache
 *      1. redis
 *      2. memcache
 *  VPN / Direct Connect
 *      1. vpn
 *      2. direct connect
 *
 *
 *  Tomorrow :
 *  redis
 *  ECS, ECR
 *  Deployment
 *  pipeline
 *  agile
 *  daily work
 */