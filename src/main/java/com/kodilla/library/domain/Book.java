package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Rent> rents = new ArrayList<>();

    public Book(String status) {
        this.status = status;
    }

    public Book(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
