#include <bits/stdc++.h>
using namespace std;
void print(int arr[3][3]){
    for(int i = 0;i<3;i++){
        for(int j =0;j<3;j++){
            cout << arr[i][j] <<" ";
        }
        cout << endl;
    }
}
int main(){
    int arr[3][3] = {{1,2,3},{4,5,6},{7,8,9}};
    print(arr);
    for(int i =0;i<3;i++){
        for(int j =i;j<3;j++){
            swap(arr[i][j],arr[j][i]);
        }
    }
    for(int i =0;i<3;i++){
        reverse(arr[i],arr[i] +3);
    }
    cout << "Matrix 90-Degrees"<<endl;
    print(arr);
    return 0;
}