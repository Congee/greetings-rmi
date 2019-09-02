# greetings-rmi Remote Method Invocation with Java

Sample project using Java RMI messaging.
Updated with more specific instructions to run the app.
This program can act as a server or a client but not both.
The program arguments are to determine that role.

## Build

``` bash
mvn clean package
```

## Runs
To run this program, three terminals are needed. Go to the project folder where
the project is built.

### Run Server
```bash
java -cp target/greetings-rmi-1.0-SNAPSHOT-jar-with-dependencies.jar edu.harrisburgu.cisc525.app.Main server //localhost:1099/GreetingServer
```

### Run Client
```bash
java -cp target/greetings-rmi-1.0-SNAPSHOT-jar-with-dependencies.jar edu.harrisburgu.cisc525.app.Main client //localhost:1099/GreetingServer "Johnny B Good"
```
