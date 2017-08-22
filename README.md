# fileupload

Upload file and store file meta data to H2 In-memory DB instance using Rest Service, Spring boot, JPA.

Usage:
curl -F group="abcGroup" -F alias="newSample123" -F file=@"C://sample.txt"  http://localhost:8080/finra/v1/fileupload/

where group and alias are the meta-data associated with the uploaded file.

Uploaded File is written to the server file system - c://temp folder

Uploaded File meta-data can be seen using H2 Db console.
-http://www.localhost:8080/console
-Setting Name:Generic H2 (Embedded)
-Driver Class:org.h2.Driver
-JDBC URL:jdbc:h2:mem:fileupload-db
-User Name:sa
