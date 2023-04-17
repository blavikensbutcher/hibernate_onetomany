package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @Id()
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int director_id;

    @OneToMany(mappedBy = "owner")
    private List<Movie> movies;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Director() {
    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
