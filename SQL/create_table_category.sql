CREATE TABLE bookeeping.category
(
   id serial NOT NULL, 
   category_name character varying(64) NOT NULL,
   CONSTRAINT category_id PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE bookeeping.category
  OWNER TO bookeep;
