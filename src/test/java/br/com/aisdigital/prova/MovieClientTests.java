package br.com.aisdigital.prova;

import br.com.aisdigital.prova.dto.MovieDTO;
import br.com.aisdigital.prova.service.MovieService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class MovieClientTests {

    @Autowired
    private MovieService service;

    @Test
    void getPopularTest() {
        List<MovieDTO> result = service.getPopular();
        Assert.assertNotNull(result);
    }

    @Test
    void getAllNowPlayingTest() {
        List<MovieDTO> result = service.getNowPlaying(null);
        Assert.assertNotNull(result);
    }

    @Test
    void getLatestTest() {
        MovieDTO result = service.getLatest();
        Assert.assertNotNull(result);
    }

}
