package br.uem.arboviroses.repository;

import br.uem.arboviroses.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
}
