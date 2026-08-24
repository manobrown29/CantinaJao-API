package com.cantinaJao.service;

import com.cantinaJao.DTO.LancheRequestDTO;
import com.cantinaJao.DTO.LancheResponseDTO;
import com.cantinaJao.expection.RecursoNaoEncontradoException;
import com.cantinaJao.model.Lanche;
import com.cantinaJao.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LancheService {
    @Autowired
    private LancheRepository lancheRepository;

    public List<LancheResponseDTO> listar(){
        return lancheRepository.findAll().stream().map(this::toResponseDTO)
                .toList();
    }

    public LancheResponseDTO cadastrar(LancheRequestDTO dto) {
        Lanche lanche = new Lanche();
        lanche.setNome(dto.nome());
        lanche.setPreco(dto.preco());

        return toResponseDTO(lancheRepository.save(lanche));
    }

    public LancheResponseDTO buscarPorId(Long id) {
        Lanche lanche = lancheRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        return toResponseDTO(lanche);
    }

    public LancheResponseDTO atualizar(Long id, Lanche lanche){
        Lanche lancheExist = lancheRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());

        lancheExist.setId(lanche.getId());
        lancheExist.setNome(lanche.getNome());
        lancheExist.setDescricao(lanche.getDescricao());
        lancheExist.setPreco(lanche.getPreco());

        return toResponseDTO(lancheRepository.save(lancheExist));
    }

    public void remover(Long id) {
        if (!lancheRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException();
        }
        lancheRepository.deleteById(id);
    }

    private LancheResponseDTO toResponseDTO(Lanche lanche) {
        return new LancheResponseDTO(
                lanche.getId(),
                lanche.getNome(),
                lanche.getPreco()
        );
    }

}
