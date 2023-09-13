class Avião extends Aeronave {
    private Double capacidadeCarga;

    public Avião(Long numeroRegistro, Integer capacidadePassageiros, double autonomia, Double capacidadeCarga) {
        super(numeroRegistro, capacidadePassageiros, (float) autonomia);
        this.capacidadeCarga = capacidadeCarga;
    }

    public Double getCapacidadeCarga() {
        return capacidadeCarga;
    }
}