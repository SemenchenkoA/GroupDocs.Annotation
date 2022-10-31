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

public class Ashx implements ILanguage {
    public final String getId() {
        return LanguageId.Ashx;
    }

    public final String getName() {
        return "ASHX";
    }

    public final String getCssClassName() {
        return "ashx";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp2 =
                new Dictionary<Integer, String>();
        tmp2.addItem(1, ScopeName.HtmlServerSideScript);
        tmp2.addItem(2, ScopeName.HtmlTagDelimiter);
        tmp2.addItem(3, ScopeName.HtmlElementName);
        tmp2.addItem(4, ScopeName.HtmlAttributeName);
        tmp2.addItem(5, ScopeName.HtmlOperator);
        tmp2.addItem(6, ScopeName.HtmlAttributeValue);
        tmp2.addItem(7, ScopeName.HtmlServerSideScript);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                "(<%)(--.*?--)(%>)", tmp2


        ));
        tmp0.addItem(new LanguageRule(
                "(?is)(?<=<%@.+?language=\"c\\#\".*?%>)(.*)", tmp2


        ));
        tmp0.addItem(new LanguageRule(
                "(?is)(?<=<%@.+?language=\"vb\".*?%>)(.*)", tmp2


        ));
        tmp0.addItem(new LanguageRule(
                "(<%)(@)(?:\\s+([a-zA-Z0-9]+))*(?:\\s+([a-zA-Z0-9]+)(=)(\"[^\\n]*?\"))*\\s*?(%>)", tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        return false;
    }

    public /*override*/ String toString() {
        return getName();
    }
}
