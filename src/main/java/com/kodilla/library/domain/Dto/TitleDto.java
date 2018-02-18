package com.kodilla.library.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TitleDto {

    private Long id;
    private String title;
    private String author;
    private String publishYear;


    @Override
    public String toString() {
        return "TitleDto{" +
                "titleId=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear='" + publishYear + '\'' +
                '}';
    }
}
