package com.example.colorcode.common;

import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.IGenericEnumerable;
import com.aspose.ms.System.StringExtensions;
import com.aspose.ms.System.ArgumentException;

import com.example.colorcode.ILanguage;

public class LanguageRepository implements ILanguageRepository {
    private final Dictionary<String, ILanguage> loadedLanguages;
    private Object mutex = new Object();

    public LanguageRepository(Dictionary<String, ILanguage> loadedLanguages) {
        this.loadedLanguages = loadedLanguages;
    }

    public final IGenericEnumerable<ILanguage> getAll() {
        return loadedLanguages.getValues();
    }

    public final ILanguage findById(String languageId) {
        Guard.argNotNullAndNotEmpty(languageId, "languageId");

        synchronized (mutex){
            ILanguage language = null;
            Dictionary.ValueCollection<String, ILanguage> vc = loadedLanguages.getValues();

            for(ILanguage il : vc){
                if(il.getId().equalsIgnoreCase(languageId) || il.hasAlias(languageId)){
                    language = il;
                }
            }

            return language;
        }
    }

    public final void load(ILanguage language) {
        Guard.argNotNull(language, "language");

        if (StringExtensions.isNullOrEmpty(language.getId()))
            throw new ArgumentException("The language identifier must not be null or empty.", "language");

        synchronized (mutex){
            loadedLanguages.set_Item(language.getId(), language);
        }
    }
}
