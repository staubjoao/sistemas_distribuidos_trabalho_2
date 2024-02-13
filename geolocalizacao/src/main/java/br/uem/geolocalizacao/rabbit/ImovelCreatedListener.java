package br.uem.geolocalizacao.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ImovelCreatedListener {

    @RabbitListener(queues = "imoveis.v1.imovel-created")
    public void onImovelCreated(ImovelCreateEvent event) {
        System.out.println("Id recebido: "+ event.getId());
        System.out.println("Quey recebida: "+ event.getQuery());
    }
}
