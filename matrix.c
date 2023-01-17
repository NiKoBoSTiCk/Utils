#include <stdlib.h>
#include <stdio.h>

int* prodotto_matrici(int* A, int ra, int ca, int* B, int rb, int cb) {
    int j = 0; //indice seconda matrice
    int p = 0; //offset per accedere alla riga corretta della prima matrice
    int* ret = (int*) calloc(ra*cb, sizeof(int));

    for (int k = 0; k < ra*cb; k++) {
        for (int i = 0 ; i < ca; i++) {
            ret[k] += A[i + p] * B[j];
            j += cb;
        }
        j -= ca*cb - 1;
        if ((k+1)%cb == 0) {
            p += ca;
            j = 0;
        }
    }
    return ret;
}

int* trasposta_matrice(int* A, int ra, int ca) {
    int j = 0;
    int* ret = (int*) calloc(ra*ca, sizeof(int));

    for (int i = 0; i < ra*ca; i++) {
        ret[i] = A[j];
        if ((i+1)%ra == 0) j -= (ra-1)*ca - 1;
        else j += ca;
    }
    return ret;
}

int main(int argc, char* argv[]) {
    int ra = 3; int ca = 4; int rb = 4; int cb = 3;
	int A[] = {3,2,7,1,1,4,9,0,5,6,6,2};
    int B[] = {3,1,8,7,0,1,9,9,4,1,8,4};

    int* C = prodotto_matrici(A, ra, ca, B, rb, cb);
    for (int i = 0; i < ra*cb; i++) {
        printf("%d\n", C[i]);
    }

    printf("----------------\n");

    int* T = trasposta_matrice(A, ra, ca);
    for (int i = 0; i < ra*ca; i++) {
        printf("%d\n", T[i]);
    }
}
