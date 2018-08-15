#ifndef ALG_H
#define ALG_H

#include <string>

using namespace std;

class alg {
	public:
		alg();

		void encrypt(string inputFile, string outputFile, int seed);
		void decrypt(string inputFile, string outputFile, int seed);

		~alg();
};



#endif