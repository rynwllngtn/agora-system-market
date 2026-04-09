CREATE TABLE sellers (
    id UUID PRIMARY KEY,
    owner_id UUID UNIQUE NOT NULL
);

CREATE TABLE products (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE listings (
    id UUID PRIMARY KEY,
    seller_id UUID NOT NULL,
    product_id UUID NOT NULL,
    stock int NOT NULL,
    price DECIMAL(9,2) NOT NULL,
    status VARCHAR(16) NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES sellers(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);