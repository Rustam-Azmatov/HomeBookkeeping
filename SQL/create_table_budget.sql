CREATE TABLE bookeeping.budget
(
   id serial NOT NULL, 
   budget_name character varying(64) NOT NULL, 
   CONSTRAINT budget_id_pk PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE bookeeping.budget
  OWNER TO bookeep;