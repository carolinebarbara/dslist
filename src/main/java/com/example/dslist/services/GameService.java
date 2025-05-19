package com.example.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.entities.Game;
import com.example.dslist.repositories.GameRepository;

//Registrar essa classe como um componente do sistema (também poderia ter sido usado o @Component)
@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //usamos para retornar a lista inteira
        //List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //mais passo a passo para retornar o DTO
        //return dto;
        return result.stream().map(x -> new GameMinDTO(x)).toList();//mais simplificado para retornar o DTO
    }
}
