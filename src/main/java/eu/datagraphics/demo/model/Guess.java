package eu.datagraphics.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="GUESS")
@Getter @Setter @NoArgsConstructor
public class Guess implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="chellange")
    private String chellange;


//    public String getChellange() {
//        return chellange;
//    }
//
//    public void setChellange(String chellange) {
//        this.chellange = chellange;
//    }
}
