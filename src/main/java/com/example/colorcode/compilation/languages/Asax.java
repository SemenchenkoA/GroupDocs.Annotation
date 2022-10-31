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


public class Asax implements ILanguage {
    public final String getId() {
        return LanguageId.Asax;
    }

    public final String getName() {
        return "ASAX";
    }

    public final String getCssClassName() {
        return "asax";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp1 =
                new Dictionary<Integer, String>();
        tmp1.addItem(1, ScopeName.HtmlServerSideScript);
        tmp1.addItem(2, ScopeName.HtmlTagDelimiter);
        tmp1.addItem(3, ScopeName.HtmlElementName);
        tmp1.addItem(4, ScopeName.HtmlAttributeName);
        tmp1.addItem(5, ScopeName.HtmlOperator);
        tmp1.addItem(6, ScopeName.HtmlAttributeValue);
        tmp1.addItem(7, ScopeName.HtmlServerSideScript);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                "(<%)(--.*?--)(%>)", tmp1


        ));
        tmp0.addItem(new LanguageRule(
                "(?is)(?<=<%@.+?language=\"c\\#\".*?%>.*?<script.*?runat=\"server\">)(.*)(?=</script>)", tmp1


        ));
        tmp0.addItem(new LanguageRule(
                "(?is)(?<=<%@.+?language=\"vb\".*?%>.*?<script.*?runat=\"server\">)(.*)(?=</script>)", tmp1


        ));
        tmp0.addItem(new LanguageRule(
                "(?xi)(</?)\r\n                                         (?: ([a-z][a-z0-9-]*)(:) )*\r\n                                         ([a-z][a-z0-9-_]*)\r\n                                         (?:\r\n                                            [\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*([^\\s\\n\"']+?)\r\n                                           |[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*(\"[^\\n]+?\")\r\n                                           |[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*('[^\\n]+?')\r\n                                           |[\\s\\n]+([a-z0-9-_]+) )*\r\n                                         [\\s\\n]*\r\n                                         (/?>)", tmp1


        ));
        tmp0.addItem(new LanguageRule(
                "(<%)(@)(?:\\s+([a-zA-Z0-9]+))*(?:\\s+([a-zA-Z0-9]+)(=)(\"[^\\n]*?\"))*\\s*?(%>)", tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        return false;
    }

    public /*override*/ String toString() {
        return getName();
    }
}
