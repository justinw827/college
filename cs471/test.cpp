#include <iostream>

using namespace std;

int main() {
	double* dp = new double(3);
	void* vp;
	int* ip;

	vp = dp;
	
	cout << ip << endl;
	ip = (int*) vp;
	cout << ip << endl;
	ip = static_cast<int*>(vp);
	cout << ip << endl;
	ip = reinterpret_cast<int*>(dp);

	cout << ip << endl;

	return 0;
}
