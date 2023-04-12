#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct trie_ {
	struct trie_* alphabet[62];
	int infect;
	int end;
}trie;

trie* new_trie();

void ChongChong_set(trie* root);

void insert(char str1[], char str2[], trie* root);

void free_trie(trie* root);

int count = 0;

int main(){
	int N;
	trie* name = new_trie();
	ChongChong_set(name);

	scanf("%d", &N);
	
	for (int i = 0; i < N; i++) {
		char str1[21], str2[21];
		scanf("%s %s", str1, str2);
		insert(str1, str2, name);
	}

	printf("%d", count);

	free_trie(name);
	return 0;
}

trie* new_trie() {
	trie* tmp = (trie*)malloc(sizeof(trie));
	for (int i = 0; i < 62; i++) {
		tmp->alphabet[i] = NULL;
	}
	tmp->infect = 0;
	tmp->end = 0;
	return tmp;
}

void ChongChong_set(trie* root) {
	char str[21] = "ChongChong";
	trie* cur = root;

	for (int i = 0; i < 10; i++) {
		int index = 0;
		if (str[i] >= 'a') {
			index = str[i] - 'a' + 36;
		}
		else if(str[i] >= 'A') {
			index = str[i] - 'A' + 10;
		}
		else {
			index = str[i] - '0';
		}
		cur->alphabet[index] = new_trie();
		cur = cur->alphabet[index];
	}
	cur->end = 1;
	cur->infect = 1;
	count++;
}

void insert(char str1[], char str2[], trie* root) {
	trie* cur1 = root;
	int len1 = strlen(str1);
	
	for (int i = 0; i < len1; i++) {
		int index = 0;
		if (str1[i] >= 'a') {
			index = str1[i] - 'a' + 36;
		}
		else if (str1[i] >= 'A') {
			index = str1[i] - 'A' + 10;
		}
		else {
			index = str1[i] - '0';
		}

		if (cur1->alphabet[index] == NULL) {
			cur1->alphabet[index] = new_trie();
		}
		cur1 = cur1->alphabet[index];
	}
	cur1->end = 1;
	
	trie* cur2 = root;
	int len2 = strlen(str2);

	for (int i = 0; i < len2; i++) {
		int index = 0;
		if (str2[i] >= 'a') {
			index = str2[i] - 'a' + 36;
		}
		else if (str2[i] >= 'A') {
			index = str2[i] - 'A' + 10;
		}
		else {
			index = str2[i] - '0';
		}

		if (cur2->alphabet[index] == NULL) {
			cur2->alphabet[index] = new_trie();
		}
		cur2 = cur2->alphabet[index];
	}
	cur2->end = 1;

	if (cur1->infect != cur2->infect) {
		cur1->infect = 1;
		cur2->infect = 1;
		
		count++;
	}
}

void free_trie(trie* root) {
	for (int i = 0; i < 62; i++) {
		if (root->alphabet[i]) {
			free_trie(root->alphabet[i]);
		}
	}
	free(root);
}