class Cliente {
    private String nome;
    private Long cpf;
    private Long dataNascimento;
    private String endereco;
    private String numeroTelefone;
    private String email;

    public Cliente(String nome, Long cpf, Long dataNascimento, String endereco, String numeroTelefone, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
    }

    public String getNome(){

        return nome;
    }

    public Long getCpf(){

        return cpf;
    }

    public Long getDataNascimento(){

        return dataNascimento;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getNumeroTelefone(){
        return numeroTelefone;
    }

    public String getEmail(){
        return email;
    }
}
