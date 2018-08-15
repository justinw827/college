#include <fstream>
#include <string>
#include <iostream>

#include "alg.h"

using namespace std;

int main(int argc, char *argv[]) {

	string inputFile;
	string outputFile;
	int seed;
	int type;

	if (argc == 4) {
		inputFile = argv[1]; // Get input file
		outputFile = argv[2]; // Get output file
		seed = 0; // Set seed default

		string temp = argv[3]; // Get encryption/decryption value
		type = stoi(temp); // Convert to int
		if (type != 0 && type != 1) { // Check encryption/decryption variable is 0 or 1
			cout << "Last argument must be '0' or '1'" << endl;
			exit(1);
		}
	} else if (argc == 5) {
		inputFile = argv[1];
		outputFile = argv[2];

		string temp = argv[3];
		string temp2 = argv[4];

		seed = stoi(temp);
		type = stoi(temp2);
		if (type != 0 && type != 1) { // Check encryption/decryption variable is 0 or 1
			cout << "Last argument must be '0' or '1'" << endl;
			exit(1);
		}
	} else { // unexpected number of args
		cout << "Expected either 3 or 4 arguments.\nUsage: ./mono <input.txt> <output.txt> <seed> 0/1" << endl;
		exit(1);
	}

	
	return 0;	
}