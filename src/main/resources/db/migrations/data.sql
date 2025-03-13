CREATE TABLE products (
    id UUID PRIMARY NOT NULL  KEY DEFAULT (UUID()),
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    image_url VARCHAR(255)
);
