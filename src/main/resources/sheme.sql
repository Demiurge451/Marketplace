create table order_buy(
    id serial PRIMARY KEY ,
    weight float,
    address_start varchar(255),
    address_end varchar(255),
    start_lat float,
    start_lon float,
    end_lat float,
    end_lon float
);