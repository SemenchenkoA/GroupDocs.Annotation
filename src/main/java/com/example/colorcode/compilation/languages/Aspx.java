package com.example.colorcode.compilation.languages;

import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.List;

import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.compilation.RuleCaptures;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;
import com.example.colorcode.compilation.RuleFormats;

public class Aspx implements ILanguage {
    public final String getId() {
        return LanguageId.Aspx;
    }

    public final String getName() {
        return "ASPX";
    }

    public final String getCssClassName() {
        return "aspx";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp1 = new Dictionary<>();
        tmp1.addItem(0, ScopeName.HtmlEntity);
        List<LanguageRule> tmp0 = new List<>();
        tmp0.addItem(new LanguageRule("(?s)(<%)(--.*?--)(%>)", tmp1));
        tmp0.addItem(new LanguageRule("(?s)<!--.*?-->", tmp1));
        tmp0.addItem(new LanguageRule("(?i)(<%)(@)(?:\\s+([a-z0-9]+))*(?:\\s+([a-z0-9]+)(=)(\"[^\\n]*?\"))*\\s*?(%>)", tmp1));
        tmp0.addItem(new LanguageRule("(?s)(?:(<%=|<%)(?!=|@|--))(?:.*?)(%>)", tmp1));
        tmp0.addItem(new LanguageRule("(?is)(<!)(DOCTYPE)(?:\\s+([a-z0-9]+))*(?:\\s+(\"[^\"]*?\"))*(>)", tmp1));
        tmp0.addItem(new LanguageRule(RuleFormats.JavaScript, RuleCaptures.JavaScript));
        tmp0.addItem(new LanguageRule("(?xi)(</?)(?: ([a-z][a-z0-9-]*)(:) )*([a-z][a-z0-9-_]*)(?:[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*([^\\s\\n\"']+?)|[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*(\"[^\\n]+?\")|[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*('[^\\n]+?')|[\\s\\n]+([a-z0-9-_]+) )*[\\s\\n]*(/?>)", tmp1));
        tmp0.addItem(new LanguageRule("(?i)&[a-z0-9]+?;", tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        return false;
    }

    public String toString() {
        return getName();
    }
}
