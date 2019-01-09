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
	docker build -t twjoi .

run: build
	docker run -p 8888:8888 twjoi "lein run"

test: build
	docker run -p 8888:8888 twjoi "lein test"

run-local:
	lein run

test-local:
	lein test
