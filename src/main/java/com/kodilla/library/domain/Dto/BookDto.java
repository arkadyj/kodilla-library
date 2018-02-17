package com.kodilla.library.domain.Dto;

import com.kodilla.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDto {

    private Long id;
    private String status;
    private Long title_id;
    //private Title title;
    private String titleName;

    public BookDto(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public BookDto(Long id, String status, Long title_id) {
        this.id = id;
        this.status = status;
        this.title_id = title_id;
    }
/*
    public BookDto(Long id, String status, Title title) {
        this.id = id;
        this.status = status;
        this.title = title;
    } */

   /* public BookDto(Long id, String status, Long title_id, String titleName) {
        this.id = id;
        this.status = status;
        this.title_id = title_id;
        this.titleName = titleName;
    } */
}
