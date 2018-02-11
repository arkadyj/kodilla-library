package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RENTS")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rentDate")
    private LocalDate rentDate;

    @Column(name = "returnDate")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    public Rent(LocalDate rentDate, LocalDate returnDate) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Rent(long id, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                ", reader=" + reader +
                '}'+"\n";
    }
}
