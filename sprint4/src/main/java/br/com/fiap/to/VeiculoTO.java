package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class VeiculoTO {
    private Long id_veiculo;
    @NotBlank
    private String placa;
    @NotBlank
    private String tipo;
    @PositiveOrZero
    private Double quilometragem;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @Positive
    private Integer ano;

    public VeiculoTO() {
    }

    public VeiculoTO(Long id_veiculo, @NotBlank String placa, @NotBlank String tipo, @PositiveOrZero Double quilometragem, @NotBlank String marca, @NotBlank String modelo, @Positive Integer ano) {
        this.id_veiculo = id_veiculo;
        this.placa = placa;
        this.tipo = tipo;
        this.quilometragem = quilometragem;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Long getId_veiculo() {return id_veiculo;}

    public void setId_veiculo(Long id_veiculo) {this.id_veiculo = id_veiculo;}

    public @NotBlank String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank String placa) {
        this.placa = placa;
    }

    public @NotBlank String getTipo() {
        return tipo;
    }

    public void setTipo(@NotBlank String tipo) {
        this.tipo = tipo;
    }

    public @PositiveOrZero Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(@PositiveOrZero Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public @NotBlank String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank String marca) {
        this.marca = marca;
    }

    public @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank String modelo) {
        this.modelo = modelo;
    }

    @Positive
    public int getAno() {
        return ano;
    }

    public void setAno(@Positive int ano) {
        this.ano = ano;
    }

}
