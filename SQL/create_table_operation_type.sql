CREATE TABLE bookeeping.operation_type
(
   id serial NOT NULL, 
   type_title character varying(64) NOT NULL, 
   type_name character varying(64) NOT NULL, 
   CONSTRAINT operation_type_id_pk PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE bookeeping.operation_type
  OWNER TO bookeep;
