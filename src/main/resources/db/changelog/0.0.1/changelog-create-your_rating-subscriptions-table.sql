--liquibase formatted sql

--changeset SemyonIvakaev:create-your_rating-subscriptions-table
--comment create table your_rating.subscriptions
create table your_rating.subscriptions
(
    id                serial primary key,
    follower_id       integer       not null,
    followed_id       integer       not null,
    created_timestamp timestamp     not null
);
--rollback drop table your_rating.subscriptions;

--changeset SemyonIvakaev:add-your_rating-subscriptions-table-constraints
--comment add constraints to your_rating.subscriptions table
alter table your_rating.subscriptions
    add constraint follower__user_profiles__fk
        foreign key (follower_id) references your_rating.user_profiles (id);

alter table your_rating.subscriptions
    add constraint followed__user_profiles__fk
        foreign key (followed_id) references your_rating.user_profiles (id);

alter table your_rating.subscriptions
    add constraint subscriptions__relationship_unique
        unique (follower_id, followed_id);
--rollback alter table your_rating.subscriptions drop constraint follower__user_profiles__fk;
--rollback alter table your_rating.subscriptions drop constraint followed__user_profiles__fk;
--rollback alter table your_rating.subscriptions drop constraint subscriptions__relationship_unique;
