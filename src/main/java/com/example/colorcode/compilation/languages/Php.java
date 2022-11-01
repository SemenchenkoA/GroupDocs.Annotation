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

public class Php implements ILanguage {
    public final String getId() {
        return LanguageId.Php;
    }

    public final String getName() {
        return "PHP";
    }

    public final String getCssClassName() {
        return "php";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp2 = new Dictionary<>();
        tmp2.addItem(1, ScopeName.Keyword);
        List<LanguageRule> tmp0 = new List<>();
        tmp0.addItem(new LanguageRule("/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/", tmp2));
        tmp0.addItem(new LanguageRule("(//.*?)\\r?$", tmp2));
        tmp0.addItem(new LanguageRule("(#.*?)\\r?$", tmp2));
        tmp0.addItem(new LanguageRule("'[^\\n]*?(?<!\\\\)'", tmp2));
        tmp0.addItem(new LanguageRule("\"[^\\n]*?(?<!\\\\)\"", tmp2));
        tmp0.addItem(new LanguageRule(
                // from http://us.php.net/manual/en/reserved.keywords.php
                "\\b(abstract|and|array|as|break|case|catch|cfunction|class|clone|const|continue|declare|default|do|else|elseif|enddeclare|endfor|endforeach|endif|endswitch|endwhile|exception|extends|fclose|file|final|for|foreach|function|global|goto|if|implements|interface|instanceof|mysqli_fetch_object|namespace|new|old_function|or|php_user_filter|private|protected|public|static|switch|throw|try|use|var|while|xor|__CLASS__|__DIR__|__FILE__|__FUNCTION__|__LINE__|__METHOD__|__NAMESPACE__|die|echo|empty|exit|eval|include|include_once|isset|list|require|require_once|return|print|unset)\\b", tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"php3"*/0:
            case /*"php4"*/1:
            case /*"php5"*/2:
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
                    "php3",
                    "php4",
                    "php5"
            );

}

