CREATE TABLE public.client(
    id UUID NOT NULL,
    person_id UUID NOT NULL,
    current_score INTEGER NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT client_pk PRIMARY KEY (id),
    CONSTRAINT person_id_fk FOREIGN KEY (person_id) REFERENCES person (id)
)