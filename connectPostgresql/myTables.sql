
-- Create 2 Tables Brands and Products :-

CREATE TABLE Brands (

    brandID SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(50) NOT NULL
);



CREATE TABLE Products (

    productID SERIAL PRIMARY KEY NOT NULL,
    brandID integer REFERENCES Brands (brandID) ON DELETE CASCADE,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(50) NOT NULL
);



-- Insert 2 Brand rows, Default Will Auto Increment { 1, 2, 3...} :-

INSERT INTO Brands (brandID, name, description) VALUES (DEFAULT, 'Toyota', 'Toyota Car Brand');
INSERT INTO Brands (brandID, name, description) VALUES (DEFAULT, 'Honda', 'Honda Car Brand');


-- Insert 2 Product rows, Default Will Auto Increment { 1, 2, 3...} :-

INSERT INTO Products (productID, brandID, name, description) VALUES (DEFAULT, 1, 'Toyota Carolla', 'Carolla Model Car');
INSERT INTO Products (productID, brandID, name, description) VALUES (DEFAULT, 1, 'Toyota Avensis', 'Avensis Model Car');
