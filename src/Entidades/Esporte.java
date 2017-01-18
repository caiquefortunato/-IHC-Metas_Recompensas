package Entidades;

public class Esporte extends Meta {
    
    private String nomeEsporte;
    private int km;
    private int tempoPraticado;
    private int vezesSemana;

    public Esporte(String titulo, String descricao, int dificuldade, 
            String nomeEsporte, int km, int tempoPraticado, int vezesSemana) {
        super(titulo, descricao, dificuldade);
        this.nomeEsporte = nomeEsporte;
        this.km = km;
        this.tempoPraticado = tempoPraticado;
        this.vezesSemana = vezesSemana;
    }

    public String getNomeEsporte() {
        return nomeEsporte;
    }

    public void setNomeEsporte(String nomeEsporte) {
        this.nomeEsporte = nomeEsporte;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getTempoPraticado() {
        return tempoPraticado;
    }

    public void setTempoPraticado(int tempoPraticado) {
        this.tempoPraticado = tempoPraticado;
    }

    public int getVezesSemana() {
        return vezesSemana;
    }

    public void setVezesSemana(int vezesSemana) {
        this.vezesSemana = vezesSemana;
    }
    
    @Override
    public int calcularDificuldade(int dificuldade) {
        return dificuldade *= 15;
    }

    @Override
    public boolean determinarDedicacao(int dedicacaoAtual) {
        boolean retorno = false;
        if(dedicacaoAtual >= vezesSemana) {
            retorno = true;
        }
        return retorno;   
    }
}
