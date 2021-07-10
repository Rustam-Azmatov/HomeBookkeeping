CREATE TABLE bookeeping.user_budget
(
   id serial NOT NULL, 
   user_id integer NOT NULL, 
   budget_id integer NOT NULL, 
   role character varying(64), 
   CONSTRAINT user_budget_id_pk PRIMARY KEY (id), 
   CONSTRAINT user_budget_user_fk FOREIGN KEY (user_id) REFERENCES bookeeping.users (id) ON UPDATE CASCADE ON DELETE CASCADE, 
   CONSTRAINT user_budget_budget_fk FOREIGN KEY (budget_id) REFERENCES bookeeping.budget (id) ON UPDATE CASCADE ON DELETE CASCADE, 
   CONSTRAINT user_budget_role_check CHECK (role = 'VIEW' or role = 'EDIT')
) 
WITH (
  OIDS = FALSE
)
;
COMMENT ON COLUMN bookeeping.user_budget.role IS 'What is able to do whith budget.
VIEW,EDIT';
ALTER TABLE bookeeping.user_budget
  OWNER TO bookeep;