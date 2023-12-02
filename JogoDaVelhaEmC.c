#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define TAM 50

typedef struct {
    int matrizint[3][3];
    char matrizchar[3][3];
} matrizes;

void cabecalhoinicial ();
void cabecalhosimples ();
void mostramatrizchar (char matriz[3][3]);
void mostramatriz (int matriz1[3][3], char matriz2[3][3]);
void preenchematrizint (int matriz[][3]);
void preenchematrizchar (char matriz[3][3]);
void tiraenter (char nome[]);
void recebenomejogadores(char nome1[], char nome2[]);
int testaescolha (int matriz1[3][3], char matriz2[3][3], int jogada);
int testaganhador (char matriz[3][3], int l, int c, char letra);
void jogo (int matriznum[3][3], char matrizle[3][3]);
int vezjogador(char nome[], char letra, int numerojogada, int *linha, int *coluna, int matriznum[3][3], char matrizle[3][3]);

int main () {
    cabecalhoinicial();
    system("pause");
    matrizes matriz;
    preenchematrizint(matriz.matrizint);
    jogo(matriz.matrizint, matriz.matrizchar);
    return 0;
}

void jogo (int matriznum[3][3], char matrizle[3][3]) {
    char resposta, testejogadores, jogador1[TAM], jogador2[TAM];
    int i;
    recebenomejogadores(jogador1, jogador2);
    do {
        preenchematrizchar(matrizle);
        int linha, coluna;
        for (i = 1; i <= 9; i++) {
            system("cls");
            cabecalhosimples();
            if (i % 2 == 1) {
                if (vezjogador(jogador1, 'o', i, &linha, &coluna, matriznum, matrizle)){
                    break;
                }
            } else {
                if (vezjogador(jogador2, 'x', i, &linha, &coluna, matriznum, matrizle)){
                    break;
                }
            }
        }
        printf("Deseja jogar outra partida? [S/N]: ");
        scanf("%c", &resposta);
        fflush(stdin);
        if (tolower(resposta) == 's') {
            printf("\n\nSerao os mesmos dois jogadores? [S/N]: ");
            scanf("%c", &testejogadores);
            fflush(stdin);
            if (tolower(testejogadores) == 'n') {
                recebenomejogadores(jogador1, jogador2);
            }
        } else {
            printf("\nObrigado por jogar o O JOGO DA VELHA! Ate mais!\n");
        }
    } while (toupper(resposta) == 'S');
}

int vezjogador(char nome[], char letra, int numerojogada, int *linha, int *coluna, int matriznum[3][3], char matrizle[3][3]) {
    int jogada;
    printf("\nVez de %s!\n\n", nome);
    mostramatriz(matriznum, matrizle);
    printf("\n");
    if (letra == 'x') {
        printf("Escolha uma posicao para jogar o X: ");
    } else {
        printf("Escolha uma posicao para jogar o BOLA: ");
    }
    scanf("%d", &jogada);
    fflush(stdin);
    while ((jogada < 1) || (jogada > 9) || testaescolha(matriznum, matrizle, jogada))  {
        printf("\nPosicao invalida! Escolha outra: ");
        scanf("%d", &jogada);
        fflush(stdin);
    }
    for (int l = 0; l < 3; l++) {
        for (int c = 0; c < 3; c++) {
            if (matriznum[l][c] == jogada) {
                matrizle[l][c] = letra;
                *linha = l;
                *coluna = c;
            }
        }
    }
    if (numerojogada >= 5) {
        if (testaganhador(matrizle, *linha, *coluna, letra)) {
            printf("\n%s E O(A) VENCEDOR(A)!\n\n", nome);
            mostramatrizchar(matrizle);
            printf("\n");
            return 1;
        }
    }
    if (numerojogada == 9) {
        printf("\nDEU VELHA!\n\n");
        mostramatrizchar(matrizle);
        printf("\n");
        return 1;
    }
    return 0;
}

