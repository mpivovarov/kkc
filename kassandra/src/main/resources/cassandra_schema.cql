CREATE KEYSPACE IF NOT EXISTS kkc
    WITH replication = {'class': 'SimpleStrategy'};

CREATE TABLE IF NOT EXISTS kkc.message (
    id bigint,
    message_id uuid,
    timestamp: timestamp,
    subject: text,
    message: text,
    PRIMARY KEY ((id))
)