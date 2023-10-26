package com.example.eventservice.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
@Getter
@Setter
@Data
public class Evenement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvents;

    private int nbrParticipant;
    private int MaxNbrParticipant;


    private String Name;

    private String Description;

    @Temporal(TemporalType.DATE)
    private Date StartDate;

    @Temporal(TemporalType.DATE)
    private Date EndDate;

    private String location;


    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Enumerated(EnumType.STRING)
    private Places Places ;
    @Lob
    private String Image;

    @Override
    public String toString() {
        return "Events{" +
                "idEvents=" + idEvents +
                ", nbrParticipant=" + nbrParticipant +
               ", MaxNbrParticipant=" + MaxNbrParticipant +
                //", Ratiing=" + Ratiing +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", Name='" + Name + '\'' +
                ", Topic='" + Description + '\'' +
                ", location='" + location + '\'' +
                ", Image='" + Image + '\'' +
                ", Places=" + Places +
                ", Themes=" + theme +
                '}';
    }

}
