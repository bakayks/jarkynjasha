package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.Diary;
import kg.inai.jarkynjasha.model.DiaryModel;

import java.util.List;

public interface DiaryService {
    List<Diary> findAll();

    Diary getDiaryById(Long id);

    void putById(Long id, DiaryModel diaryModel);

    void create(DiaryModel diaryModel);

    String deleteById(Long id);
}
