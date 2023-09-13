class Aeronave {
    private Long numeroRegistro;
    private Integer capacidadePassageiros;
    private Float autonomia;

    public Aeronave(Long numeroRegistro, Integer capacidadePassageiros, Float autonomia) {
        this.numeroRegistro = numeroRegistro;
        this.capacidadePassageiros = capacidadePassageiros;
        this.autonomia = autonomia;
    }

    public Long getNumeroRegistro() {

        return numeroRegistro;
    }

    public Integer getCapacidadePassageiros() {

        return capacidadePassageiros;
    }

    public Float getAutonomia() {

        return autonomia;
    }
}

