CREATE TABLE attribute
(
    id                bigint NOT NULL,
    name              character varying(255),
    attribute_type_id bigint
);
CREATE TABLE attribute_entry
(
    id           bigint NOT NULL,
    value        character varying(255),
    attribute_id bigint,
    product_id   bigint,
    unit_id      bigint
);
CREATE TABLE attribute_type_unit
(
    attribute_type_id bigint NOT NULL,
    unit_id           bigint NOT NULL
);
CREATE TABLE brand
(
    id   bigint NOT NULL,
    name character varying(255)
);
CREATE TABLE category
(
    id                 bigint NOT NULL,
    name               character varying(255),
    parent_category_id bigint
);
CREATE TABLE category_attribute
(
    category_id       bigint NOT NULL,
    attribute_id bigint NOT NULL
);
CREATE TABLE currency
(
    id     bigint NOT NULL,
    name   character varying(255),
    symbol character varying(255)
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
    id               bigint NOT NULL,
    description      character varying,
    name             character varying(255),
    price            numeric(21, 2),
    subtitle         character varying(255),
    brand_id         bigint,
    category_id      bigint,
    currency_id      bigint,
    preview_image_id bigint
);
CREATE TABLE product_shop
(
    product_id bigint NOT NULL,
    shop_id    bigint NOT NULL
);
CREATE TABLE shop
(
    id   bigint NOT NULL,
    name character varying(255)
);
CREATE TABLE unit
(
    id         bigint NOT NULL,
    name       character varying(255),
    symbol     character varying(255),
    short_name character varying(255)
);
CREATE TABLE attribute_type
(
    id            bigint NOT NULL,
    name          character varying(255),
    material_icon character varying(255),
    data_type     character varying(255)
);

CREATE SEQUENCE sequence_generator
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

SELECT pg_catalog.setval('sequence_generator', 1, false);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT attribute_entry_pkey PRIMARY KEY (id);

ALTER TABLE ONLY attribute
    ADD CONSTRAINT attribute_pkey PRIMARY KEY (id);

ALTER TABLE ONLY attribute_type_unit
    ADD CONSTRAINT attribute_type_unit_pkey PRIMARY KEY (attribute_type_id, unit_id);

ALTER TABLE ONLY brand
    ADD CONSTRAINT brand_pkey PRIMARY KEY (id);

ALTER TABLE ONLY category_attribute
    ADD CONSTRAINT category_attribute_pkey PRIMARY KEY (category_id, attribute_id);

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);

ALTER TABLE ONLY currency
    ADD CONSTRAINT currency_pkey PRIMARY KEY (id);

ALTER TABLE ONLY image_url
    ADD CONSTRAINT image_url_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product_shop
    ADD CONSTRAINT product_shop_pkey PRIMARY KEY (product_id, shop_id);

ALTER TABLE ONLY shop
    ADD CONSTRAINT shop_pkey PRIMARY KEY (id);

ALTER TABLE ONLY unit
    ADD CONSTRAINT unit_pkey PRIMARY KEY (id);

ALTER TABLE ONLY attribute_type
    ADD CONSTRAINT attribute_type_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product
    ADD CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE ONLY product_shop
    ADD CONSTRAINT fk7yop6fyxkpkv0ru4j0cgf2w7j FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE ONLY attribute_type_unit
    ADD CONSTRAINT fka18fu0xb7mlvwlq0s54e7b2st FOREIGN KEY (attribute_type_id) REFERENCES attribute_type (id);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT fkb5o887horbpxxy5ltt6cqy15 FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT fkb5o887horbpxxy5ltt6cqy12 FOREIGN KEY (unit_id) REFERENCES unit (id);

ALTER TABLE ONLY category_attribute
    ADD CONSTRAINT fke0pcstwj0x32r32yy4e8impwv FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE ONLY product
    ADD CONSTRAINT fkex0s5o5hsd2j5n3ev61n9xuf4 FOREIGN KEY (preview_image_id) REFERENCES image_url (id);

ALTER TABLE ONLY product_shop
    ADD CONSTRAINT fkh03olttoo3p4wmi3b023pfh2u FOREIGN KEY (shop_id) REFERENCES shop (id);

ALTER TABLE ONLY image_url
    ADD CONSTRAINT fkh8mo61jwntjpjurrxj5cfpohn FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE ONLY product
    ADD CONSTRAINT fkjs3qd4l0ebv5a0jfo7v59imbn FOREIGN KEY (currency_id) REFERENCES currency (id);

ALTER TABLE ONLY category_attribute
    ADD CONSTRAINT fkm7g4unkarkf07qegkd63bksw7 FOREIGN KEY (attribute_id) REFERENCES attribute (id);

ALTER TABLE ONLY attribute_type_unit
    ADD CONSTRAINT fkppbwh2ooi07tppw6hf06kiv51 FOREIGN KEY (unit_id) REFERENCES unit (id);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT fkq687wssyepv5v9y1mpkg5t0p8 FOREIGN KEY (attribute_id) REFERENCES attribute (id);

ALTER TABLE ONLY attribute
    ADD CONSTRAINT fkrsdelo7m37v1ew2qj6yq4hcn FOREIGN KEY (attribute_type_id) REFERENCES attribute_type (id);

ALTER TABLE ONLY category
    ADD CONSTRAINT fks2ride9gvilxy2tcuv7witnxc FOREIGN KEY (parent_category_id) REFERENCES category (id);

ALTER TABLE ONLY product
    ADD CONSTRAINT fks6cydsualtsrprvlf2bb3lcam FOREIGN KEY (brand_id) REFERENCES brand (id);
