
FROM cassandra:latest

COPY init.sh /docker-entrypoint-initdb.d/
