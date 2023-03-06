Goal
---
Create simple http client app for fetching data from REST mocked service.

How to run REST mocked service
---
docker compose up -d

REST mocked service
---
❯ curl -X GET -H "Content-Type: application/json" http://localhost:9080

{"message": "Testing data"}%  

❯ curl -X GET -H "Content-Type: application/json" http://localhost:9080/sub.data

[{"message": "Testing subdata 1"},{"message": "Testing subdata 2"}]%     

https://www.baeldung.com/java-httpclient-map-json-response