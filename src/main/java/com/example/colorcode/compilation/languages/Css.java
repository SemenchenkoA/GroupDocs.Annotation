// Copyright (c) Microsoft Corporation.  All rights reserved.   

package com.example.colorcode.compilation.languages;

//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.Collections.Generic.Dictionary;
//import com.aspose.ms.System.Collections.Generic.List;
import com.aspose.note.system.collections.Generic.Dictionary;
import com.aspose.note.system.collections.Generic.IGenericList;
import com.aspose.note.system.collections.Generic.List;
import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;


public class Css implements ILanguage
{
    public final String getId() { return LanguageId.Css; }

    public final String getName() { return "CSS"; }

    public final String getCssClassName() { return "css"; }

    public final String getFirstLinePattern()
    {
        return null;
    }

    public final IGenericList<LanguageRule> getRules()
    {
        Dictionary<Integer,String> tmp1 =
                           new Dictionary<Integer,String>();
        tmp1.addItem(3, ScopeName.CssSelector);
        tmp1.addItem(5, ScopeName.CssPropertyName);
        tmp1.addItem(6, ScopeName.CssPropertyValue);
        tmp1.addItem(4, ScopeName.Comment);
        tmp1.addItem(1, ScopeName.Comment);
         List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                           "(?msi)(?:(\\s*/\\*.*?\\*/)|(([a-z0-9#. \\[\\]=\\\":_-]+)\\s*(?:,\\s*|{))+(?:(\\s*/\\*.*?\\*/)|(?:\\s*([a-z0-9 -]+\\s*):\\s*([a-z0-9#,<>\\?%. \\(\\)\\\\\\/\\*\\{\\}:'\\\"!_=-]+);?))*\\s*})",tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang)
    {
        return false;
    }

    public /*override*/ String toString()
    {
        return getName();
    }
}

