package kg.inai.jarkynjasha.repository;

import kg.inai.jarkynjasha.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary,Long> {
}
