package com.vertex.bootdemo.dao;

import com.vertex.bootdemo.model.TranslationPair;

public interface TranslationDao {

    TranslationPair getTranslation(String word);
}
