CREATE TABLE public.address(
    id UUID NOT NULL,
    person_id UUID NOT NULL,
    street VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT adress_pk PRIMARY KEY (id),
    CONSTRAINT person_fk FOREIGN KEY (person_id) REFERENCES person (id)
)