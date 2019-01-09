FROM clojure:openjdk-11-lein
MAINTAINER Julia Naomi <jnaomi@thoughtworks.com>

EXPOSE 8888

RUN lein --version

WORKDIR /api

COPY project.clj ./
RUN lein deps

COPY . ./

ENTRYPOINT ["bash", "-c"]
CMD ["lein", "run"]
