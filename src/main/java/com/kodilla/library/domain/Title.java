package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    public Title (String title, String author, String publishYear) {
        this.title=title;
        this.author=author;
        this.publishYear=publishYear;
    }
}
