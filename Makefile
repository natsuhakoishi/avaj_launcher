all: re

compile:
	find * -name "*.java" > sources.txt
	javac @sources.txt -d avaj_launcher

run: compile
	java Main sources.txt scenario.txt

clean:
	rm -rf avaj_launcher
	rm -f sources.txt

re: clean compile run
