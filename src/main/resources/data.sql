MERGE INTO hotelier (id, first_name, last_name) KEY(id) VALUES (10, 'Elon', 'Musk');
MERGE INTO hotelier (id, first_name, last_name) KEY(id) VALUES (20, 'Steve', 'Jobs');
MERGE INTO hotelier (id, first_name, last_name) KEY(id) VALUES (30, 'Bill', 'Gates');

MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (10, 'Quito', 'Pichincha', 'Ecuador', 17090, 'San Francisco y Los Guabos Lote 1');
MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (20, 'Lisbon', '', 'Portugal', 12345, 'Av. António Augusto de Aguiar 31, 1069-413');
MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (30, 'Valladolid', 'Castile and León', 'España', 47013, 'C. del Hornija');
MERGE INTO location (id, city, state, country, zip_code, address) KEY(id) VALUES (40, 'Düsseldorf', 'North Rhine-Westphalia', 'Germany', 40221, 'Kesselstraße 5-7');

MERGE INTO item (id, name, rating, category, image, reputation, reputation_badge, price, availability, location_id, hotelier_id) KEY(id) VALUES (10, 'Marriot', 5, 0, '/images/marriot.png', 950, 0, 1200, 100, 10, 10);
MERGE INTO item (id, name, rating, category, image, reputation, reputation_badge, price, availability, location_id, hotelier_id) KEY(id) VALUES (20, 'Hilton Colon', 5, 1, '/images/hilton.png', 900, 0, 1000, 110, 20, 20);
