DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  date_of_birth BIGINT DEFAULT NULL,
  is_active BOOLEAN DEFAULT TRUE,
  email_id VARCHAR(255),
  phone_number VARCHAR(255),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  product_id VARCHAR(250) NOT NULL,
  product_name VARCHAR(255) NOT NULL,
  metadata TEXT,
  is_active BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (product_id)
);

DROP TABLE IF EXISTS user_product_mapping;

CREATE TABLE user_product_mapping (
    id VARCHAR(250) NULL,
    user_id VARCHAR(250) NOT NULL,
    product_id VARCHAR(250) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id)
);


