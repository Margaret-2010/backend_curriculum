-- 1. Create the flexi table
CREATE TABLE flexi (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    occupation VARCHAR(100),
    date DATE
);

-- 2. Insert sample records into flexi
INSERT INTO flexi (firstname, lastname, address, occupation, date)
VALUES
    ('Margaret', 'Salako', '123 Garki Street, Abuja', 'Software Engineering Intern', '2026-08-20'),
    ('Keji', 'Johnson', '45 Wuse Road, Abuja', 'Backend Developer', '2026-08-15'),
    ('Chidi', 'Okeke', '78 Maitama Avenue, Abuja', 'Data Analyst', '2026-08-10');

-- 3. Update a record (e.g., update Keji's occupation)
UPDATE flexi
SET occupation = 'Senior Backend Developer'
WHERE firstname = 'Keji' AND lastname = 'Johnson';

-- 4. Delete a record (e.g., remove Chidi's record)
DELETE FROM flexi
WHERE firstname = 'Chidi' AND lastname = 'Okeke';

-- 5. Read all remaining data (to confirm changes)
SELECT * FROM flexi;