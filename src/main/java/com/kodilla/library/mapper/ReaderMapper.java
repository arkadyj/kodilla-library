package com.kodilla.library.mapper;

import com.kodilla.library.domain.Dto.ReaderDto;
import com.kodilla.library.domain.Reader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public Reader mapToRader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFname(),
                readerDto.getSname(),
                readerDto.getCreateDate()
        );
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFname(),
                reader.getSname(),
                reader.getCreateDate()
        );
    }

    public List<ReaderDto> mapToListReaderDto(final List<Reader> list) {
        return list.stream()
                .map(t -> new ReaderDto(t.getId(), t.getFname(), t.getSname(), t.getCreateDate()))
                .collect(Collectors.toList());
    }
}
