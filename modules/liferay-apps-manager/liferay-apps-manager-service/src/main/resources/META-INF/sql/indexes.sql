create index IX_DAA3EE9 on App (groupId, status);
create index IX_456C57BB on App (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4C0D90FD on App (uuid_[$COLUMN_LENGTH:75$], groupId);