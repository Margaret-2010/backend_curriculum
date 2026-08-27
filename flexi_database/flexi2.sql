-- Week 6 (Part 2) Additional Work: Altering Tables & Aggregates
-- Continuation of the flexi table exercise

-- 1. Add a new column to the flexi table
ALTER TABLE flexi
ADD COLUMN phone_number VARCHAR(20);

-- 2. Add a constraint to an existing column (e.g., ensure occupation is never left empty)
ALTER TABLE flexi
ALTER COLUMN occupation SET NOT NULL;

-- 3. Remove a constraint (e.g., allow occupation to be empty again)
ALTER TABLE flexi
ALTER COLUMN occupation DROP NOT NULL;

-- 4. Drop a column that's no longer needed
ALTER TABLE flexi
DROP COLUMN phone_number;

-- 5. Insert a few more records so aggregate functions have more data to work with
INSERT INTO flexi (firstname, lastname, address, occupation, date)
VALUES
    ('Amaka', 'Bello', '12 Jabi Street, Abuja', 'Software Engineering Intern', '2026-08-18'),
    ('Tunde', 'Ibrahim', '9 Utako Close, Abuja', 'Backend Developer', '2026-08-12');

-- 6. Aggregate: count how many people are in the table
SELECT COUNT(*) AS total_records FROM flexi;

-- 7. Aggregate: count how many people share the same occupation
SELECT occupation, COUNT(*) AS number_of_people
FROM flexi
GROUP BY occupation;

-- 8. Aggregate: find the earliest and latest date recorded
SELECT MIN(date) AS earliest_date, MAX(date) AS latest_date
FROM flexi;

-- 9. Drop the table entirely (cleanup step, run only when you're done practicing)
-- DROP TABLE flexi;