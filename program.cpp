#include <bits/stdc++.h>
using namespace std;
void sub()
{
    vector<int> vect = {1, 2, 3, 4, 5, -2};
    sort(vect.begin(), vect.end());
    int left = 0;
    int right = vect.size() - 1;
    int target = 5;
    while (left < right)
    {
        int sum = vect[left] + vect[right];
        if (sum == target)
        {
            cout << "Bingo!" << vect[left] << " " << vect[right] << endl;
            break;
        }
        else if (sum < target)
        {
            left++;
        }
        else
        {
            right--;
        }
    }
}

void duplicate(){
    vector <int> vect = {1,1,2,3,4,5,6,6};
    int n = vect.size();
    int slow = 0;
    for(int fast = 1; fast < n;fast++){
        if(vect[fast]!=vect[slow]){
            slow++;
            vect[slow] = vect[fast];
        }
    }
    vect.resize(slow+1);
    for(int i : vect){
        cout << i << " ";
    }
    cout << endl;
}
int main()
{
    duplicate();
    return 0;
}