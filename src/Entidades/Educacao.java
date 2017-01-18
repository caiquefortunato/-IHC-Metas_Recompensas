package Entidades;

public class Educacao extends Meta{
    
    private String nomeDisciplina;
    private int horasEstudo;
    
    // Construtor
    public Educacao(String titulo, String descricao, int dificuldade, 
            String nomeDisiplina, int horasEstudo) {
        
        super(titulo, descricao, dificuldade);
        this.nomeDisciplina = nomeDisiplina;
        this.horasEstudo = horasEstudo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }    
    
    public int getHorasEstudo() {
        return horasEstudo;
    }

    public void setHorasEstudo(int horasEstudo) {
        this.horasEstudo = horasEstudo;
    }        
    
    @Override
    public int calcularDificuldade(int dificuldade) {
        return dificuldade *= 10;
    }

    @Override
    public boolean determinarDedicacao(int dedicacaoAtual) {
        boolean retorno = false;
        if(dedicacaoAtual >= horasEstudo) {
            retorno = true;
        }
        return retorno;
    }
}
