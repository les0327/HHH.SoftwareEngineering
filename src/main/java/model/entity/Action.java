package model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 13.11.2016
 *
 * @author Les
 * @version 1.0
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"actionID"})
@ToString
public class Action implements Serializable {

    @Id
    @Column(name = "ACTION_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int actionID;

    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private @Getter @Setter ActionType type;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false)
    private @Getter @Setter Date date;

    @ManyToOne
    @JoinColumn(name = "AUTHHOR", nullable = false, referencedColumnName = "USER_ID")
    private @Getter @Setter User author;

    @ManyToOne
    @JoinColumn(name = "ACTOR", referencedColumnName = "USER_ID")
    private @Getter @Setter User actor;

    @ManyToOne
    @JoinColumn(name = "ADVERT", referencedColumnName = "ADVERT_ID")
    private @Getter @Setter Advert advert;
}
