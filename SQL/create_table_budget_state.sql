CREATE TABLE bookeeping.budget_state
(
   id serial NOT NULL, 
   sum numeric(12,2) NOT NULL, 
   state_type character varying(16) NOT NULL, 
   state_name character varying(128) NOT NULL, 
   budget_id integer NOT NULL, 
   CONSTRAINT budget_state_id PRIMARY KEY (id), 
   CONSTRAINT budget_state_id_fk FOREIGN KEY (budget_id) REFERENCES bookeeping.budget (id) ON UPDATE RESTRICT ON DELETE RESTRICT, 
   CONSTRAINT budget_state_type_ch CHECK (state_type in ('CASH','BANK_CARD','BORROW','LEND'))
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE bookeeping.budget_state
  OWNER TO bookeep;
