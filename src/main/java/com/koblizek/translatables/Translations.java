package com.koblizek.translatables;

import com.koblizek.translatables.lang.Language;
import com.koblizek.translatables.lang.Languages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Translations {
    private static Language language;

    private Translations() {}

    public static Languages loadLanguages(String directory) {
        File dir = new File(directory);
        if (!dir.isDirectory() || !dir.exists())
            throw new RuntimeException("Directory either not exists or it's not directory");
        File[] jsonFiles = dir.listFiles(f -> f.isFile() && f.getName().endsWith(".json"));
        if (jsonFiles == null)
            throw new RuntimeException("Path doesn't exists or IO error occurred");
        List<Language> languages = new ArrayList<>();
        for (File jsonFile : jsonFiles) {
            StringBuilder content = new StringBuilder();
            try (BufferedReader r = new BufferedReader(new FileReader(jsonFile));) {
                while (r.ready()) {
                    content.append(r.readLine());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            languages.add(new Language(jsonFile, content.toString()));
        }
        return new Languages(languages);
    }
    public static void setCurrentLanguage(Language language) {
        Translations.language = language;
    }
    public static Language getCurrentLanguage() {
        return Translations.language;
    }
}
