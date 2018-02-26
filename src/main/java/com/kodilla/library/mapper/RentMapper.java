package com.kodilla.library.mapper;

import com.kodilla.library.domain.Dto.RentDto;
import com.kodilla.library.domain.Rent;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public RentMapper() {
        modelMapper.addMappings(rentMap);
    }

    PropertyMap<Rent, RentDto> rentMap = new PropertyMap<Rent, RentDto>() {
        @Override
        protected void configure() {
            map().setId(source.getId());
            map().setBookId(source.getBook().getId());
            map().setRentDate(source.getRentDate());
            map().setReturnDate(source.getReturnDate());
            map().setBookTitle(source.getBook().getTitle().getTitle());
            map().setReaderFirstName(source.getReader().getFname());
            map().setReaderSecondName(source.getReader().getSname());
        }
    };

    public RentDto mapToRentDto(Rent rent) {
        return modelMapper.map(rent, RentDto.class);
    }

    public List<RentDto> mapToListRentDto(List<Rent> rentList) {
        return rentList.stream()
                .map(rent -> modelMapper.map(rent, RentDto.class))
                .collect(Collectors.toList());
    }
}
