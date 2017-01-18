package Entidades;

public class OutrasMetas extends Meta {

    private int dias;

    public OutrasMetas(String titulo, String descricao, int dificuldade, int dias) {
        super(titulo, descricao, dificuldade);
        this.dias = dias;
    }

    @Override
    public int calcularDificuldade(int dificuldade) {
        return dificuldade *= 5;
    }

    @Override
    public boolean determinarDedicacao(int dedicacaoAtual) {
        boolean retorno = false;
        if (dedicacaoAtual >= dias) {
            retorno = true;
        }
        return retorno;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

}
