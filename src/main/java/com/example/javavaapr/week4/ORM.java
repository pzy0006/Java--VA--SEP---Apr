package com.example.javavaapr.week4;

/**
 *  How to use ORM / Hibernate / JPA
 *  1. configure DB connection info in application.properties : datasource
 *      username
 *      password
 *      url
 *      dialect
 *      ..
 *  2. configure pom.xml
 *      hibernate / spring data jpa dependencies
 *  3. configure session factory or entity manager factory
 *      database 1 - 1 data source 1 - 1 session factory / entity manager factory 1 - m entity manager / session 1 - 1 request
 *  4. create entity mapping
 *      @Entity
 *      @Table
 *      class Student {
 *          @ID
 *          @GeneratedType(..identity)
 *          private String id;
 *
 *          @Column("name")
 *          private String name;
 *
 *          @OneToMany(mappedBy="studentABCDEFG")
 *          private List<Teacher> teachers = new ArrayList<>();
 *      }
 *
 *      @Entity
 *      @Table
 *      class Teacher {
 *          @ID
 *          @GeneratedType(..identity)
 *          private String id;
 *
 *          @Column("name")
 *          private String name;
 *
 *          @ManyToOne
 *          @JoinColumn("foreign key")
 *          private Student studentABCDEFG;
 *      }
 *
 *      Many to Many -> 1 - m + m - 1
 *  5. create repository layer
 *      spring data jpa : interface extend JpaRepository
 *          interface XXRepo extends JpaRepository<XXType, String/Integer/Long> {
 *              @Query("customized jpql")
 *              xx findXXX();
 *
 *              xx findXXAndYY();
 *          }
 *      hibernate / jpa : interface + impl
 *          entity manager: createNativeQuery() / createQuery() / ...
 *                          persist(stu) -> insert new object
 *                          merge() -> insert if cannot find same row
 *                                     or
 *                                     update
 *
 *          session : save() / saveOrUpdate() / get() / load()
 *  6.  set @Transactional at service layer
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Lazy Loading vs Eager Loading
 *  "select s from Student s join s.teachers"
 *  Eager Loading: return everything
 *  Lazy Loading: only return student info
 *                "select s from Student s fetch join s.teachers"
 *
 *  N + 1 problem
 *  select list of student
 *  List<Student> students = entityManager.createQuery("..") //1 query
 *  for(Student s: students) {
 *      List<Teacher> teachers = s.getTeachers();
 *      sout(teachers.size()); //1 query
 *  }
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 * Questions in interview
 * 1. Why ORM
 *      a. object mapping (convert db result into entity pojo)
 *      b. connection pool
 *      c. criteria query
 *      d. hql , jpql, use function to generate sql query
 *      f. spring data jpa -> interface (less code)
 *      g. @transactional
 *      ..
 * 2. How to connect to diff databases
 *      a. diff datasource
 *      b. config data sources in configuration class
 *      c. create diff session factory / entity manager factory
 *      d. inject session / entity manager in repository
 * 3. diff Lazy loading and Eager loading
 * 4. what is N+1 issue
 * 5. how do you secure username and password
 *      a. secret manager(AWS)
 *      b. vault
 *      c. config service (encrypt + decrypt username password)
 * 6. what is sql injection
 *      String query = "select *..  from xx  where username = " + username + " and password = " + password;
 *
 *      username = "'xx' or true;"     "'xxx'; drop table xx"
 *
 *
 * Tomorrow:
 *   Security
 *
 */