package com.example.colorcode.common;

import com.aspose.ms.System.Collections.Generic.IGenericEnumerable;
import com.example.colorcode.ILanguage;

public interface ILanguageRepository {
    IGenericEnumerable<ILanguage> getAll();

    ILanguage findById(String languageId);

    void load(ILanguage language);
}
