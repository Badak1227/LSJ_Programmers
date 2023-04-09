#include <stdio.h>

long long int fac(int num1, int num2) {
    long long int tmp = 1;
    num1 = num1 > num2 / 2 ? num2 - num1 : num1;
    for (int i = num2; i > num2 - num1; i--) {
        tmp *= i;
    }
    for (int i = num1; i >= 2; i--) {
        tmp /= i;
    }
    return tmp;
}

int main() {
    int T, n, m;
    scanf("%d", &T);
    for (int i = 0; i < T; i++) {
        scanf("%d %d", &n, &m);
        printf("%lld\n", fac(n, m));
    }
}