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


public class Haskell implements ILanguage {
    public final String getId() {
        return LanguageId.Haskell;
    }

    public final String getName() {
        return "Haskell";
    }

    public final String getCssClassName() {
        return "haskell";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    private static final String nonnestComment = "((?:--.*\\r?\\n|{-(?:[^-]|-(?!})|[\\r\\n])*-}))";

    private static final String incomment = "([^-{}]|{(?!-)|-(?!})|(?<!-)})*";
    private static final String keywords = "case|class|data|default|deriving|do|else|foreign|if|import|in|infix|infixl|infixr|instance|let|module|newtype|of|then|type|where";
    private static final String opKeywords = "\\.\\.|:|::|=|\\\\|\\||<-|->|@|~|=>";

    private static final String vsymbol = "[\\!\\#\\$%\\&\\⋆\\+\\./<=>\\?@\\\\\\^\\-~\\|]";
    private static final String symbol = StringExtensions.concat("(?:", vsymbol, "|:)");

    private static final String varop = StringExtensions.concat(vsymbol, "(?:", symbol, ")*");
    private static final String conop = StringExtensions.concat(":(?:", symbol, ")*");

    private static final String conid = StringExtensions.concat("(?:[A-Z][\\w']*|\\(", conop, "\\))");
    private static final String varid = StringExtensions.concat("(?:[a-z][\\w']*|\\(", varop, "\\))");

    private static final String qconid = StringExtensions.concat("((?:[A-Z][\\w']*\\.)*)", conid);
    private static final String qvarid = StringExtensions.concat("((?:[A-Z][\\w']*\\.)*)", varid);
    private static final String qconidop = StringExtensions.concat("((?:[A-Z][\\w']*\\.)*)(?:", conid, "|", conop, ")");

    private static final String intype = StringExtensions.concat("(\\bforall\\b|=>)|", qconidop, "|(?!deriving|where|data|type|newtype|instance|class)([a-z][\\w']*)|\\->|[ \\t!\\#]|\\r?\\n[ \\t]+(?=[\\(\\)\\[\\]]|->|=>|[A-Z])");
    private static final String toptype = StringExtensions.concat("(?:", intype, "|::)");
    private static final String nestedtype = StringExtensions.concat("(?:", intype, ")");

    private static final String datatype = StringExtensions.concat("(?:", intype, "|[,]|\\r?\\n[ \\t]+|::|(?<!", symbol, "|^)([=\\|])\\s*(", conid, ")|", nonnestComment, ")");

    private static final String inexports = StringExtensions.concat("(?:[\\[\\],\\s]|(", conid, ")|", varid, "|", nonnestComment, "|\\((?:[,\\.\\s]|(", conid, ")|", varid, ")*\\)", ")*");

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp2 = new Dictionary<>();
        tmp2.addItem(0, ScopeName.String);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(
                // Nested block comments: note does not match no unclosed block comments.
                new LanguageRule(
                        // Handle nested block comments using named balanced groups
                        StringExtensions.concat("{-+", incomment,
                                "(?>",
                                "(?>(?<comment>{-)", incomment, ")+",
                                "(?>(?<-comment>-})", incomment, ")+",
                                ")*",
                                "(-+})"), tmp2));
        tmp0.addItem(
                // Line comments
                new LanguageRule("(--.*?)\\r?$", tmp2));
        tmp0.addItem(
                // Types
                new LanguageRule(
                        // Type highlighting using named balanced groups to balance parenthesized sub types
                        // 'toptype' and 'nestedtype' capture three groups: type keywords, namespaces, and type variables
                        StringExtensions.concat("(?:", "\\b(class|instance|deriving)\\b", "|::(?!", symbol, ")", "|\\b(type)\\s+", toptype, "*\\s*(=)", "|\\b(data|newtype)\\s+", toptype, "*\\s*(=)\\s*(", conid, ")", "|\\s+(\\|)\\s*(", conid, ")", ")", toptype, "*",
                                "(?:",
                                "(?:(?<type>[\\(\\[<])(?:", nestedtype, "|[,]", ")*)+",
                                "(?:(?<-type>[\\)\\]>])(?:", nestedtype, "|(?(type)[,])", ")*)+",
                                ")*"), tmp2
                        // class instance etc
                        // type
                        // data , newtype
                        // = conid
                        // | conid
                ));
        tmp0.addItem(
                // Special sequences
                new LanguageRule(StringExtensions.concat("\\b(module)\\s+(", qconid, ")(?:\\s*\\(", inexports, "\\))?"), tmp2));
        tmp0.addItem(new LanguageRule(
                StringExtensions.concat("\\b(module|as)\\s+(", qconid, ")"), tmp2


        ));
        tmp0.addItem(new LanguageRule(StringExtensions.concat("\\b(import)\\s+(qualified\\s+)?(", qconid, ")\\s*", "(?:\\(", inexports, "\\))?", "(?:(hiding)(?:\\s*\\(", inexports, "\\)))?"), tmp2));
        tmp0.addItem(
                // Keywords
                new LanguageRule(StringExtensions.concat("\\b(", keywords, ")\\b"), tmp2));
        tmp0.addItem(new LanguageRule(StringExtensions.concat("(?<!", symbol, ")(", opKeywords, ")(?!", symbol, ")"), tmp2));
        tmp0.addItem(
                // Names
                new LanguageRule(qvarid, tmp2));
        tmp0.addItem(new LanguageRule(qconid, tmp2));
        tmp0.addItem(// Operators and punctuation
                new LanguageRule(varop, tmp2));
        tmp0.addItem(new LanguageRule(conop, tmp2));
        tmp0.addItem(new LanguageRule("[{}\\(\\)\\[\\];,]", tmp2));
        tmp0.addItem(
                // Literals
                new LanguageRule("0[xX][\\da-fA-F]+|\\d+(\\.\\d+([eE][\\-+]?\\d+)?)?", tmp2));
        tmp0.addItem(new LanguageRule("'[^\\n]*?'", tmp2));
        tmp0.addItem(new LanguageRule("\"[^\\n]*?\"", tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"hs"*/0:
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
                    "hs"
            );

}
