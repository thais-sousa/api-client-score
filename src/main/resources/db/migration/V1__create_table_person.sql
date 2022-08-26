CREATE TABLE public.person(
    id UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    phone_number VARCHAR(11),
    email VARCHAR(50) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
)