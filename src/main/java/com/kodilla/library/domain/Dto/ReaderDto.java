package com.kodilla.library.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReaderDto {

    private Long id;
    private String fname;
    private String sname;
    private LocalDate createDate;

}
