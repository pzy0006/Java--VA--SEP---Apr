package com.example.javavaapr.week4;


/**
 * 1 - 1
 *    example:
 *    teacher 1 - 1 student
 * 1 - m
 *    example:
 *    teacher 1 - m student
 *    teacher: id(pk), name
 *    student: id(pk), name, t_id(fk)
 * m - m
 *    example
 *    teacher m - m student
 *    student: id(pk), name
 *    teacher: id(pk), name
 *    student_teacher: id(pk), s_id(fk), t_id(fk)
 *
 * 1st : cannot have multiple value in same cell
 *      name
 *     FN,LN
 * 2nd : non-prime attributes fully depend on prime attributes
 * 3rd : no transitive relationship among non-prime attributes
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *   Survey1: name, gender, age
 *   Survey2: name, DOB, car
 *   Survey3: name, food, color,
 *
 *
 *   solution1:
 *      col1, col2, col3, col4, col5..
 *   solution2:
 *      info_table: name, gender, DOB
 *      survey1: ..
 *      survey2: ..
 *   solution3:
 *      name, gender, DOB, json_col
 *   solution4:
 *      entity attribute value pattern
 *
 *      id, col_name, col_type,         col_value , survey_id
 *      1 ,  "name" ,  "varchar/string", "Tom"   ,    s1
 *      2 ,  "gender",  ".."          ,  "male"  ,    s1
 *
 *
 *      survey
 *      id,  description, ..
 *      s1,   ...
 *
 *
 * 1. one to many + many to one + lazy loading
 * 2. do not create table from orm
 *    set ddl auto update = false
 *    show query logs
 * 3. lazy loading vs eager loading (concept)
 */