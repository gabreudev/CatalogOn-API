#!/usr/bin/env bash

# Esperar até que o Cassandra esteja pronto para aceitar conexões
until printf "" 2>>/dev/null >>/dev/tcp/cassandra/9042; do
  sleep 5;
  echo "Waiting for cassandra...";
done

echo "Cassandra is up - executing commands..."

# Criar keyspace e tabela
cqlsh cassandra -u cassandra -p cassandra -e "CREATE KEYSPACE IF NOT EXISTS mykeyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};"
cqlsh cassandra -u cassandra -p cassandra -e "CREATE TABLE IF NOT EXISTS mykeyspace.product ( id UUID PRIMARY KEY, nome text, descricao text, preco float, img text);"
