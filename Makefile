.PHONY: default install build test
SHELL := /bin/bash

default:
	@echo "Your options are: "
	@sed -n -e "/[a-z]:$$$\/p" Makefile

build:
	./gradlew clean assemble
	./docker-build.sh

run:
	docker run -p 8080:8080 stradar

test:

publish:

