create table users
(
    id      bigint auto_increment,
    name    varchar(50),
    balance bigint,
    primary key (id)
);

create table transactions
(
    id         bigint auto_increment,
    user_id    bigint,
    amount     bigint,
    created_at timestamp,
    status     varchar(15),
    foreign key (user_id) references users (id) on delete cascade
);
