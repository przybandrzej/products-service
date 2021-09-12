CREATE TABLE attribute (
                           id bigint NOT NULL,
                           name character varying(255),
                           attribute_type_id bigint
);

CREATE TABLE attribute_entry (
                                 id bigint NOT NULL,
                                 value character varying(255),
                                 attribute_id bigint,
                                 product_id bigint,
                                 unit_id bigint
);

CREATE TABLE attribute_type (
                                id bigint NOT NULL,
                                data_type character varying(255),
                                material_icon character varying(255),
                                name character varying(255)
);

CREATE TABLE attribute_type_unit (
                                     attribute_type_id bigint NOT NULL,
                                     unit_id bigint NOT NULL
);

CREATE TABLE brand (
                       id bigint NOT NULL,
                       name character varying(255)
);

CREATE TABLE category (
                          id bigint NOT NULL,
                          name character varying(255),
                          parent_category_id bigint
);

CREATE TABLE category_attribute (
                                    category_id bigint NOT NULL,
                                    attribute_id bigint NOT NULL
);

CREATE TABLE currency (
                          id bigint NOT NULL,
                          name character varying(255),
                          symbol character varying(255)
);

CREATE TABLE image_url (
                           id bigint NOT NULL,
                           applying_order real,
                           url character varying(255),
                           product_id bigint
);

CREATE TABLE keycloak_user (
                               id bigint NOT NULL,
                               avatar oid,
                               avatar_content_type character varying(255),
                               username character varying(255) NOT NULL
);

CREATE TABLE product (
                         id bigint NOT NULL,
                         description character varying(255),
                         name character varying(255),
                         subtitle character varying(255),
                         brand_id bigint,
                         category_id bigint,
                         preview_image_id bigint
);

CREATE TABLE product_products_list_link (
                                            id bigint NOT NULL,
                                            note character varying(255),
                                            product_order real,
                                            list_id bigint,
                                            product_id bigint
);

CREATE TABLE product_shop_link (
                                   id bigint NOT NULL,
                                   price numeric(21,2),
                                   currency_id bigint,
                                   product_id bigint,
                                   shop_id bigint
);

CREATE TABLE products_list (
                               id bigint NOT NULL,
                               avatar oid,
                               avatar_content_type character varying(255),
                               description character varying(255)
);

CREATE SEQUENCE sequence_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE shop (
                      id bigint NOT NULL,
                      name character varying(255)
);

CREATE TABLE unit (
                      id bigint NOT NULL,
                      name character varying(255),
                      short_name character varying(255),
                      symbol character varying(255)
);

CREATE TABLE user_products_list_link (
                                         id bigint NOT NULL,
                                         can_add_products boolean,
                                         can_change_products_order boolean,
                                         can_edit_info boolean,
                                         can_edit_products boolean,
                                         can_manage_access boolean,
                                         can_remove_products boolean,
                                         list_id bigint,
                                         user_id bigint
);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT attribute_entry_pkey PRIMARY KEY (id);

ALTER TABLE ONLY attribute
    ADD CONSTRAINT attribute_pkey PRIMARY KEY (id);

ALTER TABLE ONLY attribute_type
    ADD CONSTRAINT attribute_type_pkey PRIMARY KEY (id);

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

ALTER TABLE ONLY keycloak_user
    ADD CONSTRAINT keycloak_user_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product_products_list_link
    ADD CONSTRAINT product_products_list_link_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product_shop_link
    ADD CONSTRAINT product_shop_link_pkey PRIMARY KEY (id);

ALTER TABLE ONLY products_list
    ADD CONSTRAINT products_list_pkey PRIMARY KEY (id);

ALTER TABLE ONLY shop
    ADD CONSTRAINT shop_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product_products_list_link
    ADD CONSTRAINT uk_5r6nutgi82j2rljd69hme0kbb UNIQUE (list_id);

ALTER TABLE ONLY user_products_list_link
    ADD CONSTRAINT uk_j1r7axhl47xwbbh9rrt0jg1v5 UNIQUE (user_id);

ALTER TABLE ONLY product_shop_link
    ADD CONSTRAINT uk_jvygomii1998ocksdwr665niw UNIQUE (shop_id);

ALTER TABLE ONLY product_products_list_link
    ADD CONSTRAINT uk_l2uq8ixl38ml5d84utwaybfep UNIQUE (product_id);

ALTER TABLE ONLY product_shop_link
    ADD CONSTRAINT uk_n5s7ttdyauw31ivf340bow197 UNIQUE (product_id);

