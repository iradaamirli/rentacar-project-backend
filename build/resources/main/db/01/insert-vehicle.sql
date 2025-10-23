INSERT INTO vehicle
(brand, model, transmission, air_conditioning, year, seats, doors, horsepower, luggage, daily_price, stock, status, image_url)
VALUES
-- BMW M5
('BMW', 'M5 Competition', 'Automatic', TRUE, 2022, 5, 4, 625, 3, 350, 3, 'AVAILABLE', '/image/bmwM5.jpg'),
('BMW', 'M5 CS', 'Automatic', TRUE, 2023, 5, 4, 635, 3, 340, 2, 'RENTED', '/image/bmwM5.jpg'),
('BMW', 'M5 F90', 'Automatic', TRUE, 2021, 5, 4, 600, 3, 320, 4, 'AVAILABLE', '/image/bmwM5.jpg'),
('BMW', 'M5 E60', 'Manual', TRUE, 2010, 5, 4, 507, 2, 250, 1, 'MAINTENANCE', '/image/bmwM5.jpg'),

-- Changan
('Changan', 'Alsvin', 'Automatic', TRUE, 2022, 5, 4, 107, 3, 120, 5, 'AVAILABLE', '/image/changan.jpg'),
('Changan', 'CS35 Plus', 'Automatic', TRUE, 2023, 5, 4, 160, 4, 130, 4, 'AVAILABLE', '/image/changan.jpg'),
('Changan', 'CS75', 'Automatic', TRUE, 2021, 5, 4, 178, 4, 150, 3, 'RENTED', '/image/changan.jpg'),
('Changan', 'Eado Plus', 'Automatic', TRUE, 2023, 5, 4, 158, 3, 140, 2, 'AVAILABLE', '/image/changan.jpg'),

-- Mercedes
('Mercedes', 'E200', 'Automatic', TRUE, 2022, 5, 4, 197, 4, 300, 3, 'AVAILABLE', '/image/mercedes1.jpg'),
('Mercedes', 'C300', 'Automatic', TRUE, 2021, 5, 4, 258, 3, 280, 2, 'RENTED', '/image/mercedes1.jpg'),
('Mercedes', 'S500', 'Automatic', TRUE, 2023, 5, 4, 435, 4, 350, 1, 'AVAILABLE', '/image/mercedes1.jpg'),
('Mercedes', 'GLC300', 'Automatic', TRUE, 2022, 5, 4, 258, 5, 310, 2, 'AVAILABLE', '/image/mercedes1.jpg'),

-- Range Rover
('Range Rover', 'Velar', 'Automatic', TRUE, 2022, 5, 4, 400, 5, 340, 2, 'AVAILABLE', '/image/rr.jpg'),
('Range Rover', 'Evoque', 'Automatic', TRUE, 2021, 5, 4, 249, 4, 320, 3, 'RENTED', '/image/rr.jpg'),
('Range Rover', 'Sport', 'Automatic', TRUE, 2023, 5, 4, 530, 5, 350, 1, 'AVAILABLE', '/image/rr.jpg'),
('Range Rover', 'Defender', 'Automatic', TRUE, 2022, 7, 4, 395, 6, 330, 2, 'AVAILABLE', '/image/rr.jpg'),

-- Toyota
('Toyota', 'Camry', 'Automatic', TRUE, 2022, 5, 4, 203, 4, 200, 4, 'AVAILABLE', '/image/toyota.jpg'),
('Toyota', 'Corolla', 'Automatic', TRUE, 2021, 5, 4, 139, 3, 150, 5, 'AVAILABLE', '/image/toyota.jpg'),
('Toyota', 'Land Cruiser', 'Automatic', TRUE, 2023, 7, 5, 409, 6, 350, 2, 'RENTED', '/image/toyota.jpg'),
('Toyota', 'RAV4', 'Automatic', TRUE, 2022, 5, 4, 203, 4, 220, 3, 'AVAILABLE', '/image/toyota.jpg');
