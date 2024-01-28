--liguibase formatted sql

--changeset SemyonIvakaev:create-your_rating-user_profiles-table
--comment create table your_rating.user_profiles
create table your_rating.user_profiles
(
    id         integer primary key,
    nickname   varchar(32) not null,
    image_link varchar(128) not null
);
--rollback drop table your_rating.user_profiles;

--changeset SemyonIvakaev:add-your_rating-user_profiles-table-constraints
--comment add constraints to your_rating.user_profiles table
alter table your_rating.user_profiles
    add constraint user_profiles__user_accounts__fk
        foreign key (id) references identity.user_accounts (id);

alter table your_rating.user_profiles
    add constraint user_profiles__nickname__unique
        unique (nickname);
--rollback alter table your_rating.user_profiles drop constraint user_profiles__user_accounts__fk;
--rollback alter table your_rating.user_profiles drop constraint user_profiles__nickname__unique;