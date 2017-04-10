package model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 05.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"advertID"})
@ToString( of = {"name", "description", "creation"}, includeFieldNames = false)
public class Advert implements Serializable {

    @Id
    @Column(name = "ADVERT_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int advertID;

    @Column(name = "NAME", nullable = false)
    private @Getter @Setter String name;

    @Column(name = "DESCRIPTION")
    private @Getter @Setter String description;

    @Column(name = "TYPE", nullable = false)
    private @Getter @Setter AdvertType type;

    @Column(name = "CREATION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private @Getter @Setter Date creation;

    @Column(name = "END")
    @Temporal(TemporalType.TIMESTAMP)
    private @Getter @Setter Date end;

    @Column(name = "SEAT_NUMBER")
    private @Getter @Setter int seatNumber;

    @Column(name = "VALID")
    private @Getter @Setter boolean valid;
}

