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
@Table(name = "articles")
public class Article {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "news_seq", sequenceName = "news_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq")
    private Long id;


    /**
     * Title
     */
    @Column(name = "title")
    private String title;

    /**
     * Last name
     */
    @Column(name = "description")
    private String description;

    /**
     * News image encode to base64
     */
    @Column(name = "image")
    private String image;

    /**
     * Created date
     */
    @CreationTimestamp
    @Column(name = "created_date")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date createdDate;
}
