// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.parsing;


import com.aspose.note.system.collections.IList;
import com.example.colorcode.ILanguage;
import com.example.colorcode.Scope;

public interface ILanguageParser
{
    public void parse(String sourceCode,
               ILanguage language,
               Action<String, IList<Scope>> parseHandler);
}
