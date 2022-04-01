
create table user (
  id bigint(20) not null auto_increment,
  title varchar(100) not null,
  first_name varchar(255) not null,
  last_name varchar(255) not null,
  gender varchar(6) not null,
  email varchar(255) not null,
  username varchar(100) not null,
  password varchar(255) not null,
  nationality char(2) not null
);

alter table user add constraint user_pk primary key (id);
