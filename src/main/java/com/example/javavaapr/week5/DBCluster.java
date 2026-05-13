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
 */