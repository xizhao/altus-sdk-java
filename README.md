# Cloudera Altus SDK for Java

The Cloudera Altus SDK for Java allows Java developers to work with Cloudera
Altus services.

## Getting Started

### Prerequisites

* **Java 1.8** or later
* **Maven 3.5** or later

### Installing the SDK

The Altus SDK is available through Cloudera's maven repository. To include it
in your Maven project, use the following declarations:

#### Add the Cloudera Maven Repository

```xml
<repositories>
  <repository>
    <id>cloudera.repo</id>
    <url>https://repository.cloudera.com/artifactory/cloudera-repos</url>
    <name>Cloudera Repository</name>
  </repository>
</repositories>
```

#### Include the Altus SDK Module

The Altus SDK uses [slf4j](https://www.slf4j.org/) for logging, so you must
also include an slf4j implementation for whichever logging library your
project will use (eg: log4j, logback, etc), and the jcl-over-slf4j bridge.
In this example, we include the log4j implementation.

```xml
<dependencies>
  <dependency>
    <groupId>com.cloudera.altus</groupId>
    <artifactId>altus-sdk-java</artifactId>
  </dependency>
  <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
  </dependency>
  <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>jcl-over-slf4j</artifactId>
    <scope>runtime</scope>
  </dependency>
</dependencies>
```

## Building the SDK from source

After checking out the source code, you can build it using Maven.

```sh
mvn clean install
```

## Using the SDK

You can see examples of how to use in the SDK in the separate
[Samples Repository](https://github.com/cloudera/altus-sdk-java-samples).
