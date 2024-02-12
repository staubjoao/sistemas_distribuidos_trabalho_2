package br.uem.arboviroses.controller;

import br.uem.arboviroses.dto.GeolocalizacaoDTO;
import br.uem.arboviroses.model.*;
import br.uem.arboviroses.service.impl.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelController {

    @Autowired
    private ImovelServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Imovel post(@RequestBody Imovel imovelDTO) {
        String urlGeolocalizacao = "http://localhost:8081/api/geolocalizacao";

        Imovel imovel = new Imovel();
        imovel.setNumero(imovelDTO.getNumero());
        imovel.setComplemento(imovelDTO.getComplemento());
        imovel.setBairro(imovelDTO.getBairro());
        imovel.setLogradouro(imovelDTO.getLogradouro());
        imovel.setTipoImovel(imovelDTO.getTipoImovel());
        imovel.setMunicipio(imovelDTO.getMunicipio());
        imovel.setLocalidade(imovelDTO.getLocalidade());

        String query = getString(imovel);

        String urlWithQuery = urlGeolocalizacao + "?query=" + query;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<GeolocalizacaoDTO> response = restTemplate.getForEntity(urlWithQuery, GeolocalizacaoDTO.class);

        GeolocalizacaoDTO geolocalizacao = response.getBody();

        if (geolocalizacao != null) {
            imovel.setLongitude(geolocalizacao.getLongitude());
            imovel.setLatitude(geolocalizacao.getLatitude());
        } else {
            System.out.println("Erro ao obter geolocalização");
        }

        return service.salvar(imovel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Imovel> getAll() {
        return service.getlAll();
    }

    @NotNull
    private static String getString(Imovel imovel) {
        String logradouro = imovel.getLogradouro();
        String numero = imovel.getNumero();
        String cidade = imovel.getMunicipio();

        return logradouro.replace(" ", "+") +
                "+" +
                numero +
                "+" +
                cidade.replace(" ", "+") +
                "+" +
                "paraná";
    }

}
