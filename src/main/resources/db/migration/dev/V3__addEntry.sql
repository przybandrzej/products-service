INSERT INTO category (id, name) VALUES (1, 'Beer');

INSERT INTO image_url (id, url) VALUES (1, 'https://sklep.stokrotka.pl/files/fotob/product-29634.jpg');

INSERT INTO brand (id, name) VALUES (1, 'Desperados');

INSERT INTO product (id, name, subtitle, price, currency_id, brand_id, preview_image_id)
VALUES (1, 'Desperados Original', 'Tequila beer', 4.59, 1, 1, 1);

INSERT INTO image_url (id, url, applying_order, product_id)
VALUES (2, 'https://pliki.dlahandlu.pl/i/03/18/52/031852_r0_940.jpg', 1.0, 1);

INSERT INTO product_shop (product_id, shop_id)
VALUES (1, 1);

INSERT INTO product_shop (product_id, shop_id)
VALUES (1, 2);

INSERT INTO product_shop (product_id, shop_id)
VALUES (1, 3);

INSERT INTO product_category (product_id, category_id)
VALUES (1, 1);

INSERT INTO attribute (id, name, is_long, category_id)
VALUES (1, 'alcohol content', true, 1);

INSERT INTO attribute (id, name, is_string, category_id)
VALUES (2, 'capacity', true, 1);

INSERT INTO attribute_entry (id, value, attribute_id)
VALUES (1, 5.9, 1);

INSERT INTO attribute_entry (id, value, attribute_id)
VALUES (2, '400ml', 2);

INSERT INTO product_attribute_entry (product_id, attribute_entry_id)
VALUES (1, 1);

INSERT INTO product_attribute_entry (product_id, attribute_entry_id)
VALUES (1, 2);

SELECT pg_catalog.setval('sequence_generator', 100, false);
