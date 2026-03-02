#include <bits/stdc++.h>
using namespace std;
void input(int &row, int &col)
{
    cout << "Enter no.of rows: ";
    cin >> row;
    cout << "Enter no.of cols: ";
    cin >> col;
}
int main()
{
    int n = 4;
    for(int i =0;i<n;i++){
        for(int j = 0;j<=i;j++){
            cout << "* ";
        }
        for(int k =i;k<(2*n -i-2);k++){
            cout << "  ";
        }
        for(int j = 0;j<=i;j++){
            cout << "* ";
        }
        cout << endl;
    }
        for(int i =n-2;i>=0;i--){
        for(int j = 0;j<=i;j++){
            cout << "* ";
        }
        for(int k =i;k<(2*n -i-2);k++){
            cout << "  ";
        }
        for(int j = 0;j<=i;j++){
            cout << "* ";
        }
        cout << endl;
    }
    return 0;
}