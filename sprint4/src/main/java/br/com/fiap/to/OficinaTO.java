package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OficinaTO {
    private Long id_oficina;
    @NotBlank
    private String nome_oficina;
    @NotNull
    private String cnpj;
    @NotBlank
    private String status;
    @NotBlank
    private String cep;

    public OficinaTO() {
    }

    public OficinaTO(Long id_oficina, @NotBlank String nome_oficina, @NotNull String cnpj, @NotBlank String status, @NotBlank String cep) {
        this.id_oficina = id_oficina;
        this.nome_oficina = nome_oficina;
        this.cnpj = cnpj;
        this.status = status;
        this.cep = cep;
    }

    public Long getId_oficina() {return id_oficina;}

    public void setId_oficina(Long id_oficina) {this.id_oficina = id_oficina;}

    public @NotBlank String getNome_oficina() {
        return nome_oficina;
    }

    public void setNome_oficina(@NotBlank String nome_oficina) {
        this.nome_oficina = nome_oficina;
    }

    public @NotNull String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }

    public @NotBlank String getCep() {
        return cep;
    }

    public void setCep(@NotBlank String cep) {
        this.cep = cep;
    }
}
