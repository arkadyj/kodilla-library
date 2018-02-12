package com.kodilla.library.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookWithTitleDto {

    private Long idTitle;
    private Long idBook;
    private String title;
    private String author;
    private String publishYear;
    private String status;
}
