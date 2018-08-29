-- id sequence
create sequence id_seq;

-- users table
create table users(
  id integer default nextval('id_seq'::regclass) not null
    constraint users_pkey
    primary key,
  name varchar(255) not null,
  password varchar(255) not null,
  datecreate date default CURRENT_DATE not null,
  locked boolean default true,
  datelock date
);

create unique index users_name_uindex on users (name);

-- roles table
create table roles(
  id integer default nextval('id_seq'::regclass) not null
    constraint roles_pkey
    primary key,
  name varchar(255) not null
);

-- user_roles table
create table user_roles(
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL ,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),

  UNIQUE (user_id, role_id)
);

-- create system user
INSERT INTO users (name, password, locked) VALUES ('testuser','testuser',false);

-- create roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- assign role to system user
INSERT INTO user_roles (user_id, role_id) VALUES (1,3);



