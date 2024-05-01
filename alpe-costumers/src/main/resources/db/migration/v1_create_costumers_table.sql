create schema if not exists costumers;

create table costumers.costumer (
    id bigserial primary key,
    legal_name varchar(255) not null,
    identification_value varchar(255) not null
);