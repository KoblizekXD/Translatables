import com.koblizek.translatables.Translations;
import com.koblizek.translatables.lang.Languages;

public class Main {
    public static void main(String[] args) {
        Languages langs = Translations.loadLanguages("C:\\Users\\janpr\\Desktop\\Coding\\JVM\\Translatables\\src\\test\\resources");
        Translations.setCurrentLanguage(langs.getLanguage("en_us"));
        System.out.println(Translations.getCurrentLanguage().getFromKey("hello_world"));
    }
}
