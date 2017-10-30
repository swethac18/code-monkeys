# Homework - 2

## Twitter Integration using Karaf

As a prerequisite obtain a twitter developer token from [twitter apps](https://apps.twitter.com/) by clicking on "Create New App".
Copy the consumerKey, consumerSecret, accessToken, accessTokenSecret and paste them in `config/src/main/resources/TwitterConfig.cfg` and `service/src/test/resources/rest-order.xml`

These are required to get passing test cases and to deploy an application that can be authenticated by twitter APIs.

To build this project run:

```
git clone https://github.com/vjsamuel/code-monkeys
cd code-monkeys/homework-2
mvn clean install
```

Install Karaf and start it using:

```
bin/karaf
```

Add the new repositories that were created using:

```
feature:repo-add mvn:edu.sjsu.twitter/config/1.0.0/xml/features
feature:repo-add mvn:edu.sjsu.twitter/service/1.0.0/xml/features
feature:repo-add mvn:edu.sjsu.twitter/webapp/1.0.0/xml/features
```

Start up the bundles using:

```
feature:install twitter-config
feature:install twitter-service
feature:install twitter-webapp
```

The REST APIs are deployed by default on:

[http://localhost:8181/cxf/service/api/v1/twitter](http://localhost:8181/cxf/service/api/v1/twitter)

The webapp is deployed on:

[http://localhost:8081](http://localhost:8181)
