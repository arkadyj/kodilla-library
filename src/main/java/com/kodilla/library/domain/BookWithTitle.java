package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookWithTitle {

    private Long idTitle;
    private Long idBook;
    private String title;
    private String author;
    private String publishYear;
    private String status;
}
