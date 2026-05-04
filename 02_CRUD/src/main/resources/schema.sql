DROP TABLE IF EXISTS student;

CREATE TABLE student (
                         id      INT    PRIMARY KEY,    -- matches 'private int id'
                         name    VARCHAR(100)  NOT NULL,       -- matches 'private String name'
                         marks   INT                           -- matches 'private int marks'
);