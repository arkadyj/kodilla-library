package com.kodilla.library.controller;

import com.kodilla.library.domain.Dto.ReaderDto;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private DbService dbService;

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToListReaderDto(dbService.getAllReaders());
    }
}
