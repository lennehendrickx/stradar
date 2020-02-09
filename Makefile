.PHONY: default install build test
SHELL := /bin/bash

default:
	@echo "Your options are: "
	@sed -n -e "/[a-z]:$$$\/p" Makefile

build:
	./docker-build.sh

run:
	docker run -p 8080:8080 --env-file .env stradar

test:

publish:
	heroku container:login
	docker tag stradar registry.heroku.com/stradar/web
	docker push registry.heroku.com/stradar/web

release:
	heroku container:release web -a stradar

