package Misc;

import java.io.Serializable;

public class Endereco implements Serializable {
private String cidade;
private String bairro;
private String estado;

    public Endereco(String cidade, String bairro, String estado)
    {
        this.cidade=cidade;
        this.bairro=bairro;
        this.estado=estado;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void print()
    {
        System.out.println("\nEstado: "+estado);
        System.out.println("Cidade: "+cidade);
        System.out.println("Bairro: "+bairro);
    }
}
