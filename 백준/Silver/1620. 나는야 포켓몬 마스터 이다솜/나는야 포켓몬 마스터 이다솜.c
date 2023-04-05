#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct pokemon {
    char name[21];
    int num;
}pokemon;

int str_int(char str[]);

void comp(char str[], int start, int end, pokemon* namedic);

void sort(pokemon* namedic, int start, int end);

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    pokemon* idxdic = (pokemon*)malloc(N * sizeof(pokemon));
    pokemon* namedic = (pokemon*)malloc(N * sizeof(pokemon));

    for (int i = 0; i < N; i++) {
        scanf("%s", idxdic[i].name);
        idxdic[i].num = i + 1;
    }

    for (int i = 0; i < N; i++) {
        namedic[i] = idxdic[i];
    }

    sort(namedic, 0, N - 1);

    for (int i = 0; i < M; i++) {
        char tmp[21] = "";
        scanf("%s", tmp);
        if (tmp[0] <= '9') {
            printf("%s\n", idxdic[str_int(tmp) - 1].name);
        }
        else {
            comp(tmp, 0, N - 1, namedic);
        }
    }
}

int str_int(char str[]) {
    int num = 0;
    for (int i = strlen(str) - 1, j = 1; i >= 0; i--, j *= 10) {
        num += (str[i] - '0') * j;
    }
    return num;
}

void comp(char str[], int start, int end, pokemon* namedic) {
    while (start <= end) {
        int mid = (start + end) / 2;
        int cmp = strcmp(str, namedic[mid].name);
        if (cmp == 0) {
            printf("%d\n", namedic[mid].num);
            break;
        }
        else if (cmp < 0) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
    }
}

void sort(pokemon* namedic, int start, int end) {
    int l = start, r = end;
    char m[21] = "";
    strcpy(m, namedic[(l + r) / 2].name);

    while (l <= r) {
        while (strcmp(namedic[l].name, m) < 0) {
            l++;
        }
        while (strcmp(namedic[r].name, m) > 0) {
            r--;
        }


        if (l <= r) {
            pokemon tmp;
            tmp = namedic[l];
            namedic[l] = namedic[r];
            namedic[r] = tmp;

            l++;
            r--;
        }
    }

    if (start < r) {
        sort(namedic, start, r);
    }
    if (l < end) {
        sort(namedic, l, end);
    }
}