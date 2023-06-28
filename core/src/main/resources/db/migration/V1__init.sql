CREATE TABLE workers
(
    id               bigserial   NOT NULL,
    first_name       varchar(50) NOT NULL,
    surname          varchar(50),
    last_name        varchar(50) NOT NULL,
    cost_of_one_hour int         NOT NULL,
    specialization   varchar(50) NOT NULL,
    created_at       timestamp DEFAULT (current_timestamp),
    updated_at       timestamp DEFAULT (current_timestamp),
    CONSTRAINT workers_pkey PRIMARY KEY (id)
);

CREATE TABLE clients
(
    id              bigserial   NOT NULL,
    first_name      varchar(50) NOT NULL,
    surname         varchar(50),
    last_name       varchar(50) NOT NULL,
    car_description varchar(50) NOT NULL,
    phone_number    varchar(50) NOT NULL,
    created_at      timestamp DEFAULT (current_timestamp),
    updated_at      timestamp DEFAULT (current_timestamp),
    CONSTRAINT clients_pkey PRIMARY KEY (id)
);
CREATE TABLE orders
(
    id          bigserial   NOT NULL,
    status      varchar(50) NOT NULL,
    total_price numeric(8, 2),
    client_id   int         NOT NULL,
    created_at  timestamp DEFAULT (current_timestamp),
    updated_at  timestamp DEFAULT (current_timestamp),
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_client_id FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE auto_parts
(
    id           bigserial   NOT NULL,
    name_of_part varchar(50) NOT NULL,
    cost         int         NOT NULL,
    distributor  varchar(50) NOT NULL,
    order_id     bigint,
    created_at   timestamp DEFAULT (current_timestamp),
    updated_at   timestamp DEFAULT (current_timestamp),
    CONSTRAINT auto_parts_pkey PRIMARY KEY (id),
    CONSTRAINT fk_auto_part_order_id FOREIGN KEY (order_id) REFERENCES orders (id)
);

CREATE TABLE works
(
    id                 bigserial   NOT NULL,
    name               varchar(50) NOT NULL,
    description        varchar(255),
    time_spent_on_work int         NOT NULL,
    order_id           bigint      NOT NULL,
    worker_id          bigint      NOT NULL,
    created_at         timestamp DEFAULT (current_timestamp),
    updated_at         timestamp DEFAULT (current_timestamp),
    CONSTRAINT works_pkey PRIMARY KEY (id),
    CONSTRAINT fk_work_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_work_worker_id FOREIGN KEY (worker_id) REFERENCES workers (id)
);

