#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define min 100
#define max 200

int main ()
{
  srand ( time(NULL) );
  int random_number = ( rand() % ( max - min +1 ) ) + min;
  printf("%d",random_number);
  
  return 0;
}
