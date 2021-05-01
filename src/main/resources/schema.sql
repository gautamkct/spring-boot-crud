
CREATE TABLE department (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    dept_name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employee (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    emp_name VARCHAR(128) NOT NULL,
    doj DATE NOT NULL,
    salary decimal(8,2) DEFAULT NULL,
    department_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 21 INCREMENT BY 1;