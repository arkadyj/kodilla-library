package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(name = "createdate")
    private String createDate;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Rent> rents = new ArrayList<>();

    public Reader(String fname, String sname, String createDate) {

        this.fname = fname;
        this.sname = sname;
        this.createDate = createDate;
    }

    public Reader(Long id, String fname, String sname, String createDate) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
