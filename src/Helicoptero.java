class Helicoptéro extends Aeronave{
    private String tipoTransporte;

    public Helicoptéro(Long numeroRegistro, Integer capacidadePassageiros, double autonomia, String tipoTransporte) {
        super(numeroRegistro, capacidadePassageiros, (float) autonomia);
        this.tipoTransporte = tipoTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }
}