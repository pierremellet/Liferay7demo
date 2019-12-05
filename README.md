# INSTALL

  blade server init

  setup external datasource   

  blade server start

  blade deploy


# External Datasource  (MySQL example)

setup bundle/portal-ext.properties

    jdbc.ext.driverClassName=com.mysql.cj.jdbc.Driver
    jdbc.ext.url=jdbc:mysql://localhost:3306/****?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
    jdbc.ext.username=****
    jdbc.ext.password=****
    
setup database

    create table Retail_Product (
    	uuid_ VARCHAR(75) null,
    	productId BIGINT not null primary key,
    	groupId LONG,
    	companyId LONG,
    	userId LONG,
    	productName VARCHAR(75) null,
    	createDate DATE null,
    	modifiedDate DATE null
    );    