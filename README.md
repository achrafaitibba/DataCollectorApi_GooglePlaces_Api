# DataCollectorApi_GooglePlaces_Api
Is a Java web application that collects businesses and places data using the Google Places API. It supports pagination and can collect at least 100 results per call. The collected data could be saved to an Excel file for further use.


<Needed dependencies>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>7.0.1.Final</version>
        </dependency>
        <dependency>
            <groupId>com.google.maps</groupId>
            <artifactId>google-maps-services</artifactId>
            <version>0.17.0</version>
        </dependency>
