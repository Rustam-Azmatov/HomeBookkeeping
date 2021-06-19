CREATE TABLE bookeeping.operation
(
   id serial NOT NULL, 
   operation_type_id integer NOT NULL, 
   category_id integer NOT NULL, 
   CONSTRAINT operation_id_pk PRIMARY KEY (id), 
   CONSTRAINT operation_type_id_fk FOREIGN KEY (operation_type_id) REFERENCES bookeeping.operation_type (id) ON UPDATE RESTRICT ON DELETE RESTRICT, 
   CONSTRAINT category_id_fk FOREIGN KEY (category_id) REFERENCES bookeeping.category (id) ON UPDATE RESTRICT ON DELETE RESTRICT
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE bookeeping.operation
  OWNER TO bookeep;
