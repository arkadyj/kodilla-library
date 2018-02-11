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
@Table(name = "TITLES")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name="publishYear")
    private String publishYear;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Book> books = new ArrayList<>();

    public Title (String title, String author, String publishYear) {
        this.title=title;
        this.author=author;
        this.publishYear=publishYear;
    }

    public Title (Long id, String title, String author, String publishYear) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.publishYear=publishYear;
    }



    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", books=" + books +
                '}';
    }
}
