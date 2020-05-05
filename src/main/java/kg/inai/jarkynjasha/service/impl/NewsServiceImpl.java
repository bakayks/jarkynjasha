package kg.inai.jarkynjasha.service.impl;

import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.exception.RecordNotFoundException;
import kg.inai.jarkynjasha.model.NewsModel;
import kg.inai.jarkynjasha.repository.NewsRepository;
import kg.inai.jarkynjasha.service.NewsService;
import kg.inai.jarkynjasha.util.UtilBase64Image;
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
    public void putById(Long id, NewsModel newsModel) {
        newsRepository.findById(id)
                .map(newNews -> {
                    newNews.setTitle(newsModel.getTitle());
                    newNews.setDescription(newsModel.getDescription());
                    if (newsModel.getImage() != null && newsModel.getImage().getContentType().contains("image")) {
                        newNews.setImage(UtilBase64Image.encoder(newsModel.getImage()));
                    }
                    newNews.setCreatedDate(newsModel.getCreatedDate());
                    return newsRepository.save(newNews);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void create(NewsModel newsModel) {
        News organization = new News();
        organization.setTitle(newsModel.getTitle());
        organization.setDescription(newsModel.getDescription());
        if(newsModel.getImage() != null && newsModel.getImage().getContentType().contains("image")) {
            organization.setImage(UtilBase64Image.encoder(newsModel.getImage()));
        }
        organization.setCreatedDate(newsModel.getCreatedDate());
        newsRepository.save(organization);
    }

    @Override
    public String deleteById(Long id) {
        newsRepository.deleteById(id);
        return "Organization number " + id + " has been deleted!";
    }
}
