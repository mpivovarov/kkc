CREATE KEYSPACE IF NOT EXISTS kkc
    WITH replication = {'class': 'SimpleStrategy'};

CREATE TABLE IF NOT EXISTS kkc.message (
    message_id uuid,
    timestamp timestamp,
    subject text,
    message text,
    PRIMARY KEY ((message_id))
);