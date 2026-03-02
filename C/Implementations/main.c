#include <stdio.h>

int main(void) {
    double a, b;
    char op;

    printf("Enter expression (e.g., 10 + 5): ");
    if (scanf("%lf %c %lf", &a, &op, &b) != 3) {
        printf("Invalid input\n");
        return 1;
    }

    switch (op) {
        case '+':
            printf("%.2lf\n", a + b);
            break;
        case '-':
            printf("%.2lf\n", a - b);
            break;
        case '*':
            printf("%.2lf\n", a * b);
            break;
        case '/':
            if (b == 0) {
                printf("Division by zero error\n");
                return 1;
            }
            printf("%.2lf\n", a / b);
            break;
        default:
            printf("Invalid operator\n");
            return 1;
    }

    return 0;
}
