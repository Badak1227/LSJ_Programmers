#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct trie_ {
    struct trie_* alphabet[26];
    int end;
}trie;

trie* new_trie() {
    trie* tmp = (trie*)malloc(sizeof(trie));
    for (int i = 0; i < 26; i++) {
        tmp->alphabet[i] = NULL;
    }
    tmp->end = 1;
    return tmp;
}

void insert(char str[], trie* head) {
    trie* cur = head;
    int len = strlen(str);
    
    for (int i = 0; i < len; i++) {
        int index = str[i] - 'a';

        if (cur->alphabet[index] == NULL) {
            cur->alphabet[index] = new_trie();
        }
        cur = cur->alphabet[index];
    }
    cur->end = 0;
}

int comp(char str[], trie* head) {
    trie* cur = head;
    int e = strlen(str);
    for (int i = 0; i < e; i++) {
        
        if (!cur->alphabet[str[i] - 'a']) {
            return 0;
        }
        cur = cur->alphabet[str[i] - 'a'];
    }
    return cur->end ? 0 : 1;
}

int main() {
    int N, M, count = 0;
    trie* strs = new_trie();

    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++) {
        char str[500];
        scanf("%s", str);
        insert(str, strs);
    }

    for (int i = 0; i < M; i++) {
        char str[500];
        scanf("%s", str);
        count += comp(str, strs);
    }

    printf("%d", count);
    return 0;
}