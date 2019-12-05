create table Retail_Product (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	productName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);