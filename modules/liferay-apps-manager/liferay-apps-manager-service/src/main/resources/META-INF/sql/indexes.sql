create index IX_8001B303 on App (groupId);
create index IX_456C57BB on App (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4C0D90FD on App (uuid_[$COLUMN_LENGTH:75$], groupId);