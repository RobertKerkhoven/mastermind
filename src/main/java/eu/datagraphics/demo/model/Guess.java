package eu.datagraphics.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="GUESS")
@Data
public class Guess implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="chellange")
    private String chellange;

}