int testaganhador (char matriz[3][3], int l, int c, char letra) {
    int teste = 0;
    for (int j = 0; j < 3; j++) {
        if (matriz[l][j] == letra) {
            teste += 1;
        }
    }
    if (teste == 3) {
        for (int j = 0; j < 3; j++) {
            matriz[l][j] = '-';
        }
        return 1;
    }
    teste = 0;
    for (int i = 0; i < 3; i++) {
        if (matriz[i][c] == letra) {
            teste += 1;
        }
    }
    if (teste == 3) {
        for (int i = 0; i < 3; i++) {
            matriz[i][c] = '|';
        }
        return 1;
    }
    teste = 0;
    if (l == c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (matriz[i][j] == letra) {
                        teste += 1;
                    }
                }
            }
        }
    }
    if (teste == 3) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (matriz[i][j] == letra) {
                        matriz[i][j] = '`';
                    }
                }
            }
        }
        return 1;
    }
    teste = 0;
    if ((l == 0 && c == 2) || (l == 1 && c == 1) || (l == 2 && c == 0)) {
        int a = 0, b = 2;
        for (; a < 3; a++) {
            if (matriz[a][b] == letra) {
                teste += 1;
                b -= 1;
            }
        }
    }
    if (teste == 3) {
        int a = 0, b = 2;
        for (; a < 3; a++) {
            if (matriz[a][b] == letra) {
                matriz[a][b] = '/';
                b -= 1;
            }
        }
        return 1;
    }
    return 0;
}

int testaescolha (int matriz1[3][3], char matriz2[3][3], int jogada) {
    for (int l = 0; l < 3; l++) {
        for (int c = 0; c < 3; c++) {
            if (matriz1[l][c] == jogada) {
                if ((matriz2[l][c] == 'x') || (matriz2[l][c] == 'o')) {
                    return 1;
                }
            }
        }
    }
    return 0;
}

void recebenomejogadores(char nome1[], char nome2[]) {
    system("cls");
    cabecalhosimples();
    printf("\nDigite o nome do jogador 1 (BOLA): ");
    fgets(nome1, TAM, stdin);
    tiraenter(nome1);
    fflush(stdin);
    printf("\nDigite o nome do jogador 2 (X): ");
    fgets(nome2, TAM, stdin);
    tiraenter(nome2);
    fflush(stdin);
}

void tiraenter (char nome[]) {
    for (int i = 0; nome[i] != '\0'; i++) {
        if (nome[i] == '\n') {
            nome[i] = '\0';
            break;
        }
    }
}

void preenchematrizchar (char matriz[3][3]) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            matriz[i][j] = ' ';
        }
    }
}

void preenchematrizint (int matriz[][3]) {
    int a = 1;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            matriz[i][j] = a;
            a += 1;
        }
    }
}

void mostramatriz (int matriz1[3][3], char matriz2[3][3]) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if ((matriz2[i][j] == 'o') || (matriz2[i][j] == 'x')) {
                printf("%c ", matriz2[i][j]);
            } else {
                printf("%d ", matriz1[i][j]);
            }
        }
        printf("\n");
    }
}

void mostramatrizchar (char matriz[3][3]) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%c ", matriz[i][j]);
        }
        printf("\n");
    }
}

void cabecalhosimples () {
    printf("===============================\n");
    printf("        O Jogo da Velha        \n");
    printf("===============================\n");
}

void cabecalhoinicial () {
    printf("===============================\n");
    printf("        O Jogo da Velha        \n");
    printf("===============================\n");
    printf("\nSeja muito bem-vindo ao O Jogo da Velha!\nEsse jogo foi feito para ser jogado por duas pessoas. Decida com o seu amigo quem ficara com a BOLA (jogador 1) e quem ficara com o X (jogador 2). Lembrando que o jogador 1 sempre comeca jogando.\n\n");
}