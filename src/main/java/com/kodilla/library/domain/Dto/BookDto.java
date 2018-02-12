package com.kodilla.library.domain.Dto;

import com.kodilla.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDto {

    private Long id;
    private String status;
    //private Title title;
}
