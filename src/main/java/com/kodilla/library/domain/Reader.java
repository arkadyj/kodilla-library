package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fname")
    private String fname;

    @Column(name = "sname")
    private String sname;

    @Column(name="createdate")
    private LocalDate createDate;

    public Reader (String fname, String sname, LocalDate createDate) {
        this.fname=fname;
        this.sname=sname;
        this.createDate=createDate;
    }




}
