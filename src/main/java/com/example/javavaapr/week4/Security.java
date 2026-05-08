package com.example.javavaapr.week4;


/**
 *  Asymmetric key: public key and private key
 *      public key encrypt -> private key to decrypt
 *      private key encrypt -> public key to decrypt
 *  Symmetric key
 *      same key to encrypt and decrypt
 *
 *  How to secure your application / microservice
 *  1. HTTPS(HTTP + TLS)
 *
 *                   CA (certificate authority)
 *                                             \
 *      browser                                 server(private key)
 *                     <- certificate
 *                        public key
 *
 *               <-> exchange some random numbers
 *
 *
 *      a. CA generates root public key and private key
 *         use private key to sign root certificate (public key)
 *      b. CA generate intermediate public key, and private key
 *         use root private key to sign intermediate certificate
 *      c. company generate server public key + server private key
 *         company will share server public key + other company info with CA
 *         CA sign server certificate by using intermediate private key
 *
 *
 *      a. user gets intermediate certificate + server certificate from server
 *      b. user will use local trusted root certificate (public key)
 *         to verify intermediate certificate
 *      c. intermediate certificate to verify server certificate
 *
 *  2. Authentication: get jwt or id token
 *      id token
 *  3. Authorization(access token) : role based control + JWT  / OAuth2.0
 *
 *      bearer jwt :
 *      header.payload.signature
 *      header.payload.encrypt(header.payload)
 *
 *      Authorization header: Bearer jwt token
 *
 *      OAuth2.0
 *            client
 *            |     \
 *          app -  security server
 *
 *
 *            client  -  3rd party login
 *              |
 *             app
 *
 *       1. click 3rd party login, redirect to their page
 *       2. input login info, click login, authorize
 *       3. 3rd party page will send redirect url?access_code=xxx
 *       4. client send access code to app server side
 *       5. app server will send access_code + client_id + client secret to 3rd party center
 *       6. 3rd party security center returns access token
 *
 *      role m - m scope = /xx read , /yy write
 *
 *  4. CORS
 *  5. CSRF (?)
 *          /bank website domain  -> jwt (http only cookie)
 *          /scam website domain -> <form>submit request to /bank website domain </form>
 *  6. Log injection... / sql injections / xml injections ...
 *  7. encrypt at rest
 *  8. DDOS
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Spring Security
 *  For jwt flow
 *  1. impl jwt filter
 *      get jwt from header
 *      verify jwt
 *      save user details / authentication obj in security context
 *  2. add jwt filter in filter chain
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Homework3.1 (ai):
 *      1. add spring security to homework1
 *      2. save user name , password in h2 db
 *      3. write user details and user details service
 *      4. create jwt filter to validate jwt
 *         save login identity -> security context
 *      5. use @PreAuthorize on top the endpoint
 *      6. don't use spring security built in login
 *         /auth/login
 *  Homework3.2 (ai):
 *      1. use chat-gpt / ai tool to generate alarm data in csv
 *      2. use isolation forest model to train alarm data -> identify false alarm
 *      3. dump the model into a file to your local
 *      4. create AWS free account
 *      5. create Api Gateway(post, /verify, pass data through request body) -> linked with AWS Lambda
 *      6. use Lambda SAM as local lambda development tool
 *      7. upload model to AWS S3
 *      8. setup libraries in lambda layer
 *      9. lambda load model from S3  -> serve the result through api gateway
 *      test api through Postman
 *
 * Deadline is next Thursday 10am EDT
 *
 * request -> api gateway -> lambda
 */