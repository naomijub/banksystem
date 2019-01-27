setup:
	lein deps

watch:
	lein test-refresh

lint:
	lein cljfmt check

lint-fix:
	lein cljfmt fix

uberjar:
	lein uberjar

build:
	docker build -t banksystem .

run: build
	docker run -p 8888:8888 banksystem "lein run"

test: build
	docker run -p 8888:8888 banksystem "lein test"

run-local:
	lein run

test-local:
	lein test

run-cassandra:
	docker run -it --rm --name graphql-cassandra -p 9042:9042 -v "$(PWD)/dev-resources/testseed.cql:/testseed.cql" cassandra:3.11.1

seed-cassandra:
	docker exec -t graphql-cassandra cqlsh --debug -f /tesstseed.cql