ALTER TABLE ONLY keycloak_user
    ADD CONSTRAINT uk_p2g5grean76lk0uwfruxp0f7y UNIQUE (username);

ALTER TABLE ONLY user_products_list_link
    ADD CONSTRAINT uk_pfllyhfjacwkc4qog3na8b45o UNIQUE (list_id);

ALTER TABLE ONLY unit
    ADD CONSTRAINT unit_pkey PRIMARY KEY (id);

ALTER TABLE ONLY user_products_list_link
    ADD CONSTRAINT user_products_list_link_pkey PRIMARY KEY (id);

ALTER TABLE ONLY product
    ADD CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id) REFERENCES category(id);

ALTER TABLE ONLY product_products_list_link
    ADD CONSTRAINT fk6anjg561m4s36bblhfet9s5xk FOREIGN KEY (list_id) REFERENCES products_list(id);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT fkb5o887horbpxxy5ltt6cqy15 FOREIGN KEY (product_id) REFERENCES product(id);

ALTER TABLE ONLY category_attribute
    ADD CONSTRAINT fke0pcstwj0x32r32yy4e8impwv FOREIGN KEY (category_id) REFERENCES category(id);

ALTER TABLE ONLY product
    ADD CONSTRAINT fkex0s5o5hsd2j5n3ev61n9xuf4 FOREIGN KEY (preview_image_id) REFERENCES image_url(id);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT fkf20rh8xb96wm5gt5bqd8spi8e FOREIGN KEY (unit_id) REFERENCES unit(id);

ALTER TABLE ONLY attribute
    ADD CONSTRAINT fkfdho64rl52x8xjxhl0gwge823 FOREIGN KEY (attribute_type_id) REFERENCES attribute_type(id);

ALTER TABLE ONLY user_products_list_link
    ADD CONSTRAINT fkgm4q817ga8xjnx86jgoay0vjg FOREIGN KEY (user_id) REFERENCES keycloak_user(id);

ALTER TABLE ONLY image_url
    ADD CONSTRAINT fkh8mo61jwntjpjurrxj5cfpohn FOREIGN KEY (product_id) REFERENCES product(id);

ALTER TABLE ONLY category_attribute
    ADD CONSTRAINT fki8qw5dueeesbkbslbpfopnrkl FOREIGN KEY (attribute_id) REFERENCES attribute(id);

ALTER TABLE ONLY product_shop_link
    ADD CONSTRAINT fklp37dpdblqglcdxmj6ueoq022 FOREIGN KEY (product_id) REFERENCES product(id);

ALTER TABLE ONLY product_shop_link
    ADD CONSTRAINT fkls6ja6k2ftvlcfujb6w00th7f FOREIGN KEY (shop_id) REFERENCES shop(id);

ALTER TABLE ONLY product_products_list_link
    ADD CONSTRAINT fkmkkiu7j2tif8omc56prqum04m FOREIGN KEY (product_id) REFERENCES product(id);

ALTER TABLE ONLY product_shop_link
    ADD CONSTRAINT fkmunmjr6c2wi6osw7qpst65x6t FOREIGN KEY (currency_id) REFERENCES currency(id);

ALTER TABLE ONLY attribute_type_unit
    ADD CONSTRAINT fkmyp4cmgkoyqlnjxfn9lerbbms FOREIGN KEY (attribute_type_id) REFERENCES attribute_type(id);

ALTER TABLE ONLY attribute_type_unit
    ADD CONSTRAINT fkppbwh2ooi07tppw6hf06kiv51 FOREIGN KEY (unit_id) REFERENCES unit(id);

ALTER TABLE ONLY attribute_entry
    ADD CONSTRAINT fkq687wssyepv5v9y1mpkg5t0p8 FOREIGN KEY (attribute_id) REFERENCES attribute(id);

ALTER TABLE ONLY category
    ADD CONSTRAINT fks2ride9gvilxy2tcuv7witnxc FOREIGN KEY (parent_category_id) REFERENCES category(id);

ALTER TABLE ONLY product
    ADD CONSTRAINT fks6cydsualtsrprvlf2bb3lcam FOREIGN KEY (brand_id) REFERENCES brand(id);

ALTER TABLE ONLY user_products_list_link
    ADD CONSTRAINT fksouj0isxyy3nsd3xqdm1s9hd8 FOREIGN KEY (list_id) REFERENCES products_list(id);
