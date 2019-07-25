DROP TABLE owners IF EXISTS;
DROP TABLE plants IF EXISTS;
DROP TABLE sensors IF EXISTS;


CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20),
  email		 VARCHAR(255)
);
CREATE INDEX owners_last_name ON owners (last_name);

CREATE TABLE plants (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  humidity_minimum   INTEGER NOT NULL,
  humidity_maximum   INTEGER NOT NULL,
  message 			 VARCHAR(60)
);
CREATE INDEX plants_name ON plants (name);

CREATE TABLE sensors (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  humidity           INTEGER NOT NULL,
  id_plant			 INTEGER
);
ALTER TABLE sensors ADD CONSTRAINT fk_sensors_plants FOREIGN KEY (id_plant) REFERENCES plants (id);
CREATE INDEX sensors_name ON sensors (name);
