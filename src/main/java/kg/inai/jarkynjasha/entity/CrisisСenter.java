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
@Table(name = "crisisCenters")
public class CrisisСenter {
    @Id
    @SequenceGenerator(name = "crisisCenter_seq", sequenceName = "crisisCenter_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crisisCenter_seq")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "address", columnDefinition = "text")
    private String address;

    @Column(name = "number", columnDefinition = "text")
    private String number;
}
