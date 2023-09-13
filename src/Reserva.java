class Reserva{

    private Aeronave meioTransporte;
    private String origem;
    private String destino;
    private Long dataViagem;
    private boolean pagamento;
    private String validacaoTrecho;
    private Long registroANAC;

    public Reserva(Aeronave meioTransporte, String origem, String destino, Long dataViagem) {
        this.meioTransporte = meioTransporte;
        this.origem = origem;
        this.destino = destino;
        this.dataViagem = dataViagem;
        this.pagamento = false;
    }

    public Aeronave getMeioTransporte(){
        return meioTransporte;
    }
    public String getOrigem(){
        return origem;
    }
    public String getDestino(){
        return destino;
    }
    public String getValidacaoTrecho(){
        return validacaoTrecho;
    }
    public void setValidacaoTrecho(String validacaoTrecho) {
        this.validacaoTrecho = validacaoTrecho;
    }
    public Long getRegistroANAC(){
        return registroANAC;
    }
    public void setRegistroANAC(Long registroANAC) {
        this.registroANAC = registroANAC;
    }
    public Long getDataViagem(){
        return dataViagem;
    }
    public boolean isPagamento(){
        return pagamento;
    }
    public void efetuarPagamento() {
        this.pagamento = true;
    }
}
