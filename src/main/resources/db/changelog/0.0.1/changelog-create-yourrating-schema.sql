--liquibase formatted sql

--changeset SemyonIvakaev:create-your-rating-schema
--comment create new schema
create schema your_rating;
--rollback drop schema your-rating;