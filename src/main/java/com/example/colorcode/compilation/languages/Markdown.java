package com.example.colorcode.compilation.languages;

import com.aspose.ms.lang.StringSwitchMap;
import com.aspose.ms.System.StringExtensions;
import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.List;

import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;

public class Markdown implements ILanguage {
    public final String getId() {
        return LanguageId.Markdown;
    }

    public final String getName() {
        return "Markdown";
    }

    public final String getCssClassName() {
        return "markdown";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    private String link(String content) //content = "([^\\]\\n]+)"
    {
        return StringExtensions.concat("\\!?\\[", content, "\\][ \\t]*(\\([^\\)\\n]*\\)|\\[[^\\]\\n]*\\])");
    }


    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp1 =
                new Dictionary<Integer, String>();
        tmp1.addItem(0, ScopeName.HtmlEntity);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(
                // Heading
                new LanguageRule("^(\\#.*)\\r?|^.*\\r?\\n([-]+|[=]+)\\r?$", tmp1));
        tmp0.addItem(
                // code block
                new LanguageRule("^([ ]{4}(?![ ])(?:.|\\r?\\n[ ]{4})*)|^(```+[ \\t]*\\w*)((?:[ \\t\\r\\n]|.)*?)(^```+)[ \\t]*\\r?$", tmp1));
        tmp0.addItem(
                // Line
                new LanguageRule("^\\s*((-\\s*){3}|(\\*\\s*){3}|(=\\s*){3})[ \\t\\-\\*=]*\\r?$", tmp1));
        tmp0.addItem(
                // List
                new LanguageRule("^[ \\t]*([\\*\\+\\-]|\\d+\\.)", tmp1));
        tmp0.addItem(
                // escape
                new LanguageRule("\\\\[\\\\`\\*_{}\\[\\]\\(\\)\\#\\+\\-\\.\\!]", tmp1));
        tmp0.addItem(
                // link
                new LanguageRule(StringExtensions.concat(link(link("([^\\]\\n]+)")), "|", link("([^\\]\\n]+)")), tmp1));  // support nested links (mostly for images)
        tmp0.addItem(new LanguageRule("^[ ]{0,3}\\[[^\\]\\n]+\\]:(.|\\r|\\n[ \\t]+(?![\\r\\n]))*$", tmp1
                // nice gray
        ));
        tmp0.addItem(
                // bold
                new LanguageRule("\\*(?!\\*)([^\\*\\n]|\\*\\w)+?\\*(?!\\w)|\\*\\*([^\\*\\n]|\\*(?!\\*))+?\\*\\*", tmp1));
        tmp0.addItem(
                // emphasized
                new LanguageRule("_([^_\\n]|_\\w)+?_(?!\\w)|__([^_\\n]|_(?=[\\w_]))+?__(?!\\w)", tmp1));
        tmp0.addItem(
                // inline code
                new LanguageRule("`[^`\\n]+?`|``([^`\\n]|`(?!`))+?``", tmp1));
        tmp0.addItem(
                // strings
                new LanguageRule("\"[^\"\\n]+?\"|'[\\w\\-_]+'", tmp1));
        tmp0.addItem(
                // html tag
                new LanguageRule("</?\\w.*?>", tmp1));
        tmp0.addItem(
                // html entity
                new LanguageRule(
                        "\\&\\#?\\w+?;", tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"md"*/0:
            case /*"markdown"*/1:
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
                    "md",
                    "markdown"
            );

}
