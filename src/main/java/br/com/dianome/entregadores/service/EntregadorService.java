package br.com.dianome.entregadores.service;

import br.com.dianome.entregadores.dto.EntregadorDto;
import br.com.dianome.entregadores.model.Entregador;
import br.com.dianome.entregadores.repository.EntregadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public EntregadorDto criarEntregador(EntregadorDto dto) {
        Entregador entregador = modelMapper.map(dto, Entregador.class);
        repository.save(entregador);

        return modelMapper.map(entregador, EntregadorDto.class);
    }

    public Page<EntregadorDto> obterTodos (Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, EntregadorDto.class));
    }

    public EntregadorDto obterPorId(Long id) {
        Entregador entregador = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(entregador, EntregadorDto.class);
    }

    public EntregadorDto atualizarEntregador(Long id, EntregadorDto dto) {
        Entregador entregador = modelMapper.map(dto, Entregador.class);
        entregador.setId(id);
        entregador = repository.save(entregador);

        return modelMapper.map(entregador, EntregadorDto.class);
    }

    public void excluirEntregador(Long id) {
        repository.deleteById(id);
    }
}
