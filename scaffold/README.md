# User scaffolding and tools

## Getting started
Quick Setup:
 * print maven version `mvn -version`
 * compile: `mvn compile`
 * cleaning up: `mvn clean` 
 * building the final jar: `mvn clean package`
 * Run the command `java -jar target/energy-kafka-1.0-SNAPSHOT.jar server src/main/resources/api.yml`
 * Go to Terminal and run `bash`
 * Test the app with REST call `curl localhost:8080/api/status?id=b1`

Postgres on Mac:
```
brew install postgresql
// Start the server
pg_ctl -D /usr/local/var/postgres start
psql postgres
```
Note: DeviceApiServer is creating table
`dbDao.createTable(config.deviceTable)`
  