CREATE TABLE bookeeping.action
(
   id serial NOT NULL, 
   action_type smallint NOT NULL, 
   sum numeric(12,2) NOT NULL, 
   total_sum numeric(12,2) NOT NULL, 
   budget_state_id integer NOT NULL, 
   operation_id integer NOT NULL, 
   action_time timestamp without time zone NOT NULL, 
   CONSTRAINT action_id_pk PRIMARY KEY (id), 
   CONSTRAINT operation_id_fk FOREIGN KEY (operation_id) REFERENCES bookeeping.operation (id) ON UPDATE CASCADE ON DELETE CASCADE, 
   CONSTRAINT budget_state_id_fk FOREIGN KEY (budget_state_id) REFERENCES bookeeping.budget_state (id) ON UPDATE CASCADE ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE bookeeping.action
  OWNER TO bookeep;
