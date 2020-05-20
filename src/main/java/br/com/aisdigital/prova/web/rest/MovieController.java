package br.com.aisdigital.prova.web.rest;

import br.com.aisdigital.prova.dto.MovieDTO;
import br.com.aisdigital.prova.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Filme", description = "Classe cliente que consome a API de Filmes")
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @ApiOperation(value = "Retorna uma lista de filmes polulares")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success."),
            @ApiResponse(code = 400, message = "Erro ao acessar a API!")
    })
    @GetMapping("/popular")
    public ResponseEntity<List<MovieDTO>> getPopular() {
        try {
            List<MovieDTO> result = this.service.getPopular();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Obtenha uma lista de filmes nos cinemas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success."),
            @ApiResponse(code = 400, message = "Erro ao acessar a API!"),
    })
    @GetMapping("/nowPlaying")
    public ResponseEntity<List<MovieDTO>> getNowPlaying(@RequestParam( required = false) String region) {
        try {
            List<MovieDTO> result = this.service.getNowPlaying(region);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Obtenha o filme mais recente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success."),
            @ApiResponse(code = 400, message = "Erro ao acessar a API!")
    })
    @GetMapping("/latest")
    public ResponseEntity<MovieDTO> getLatest() {
        try {
            MovieDTO result = this.service.getLatest();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
