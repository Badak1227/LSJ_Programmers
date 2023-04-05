#include <stdio.h>

int main(){
    int nums[20000001] = {0};
    int N, M;
    scanf("%d", &N);
    while(N--){
        int index;
        scanf("%d", &index);
        nums[index + 10000000]++;
    }
    scanf("%d", &M);
    while(M--){
        int index;
        scanf("%d", &index);
        printf("%d ", nums[index + 10000000]);
    }
}