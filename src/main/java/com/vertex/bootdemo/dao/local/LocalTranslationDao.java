package com.vertex.bootdemo.dao.local;

import com.vertex.bootdemo.dao.TranslationDao;
import com.vertex.bootdemo.model.Language;
import com.vertex.bootdemo.model.TranslationPair;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class LocalTranslationDao implements TranslationDao {

    private List<TranslationPair> pairs =
            Arrays.asList(
              new TranslationPair("word", "слово", Language.ENG, Language.RUS),
              new TranslationPair("world", "мир", Language.ENG, Language.RUS),
                  new TranslationPair("way", "путь", Language.ENG, Language.RUS)
            );

    private TranslationPair defaultTranslation =
            new TranslationPair("no translation", "слово не найдено", Language.ENG, Language.RUS);

    @Override
    public TranslationPair getTranslation(String word) {
        String smallWord = word.toLowerCase();
        return pairs.stream()
                .filter(pair -> pair.getWordFrom().equals(smallWord))
                .findAny()
                .orElse(defaultTranslation);
    }
}
