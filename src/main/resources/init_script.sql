create table counter_information
(
    id         bigint auto_increment
        primary key,
    reached_at TIMESTAMP
);

create table request_information
(
    id          bigint auto_increment
        primary key,
    url         TEXT,
    remote_host TEXT,
    method      TEXT,
    uri         TEXT,
    query_string TEXT
)
