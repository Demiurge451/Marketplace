create table order_delivery (
                    id serial PRIMARY KEY,
                    weight serial,
                    address_start varchar(255),
                    address_end varchar(255)
);