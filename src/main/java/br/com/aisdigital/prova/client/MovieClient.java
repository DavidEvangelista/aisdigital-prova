package br.com.aisdigital.prova.client;

import br.com.aisdigital.prova.dto.MovieDTO;
import br.com.aisdigital.prova.dto.ResponseList;
import feign.Param;
import feign.RequestLine;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Optional;

@FeignClient(name = "movie", url = "https://api.themoviedb.org/3/movie")
public interface MovieClient {

    @RequestLine(value = "GET /popular")
    Optional<ResponseList<MovieDTO>> getPopular();

    @RequestLine(value = "GET /now_playing?region={region}")
    Optional<ResponseList<MovieDTO>> getNowPlaying(@Param("region") String region);

    @RequestLine(value = "GET /latest")
    Optional<MovieDTO> getLatest();

}
