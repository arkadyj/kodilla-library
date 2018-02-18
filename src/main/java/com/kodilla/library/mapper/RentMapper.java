package com.kodilla.library.mapper;

import com.kodilla.library.domain.Dto.RentDto;
import com.kodilla.library.domain.Rent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentMapper {

    public Rent mapToRent(RentDto rentDto) {
        return new Rent(
                rentDto.getId(),
                rentDto.getRentDate(),
                rentDto.getReturnDate()
        );
    }

    public RentDto mapToRentDto(Rent rent) {
        return new RentDto(
                rent.getId(),
                rent.getBook().getId(),
                rent.getRentDate(),
                rent.getReturnDate(),
                rent.getBook().getTitle().getTitle(),
                rent.getReader().getFname(),
                rent.getReader().getSname()
        );
    }

    public List<RentDto> mapToListRentDto(List<Rent> rentList) {
        return rentList.stream()
                .map(list -> new RentDto(list.getId(), list.getBook().getId(), list.getRentDate(), list.getReturnDate(),
                        list.getBook().getTitle().getTitle(), list.getReader().getFname(), list.getReader().getSname()))
                .collect(Collectors.toList());
    }
}
