#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char* str[100001] = { 0 };
int freq[100001] = { 0 };
int idx = 0;

typedef struct trie {
    struct trie* alpha[26];
    int end;
    int freq;
}trie;

trie* new_trie();

void insert(char str[], trie* root);

void search(trie* root, int index, char arr[]);

void merge_sort_len(int start, int end);

void merge_len(int start, int mid, int end);

void merge_sort_freq(int start, int end);

void merge_freq(int start, int mid, int end);

void free_trie(trie* root);

int main() {
    int N, M;
    scanf("%d %d", &N, &M);


    trie* che = new_trie();

    for (int i = 0; i < N; i++) {
        char* tmp = (char*)malloc(sizeof(char) * 11);
        scanf("%s", tmp);
        if (strlen(tmp) >= M) {
            insert(tmp, che);
        }
    }

    char tmp[11] = "";

    search(che, 0, tmp);

    merge_sort_len(0, idx - 1);

    merge_sort_freq(0, idx - 1);

    idx = 0;
    while (str[idx] != 0) {
        printf("%s\n", str[idx], freq[idx]);
        idx++;
    }

    idx = 0;
    while (str[idx] != 0) {
        free(str[idx++]);
    }

    free_trie(che);
}



trie* new_trie() {
    trie* tmp = (trie*)malloc(sizeof(trie));
    for (int i = 0; i < 26; i++) {
        tmp->alpha[i] = 0;
    }
    tmp->end = 0;
    tmp->freq = 0;

    return tmp;
}

void insert(char str[], trie* root) {
    trie* cur = root;
    for (int i = 0; str[i] != 0; i++) {
        int idx = str[i] - 'a';
        if (!cur->alpha[idx]) {
            cur->alpha[idx] = new_trie();
        }

        cur = cur->alpha[idx];
    }

    cur->freq++;
    cur->end = 1;
}

void search(trie* root, int index, char arr[]) {
    trie* cur = root;

    if (cur->end) {
        arr[index] = 0;

        char* tmp = (char*)malloc(sizeof(char) * 11);
        strcpy(tmp, arr);

        str[idx] = tmp;
        freq[idx++] = cur->freq;
    }

    for (int i = 0; i < 26; i++) {
        if (cur->alpha[i]) {
            arr[index] = i + 'a';
            search(cur->alpha[i], index + 1, arr);
        }
    }
}

void merge_sort_len(int start, int end) {
    int l = start, r = end, m = (l + r) / 2;

    if (l < r) {
        merge_sort_len(l, m);
        merge_sort_len(m + 1, r);
        merge_len(l, m, r);
    }
}

void merge_len(int start, int mid, int end) {
    int l = start, r = mid + 1;

    char** tmps = (char**)malloc(sizeof(char*) * (end - start + 1));
    int* tmpf = (int*)malloc(sizeof(int*) * (end - start + 1));
    int idx = 0;

    while (l <= mid && r <= end) {
        if (strlen(str[l]) >= strlen(str[r])) {
            tmps[idx] = str[l];
            tmpf[idx++] = freq[l++];
        }
        else {
            tmps[idx] = str[r];
            tmpf[idx++] = freq[r++];
        }
    }
    while (l <= mid) {
        tmps[idx] = str[l];
        tmpf[idx++] = freq[l++];
    }
    while (r <= end) {
        tmps[idx] = str[r];
        tmpf[idx++] = freq[r++];
    }

    idx = 0;
    l = start;
    while (l <= end) {
        str[l] = tmps[idx];
        freq[l++] = tmpf[idx++];
    }

    free(tmps);
    free(tmpf);
}

void merge_sort_freq(int start, int end) {
    int l = start, r = end, m = (l + r) / 2;

    if (l < r) {
        merge_sort_freq(l, m);
        merge_sort_freq(m + 1, r);
        merge_freq(l, m, r);
    }
}

void merge_freq(int start, int mid, int end) {
    int l = start, r = mid + 1;

    char** tmps = (char**)malloc(sizeof(char*) * (end - start + 1));
    int* tmpf = (int*)malloc(sizeof(int*) * (end - start + 1));
    int idx = 0;

    while (l <= mid && r <= end) {
        if (freq[l] >= freq[r]) {
            tmps[idx] = str[l];
            tmpf[idx++] = freq[l++];
        }
        else {
            tmps[idx] = str[r];
            tmpf[idx++] = freq[r++];
        }
    }
    while (l <= mid) {
        tmps[idx] = str[l];
        tmpf[idx++] = freq[l++];
    }
    while (r <= end) {
        tmps[idx] = str[r];
        tmpf[idx++] = freq[r++];
    }

    idx = 0;
    l = start;
    while (l <= end) {
        str[l] = tmps[idx];
        freq[l++] = tmpf[idx++];
    }

    free(tmps);
    free(tmpf);
}

void free_trie(trie* root) {
    trie* cur = root;
    for (int i = 0; i < 26; i++) {
        if (cur->alpha[i]) {
            free_trie(cur->alpha[i]);
        }
    }
    free(cur);
}