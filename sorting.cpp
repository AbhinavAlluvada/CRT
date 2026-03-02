#include <bits/stdc++.h>
using namespace std;
int main(){
    vector<int> vect = {1,4,-3,2,5};
    int ptr = 0;
    for(int i =0;i<vect.size();i++){
        for(int j =0;j<vect.size()-i-1;j++){
            if(vect[j]>vect[j+1]){
                int temp = vect[j];
                vect[j] = vect[j+1];
                vect[j+1] = temp;
            }
        }
    }
    for(int i: vect){
        cout << i << " ";
    }
    cout << endl;
    return 0;
}