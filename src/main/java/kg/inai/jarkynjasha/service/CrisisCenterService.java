package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.CrisisСenter;

import java.util.List;

public interface CrisisCenterService {
    List<CrisisСenter> findAll();

    void create(CrisisСenter crisisСenter);

    String deleteById(Long id);
}