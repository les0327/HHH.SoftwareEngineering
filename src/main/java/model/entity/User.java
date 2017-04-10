package model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on 04.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"userID"})
@ToString(of = {"name", "email"}, includeFieldNames = false)
public class User implements Serializable {

    @Id
    @Column(name = "USER_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int userID;

    @Column(name = "NAME", nullable = false)
    private @Getter @Setter String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private @Getter @Setter String email;

    @Column(name = "PASSWORD", nullable = false)
    private @Getter @Setter String password;
}
