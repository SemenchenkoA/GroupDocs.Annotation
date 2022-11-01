package com.example.colorcode.common;

import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.IGenericEnumerable;
import com.aspose.ms.System.StringExtensions;
import com.aspose.ms.System.ArgumentException;

import com.example.colorcode.ILanguage;

public class LanguageRepository implements ILanguageRepository {
    private final Dictionary<String, ILanguage> loadedLanguages;
    private final ReaderWriterLockSlim loadLock;

    public LanguageRepository(Dictionary<String, ILanguage> loadedLanguages) {
        this.loadedLanguages = loadedLanguages;
        loadLock = new ReaderWriterLockSlim();
    }

    public final IGenericEnumerable<ILanguage> getAll() {
        return loadedLanguages.getValues();
    }

    public final ILanguage findById(String languageId) {
        Guard.argNotNullAndNotEmpty(languageId, "languageId");

        ILanguage language = null;

        loadLock.EnterReadLock();

        try {
            // If we have a matching name for the language then use it
            // otherwise check if any languages have that string as an
            // alias. For example: "js" is an alias for Javascript.
            language = loadedLanguages.FirstOrDefault((x) = > (x.Key.ToLower() == languageId.ToLower()) ||
                    (x.Value.HasAlias(languageId))).Value;
        } finally {
            loadLock.ExitReadLock();
        }

        return language;
    }

    public final void load(ILanguage language) {
        Guard.argNotNull(language, "language");

        if (StringExtensions.isNullOrEmpty(language.getId()))
            throw new ArgumentException("The language identifier must not be null or empty.", "language");

        loadLock.EnterWriteLock();

        try {
            loadedLanguages.set_Item(language.getId(), language);
        } finally {
            loadLock.ExitWriteLock();
        }
    }
}
