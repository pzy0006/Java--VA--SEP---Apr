package com.example.javavaapr.week3;

/**
 *  What will happen if we click url in our browser?
 *  1. check DNS server
 *  2. build tcp connection: source ip source port, dest ip dest port
 *
 *
 *      laptop(private ip) - NAT (public ip pool) - Tomcat (dest ip)
 *                                                    |socket build connection
 *                                                   ThreadPool [][][][][][][] -> Thread1 (connection1)
 *                                                                                  |
 *                                                                            decode http request data
 *                                                                            /students, get , ...
 *                                                                                 |
 *                                                                           Spring MVC:
 *                                                                           Dispatcher Servlet "/*"
 *                                                                                 |
 *                                                                            HandlerMapping
 *                                                                                 |
 *                                                                            Controller
 *                                                                                 |
 *                                                                               Service
 *                                                                                |
 *                                                                              Repo
 *                                                                               |
 *                                                                              DB
 */


/**
 * Rest API
 * 1. Why Rest api
 *      a. http
 *          method: get / post / delete / put
 *          status: ..
 *          header: ..
 *      b. json/xml in request body / response body
 *      c. stateless
 *      ...
 *
 *                 user
 *                  |
 *             Load balancer(ip)
 *             /    \   \
 *         Tomcat Tomcat Tomcat
 *          \         |     /
 *          global cache (redis , mem cache)
 *              or
 *              DB
 *
 * 2. How to design Rest api
 *      a. what rest endpoints should we create : CRUD ? Just get student or get all students?
 *          interviewer: impl CRUD + get all students
 *      b. do I need to design table structure
 *          interviewer: yes
 *      c. do i need to run it ?
 *          1. yes -> ???
 *          2. no -> where should I write it ?
 *      d. do i need to handle exceptions ? global exception?
 *          interviewer: no
 *      e. do i need to write test
 *          interviewer: let's impl basic CRUD rest api first
 *
 *  Student Table:
 *      id (pk), name
 *
 *  Rest API design:
 *      1. Create students
 *          endpoint: /student
 *          http method: post
 *          status code: 201 Creation / 200 OK / 400 Bad Request / 500 Internal Server Error
 *          header:
 *              Content-type: json
 *              Accept: json
 *              Authorization: token ...
 *              ..
 *          request body :
 *              {
 *                  name: xxx
 *              }
 *          response body :
 *              {
 *                  relocationId: xxx / id: xxx ,
 *              }
 *      2. Get student by id
 *          endpoint: /student/{id}
 *          http method: get
 *          status code: 200 OK / 400 Bad Request / 404 Resource Not Found / 500 Internal Server Error
 *          response body :
 *              {
 *                  id: ..,
 *                  name:..
 *              }
 *      3. Get all students
 *          endpoint: /student&name=xx,age=xx
 *          http method: get
 *          status code: 200 OK / 400 Bad Request / 500 Internal Server Error
 *          request param: filters...
 *          response body :
 *              {
 *                  content: [
 *                      {
 *                          id: ..,
 *                          name:..
 *                      },
 *                      {
 *                          id: ..,
 *                          name:..
 *                      }
 *                  ]
 *              }
 *      4. delete student by id
 *          endpoint: /student/{id}
 *          http method: delete
 *          status code: 200, 204 Success / 400 Bad Request / 404 Resource Not Found /  500 Internal Server Error
 *          request body: ?
 *          response body: ?
 *      5. update student by id
 *          endpoint: /student/{id}
 *          http method: put(update entire resource) / patch(update partial resource)
 *          status code: 200, 204 Success / 400 Bad Request / 404 Resource Not Found /  500 Internal Server Error
 *          request body:
 *              {
 *                  name: ..
 *              }
 *          response body: ?
 *
 */