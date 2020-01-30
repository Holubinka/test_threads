Created a simple spring boot app with the following conditions:
a. Created a variable(counter) that can be shared by all the clients, 
the initial value of the counter is 50.
b. There is an ENDPOINT that will receive two request parameter, the first one will increase the number of producer threads. The second parameter will increase the number of consumer threads.
     The response will be HTTP 201 Created success status.
     
     http://localhost:8086/threads?producerThreads=10&consumerThreads=15
     
  // created endpoint works as in task description,
  producerThreads --- number of producer which increase counter
  consumerThreads --- number of consumer which decrease counter
     
c. Using MySQL, persist the request's information received by the app to the database.
d. The producer threads will increase the value of the counter while the consumer threads will decrease it.
e. Print in the console the current value of the counter when it changes and print which producer/consumer is responsible for the change.

        Counter value: 51. Counter was increment by: producer_5
        Counter value: 50. Counter was decrement by: consumer_3
        Counter value: 49. Counter was decrement by: consumer_9
        Counter value: 48. Counter was decrement by: consumer_1
        Counter value: 49. Counter was increment by: producer_1
        Counter value: 50. Counter was increment by: producer_6
        .......................................................
        Counter value: 2. Counter was increment by: producer_3
        Counter value: 1. Counter was decrement by: consumer_8
        Counter value: 2. Counter was increment by: producer_8
        Counter value: 1. Counter was decrement by: consumer_4
        Counter value: 0. Counter was decrement by: consumer_11

f. The threads will run in parallel and continue until the counter reaches 0 or 100. Persist in the database the timestamp when the counter reaches 0 or 100.
g. Create another ENDPOINT that will receive one parameter, the parameter will change the current value of the counter.
  The response will be HTTP 200 Ok success status.
  
      http://localhost:8086/counter?counterValue=50
   
   // As in task description, 
   counterValue -- parameter that change current counter
  
h. Spring Boot App is dockerized:

To be possible run project under docker:
1) Pull and run mysql from dockerHub 
    a) Connect to the mysql container and create database 'testdb'.
    b) Update application properties with mysql container credentials. 
2) Build jar file in Spring Boot with Maven
3) Standard  docker build and run:
    docker build . -t user-mysql   // where 'user-mysql' is name of project .jar
    
    docker run -p 8086:8086 --name user-mysql --link mysqldbtest:mysql -d user-mysql


Please feel to free to contact me if you will have more questions: vitalii.holubinka@crystalogic.net