package com.vertex.bootdemo.services.impl;

import com.vertex.bootdemo.dao.TranslationDao;
import com.vertex.bootdemo.model.TranslationPair;
import com.vertex.bootdemo.services.TranslationService;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl implements TranslationService {

    private final TranslationDao translationDao;

    public TranslationServiceImpl(TranslationDao translationDao) {
        this.translationDao = translationDao;
    }

    @Override
    public TranslationPair translate(String word) {
        return translationDao.getTranslation(word);
    }
}
