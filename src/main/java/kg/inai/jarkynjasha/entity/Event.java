package kg.inai.jarkynjasha.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {


    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "event_seq", sequenceName = "event_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    private Long id;

    /**
     * Title
     */
    @Column(name = "title")
    private String title;

    /**
     * Last name
     */
    @Column(name = "description", columnDefinition = "text")
    private String description;

    /**
     * News image encode to base64
     */
    @Column(name = "image", columnDefinition = "text")
    private String image;


    @Column(name = "created_date")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date eventDate;
}
