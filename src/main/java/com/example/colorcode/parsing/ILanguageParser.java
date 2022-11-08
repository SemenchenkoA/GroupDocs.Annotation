package com.example.colorcode.parsing;

import com.aspose.ms.System.Action;
import com.aspose.ms.System.Collections.Generic.List;
import com.aspose.ms.System.Collections.IList;
import com.example.colorcode.ILanguage;

@FunctionalInterface
public interface ILanguageParser
{
    void parse(String sourceCode,
               ILanguage language,
               Action<List> parseHandler);
}
