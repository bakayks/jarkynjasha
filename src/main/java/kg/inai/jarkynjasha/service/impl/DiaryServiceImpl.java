package kg.inai.jarkynjasha.service.impl;

import kg.inai.jarkynjasha.entity.Diary;
import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.exception.RecordNotFoundException;
import kg.inai.jarkynjasha.model.DiaryModel;
import kg.inai.jarkynjasha.model.NewsModel;
import kg.inai.jarkynjasha.repository.DiaryRepository;
import kg.inai.jarkynjasha.repository.NewsRepository;
import kg.inai.jarkynjasha.service.DiaryService;
import kg.inai.jarkynjasha.service.NewsService;
import kg.inai.jarkynjasha.util.UtilBase64Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public List<Diary> findAll() {
        return diaryRepository.findAll();
    }


    @Override
    public Diary getDiaryById(Long id) {
        return diaryRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("Record not found with id:" + id));
    }


    @Override
    public void putById(Long id, DiaryModel diaryModel) {
        diaryRepository.findById(id)
                .map(newDiary -> {
                    newDiary.setTitle(diaryModel.getTitle());
                    newDiary.setDescription(diaryModel.getDescription());
                    if (diaryModel.getImage() != null && diaryModel.getImage().getContentType().contains("image")) {
                        newDiary.setImage(UtilBase64Image.encoder(diaryModel.getImage()));
                    }
                    newDiary.setCreatedDate(diaryModel.getCreatedDate());
                    return diaryRepository.save(newDiary);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void create(DiaryModel diaryModel) {
        Diary diary = new Diary();
        diary.setTitle(diaryModel.getTitle());
        diary.setDescription(diaryModel.getDescription());
        if(diaryModel.getImage() != null && diaryModel.getImage().getContentType().contains("image")) {
            diary.setImage(UtilBase64Image.encoder(diaryModel.getImage()));
        }
        diary.setCreatedDate(diaryModel.getCreatedDate());
        diaryRepository.save(diary);
    }

    @Override
    public String deleteById(Long id) {
        diaryRepository.deleteById(id);
        return "Diary number " + id + " has been deleted!";
    }
}
