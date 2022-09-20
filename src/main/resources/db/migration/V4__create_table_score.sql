CREATE TABLE public.score(
    id UUID NOT NULL,
    client_id UUID NOT NULL,
    consulted_date TIMESTAMP NOT NULL,
    score INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT score_pk PRIMARY KEY (id),
    CONSTRAINT client_fk FOREIGN KEY (client_id) REFERENCES client (id)
);
