#include <stdio.h>

int queue[1001] = { 0 };

int front = 0;
int rear = 0;

int main() {
	int N, K;
	scanf("%d %d", &N, &K);

	for (int i = 1; N--; i++) {
		queue[rear++] = i;
	}

	int pop = 1;
	printf("<");
	while (rear != front) {
		if (pop == K) {
			printf("%d", queue[front]);
			front = (front + 1) % 1001;
			pop = 1;
			if (rear == front) break;
			printf(", ");
		}
		else {
			queue[rear] = queue[front];
			rear = (rear + 1) % 1001;
			front = (front + 1) % 1001;
			pop++;
		}
	}
	printf(">");
	return 0;
}