package br.uem.geolocalizacao.service;

import br.uem.geolocalizacao.model.Geolocalizacao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface GeolocalizacaoService {

    Geolocalizacao salvar(@Valid @RequestBody Geolocalizacao geolocalizacao);

}
