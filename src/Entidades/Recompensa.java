package Entidades;

public class Recompensa {
    
    private String titulo;
    private String descricao;
    private int xp;
    
    public Recompensa() {
        
    }

    public Recompensa(String titulo, String descricao, int xp) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
}
