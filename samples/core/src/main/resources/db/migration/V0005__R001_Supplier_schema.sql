CREATE TABLE Supplier(
    id BIGINT NOT NULL,
    modificationCounter INTEGER NOT NULL,
    name VARCHAR(255),
    description VARCHAR(255),
    rate INTEGER,
    CONSTRAINT PK_Supplier PRIMARY KEY(id),
    CONSTRAINT UC_Supplier_name UNIQUE(name)
);

INSERT INTO Supplier (id, modificationCounter, name, description, rate) VALUES (1, 0, 'Natural Fruit Exports', 'Fruit', 4);
 
INSERT INTO Supplier (id, modificationCounter, name, description, rate) VALUES (2, 0, 'CPS Gourmet', 'Meat', 5);
 
INSERT INTO Supplier (id, modificationCounter, name, description, rate) VALUES (3, 0, 'Albafrost', 'Vegetables', 3);
