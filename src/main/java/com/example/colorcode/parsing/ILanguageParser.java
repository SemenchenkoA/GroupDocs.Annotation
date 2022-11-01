package com.example.colorcode.parsing;

import com.aspose.ms.System.Action;
import com.aspose.ms.System.Collections.IList;
import com.example.colorcode.ILanguage;


public interface ILanguageParser
{
    public void parse(String sourceCode,
               ILanguage language,
               Action<String, IList<Scope>> parseHandler);
}
