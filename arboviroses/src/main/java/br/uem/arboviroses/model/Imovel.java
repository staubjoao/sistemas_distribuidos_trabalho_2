package br.uem.arboviroses.model;

import lombok.Data;

@Data
public class Imovel {

    private Integer id;
    private String localidade;
    private String numero;
    private String complemento;
    private String latitude;
    private String longitude;
    private String bairro;
    private String logradouro;
    private String tipoImovel;
    private String municipio;

}
