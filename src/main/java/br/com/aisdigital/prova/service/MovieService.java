package br.com.aisdigital.prova.service;

import br.com.aisdigital.prova.client.MovieClient;
import br.com.aisdigital.prova.dto.MovieDTO;
import br.com.aisdigital.prova.dto.ResponseList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieClient client;

    public MovieService(MovieClient client) {
        this.client = client;
    }

    public List<MovieDTO> getPopular() {
        List<MovieDTO> result = client.getPopular().map(ResponseList::getResults).orElseThrow(() -> new RuntimeException("Erro ao acessar a API!"));
        return result;
    }

    public List<MovieDTO> getNowPlaying(String region) {
        List<MovieDTO> result = client.getNowPlaying(region).map(ResponseList::getResults).orElseThrow(() -> new RuntimeException("Erro ao acessar a API!"));
        return result;
    }

    public MovieDTO getLatest() {
        return client.getLatest().orElseThrow(() -> new RuntimeException("Erro ao acessar a API!"));
    }

}
