package com.example.atv_banda;

public class Album {

    private String banda;
    private int ano;
    private String fotografo;
    private int imagem;

    public Album(String banda, int ano, String saibamais, String fotografo, int imagem) {
        this.banda = banda;
        this.ano = ano;
        this.fotografo = fotografo;
        this.imagem = imagem;
    }

    public String getBanda() {
        return banda;
    }

    public int getAno() {
        return ano;
    }


    public String getFotografo() {
        return fotografo;
    }

    public int getImagem() {
        return imagem;
    }

}
