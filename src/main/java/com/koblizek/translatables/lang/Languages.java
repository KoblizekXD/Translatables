package com.koblizek.translatables.lang;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Languages {
    private final HashMap<String, Language> map;

    public Languages(List<Language> languages) {
        map = new HashMap<>();
        for (Language language : languages) {
            map.put(language.getFile().getName(), language);
        }
    }
    public Language getLanguage(String name) {
        AtomicReference<Language> l = new AtomicReference<>();
        map.forEach((n, lang) -> {
            if (name.equals(n)) {
                l.set(lang);
            }
        });
        return l.get();
    }
}
