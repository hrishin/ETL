# ETL Tool

Command Line Interface (CLI) based Extract -> Trasnform -> Load (ETL) tool implemnted in Java.

Following set of Extractors supported
  * File 

Following set of Trasnformers supported
  * Capitalization
  * Word Count
  
Following set of Loaders supported
  * File

Additinally ETL can execute flow serially or concurrently, default behaviour is concurrent execution

### Build
Dev. Environment:

1) Java DK 1.8 +

2) Maven 3.0 +


with test
```
mvn clean package
```
or
```
mvn clean installl
```

without test
```
mvn clean package -Dmaven.test.skip=true
```

### Usage

```
java -jar ETLDemo-1.0.0.jar <extractor locaion> <loader locaion>  <transformer>
```
Application requires 3 command line arguments to work

transformer:  argument supports only two possible values, 'capitalize' or 'wordcount'

sample
```
java -jar ETLDemo-1.0.0.jar files/source/ files/destination/ wordcount
```
```
java -jar ETLDemo-1.0.0.jar files/source/ files/destination/ capitalize
```
