#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);

    for (int i = 0; i < T; i++) {
        char stack[50] = { 0 };
        int index = 0;
        int VPS = 1;

        char PS[51];
        scanf("%s", PS);
        int j = 0;
        while (PS[j]) {
            if (PS[j] == '(') {
                stack[index++] = '(';
            }
            else if (PS[j] == ')') {
                if (index > 0) {
                    index--;
                }
                else {
                    VPS = 0;
                    break;
                }
            }
            
            j++;
        }
        VPS = index > 0 ? 0 : VPS;
        printf("%s\n", VPS == 1 ? "YES" : "NO");
    }
    
    return 0;
}