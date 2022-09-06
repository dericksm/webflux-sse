create table users
(
    id      bigint auto_increment,
    name    varchar(50),
    balance int,
    primary key (id)
);

create table transactions
(
    id               bigint auto_increment,
    user_id          bigint,
    amount           int,
    created_at timestamp,
    status           int,
    foreign key (user_id) references users (id) on delete cascade
);
