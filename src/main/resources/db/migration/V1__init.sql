create sequence hibernate_sequence start with 1 increment by 1;

create table event (
    id int8 not null,
    age_censor int4,
    description varchar(255),
    end_date timestamp,
    event_name varchar(255),
    like_counter int8,
    start_date timestamp,
    primary key (id)
);

create table usr (
    dtype varchar(31) not null,
    id int8 not null,
    login varchar(255),
    password varchar(255),
    role int4,
    address varchar(255),
    company_name varchar(255),
    b_day date,
    city_name varchar(255),
    username varchar(255),
    primary key (id)
);

create table usr_event (
    id int8 not null, 
    liked boolean,
    owner boolean,
    review varchar(255),
    event_id int8,
    usr_id int8,
    primary key (id)
);

alter table if exists usr add constraint UK_b2j2bjirhqhbg1rsexaq5qs9x unique (login);
alter table if exists usr_event add constraint FKt6o8gfnxr2g1g9761jrg5rqfp foreign key (event_id) references event;
alter table if exists usr_event add constraint FK8ma492rm6i5ofc4b6hs4w8xgp foreign key (usr_id) references usr;
