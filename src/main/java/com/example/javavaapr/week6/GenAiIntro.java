package com.example.javavaapr.week6;


/**
 *  LLM
 *      input: what is kafka
 *
 *      [kafka] + next token list[{is: 0.8}, {create: 0.3}]
 *      [kafka is] + next token
 *
 *      1. seed
 *      2. temperature
 *
 *
 *     user
 *      | http request
 *  Api Gateway
 *      |
 * Stream Lambda
 *      |
 *  LLM model
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *   user
 *    |
 *   mcp -> resources
 *
 *   routes
 *   "order info" -> query order db
 *   "get log info" -> read from s3
 *   ".." -> api / db / resources
 *
 *   Langchain chain / graph
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *   RAG (vector DB)
 *
 *   AWS OpenSearch
 *   1. Semantic Search
 *   2. Keyword Search
 *   3. hybrid search = 1 + 2
 *
 *   Input chunks (must have overlapped area)
 *   1. based on subtitle
 *   2. fixed token per chunk
 *   3. split chunk based on paragraph / semantic meaning
 *
 *   Feed chunks to vector DB
 *   1. setup domain / filters
 *   2. chunks -> embedding -> in vector DB
 *
 *
 *   Search Chunks
 *   1. what is kafka? -> embedding -> use algorithm to find similar chunks
 *   2. top K chunks
 *   3. return x chunks
 *
 *   Improve the accuracy
 *   1. get a suitable algorithm in vector DB
 *   2. rerank
 *   3. better chunking strategy
 *   4. prompt / input
 *   5. cache the result
 *   ....
 *
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *    ElasticSearch
 *
 *    doc1: "hello world"
 *
 *    hello : [doc1]
 *    world : [doc1, doc2]
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *          user
 *           |
 *       agent / hardcode configuration
 *       /  \   \
 *    LLM   RAG  MCP
 *      \    |  /
 *          LLM -> merge result -> generate answer
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Bedrock : FM / LLM models
 *    Bedrock Knowledge Base + OpenSearch : RAG service + VectorDB
 *    Bedrock GuardRail:
 *      a. mask / redact
 *      b. filter content
 *      c. filter PII
 *      d. grounding / faithful scores...
 *    Bedrock Evaluation Job
 *
 *
 *
 *

 1. US internship / working exp

 1.please write down design document for your most recent project.
 design document includes
     1. features / functionalities  / system purpos + overview / clients, why
     2. database schema (tables)
     3. high level design (microservice architecture) and provide module details
     4. rest api design (design 2 - 4 rest apis)
     5.Data flow, prepare 2 - 3 data flow diagram (example: when user client some buttons to upload some files, what happens next, how does request go through your services)
     6. message queue story
     7. biggest challenge(technical challenge)
     8. aws
     9. how did you monitor your application(log monitor / jvm monitor / api monitor / performance apm monitor)
     10. a story about production support
     11. a story about performance tuning
     12. a story about most recent api you developed
     13. a story about ETL , ML pipeline + model training + inference serving
     14. a story about GenAI, LLM, MCP, RAG
 2.Prepare stories based on your resume: example,  where did you use multi-threading in your last project? Where did you use builder design patterns in your last project?
 3. Come up team size
 4. Design a ci/cd pipeline flow to (AWS / local) depends on your resume project (if you want to keep AWS)
 5. daily user / TPS / QPS
 6. frontend story
 7. monitor tools (jvm , api performance, alert, log, APM monitor and other monitor tools)
 8. what metrics + alerts do you have
 9. what do you save in log (what fields, diff correlation id, trace id, span id.. other fields)

 upload doc to google doc -> send link to me
 Deadline is next Friday 10am edt
 */