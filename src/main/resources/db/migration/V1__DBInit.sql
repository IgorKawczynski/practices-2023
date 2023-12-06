-- PostgreSQL Script
-- 05.12.2023 09:00
-- Initialization of entire database

-- Creating a sequence for all tables
CREATE SEQUENCE IF NOT EXISTS public.id_seq;

-- Table Buyers
CREATE TABLE IF NOT EXISTS public.buyers
(
    id BIGINT DEFAULT nextval('public.id_seq') PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    email VARCHAR(40) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Table Sellers
CREATE TABLE IF NOT EXISTS public.sellers
(
    id BIGINT DEFAULT nextval('public.id_seq') PRIMARY KEY,
    company_name VARCHAR(30) NOT NULL,
    address VARCHAR(40) NOT NULL
);

-- Table Products
CREATE TABLE IF NOT EXISTS public.products
(
    id BIGINT DEFAULT nextval('public.id_seq') PRIMARY KEY,
    created_at timestamp NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL DEFAULT 0,
    amount integer NOT NULL DEFAULT 0,
    buyer_id bigint NOT NULL,
    seller_id bigint NOT NULL,
    CONSTRAINT fk_Product_buyer FOREIGN KEY (buyer_id) REFERENCES public.buyers(id),
    CONSTRAINT fk_Product_seller FOREIGN KEY (seller_id) REFERENCES public.sellers(id)
);
