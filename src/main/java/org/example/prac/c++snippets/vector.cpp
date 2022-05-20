#include <bits/stdc++.h>
using namespace std;

int main() {


vector<int> a;                                       // empty vector of ints
vector<int> b (5, 10);                                // five ints with value 10
vector<int> c (b.begin(),b.end());                     // iterating through second
vector<int> d (c);                                   // copy of c

	vector<int>vec;

	vec.push_back(1);
	vec.push_back(4);

	vector<int>::iterator it1;

	for(auto it : vec) {
	    cout<<"element : "<<it<<endl;
	}
}
