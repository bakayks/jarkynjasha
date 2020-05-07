package kg.inai.jarkynjasha.service.impl;

import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.exception.RecordNotFoundException;
import kg.inai.jarkynjasha.repository.NewsRepository;
import kg.inai.jarkynjasha.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Page<News> getAllNewsWithPagination(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void putById(Long id, News news) {
        newsRepository.findById(id)
                .map(newNews -> {
                    newNews.setTitle(news.getTitle());
                    newNews.setDescription(news.getDescription());
                    newNews.setImage(news.getImage());
//                    if (newsModel.getImage() != null && newsModel.getImage().getContentType().contains("image")) {
//                        newNews.setImage(UtilBase64Image.encoder(newsModel.getImage()));
//                    }
//                    newNews.setCreatedDate(newsModel.getCreatedDate());
                    return newsRepository.save(newNews);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void create(News news) {
        newsRepository.save(news);
    }

    @Override
    public String deleteById(Long id) {
        newsRepository.deleteById(id);
        return "Organization number " + id + " has been deleted!";
    }
}
