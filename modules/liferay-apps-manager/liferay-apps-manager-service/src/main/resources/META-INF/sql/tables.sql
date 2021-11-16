create table App (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	appId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(500) null,
	iconUrl VARCHAR(255) null,
	link VARCHAR(255) null
);