package com.kodilla.library.mapper;

import com.kodilla.library.domain.Dto.ReaderDto;
import com.kodilla.library.domain.Reader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public Reader mapToReader(ReaderDto readerDto) {
        Reader reader = modelMapper.map(readerDto, Reader.class);
        return reader;
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        ReaderDto readerDto = modelMapper.map(reader, ReaderDto.class);
        return readerDto;
    }

    public List<ReaderDto> mapToListReaderDto(final List<Reader> list) {
        return list.stream()
                .map(reader -> modelMapper.map(reader, ReaderDto.class))
                .collect(Collectors.toList());
    }
}
