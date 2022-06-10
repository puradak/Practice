#include <stdio.h>
#include <stdlib.h>
#define stack queue

typedef struct node {
	int value;
	struct node* next;
}node;

typedef struct stack {
	node* head;
	node* tail;
}stack;

void push(stack* s, int value) {
	if (s->head == NULL) {
		node* dummy = (node*)malloc(sizeof(node));
		s->head = dummy;
		s->tail = dummy;
	}

	node* newNode = (node*)malloc(sizeof(node));
	newNode->value = value;
	newNode->next = NULL;
	s->tail->next = newNode;
	s->tail = newNode;
	return;
}

void pop(stack* s) {
	if (s->head == s->tail) {
		return;
	}
	node* temp = s->head;
	while (temp) {
		if (temp->next == s->tail) {
			printf("[%d] ", s->tail->value);
			s->tail = temp;
			free(temp->next);
			return;
		}
		temp = temp->next;
	}
	return;
}

void enQueue(queue* q, int value) {
	if (q->head == NULL) {
		node* dummy = (node*)malloc(sizeof(node));
		q->head = dummy;
		q->tail = dummy;
	}

	node* newNode = (node*)malloc(sizeof(node));
	newNode->value = value;
	newNode->next = NULL;
	q->tail->next = newNode;
	q->tail = newNode;
	return;
}

void deQueue(queue* q) {
	if (q->head == q->tail) {
		return;
	}
	node* temp = q->head->next;
	q->head->next = temp->next;
	printf("[%d] ", temp->value);
	free(temp);
}

int main(void) {
	stack s = { NULL,NULL };
	for (int i = 0; i < 10; i++) {
		push(&s, (i + 1) * 10);
	}
	for (int i = 0; i < 10; i++) {
		pop(&s);
	}
	queue q = { NULL, NULL };
	printf("\n\n");
	for (int i = 0; i < 10; i++) {
		enQueue(&q, (i + 1) * 10);
	}
	for (int i = 0; i < 10; i++) {
		deQueue(&q);
	}
}