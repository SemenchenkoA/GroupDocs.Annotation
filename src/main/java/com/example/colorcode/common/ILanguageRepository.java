// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.common;

//import com.aspose.ms.System.Collections.Generic.IGenericEnumerable;
import com.aspose.note.system.collections.Generic.IGenericEnumerable;
import com.example.colorcode.ILanguage;


public interface ILanguageRepository
{
    public IGenericEnumerable<ILanguage> getAll();
    public ILanguage findById(String languageId);
    public void load(ILanguage language);
}
