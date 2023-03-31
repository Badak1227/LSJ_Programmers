#include <stdio.h>

int main() {
    long int N;
    scanf("%d", &N);
    int count = 1;
    for (long int j = 2; j * j <= N; j++) {
        count++;
    }
    printf("%d", count);
}