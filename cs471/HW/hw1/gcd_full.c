#include <stdio.h>
#include "gcd.h"


/* Imperative style modification of example 1.20  */

int gcdI(int i, int j) {
   while ( i != j) { 
       if (i > j) {
          i = i - j;
       } else {
          j = j - i;
       }
   }      
   return i;
}

/* Modiification of 1.4 page 38 */
int gcdM(int i, int j) {
   while (i != j) {
      if (i > j) {
          i = i % j;
      } else {
          j = j % i;
      }
   }
   return i;
}

// ADD code for the recursive style implementation
int gcdF(int i, int j) {
  if (j == 0) {
      return i;
  } else {
      return gcdF(j, i % j);
  }
}
// Also
// For exercise 4 modify the main function to call gcdR instead of gcdI  



int main(int argc, char **argv) {
  if (argc < 3) {
    printf("%s usage: [I] [J]\n", argv[0]);
    return 1;
  }
  int i = atoi(argv[1]);
  int j = atoi(argv[2]);
  //int r = gcdM(i,j);
  int s = gcdI(i,j);
  int f = gcdF(i,j);

  printf("gcdI %d\n", s);
  //printf("gcdM %d\n", r);
  printf("gcdF %d\n", f);

  return 0;
}