package br.uem.arboviroses.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "imovel")
public class Imovel {

    @Id
    @GeneratedValue
    @Column(name = "imovel_id")
    private Integer id;

    @Column
    private String localidade;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String latitude;

    @Column
    private String longitude;

    @Column
    private String bairro;

    @Column
    private String logradouro;

    @Column
    private String tipoImovel;

    @Column
    private String municipio;

}
