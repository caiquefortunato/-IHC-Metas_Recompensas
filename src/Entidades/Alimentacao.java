package Entidades;

public class Alimentacao extends Meta{
    
    private String nomeComida;
    private String nomeBebida;
    private int vezesDia;
    
    // Construtor
    public Alimentacao(String titulo, String descricao, int dificuldade,
        String nomeComida, String nomeBebida, int vezesDia) {
        super(titulo, descricao, dificuldade);
        this.nomeComida = nomeComida;
        this.nomeBebida = nomeBebida;
        this.vezesDia = vezesDia;
    }

    @Override
    public int calcularDificuldade(int dificuldade) {
        return dificuldade *= 5;
    }

    @Override
    public boolean determinarDedicacao(int dedicacaoAtual) {
        boolean retorno = false;
        if(dedicacaoAtual >= vezesDia) {
            retorno = true;
        }
        return retorno;          
    }

    public String getNomeComida() {
        return nomeComida;
    }

    public void setNomeComida(String nomeComida) {
        this.nomeComida = nomeComida;
    }

    public String getNomeBebida() {
        return nomeBebida;
    }

    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }

    public int getVezesDia() {
        return vezesDia;
    }

    public void setVezesDia(int vezesDia) {
        this.vezesDia = vezesDia;
    }
    
    
}
