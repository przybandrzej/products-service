INSERT INTO currency (id, name, symbol) VALUES (nextval('sequence_generator'), '${currencies.pln.name}', '${currencies.pln.symbol}');
INSERT INTO currency (id, name, symbol) VALUES (nextval('sequence_generator'), '${currencies.euro.name}', '${currencies.euro.symbol}');
INSERT INTO currency (id, name, symbol) VALUES (nextval('sequence_generator'), '${currencies.dollar.name}', '${currencies.dollar.symbol}');

INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.lidl}');
INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.intermarche}');
INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.carrefour}');
INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.auchan}');
INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.netto}');
INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.aldi}');
INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.kaufland}');
INSERT INTO shop (id, name) VALUES (nextval('sequence_generator'), '${shops.ikea}');

