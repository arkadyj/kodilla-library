package com.kodilla.library.mapper;

import com.kodilla.library.domain.Dto.TitleDto;
import com.kodilla.library.domain.Title;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublishYear()
        );
    }

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublishYear()
        );
    }

    public List<TitleDto> mapToListTitleDto(List<Title> titleList) {
        return titleList.stream()
                .map(title -> new TitleDto(title.getId(), title.getTitle(), title.getAuthor(), title.getPublishYear()))
                .collect(Collectors.toList());
    }
}
