package ufc;

import java.util.Random;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private boolean aprovada;

    public void marcarLuta (Lutador lutador1, Lutador lutador2) {
        if (lutador1.getCategoria().toLowerCase().equals(lutador2.getCategoria().toLowerCase()) && lutador1 != lutador2) {
            this.setAprovada(true);
            this.setDesafiado(lutador1);
            this.setDesafiante(lutador2);
        } else {
            this.setAprovada(false);
            this.setDesafiado(null);
            this.setDesafiante(null);
        }
    }
    
    public void lutar() {
        double p1 = 0, p2 = 0;
        if (this.getAprovada()) {
            System.out.println("================================");
            System.out.println("       A LUTA VAI COMECAR       ");
            System.out.println("================================");
            System.out.println("Com vocês, BRUCE BUFFER: ");
            System.out.println("Ladies and gentlemen, we … are … live! This is the main event of the evening. This is the moment we’ve all been waiting for!!!! Live, from the T-Mobile Arena in Las Vegas!!! IIIIIIIIIIIIIT`S TIME!!!!!!!");
            Random ale = new Random();
            int aleato1 = ale.nextInt(100);
            int aleato2 = ale.nextInt(100);
            for (int i = 1; i <= 2; i++) {
                if (i%2 == 1) {
                    System.out.printf("\nFighting out of the blue corner: ");
                    this.desafiado.apresentarParaLuta();
                    p1 = (double) (this.desafiado.getAltura() + (this.desafiado.getPeso()*2) + (this.desafiado.getVitorias()*3) + (this.desafiado.getDerrotas() + this.desafiado.getVitorias() + this.desafiado.getEmpates())*2 + aleato1*2) - this.desafiado.getIdade()*2 - this.desafiado.getDerrotas()*3;
                } else {
                    System.out.printf("\n\nFighting out of the red corner: ");
                    this.desafiante.apresentarParaLuta();
                    p2 = (double) (this.desafiante.getAltura() + this.desafiante.getPeso()*2 + this.desafiante.getVitorias()*3 + (this.desafiante.getDerrotas() + this.desafiante.getVitorias() + this.desafiante.getEmpates())*2 + aleato2*2) - this.desafiante.getIdade()*2 - this.desafiante.getDerrotas()*3;
                }
            }
            
            if (p1 == p2) {
                System.out.printf("\n\nEMPATOU\n");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
            } else if (p1 > p2) {
                System.out.printf("\n\n%s VENCEU! Com %.2f pontos e %s perdeu com %.2f pontos.\n", this.desafiado.getNome(), p1, this.desafiante.getNome(), p2);
                this.desafiado.ganharLuta();
                this.desafiante.perderLuta();
            } else {
                System.out.printf("\n\n%s VENCEU! Com %.2f pontos e %s perdeu com %.2f pontos.", this.desafiante.getNome(), p2, this.desafiado.getNome(), p1);
                this.desafiante.ganharLuta();
                this.desafiado.perderLuta();
            }
        } else {
            System.out.println("----------------------------------------------------------");
            System.out.print("\nA luta nao pode acontecer por dois possiveis motivos, companheiro:\n1) Os lutadores escolhidos sao de categorias diferentes;\n2) Voce escolheu o mesmo jogador duas vezes.\n");
        }
    }
    
    public Lutador getDesafiado() {
        return desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public boolean getAprovada() {
        return aprovada;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
}