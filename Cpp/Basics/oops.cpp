#include <bits/stdc++.h>
using namespace std;
class Student{
    private:
    string name;
    int age;
    double marks;

    public:
    string getname(){
        return name;
    }
    void setname(string n){
        name = n;
    }
    int getage(){
        return age;
    }
    void setage(int a){
        age = a;
    }
    double getmarks(){
        return marks;
    }
    void setmarks(double ma){
        marks = ma;
    }
    void intro(){
        cout << "Hello World! I am "<< name <<"!"<<endl;
    }
};
class Animal{
    public:
    virtual void speaks(){
        cout << "Animal makes sounds!"<<endl;
    }

};
class Dog : public Animal{
    public:
    void speaks(){
        cout << "Dog barks!"<<endl;
    }
};
class overload{
    public:
    int add(int a , int b, int c){
        return a+b+c;
    }
    int add (int a , int b){
        return a+b;
    }
    double add(double a , double b){
        return a+b;
    }
};
int main(){
    Student obj;
    obj.setname("Luffy");
    obj.setage(19);
    obj.setmarks(10);

    cout << obj.getname() <<" "<<obj.getmarks()<<endl;

    Student obj2;
    obj2.setname("Light");
    obj2.setage(19);
    obj2.setmarks(100);

    cout << obj2.getname() <<" "<< obj2.getmarks()<<endl;

    Animal ani;
    ani.speaks();

    Dog ani2;
    ani2.speaks();

    overload obj3;
    int result1 = obj3.add(12,23,34);
    int result2 = obj3.add(12,34);
    double result3 = obj3.add(12.5,34.8);

    cout << "Add1: "<<result1<<endl;
    cout << "Add2: "<<result2<<endl;
    cout << "Add3: "<<result3<<endl;
    return 0;
}