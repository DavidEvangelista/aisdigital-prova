package br.com.aisdigital.prova.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class MovieDTO extends GenericDTO {

    private Double popularity;
    private Integer voteCount;
    private Boolean video;
    private String posterPath;
    private Boolean adult;
    private String backdropPath;
    private String originalLanguage;
    private String originalTitle;
    private List<Integer> genreIds;
    private String title;
    private Integer voteAverage;
    private String overview;
    private Date releaseDate;

}
