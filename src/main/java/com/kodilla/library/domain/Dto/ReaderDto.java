package com.kodilla.library.domain.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {

    private Long id;
    private String fname;
    private String sname;
    private String email;
    private String createDate;
}
