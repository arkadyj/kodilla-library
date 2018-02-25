package com.kodilla.library.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookWithTitle {

    private Long idTitle;
    private Long idBook;
    private String title;
    private String author;
    private String publishYear;
    private String status;
}
