#include <bits/stdc++.h>
using namespace std;

struct Foo {
    bool operator()(int a,int b) {
        return a<b;
    }
};

bool func(int a, int b) {
    return a<b;
}

int main() {
	priority_queue<int,vector<int>,Foo>pq;


	pq.push(2);
	pq.push(1);
	pq.push(3);

	cout<<"top "<<pq.top()<<endl;

	return 0;
}
