package Entidades;

import OperacoesBancoSQL.SelecaoBanco;

public class Usuario {
    
    private int id;
    private String nome;
    private String username;
    private String senha;
    private String email;
    private int experiencia = 0;
    private Recompensa recompensa;
    private Educacao metaEducacao;
    private Leitura metaLeitura;
    private Alimentacao metaAlimentacao;
    private Esporte esporte;
    private OutrasMetas outrasMetas;
    
    private static Usuario usuarioAtivo;

    private Usuario() {
        
    }
    
    // Construtor publico que cria uma unica instancia
    public static synchronized Usuario getUsuarioAtivo() {
        if(usuarioAtivo == null)
            usuarioAtivo = new Usuario();  

        return usuarioAtivo;
    }

    public Usuario(int id, String nome, String username, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usuario) {
        this.username = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }
    
    public Educacao getMetaEducacao() {
        return metaEducacao;
    }

    public void setMetaEducacao(Educacao metaEducacao) {
        this.metaEducacao = metaEducacao;
    }    
    
        public Leitura getMetaLeitura() {
        return metaLeitura;
    }

    public void setMetaLeitura(Leitura metaLeitura) {
        this.metaLeitura = metaLeitura;
    }

    public Alimentacao getMetaAlimentacao() {
        return metaAlimentacao;
    }

    public void setMetaAlimentacao(Alimentacao metaAlimentacao) {
        this.metaAlimentacao = metaAlimentacao;
    }
    
    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public OutrasMetas getOutrasMetas() {
        return outrasMetas;
    }

    public void setOutrasMetas(OutrasMetas outrasMetas) {
        this.outrasMetas = outrasMetas;
    }
    
    public void preencherDadosAposLogin( ) {
        //SelecaoBanco recuperaDados = new SelecaoBanco();
        
        SelecaoBanco.preencherCamposUsuario(Usuario.usuarioAtivo);
    }

    public void limparDados() {
        this.email = null;
        this.nome = null;
        this.esporte = null;
        this.experiencia = 0;
        this.id = 0;
        this.metaAlimentacao = null;
        this.metaEducacao = null;
        this.metaLeitura = null;
        this.outrasMetas = null;
        this.recompensa = null;
        this.senha = null;
        this.username = null;
    }
    
    
}
