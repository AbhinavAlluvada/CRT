#include <bits/stdc++.h>
using namespace std;
class Calculator
{
public:
    float addition(float a, float b)
    {
        return a + b;
    }
    float subtraction(float a, float b)
    {
        return a - b;
    }
    float multiplication(float a, float b)
    {
        return a * b;
    }
    float division(float a, float b)
    {
        if (b == 0)
        {
            return -1;
        }
        return a / b;
    }
    float power(float a, float b)
    {
        return pow(a, b);
    }
    float modulo(int a, int b)
    {
        return a % b;
    }
};
int main()
{
    Calculator obj = Calculator();
    while (true)
    {
        float a, b;
        cout << "Enter your numbers:" << endl;
        cin >> a >> b;
        int choice;
        cout << "1.Addition" << endl;
        cout << "2.Subtraction" << endl;
        cout << "3.Multiplication" << endl;
        cout << "4.Division" << endl;
        cout << "5.Exponents" << endl;
        cout << "6.Modulo" << endl;
        cout << "7.Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;
        if (choice == 1)
        {
            float result = obj.addition(a, b);
            cout << result << endl;
            cout << "----------------------------" << endl;
        }
        if (choice == 2)
        {
            float result = obj.subtraction(a, b);
            cout << result << endl;
            cout << "----------------------------" << endl;
        }
        if (choice == 3)
        {
            float result = obj.multiplication(a, b);
            cout << result << endl;
            cout << "----------------------------" << endl;
        }
        if (choice == 4)
        {
            float result = obj.division(a, b);
            cout << result << endl;
            cout << "----------------------------" << endl;
        }
        if (choice == 5)
        {
            float result = obj.power(a, b);
            cout << result << endl;
            cout << "----------------------------" << endl;
        }
        if (choice == 6)
        {
            float result = obj.modulo(a, b);
            cout << result << endl;
            cout << "----------------------------" << endl;
        }
        if (choice == 7)
        {
            cout << "Program Terminated!" << endl;
            break;
        }
    }
    return 0;
}