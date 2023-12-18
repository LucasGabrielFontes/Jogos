package ufc;

import java.util.Scanner;

public class Ufc {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        Lutador lutadores[] = new Lutador[15];

        lutadores[0] = new Lutador ("Charles Oliveira", "Brasil", 34, 1.78, 70, 34, 9, 0);
        lutadores[1] = new Lutador ("Islam Makhachev", "Russia", 32, 1.78, 70, 14, 1, 0);
        lutadores[2] = new Lutador ("Justin Gaethje", "Estados Unidos", 35, 1.80, 70, 25, 4, 0);
        lutadores[3] = new Lutador ("Dustin Poirier", "Estados Unidos", 34, 1.75, 70, 29, 8, 1);
        lutadores[4] = new Lutador ("Michael Chandler", "Estados Unidos", 37, 1.73, 70.3, 23, 8, 0);
        lutadores[5] = new Lutador ("Alex Pereira", "Brasil", 36, 1.93, 83.7, 9, 2, 0);
        lutadores[6] = new Lutador ("Sean Strickland", "Estados Unidos", 32, 1.85, 83.9, 28, 5, 0);
        lutadores[7] = new Lutador ("Israel Adesanya", "Nigeria", 34, 1.93, 83.9, 24, 3, 0);
        lutadores[8] = new Lutador ("Dricus Du Plessis", "Africa do Sul", 29, 1.83, 83.9, 20, 2, 0);
        lutadores[9] = new Lutador ("Paulo Costa", "Brasil", 32, 1.83, 83.9, 14, 2, 0);
        lutadores[10] = new Lutador ("Jon Jones", "Estados Unidos", 36, 1.93, 112, 27, 1, 0);
        lutadores[11] = new Lutador ("Tom Aspinall", "Inglaterra", 30, 1.96, 119, 14, 3, 0);
        lutadores[12] = new Lutador ("Ciryl Gane", "Franca", 33, 1.93, 112, 12, 2, 0);
        lutadores[13] = new Lutador ("Sergei Pavlovich", "Russia", 31, 1.91, 116, 18, 2, 0);
        lutadores[14] = new Lutador ("Stipe Miocic", "Estados Unidos", 41, 1.93, 106, 20, 4, 0);
        
        String resp;

        do {
            System.out.println("Todos os lutadores cadastrados: ");
            for (int i = 0; i < 15; i++) {
                System.out.println("============================");
                System.out.printf("     LUTADOR %d     \n", i+1);
                lutadores[i].apresentar();
                System.out.println("");
            }
        
            int teste = 0, i1 = 0, i2 = 0;
            System.out.println("===========================================");
            System.out.print("Digite o nome do primeiro lutador para o combate: ");
            String lutador1 = teclado.nextLine();
            for (int i = 0; i < 15; i++) {
                if (lutadores[i].getNome().toLowerCase().trim().equals(lutador1.toLowerCase().trim())) {
                    i1 = i;
                    teste += 1;
                }
            }
            while (teste == 0) {
                System.out.printf("\nJogador nao encontrado. Digite o nome corretamente: ");
                lutador1 = teclado.nextLine();
                teste = 0;
                for (int i = 0; i < 15; i++) {
                    if (lutadores[i].getNome().toLowerCase().trim().equals(lutador1.toLowerCase().trim())) {
                        i1 = i;
                        teste += 1;
                    }
                }
            }
            
            System.out.printf("\nDigite o nome do segundo lutador para o combate: ");
            String lutador2 = teclado.nextLine();
            teste = 0;
            for (int i = 0; i < 15; i++) {
                if (lutadores[i].getNome().toLowerCase().trim().equals(lutador2.toLowerCase().trim())) {
                    i2 = i;
                    teste += 1;
                }
            }
            while (teste == 0) {
                System.out.printf("\nJogador nao encontrado. Digite o nome corretamente: ");
                lutador2 = teclado.nextLine();
                teste = 0;
                for (int i = 0; i < 15; i++) {
                    if (lutadores[i].getNome().toLowerCase().trim().equals(lutador2.toLowerCase().trim())) {
                        i2 = i;
                        teste += 1;
                    }
                } 
            }
        
            Luta UFC001 = new Luta();
            UFC001.marcarLuta(lutadores[i1], lutadores[i2]);
            UFC001.lutar();
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Deseja jogar novamente? [S/N]: ");
            resp = teclado.nextLine();
        } while (resp.toUpperCase().trim().equals("S"));
        
        teclado.close();
    }       
}