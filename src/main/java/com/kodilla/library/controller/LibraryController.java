package com.kodilla.library.controller;


import com.kodilla.library.domain.Dto.ReaderDto;
import com.kodilla.library.domain.Dto.RentDto;
import com.kodilla.library.domain.Dto.TitleDto;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.mapper.RentMapper;
import com.kodilla.library.mapper.TitleMapper;
import com.kodilla.library.repository.TitleRepository;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private DbService dbService;

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToListReaderDto(dbService.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReaderRents")
    public List<RentDto> getReaderRents() {
        return rentMapper.mapToListRentDto(dbService.getRents());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        dbService.createReader(readerMapper.mapToRader(readerDto));    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody TitleDto titleDto) {
        dbService.createTitle(titleMapper.mapToTitle(titleDto));
    }
}
