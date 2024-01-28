--liguibase formatted sql

--changeset SemyonIvakaev:create-your_rating-comments-table
--comment create table your_rating.comments
create table your_rating.comments
(
    id                serial primary key,
    message           varchar(180)  not null,
    user_profile_id   integer       not null,
    created_timestamp timestamp     not null
);
--rollback drop table your_rating.comments;

--changeset SemyonIvakaev:add-your_rating-user_profiles-table-constraints
--comment add constraints to your_rating.comments table
alter table your_rating.comments
    add constraint comments__user_profiles__fk
        foreign key (user_profile_id) references your_rating.user_profiles (id);

--rollback alter table your_rating.comments drop constraint comments__user_profiles__fk;