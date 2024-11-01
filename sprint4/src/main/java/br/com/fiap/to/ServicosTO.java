package br.com.fiap.to;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ServicosTO {
    private Long id_servicos;
    @NotBlank
    private String placa;
    @NotBlank
    private String motivo;
    @Positive
    private Double valor;
    @NotNull
    @PastOrPresent
    private LocalDate dt_entrada;
    @NotNull
    @FutureOrPresent
    private LocalDate dt_saida;

    public ServicosTO() {
    }

    public ServicosTO(Long id_servicos, @NotBlank String placa1, @NotBlank String motivo, @Positive Double valor, @NotNull @PastOrPresent LocalDate dt_entrada, @NotNull @FutureOrPresent LocalDate dt_saida) {
        this.id_servicos = id_servicos;
        this.placa = placa1;
        this.motivo = motivo;
        this.valor = valor;
        this.dt_entrada = dt_entrada;
        this.dt_saida = dt_saida;
    }

    public Long getId_servicos() {return id_servicos;}

    public void setId_servicos(Long id_servicos) {this.id_servicos = id_servicos;}

    public @NotBlank String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank String placa1) {
        this.placa = placa1;
    }

    public @NotBlank String getMotivo() {
        return motivo;
    }

    public void setMotivo(@NotBlank String motivo) {
        this.motivo = motivo;
    }

    public @Positive Double getValor() {
        return valor;
    }

    public void setValor(@Positive Double valor) {
        this.valor = valor;
    }

    public @NotNull @PastOrPresent LocalDate getDt_entrada() {
        return dt_entrada;
    }

    public void setDt_entrada(@NotNull @PastOrPresent LocalDate dt_entrada) {
        this.dt_entrada = dt_entrada;
    }

    public @NotNull @FutureOrPresent LocalDate getDt_saida() {
        return dt_saida;
    }

    public void setDt_saida(@NotNull @FutureOrPresent LocalDate dt_saida) {
        this.dt_saida = dt_saida;
    }
}
