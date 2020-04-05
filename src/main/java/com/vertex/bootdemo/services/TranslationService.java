package com.vertex.bootdemo.services;

import com.vertex.bootdemo.model.TranslationPair;

public interface TranslationService {
    TranslationPair translate(String word);
}
