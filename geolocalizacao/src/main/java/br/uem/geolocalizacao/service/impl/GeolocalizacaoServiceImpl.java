package br.uem.geolocalizacao.service.impl;

import br.uem.geolocalizacao.model.Geolocalizacao;
import br.uem.geolocalizacao.repository.GeolocalizacaoRepository;
import br.uem.geolocalizacao.service.GeolocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeolocalizacaoServiceImpl implements GeolocalizacaoService {

    @Autowired
    private GeolocalizacaoRepository repository;

    @Override
    public Geolocalizacao salvar(Geolocalizacao geolocalizacao) {
        return repository.save(geolocalizacao);
    }
}