posible modelo

-- Crear tabla Scooter
CREATE TABLE Scooter (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         normalRate BIGINT,
                         extraRate BIGINT,
                         activeTime TIMESTAMP,
                         offTime TIMESTAMP,
                         kilometres BIGINT,
                         status BOOLEAN,
                         location VARCHAR(255),
                         stop_id INT,
                         FOREIGN KEY (stop_id) REFERENCES ScooterStop(id)
);

-- Crear tabla ScooterStop
CREATE TABLE ScooterStop (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             location VARCHAR(255)
);

-- Crear tabla Trip
CREATE TABLE Trip (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      idScooter BIGINT,
                      idUser BIGINT,
                      kilometres BIGINT,
                      startTime DATE,
                      endTime DATE,
                      price BIGINT,
                      offTime TIMESTAMP
);