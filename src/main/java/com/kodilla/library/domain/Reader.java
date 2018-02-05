package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime createDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RENT_ID")
    private Rent rent;

    public Reader (String fname, String sname, LocalDateTime createDate) {
        this.fname=fname;
        this.sname=sname;
        this.createDate=createDate;
    }




}
