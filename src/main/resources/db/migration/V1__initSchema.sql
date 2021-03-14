CREATE TABLE attribute
(
    id          bigint NOT NULL,
    is_boolean  boolean,
    is_date     boolean,
    is_double   boolean,
    is_long     boolean,
    is_string   boolean,
    name        character varying(255),
    category_id bigint
);

CREATE TABLE attribute_entry
(
    id           bigint NOT NULL,
    value        character varying(255),
    attribute_id bigint
);

CREATE TABLE brand
(
    id   bigint NOT NULL,
    name character varying(255)
);

CREATE TABLE category
(
    id   bigint NOT NULL,
    name character varying(255)
);

CREATE TABLE image_url
(
    id             bigint NOT NULL,
    applying_order real,
    url            character varying(255),
    product_id     bigint
);

CREATE TABLE product
(
    id       bigint NOT NULL,
    name     character varying(255),
    price    numeric(21, 2),
    brand_id bigint
);

CREATE TABLE product_attribute_entry
(
    product_id         bigint NOT NULL,
    attribute_entry_id bigint NOT NULL
);

CREATE TABLE product_category
(
    product_id  bigint NOT NULL,
    category_id bigint NOT NULL
);

CREATE TABLE product_shop
(
    product_id bigint NOT NULL,
    shop_id    bigint NOT NULL
);

CREATE SEQUENCE sequence_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE shop
(
    id   bigint NOT NULL,
    name character varying(255)
);

SELECT pg_catalog.setval('sequence_generator', 1, false);
ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT attribute_entry_pkey PRIMARY KEY (id);
ALTER TABLE ONLY attribute
    ADD CONSTRAINT attribute_pkey PRIMARY KEY (id);
ALTER TABLE ONLY brand
    ADD CONSTRAINT brand_pkey PRIMARY KEY (id);
ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
ALTER TABLE ONLY image_url
    ADD CONSTRAINT image_url_pkey PRIMARY KEY (id);
ALTER TABLE ONLY product_attribute_entry
    ADD CONSTRAINT product_attribute_entry_pkey PRIMARY KEY (product_id, attribute_entry_id);
ALTER TABLE ONLY product_category
    ADD CONSTRAINT product_category_pkey PRIMARY KEY (product_id, category_id);
ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
ALTER TABLE ONLY product_shop
    ADD CONSTRAINT product_shop_pkey PRIMARY KEY (product_id, shop_id);
ALTER TABLE ONLY shop
    ADD CONSTRAINT shop_pkey PRIMARY KEY (id);
ALTER TABLE ONLY attribute
    ADD CONSTRAINT fk1eji3t1hu871hkq00mx58v7w3 FOREIGN KEY (category_id) REFERENCES category (id);
ALTER TABLE ONLY product_category
    ADD CONSTRAINT fk2k3smhbruedlcrvu6clued06x FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE ONLY product_attribute_entry
    ADD CONSTRAINT fk74kajff1ydoer51vvdx3mgxeb FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE ONLY product_shop
    ADD CONSTRAINT fk7yop6fyxkpkv0ru4j0cgf2w7j FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE ONLY product_shop
    ADD CONSTRAINT fkh03olttoo3p4wmi3b023pfh2u FOREIGN KEY (shop_id) REFERENCES shop (id);
ALTER TABLE ONLY product_attribute_entry
    ADD CONSTRAINT fkh6gtt1see33e4t751gfjjbwiv FOREIGN KEY (attribute_entry_id) REFERENCES attribute_entry (id);
ALTER TABLE ONLY image_url
    ADD CONSTRAINT fkh8mo61jwntjpjurrxj5cfpohn FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE ONLY product_category
    ADD CONSTRAINT fkkud35ls1d40wpjb5htpp14q4e FOREIGN KEY (category_id) REFERENCES category (id);
ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT fkq687wssyepv5v9y1mpkg5t0p8 FOREIGN KEY (attribute_id) REFERENCES attribute (id);
ALTER TABLE ONLY product
    ADD CONSTRAINT fks6cydsualtsrprvlf2bb3lcam FOREIGN KEY (brand_id) REFERENCES brand (id);
