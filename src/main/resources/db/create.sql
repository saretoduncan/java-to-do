CREATE DATABASE todolist;
\c todolist;
CREATE TABLE tasks (id SERIAL PRIMARY KEY, description VARCHAR, completed BOOLEAN);
CREATE DATABASE todolist_test WITH TEMPLATE  todolist;