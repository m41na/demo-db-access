sample spring jdbc with northwind database

#update gradlew version
gradle wrapper --gradle-version 6.9

#create local volume for postgres data
mkdir ${HOME}/.pgdata
docker run -d \
--name dev-postgres \
-e POSTGRES_PASSWORD=postgres \
-v ${HOME}/.pgdata/:/var/lib/postgresql/data \
-p 5432:5432
postgres:latest
