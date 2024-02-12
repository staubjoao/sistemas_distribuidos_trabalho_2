package br.uem.geolocalizacao.repository;

import br.uem.geolocalizacao.model.Geolocalizacao;
import org.springframework.stereotype.Repository;

@Repository
public class GeolocalizacaoRepository {

    public Geolocalizacao save(Geolocalizacao geolocalizacao) {
        return geolocalizacao;
    }

}
