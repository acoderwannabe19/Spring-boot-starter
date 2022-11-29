package com.example.demo.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kudo implements Serializable{
    enum Level{
        MERCI_BEAUCOUP,
        BIEN_JOUE,
        FELICITATIONS,
        EXTRAORDINAIRE,
        EXCELLENT_TRAVAIL,

    }

    @EmbeddedId
    KudoKey id;

    @ManyToOne
    private Roomie giver;

    @ManyToOne
    private Roomie recipient;

    @Column(nullable = false)
    private Level appreciation;

    @Column
    private String message;

    @Column
    private LocalDate date;




}
@Embeddable
class KudoKey implements Serializable {

    private Long id_giver;

    private Long id_recipient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KudoKey kudoKey = (KudoKey) o;
        return Objects.equals(id_giver, kudoKey.id_giver) && Objects.equals(id_recipient, kudoKey.id_recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_giver, id_recipient);
    }



}
