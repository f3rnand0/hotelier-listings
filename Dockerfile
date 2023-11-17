FROM amazoncorretto:17.0.9
WORKDIR /app
EXPOSE $SERVER_PORT
ADD ./target/hotelier-listings-1.0.0.jar .
ENV DATABASE_URL=jdbc:h2:mem:listingsdb;DB_CLOSE_DELAY=-1 \
    DATABASE_USERNAME=sa \
    DATABASE_PASSWORD= \
    SERVER_PORT=$SERVER_PORT
ENTRYPOINT exec java -jar hotelier-listings-1.0.0.jar