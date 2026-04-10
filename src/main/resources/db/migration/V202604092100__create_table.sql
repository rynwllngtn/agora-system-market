ALTER TABLE listings
RENAME COLUMN seller_id TO seller;

ALTER TABLE listings
RENAME COLUMN product_id TO product;

ALTER TABLE sellers
ADD COLUMN name VARCHAR(255);