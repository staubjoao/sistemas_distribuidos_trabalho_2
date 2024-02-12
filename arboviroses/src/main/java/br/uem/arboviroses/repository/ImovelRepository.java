package br.uem.arboviroses.repository;

import br.uem.arboviroses.model.Imovel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ImovelRepository {

    private final List<Imovel> imovelList = new ArrayList<>();
    private int nextId = 1;

    public Imovel save(Imovel imovel) {
        if (imovel.getId() == null) {
            imovel.setId(nextId++);
        }
        imovelList.add(imovel);
        return imovel;
    }

    public List<Imovel> getAll() {
        return imovelList;
    }

}
