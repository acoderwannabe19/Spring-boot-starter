package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Kudo {
    public Kudo() {
    }

    public enum Level{
        MERCI_BEAUCOUP,
        BIEN_JOUE,
        FELICITATIONS,
        EXTRAORDINAIRE,
        EXCELLENT_TRAVAIL,

    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    Roomie giver;

    @ManyToOne
    Roomie recipient;

    @Column(nullable = false)
    private Level appreciation;

    @Column
    private String message;

    @Column
    private LocalDate date;

    public Kudo(Roomie giver, Roomie recipient, Level appreciation, String message, LocalDate date) {

        this.giver = giver;
        this.recipient = recipient;
        this.appreciation = appreciation;
        this.message = message;
        this.date = date;
    }
}
//@Embeddable
//class KudoKey implements Serializable {
//
//    private Long id_giver;
//
//    private Long id_recipient;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        KudoKey kudoKey = (KudoKey) o;
//        return Objects.equals(id_giver, kudoKey.id_giver) && Objects.equals(id_recipient, kudoKey.id_recipient);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id_giver, id_recipient);
//    }
//
//
//
//}
