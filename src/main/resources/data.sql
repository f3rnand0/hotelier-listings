MERGE INTO hotelier (id, first_name, last_name) KEY(id) VALUES (1, 'Elon', 'Musk');
MERGE INTO hotelier (id, first_name, last_name) KEY(id) VALUES (2, 'Steve', 'Jobs');
MERGE INTO hotelier (id, first_name, last_name) KEY(id) VALUES (3, 'Bill', 'Gates');

MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (1, 'Quito', 'Pichincha', 'Ecuador', 17090, 'San Francisco y Los Guabos Lote 1');
MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (2, 'Lisbon', '', 'Portugal', 12345, 'Av. Ant�nio Augusto de Aguiar 31, 1069-413');
MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (3, 'Valladolid', 'Castile and Le�n', 'Espa�a', 47013, 'C. del Hornija');
MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (4, 'D�sseldorf', 'North Rhine-Westphalia', 'Germany', 40221, 'Kesselstra�e 5-7');

MERGE INTO item (id, name, rating, category, image, reputation, reputation_badge, price, availability, location_id, hotelier_id) KEY(id) VALUES (1, 'Marriot', 5, 0, '/images/marriot.png', 950, 0, 1200, 100, 1, 1);
MERGE INTO item (id, name, rating, category, image, reputation, reputation_badge, price, availability, location_id, hotelier_id) KEY(id) VALUES (2, 'Hilton Colon', 5, 1, '/images/hilton.png', 900, 0, 1000, 110, 2, 2);
