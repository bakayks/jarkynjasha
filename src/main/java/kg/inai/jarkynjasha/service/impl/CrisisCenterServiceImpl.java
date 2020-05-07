package kg.inai.jarkynjasha.service.impl;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.entity.CrisisСenter;
import kg.inai.jarkynjasha.exception.RecordNotFoundException;
import kg.inai.jarkynjasha.model.ArticleModel;
import kg.inai.jarkynjasha.repository.CrisisCenterRepository;
import kg.inai.jarkynjasha.service.CrisisCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrisisCenterServiceImpl implements CrisisCenterService {
    @Autowired
    private CrisisCenterRepository crisisCenterRepository;

    @Override
    public List<CrisisСenter> findAll() {
        return crisisCenterRepository.findAll();
    }

    @Override
    public void create(CrisisСenter crisisCenter) {
        crisisCenterRepository.save(crisisCenter);
    }

    @Override
    public String deleteById(Long id) {
        crisisCenterRepository.deleteById(id);
        return "Diary number " + id + " has been deleted!";
    }


}
