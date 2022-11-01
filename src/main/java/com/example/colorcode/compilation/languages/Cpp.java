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

public class Cpp implements ILanguage {
    public final String getId() {
        return LanguageId.Cpp;
    }

    public final String getName() {
        return "C++";
    }

    public final String getCssClassName() {
        return "cplusplus";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp2 = new Dictionary<>();
        tmp2.addItem(0, ScopeName.Keyword);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule("/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/", tmp2));
        tmp0.addItem(new LanguageRule("(//.*?)\\r?$", tmp2));
        tmp0.addItem(new LanguageRule("(?s)(\"[^\\n]*?(?<!\\\\)\")", tmp2));
        tmp0.addItem(new LanguageRule("\\b(abstract|array|auto|bool|break|case|catch|char|ref class|class|const|const_cast|continue|default|delegate|delete|deprecated|dllexport|dllimport|do|double|dynamic_cast|each|else|enum|event|explicit|export|extern|false|float|for|friend|friend_as|gcnew|generic|goto|if|in|initonly|inline|int|interface|literal|long|mutable|naked|namespace|new|noinline|noreturn|nothrow|novtable|nullptr|operator|private|property|protected|public|register|reinterpret_cast|return|safecast|sealed|selectany|short|signed|sizeof|static|static_cast|ref struct|struct|switch|template|this|thread|throw|true|try|typedef|typeid|typename|union|unsigned|using|uuid|value|virtual|void|volatile|wchar_t|while)\\b", tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"c++"*/0:
            case /*"c"*/1:
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
                    "c++",
                    "c"
            );

}

