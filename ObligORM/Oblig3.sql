-- sletter hvis schema eksisterer, og alt inni den.
DROP SCHEMA IF EXISTS Oblig3 CASCADE;

-- oppretter schema på nytt
CREATE SCHEMA Oblig3;
SET search_path TO Oblig3;

CREATE TABLE Ansatt (
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(15) UNIQUE,
    fornavn VARCHAR(50),
    etternavn VARCHAR(50),
    dato_ansatt DATE,
    stilling VARCHAR(50),
    lonn_mnd DECIMAL(10, 2),
    avdeling_id INT
	);

CREATE TABLE Avdeling (
    avdeling_id SERIAL PRIMARY KEY,
    navn VARCHAR(100),
    sjef_id INT,
    FOREIGN KEY (sjef_id) REFERENCES Ansatt(ansatt_id)
    ON DELETE RESTRICT
);

CREATE TABLE Prosjekt (
    prosjekt_id SERIAL PRIMARY KEY,
    navn VARCHAR(100),
    beskrivelse TEXT
);

CREATE TABLE AnsattProsjekt (
    ansatt_id INT,
    prosjekt_id INT,
    rolle VARCHAR(50),
    antall_arbeidstimer INT,
    PRIMARY KEY (ansatt_id, prosjekt_id),
    FOREIGN KEY (ansatt_id) REFERENCES Ansatt(ansatt_id)
    ON DELETE RESTRICT,
    FOREIGN KEY (prosjekt_id) REFERENCES Prosjekt(prosjekt_id)
    ON DELETE RESTRICT
);

ALTER TABLE Ansatt
ADD CONSTRAINT fk_avdeling_id_not_null
FOREIGN KEY (avdeling_id) REFERENCES Avdeling(avdeling_id)
ON DELETE RESTRICT;

ALTER TABLE Avdeling
ADD CONSTRAINT fk_sjef_ansatt_id_not_null
FOREIGN KEY (sjef_id) REFERENCES Ansatt(ansatt_id)
ON DELETE RESTRICT;

INSERT INTO Avdeling(navn, sjef_id)
VALUES ('Development', NULL);

-- Legg til sjefen i Avdeling-tabellen
INSERT INTO Ansatt (brukernavn, fornavn, etternavn, dato_ansatt, stilling, lonn_mnd, avdeling_id)
VALUES ('slaasletten', 'Frikk', 'Slaasletten', '2024-01-01', 'Driftssjef', 100000, 1);

-- Legg til den andre ansatte
INSERT INTO Ansatt (brukernavn, fornavn, etternavn, dato_ansatt, stilling, lonn_mnd, avdeling_id)
VALUES ('matsk', 'Mats', 'Karstad', '2024-01-04', 'Utvikler', 80000, 1);

-- Legg til den tredje ansatte
INSERT INTO Ansatt (brukernavn, fornavn, etternavn, dato_ansatt, stilling, lonn_mnd, avdeling_id)
VALUES ('kjetilme', 'Kjetil', 'Eide', '2024-03-04', 'Prosjektleder', 90000, 1);

SELECT * FROM Ansatt;
SELECT * FROM Avdeling;
