# sharding-jdbc-test-demo
sharding-jdbc测试

#建表脚本
-- Create table
create table TEST_SHARDING_A
(
  id      NUMBER not null,
  sd_name VARCHAR2(32)
);
alter table TEST_SHARDING_A
  add constraint TEST_SHARDING_A_PK primary key (ID);