--
-- PostgreSQL database dump
--

-- Dumped from database version 12.7 (Ubuntu 12.7-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.7 (Ubuntu 12.7-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: tasks; Type: TABLE; Schema: public; Owner: softwaredev
--

CREATE TABLE public.tasks (
    id integer NOT NULL,
    description character varying,
    completed boolean
);


ALTER TABLE public.tasks OWNER TO softwaredev;

--
-- Name: tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: softwaredev
--

CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tasks_id_seq OWNER TO softwaredev;

--
-- Name: tasks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: softwaredev
--

ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;


--
-- Name: tasks id; Type: DEFAULT; Schema: public; Owner: softwaredev
--

ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: softwaredev
--

COPY public.tasks (id, description, completed) FROM stdin;
1	kill the person	\N
\.


--
-- Name: tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: softwaredev
--

SELECT pg_catalog.setval('public.tasks_id_seq', 1, true);


--
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: softwaredev
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

