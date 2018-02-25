package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
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

    @Column(name = "email")
    private String email;

    @Column(name = "createdate")
    private String createDate;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Rent> rents = new ArrayList<>();

    public Reader(String fname, String sname, String email, String createDate) {

        this.fname = fname;
        this.sname = sname;
        this.email = email;
        this.createDate = createDate;
    }

    public Reader(Long id, String fname, String sname, String email, String createDate) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.email = email;
        this.createDate = createDate;
    }
}
