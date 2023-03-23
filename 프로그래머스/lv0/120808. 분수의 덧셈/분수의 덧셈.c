#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int gcd(int num1, int num2){
    return num1 ? gcd(num2%num1, num1) : num2;  
}

int* solution(int numer1, int denom1, int numer2, int denom2) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(2*sizeof(int));
    int lcm;
    
    lcm = (denom1 > denom2) ? (denom1 * denom2)/gcd(denom2, denom1) : (denom1 * denom2)/gcd(denom1, denom2);
    
    answer[0] = numer1*(lcm/denom1) + numer2*(lcm/denom2);
    answer[1] = lcm;
    
    int tmpgcd = (answer[0] > answer[1]) ? gcd(answer[1], answer[0]) : gcd(answer[0], answer[1]);
    
    answer[0] /= tmpgcd;
    answer[1] /= tmpgcd;
                               
    return answer;
}