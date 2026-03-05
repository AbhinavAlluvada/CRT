#include <bits/stdc++.h>
using namespace std;
int main(){
    int row , col;
    cout << "Enter no of rows: ";
    cin >> row;
    cout << "Enter no of cols: ";
    cin>> col;
    int arr[row][col];
    for(int i =0;i<row;i++){
        for(int j =0;j<col;j++){
            cout << "Row ("<<i<<") and Col ("<<j<<"): ";
            cin >> arr[i][j];
        }
    }
    for(int i =0;i<row;i++){
        for(int j =0;j<col;j++){
            cout << arr[i][j] <<" ";
        }
        cout << endl;
    }
    return 0;
}