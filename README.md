# Kotlin Tryouts

Testing out some Kotlin, some GraphQL, some Spring Boot, and whatever else in that general area I want to brush up on

# Running

`./gradlew bootRun`

## Set up DB

```bash
cd database
docker build . -t ktdb
docker run -itp 5432:5432 ktdb

cd ..
./gradlew flywayMigrate -i
```
