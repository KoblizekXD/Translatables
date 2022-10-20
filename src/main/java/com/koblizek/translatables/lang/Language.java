package com.koblizek.translatables.lang;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Getter;

import java.io.File;

public class Language {
    @Getter
    private final File file;
    @Getter
    private final String content;
    @Getter
    private final JsonObject json;

    public Language(File file, String content) {
        this.file = file;
        this.content = content;
        this.json = new Gson().fromJson(content, JsonObject.class);
    }
    public String getFromKey(String key) {
        return json.get(key).getAsString();
    }
}
