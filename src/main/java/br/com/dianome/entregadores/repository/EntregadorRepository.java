package br.com.dianome.entregadores.repository;

import br.com.dianome.entregadores.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
}
