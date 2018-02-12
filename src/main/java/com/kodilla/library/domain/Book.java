package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
        //this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", title=" + title.getTitle() +
                '}';
    }
}
