package com.example.colorcode.compilation.languages;

import com.aspose.ms.lang.StringSwitchMap;
import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.List;
import com.aspose.ms.System.StringExtensions;

import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;

public class Xml implements ILanguage {
    public final String getId() {
        return LanguageId.Xml;
    }

    public final String getName() {
        return "XML";
    }

    public final String getCssClassName() {
        return "xml";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp1 = new Dictionary<>();
        tmp1.addItem(1, ScopeName.XmlDelimiter);
        tmp1.addItem(2, ScopeName.XmlCDataSection);
        tmp1.addItem(3, ScopeName.XmlDelimiter);
        List<LanguageRule> tmp0 = new List<>();
        tmp0.addItem(new LanguageRule("\\<![ \\r\\n\\t]*(--([^\\-]|[\\r\\n]|-[^\\-])*--[ \\r\\n\\t]*)\\>", tmp1));
        tmp0.addItem(new LanguageRule("(?i)(<!)(doctype)(?:\\s+([a-z0-9]+))*(?:\\s+(\")([^\\n]*?)(\"))*(>)", tmp1));
        tmp0.addItem(new LanguageRule("(?i)(<\\?)(xml-stylesheet)((?:\\s+[a-z0-9]+=\"[^\\n\"]*\")*(?:\\s+[a-z0-9]+=\\'[^\\n\\']*\\')*\\s*?)(\\?>)", tmp1));
        tmp0.addItem(new LanguageRule("(?i)(<\\?)([a-z][a-z0-9-]*)(?:\\s+([a-z0-9]+)(=)(\")([^\\n]*?)(\"))*(?:\\s+([a-z0-9]+)(=)(\\')([^\\n]*?)(\\'))*\\s*?(\\?>)", tmp1));
        tmp0.addItem(new LanguageRule("(?xi)(</?)(?: ([a-z][a-z0-9-]*)(:) )*([a-z][a-z0-9-_\\.]*)(?:|[\\s\\n]+([a-z0-9-_\\.:]+)[\\s\\n]*(=)[\\s\\n]*(\")([^\\n]+?)(\")|[\\s\\n]+([a-z0-9-_\\.:]+)[\\s\\n]*(=)[\\s\\n]*(')([^\\n]+?)(')|[\\s\\n]+([a-z0-9-_\\.:]+) )*[\\s\\n]*(/?>)", tmp1));
        tmp0.addItem(new LanguageRule("(?i)&[a-z0-9]+?;", tmp1));
        tmp0.addItem(new LanguageRule("(?s)(<!\\[CDATA\\[)(.*?)(\\]\\]>)", tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"xaml"*/0:
            case /*"axml"*/1:
                return true;

            default:
                return false;
        }
    }

    public String toString() {
        return getName();
    }

    //JAVA-added for string switch emulation
    private static final StringSwitchMap gStringSwitchMap = new StringSwitchMap
            (
                    "xaml",
                    "axml"
            );

}
