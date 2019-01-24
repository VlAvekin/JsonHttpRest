create sequence hibernate_sequence start 1 increment 1

create table data_json (
  id int8 not null,
  data text,
  primary key (id)
 );