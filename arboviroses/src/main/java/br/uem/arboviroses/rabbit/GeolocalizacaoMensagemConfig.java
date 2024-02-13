package br.uem.arboviroses.rabbit;

import br.uem.arboviroses.model.Imovel;
import br.uem.arboviroses.repository.ImovelRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeolocalizacaoMensagemConfig {

    @Autowired
    private ImovelRepository repository;

    @RabbitListener(queues = "geolocalizacao.v1.geolocalizacao-created")
    public void onImovelCreated(GeolocalizacaoCreateEvent event) {
        System.out.println(event.toString());

        Imovel imovel = repository.findById(event.getId()).get();
        System.out.println(imovel.toString());
        imovel.setLatitude(event.getLat());
        imovel.setLongitude(event.getLon());

        repository.save(imovel);
    }
}
