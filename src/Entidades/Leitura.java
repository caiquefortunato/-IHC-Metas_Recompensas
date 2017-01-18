package Entidades;

public class Leitura extends Meta {
    
    private int horasLidas;
    private String nomeLivro;
    private String assuntoLivro;
    private int paginasDia;

    // Construtor 
    public Leitura(String titulo, String descricao, int dificuldade,
            int horasLidas, String nomeLivro, String assuntoLivro, int paginasDia) {
        super(titulo, descricao, dificuldade);
        this.horasLidas = horasLidas;
        this.nomeLivro = nomeLivro;
        this.assuntoLivro = assuntoLivro;
        this.paginasDia = paginasDia;
    }

    @Override
    public int calcularDificuldade(int dificuldade) {
        return dificuldade *= 5;
    }

    @Override
    public boolean determinarDedicacao(int dedicacaoAtual) {
        boolean retorno = false;
        if(dedicacaoAtual >= paginasDia) {
            retorno = true;
        }
        return retorno;        
    }

    public int getHorasLidas() {
        return horasLidas;
    }

    public void setHorasLidas(int horasLidas) {
        this.horasLidas = horasLidas;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAssuntoLivro() {
        return assuntoLivro;
    }

    public void setAssuntoLivro(String assuntoLivro) {
        this.assuntoLivro = assuntoLivro;
    }

    public int getPaginasDia() {
        return paginasDia;
    }

    public void setPaginasDia(int paginasDia) {
        this.paginasDia = paginasDia;
    }
    
    
    
}
