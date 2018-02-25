package com.kodilla.library.domain.Dto;

import com.kodilla.library.domain.Title;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

    private Long id;
    private String status;
    private Long title_id;
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
}
