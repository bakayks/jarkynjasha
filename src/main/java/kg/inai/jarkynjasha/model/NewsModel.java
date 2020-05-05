package kg.inai.jarkynjasha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsModel {
    private Long id;
    private String title;
    private String description;
    private MultipartFile image;
    private Date createdDate;
}
