package ufc;

public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private double altura;
    private double peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;
    
    public Lutador (String no, String na, int i, double a, double p, int v, int d, int e) {
        this.nome = no;
        this.nacionalidade = na;
        this.idade = i;
        this.altura = a;
        this.setPeso(p);
        this.vitorias = v;
        this.derrotas = d;
        this.empates = e;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome (String n) {
        this.nome = n;
    }
    
    public String getNacionalidade () {
        return this.nacionalidade;
    }
    
    public void setNacionalidade (String na) {
        this.nacionalidade = na;
    }
    
    public int getIdade () {
        return this.idade;
    }
    
    public void setIdade (int i) {
        this.idade = i;
    }

    public double getAltura () {
        return this.altura;
    }
    
    public void setAltura (float a) {
        this.altura = a;
    }
    
    public double getPeso () {
        return this.peso;
    }
    
    public void setPeso (double p) {
        this.peso = p;
        this.setCategoria();
    }
    
    public String getCategoria () {
        return this.categoria;
    }
    
    private void setCategoria () {
        if ((this.getPeso() < 65.7) || (this.getPeso() > 120.2)) {
            this.categoria = "Invalido";
        } else if (this.getPeso() <= 70.3) {
            this.categoria = "Leve";
        } else if (this.getPeso() <= 83.9) {
            this.categoria = "Medio";
        } else if (this.getPeso() <= 120.2) {
            this.categoria = "Pesado";
        }
    }
    
    public int getVitorias () {
        return this.vitorias;
    }
    
    public void setVitorias (int v) {
        this.vitorias = v;
    }
    
    public int getDerrotas () {
        return this.derrotas;
    }
    
    public void setDerrotas (int d) {
        this.derrotas = d;
    }
    
    public int getEmpates () {
        return this.empates;
    }
    
    public void setEmpates (int e) {
        this.empates = e;
    }
    
    public void ganharLuta() {
        this.setVitorias(this.getVitorias() + 1);
    }
    
    public void perderLuta() {
        this.setDerrotas(this.getDerrotas() + 1);
    }
    
    public void empatarLuta() {
        this.setEmpates(this.getEmpates() + 1);
    }
    
    public void apresentar() {
        System.out.println("Lutador: " + this.getNome());
        System.out.println("Origem: " + this.getNacionalidade());
        System.out.println("Idade: " + this.getIdade() + " anos");
        System.out.println("Altura: " + this.getAltura() + "m");
        System.out.println("Peso: " + this.getPeso() + "kg");
        System.out.println("Categoria: " + this.getCategoria());
        System.out.println("Vitorias: " + this.getVitorias());
        System.out.println("Derrotas: " + this.getDerrotas());
        System.out.println("Empates: " + this.getEmpates());
    }
    
    public void apresentarParaLuta () {
        System.out.printf("This man is a martial artist. "
                + "Holding a professional record of %d wins, "
                + "%d losses "
                + "and %d draws. "
                + "Standing %.2f meters tall, "
                + "weighing in at %.2f kilograms. "
                + "Fighting out of %s, %s!!!!!!!"
                , this.getVitorias(), this.getDerrotas(), this.getEmpates(), this.getAltura(), this.getPeso(), this.getNacionalidade(), this.getNome().toUpperCase());
    }
    
    public void status() {
        System.out.println("=============================");
        System.out.println(this.getNome());
        System.out.println("Peso " + this.getCategoria());
        System.out.println(this.getVitorias() + " Vitorias");
        System.out.println(this.getDerrotas() + " Derrotas");
        System.out.println(this.getEmpates() + " Empates");
    }  
}