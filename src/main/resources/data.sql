create table public.lead (
                             id integer primary key not null default nextval('lead_id_seq'::regclass),
                             aggregate_id character varying(256),
                             changeset_id character varying(256),
                             payload json[],
                             metadata json
);
create unique index lead_aggregate_id_changeset_id_key on lead using btree (lead_id, changeset_id);

