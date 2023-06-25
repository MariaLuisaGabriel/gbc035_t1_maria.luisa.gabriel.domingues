package Misc;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Pessoa implements Serializable {
    protected String nome, cpf, estadoCivil, sexo, rg;
    protected LocalDate dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String estadoCivil, String sexo, LocalDate dataNascimento,String rg)
    {
        this.nome=nome;
        this.cpf=cpf;
        this.estadoCivil=estadoCivil;
        this.sexo=sexo;
        this.dataNascimento=dataNascimento;
        this.rg=rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}
