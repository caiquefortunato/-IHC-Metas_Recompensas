package Util;

public class Exibicao {
    
    private int id;
    private String titulo;
    
    public Exibicao() {
        
    }

    public Exibicao(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
    
}
