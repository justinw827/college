flags = -g -Wall -std=c++11

all: mono

mono: mono.o alg.o
	g++ $(flags) mono.o alg.o -o mono

mono.o: mono.cpp
	g++ -c $(flags) mono.cpp -o mono.o

alg.o: alg.cpp alg.h
	g++ -c $(flags) alg.cpp -o alg.o

clean:
	rm -f *.o mono