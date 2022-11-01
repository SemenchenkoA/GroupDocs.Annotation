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

public class CSharp implements ILanguage {
    public final String getId() {
        return LanguageId.CSharp;
    }

    public final String getName() {
        return "C#";
    }

    public final String getCssClassName() {
        return "csharp";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp2 = new Dictionary<>();
        tmp2.addItem(0, ScopeName.Number);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule("/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/", tmp2));
        tmp0.addItem(new LanguageRule("(///)(?:\\s*?(<[/a-zA-Z0-9\\s\"=]+>))*([^\\r\\n]*)", tmp2));
        tmp0.addItem(new LanguageRule("(//.*?)\\r?$", tmp2));
        tmp0.addItem(new LanguageRule("'[^\\n]*?(?<!\\\\)'", tmp2));
        tmp0.addItem(new LanguageRule("(?s)@\"(?:\"\"|.)*?\"(?!\")", tmp2));
        tmp0.addItem(new LanguageRule("(?s)(\"[^\\n]*?(?<!\\\\)\")", tmp2));
        tmp0.addItem(new LanguageRule("\\[(assembly|module|type|return|param|method|field|property|event):[^\\]\"]*(\"[^\\n]*?(?<!\\\\)\")?[^\\]]*\\]", tmp2));
        tmp0.addItem(new LanguageRule(
                "^\\s*(\\#define|\\#elif|\\#else|\\#endif|\\#endregion|\\#error|\\#if|\\#line|\\#pragma|\\#region|\\#undef|\\#warning).*?$", tmp2));
        tmp0.addItem(new LanguageRule("\\b(abstract|as|ascending|base|bool|break|by|byte|case|catch|char|checked|class|const|continue|decimal|default|delegate|descending|do|double|dynamic|else|enum|equals|event|explicit|extern|false|finally|fixed|float|for|foreach|from|get|goto|group|if|implicit|in|int|into|interface|internal|is|join|let|lock|long|namespace|new|null|object|on|operator|orderby|out|override|params|partial|private|protected|public|readonly|ref|return|sbyte|sealed|select|set|short|sizeof|stackalloc|static|string|struct|switch|this|throw|true|try|typeof|uint|ulong|unchecked|unsafe|ushort|using|var|virtual|void|volatile|where|while|yield|async|await|warning|disable)\\b", tmp2));
        tmp0.addItem(new LanguageRule("\\b[0-9]{1,}\\b", tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"cs"*/0:
            case /*"c#"*/1:
            case /*"csharp"*/2:
            case /*"cake"*/3:
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
                    "cs",
                    "c#",
                    "csharp",
                    "cake"
            );

}
