#include <bits/stdc++.h>
using namespace std;

int main() {
    int temp;
    cout << "Enter a number: ";
    cin>> temp;
    int n = temp;
    int rev = 0;
    while(n!=0){
        int digit = n%10;
        rev = rev*10 + digit;
        n=n/10;
    }

    if(rev == temp) cout << "Hell yeah!"<<endl;
    else cout << "Nah!"<<endl;
    return 0;
}