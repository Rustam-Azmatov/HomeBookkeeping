CREATE TABLE bookeeping.users
(
   id serial, 
   login character varying(64) NOT NULL, 
   password character varying(128), 
   first_name character varying(64), 
   last_name character varying(64), 
   is_admin boolean, 
   CONSTRAINT user_id_pk PRIMARY KEY (id), 
   CONSTRAINT user_login_uk UNIQUE (login)
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE bookeeping.users
  OWNER TO bookeep;
