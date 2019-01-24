create sequence hibernate_sequence start 1 increment 1

create table data_domain (
  id int8 not null,
  data_model bytea,
  primary key (id)
);