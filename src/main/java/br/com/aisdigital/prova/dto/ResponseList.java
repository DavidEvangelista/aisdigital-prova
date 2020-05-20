package br.com.aisdigital.prova.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseList<T extends GenericDTO> {

    private Integer page;
    private Integer totalResults;
    private Integer totalPages;
    private List<T> results;

}
