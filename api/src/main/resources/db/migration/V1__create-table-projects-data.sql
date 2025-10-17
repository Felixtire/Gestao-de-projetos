CREATE TABLE projects (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(500),
    start_date DATETIME,
    end_date DATETIME
);

CREATE TABLE tasks (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description_task VARCHAR(500),
    status VARCHAR(100) NOT NULL,
    priority VARCHAR(100) NOT NULL,
    due_date DATETIME,
    project_id BIGINT,
    FOREIGN KEY (project_id) REFERENCES projects(id)
);
