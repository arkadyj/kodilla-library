package com.kodilla.library.mapper;

import com.kodilla.library.domain.Dto.TitleDto;
import com.kodilla.library.domain.Title;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public Title mapToTitle(TitleDto titleDto) {
        return modelMapper.map(titleDto, Title.class);
    }

    public TitleDto mapToTitleDto(Title title) {
        return modelMapper.map(title, TitleDto.class);
    }

    public List<TitleDto> mapToListTitleDto(List<Title> titleList) {
        return titleList.stream()
                .map(title -> modelMapper.map(title, TitleDto.class))
                .collect(Collectors.toList());
    }
}
