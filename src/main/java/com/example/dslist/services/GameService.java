package com.example.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dslist.dto.GameDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.entities.Game;
import com.example.dslist.projections.GameMinProjection;
import com.example.dslist.repositories.GameRepository;

//Registrar essa classe como um componente do sistema (também poderia ter sido usado o @Component)
@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //usamos para retornar a lista inteira
        //List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //mais passo a passo para retornar o DTO
        //return dto;
        return result.stream().map(x -> new GameMinDTO(x)).toList();//mais simplificado para retornar o DTO
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
         List<GameMinProjection> result = gameRepository.searchByList(listId);
         return result.stream().map(x -> new GameMinDTO(x)).toList();

    }
}
