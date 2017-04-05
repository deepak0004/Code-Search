#include<stdio.h>
#include<stdlib.h>
 
struct node
{
    void  *data; 	// pointers
 
    struct node *next; 	// pointers
};
 
void push(struct node** head_ref, void *new_data, size_t data_size) 	// types
{
    struct node* new_node = (struct node*)malloc(sizeof(struct node)); 	// types,integer,pointers
 
    new_node->data  = malloc(data_size); 	// types,integer
    new_node->next = (*head_ref); 	// types,integer,pointers
    int i; 	// structure
    for (i=0; i<data_size; i++) 	// types,loop,function,integer
        *(char *)(new_node->data + i) = *(char *)(new_data + i); 	// character,types,string,array,double,integer,pointers,structure
    (*head_ref)    = new_node; 	// types,integer,pointers
}
 
void printList(struct node *node, void (*fptr)(void *)) 	// types
{
    while (node != NULL) 	// types,integer
    {
        (*fptr)(node->data); 	// types,pointers,structure
        node = node->next; 	// integer
    }
}
 
// Function to print an integer
void printInt(void *n) 	// types
{
   printf(" %d", *(int *)n); 	// characters,types,pointers
}
 
void printFloat(void *f) 	// types
{
   printf(" %f", *(float *)f); 	// types,pointers
}

int main() 	// types
{
    struct node *start = NULL; 	// integer,pointers
 
    unsigned int_size = sizeof(int); 	// characters,types,integer
    int arr[] = {10, 20, 30, 40, 50}, i; 	// types,functions,array,integer,while,list
    for (i=4; i>=0; i--) 	// types,loop,integer
       push(&start, &arr[i], int_size); 	// types
    printf("Created integer linked list is \n"); 	// types
    printList(start, printInt); 	// types
 
    unsigned float_size = sizeof(float); 	// types,integer
    start = NULL; 	// integer
    float arr2[] = {10.1, 20.2, 30.3, 40.4, 50.5}; 	// types,functions,array,integer,while,list
    for (i=4; i>=0; i--) 	// types,loop,integer
       push(&start, &arr2[i], float_size); 	// types
    printf("\n\nCreated float linked list is \n"); 	// types
    printList(start, printFloat); 	// types
 
    return 0;
}
