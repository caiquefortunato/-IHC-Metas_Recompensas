package Entidades;

public abstract class Meta {
    
    private final String titulo;
    private final String descricao;
    private final int dificuldade;

    public Meta(String titulo, String descricao, int dificuldade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public abstract int calcularDificuldade(int dificuldade);   
    public abstract boolean determinarDedicacao(int dedicacaoAtual);
    
}
