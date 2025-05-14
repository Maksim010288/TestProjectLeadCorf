create table client_info(
    id INTEGER primary key  ,
    name CHARACTER(30) not null ,
    email CHARACTER(30) not null ,
    tax_number CHARACTER(50) not null,
    location CHARACTER(40) not null ,
    user_id INTEGER
);