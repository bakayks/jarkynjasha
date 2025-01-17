package kg.inai.jarkynjasha.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User{

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;


    /**
     * Title
     */
    @Column(name = "login")
    private String login;

    /**
     * Last name
     */
    @Column(name = "password")
    private String password;
}
