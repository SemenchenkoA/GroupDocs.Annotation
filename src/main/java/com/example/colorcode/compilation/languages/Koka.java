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

public class Koka implements ILanguage {
    public final String getId() {
        return LanguageId.Koka;
    }

    public final String getName() {
        return "Koka";
    }

    public final String getCssClassName() {
        return "koka";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    private static final String incomment = "([^*/]|/(?!\\*)|\\*(?!/))*";

    private static final String plainKeywords = "infix|infixr|infixl|type|cotype|rectype|struct|alias|interface|instance|external|fun|function|val|var|con|module|import|as|public|private|abstract|yield";
    private static final String controlKeywords = "if|then|else|elif|match|return";
    private static final String typeKeywords = "forall|exists|some|with";
    private static final String pseudoKeywords = "include|inline|cs|js|file";
    private static final String opkeywords = "[=\\.\\|]|\\->|\\:=";

    private static final String intype = StringExtensions.concat("\\b(", typeKeywords, ")\\b|(?:[a-z]\\w*/)*[a-z]\\w+\\b|(?:[a-z]\\w*/)*[A-Z]\\w*\\b|([a-z][0-9]*\\b|_\\w*\\b)|\\->|[\\s\\|]");
    private static final String toptype = StringExtensions.concat("(?:", intype, "|::)");
    private static final String nestedtype = StringExtensions.concat("(?:([a-z]\\w*)\\s*[:]|", intype, ")");

    private static final String symbol = "[$%&\\*\\+@!\\\\\\^~=\\.:\\-\\?\\|<>/]";
    private static final String symbols = StringExtensions.concat("(?:", symbol, ")+");

    private static final String escape = "\\\\(?:[nrt\\\\\"']|x[\\da-fA-F]{2}|u[\\da-fA-F]{4}|U[\\da-fA-F]{6})";

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp2 =
                new Dictionary<Integer, String>();
        tmp2.addItem(1, ScopeName.PreprocessorKeyword);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(
                // Nested block comments. note: does not match on unclosed comments
                new LanguageRule(
                        // Handle nested block comments using named balanced groups
                        StringExtensions.concat("/\\*", incomment,
                                "(",
                                "((?<comment>/\\*)", incomment, ")+",
                                "((?<-comment>\\*/)", incomment, ")+",
                                ")*",
                                "(\\*+/)"), tmp2
                ));
        tmp0.addItem(
                // Line comments
                new LanguageRule("(//.*?)\\r?$", tmp2));
        tmp0.addItem(
                // operator keywords
                new LanguageRule(StringExtensions.concat("(?<!", symbol, ")(", opkeywords, ")(?!", symbol, ")"), tmp2));
        tmp0.addItem(
                // Types
                new LanguageRule(
                        // Type highlighting using named balanced groups to balance parenthesized sub types
                        // 'toptype' captures two groups: type keyword and type variables
                        // each 'nestedtype' captures three groups: parameter names, type keywords and type variables
                        StringExtensions.concat("(?:", "\\b(type|struct|cotype|rectype)\\b|", "::?(?!", symbol, ")|", "\\b(alias)\\s+[a-z]\\w+\\s*(?:<[^>]*>\\s*)?(=)", ")", toptype, "*",
                                "(?:",
                                "(?:(?<type>[\\(\\[<])(?:", nestedtype, "|[,]", ")*)+",
                                "(?:(?<-type>[\\)\\]>])(?:", nestedtype, "|(?(type)[,])", ")*)+",
                                ")*",
                                ""), tmp2 //(?=(?:[,\)\{\}\]<>]|(" + keywords +")\b))",
                        // type struct etc
                        // alias
                        //  =
                ));
        tmp0.addItem(
                // module and imports
                new LanguageRule("\\b(module)\\s+(interface\\s+)?((?:[a-z]\\w*/)*[a-z]\\w*)", tmp2));
        tmp0.addItem(new LanguageRule("\\b(import)\\s+((?:[a-z]\\w*/)*[a-z]\\w*)\\s*(?:(=)\\s*(qualified\\s+)?((?:[a-z]\\w*/)*[a-z]\\w*))?", tmp2));
        tmp0.addItem(
                // keywords
                new LanguageRule(StringExtensions.concat("\\b(", plainKeywords, "|", typeKeywords, ")\\b"), tmp2));
        tmp0.addItem(new LanguageRule(StringExtensions.concat("\\b(", controlKeywords, ")\\b"), tmp2));
        tmp0.addItem(new LanguageRule(StringExtensions.concat("\\b(", pseudoKeywords, ")\\b"), tmp2));
        tmp0.addItem(
                // Names
                new LanguageRule(StringExtensions.concat("([a-z]\\w*/)*([a-z]\\w*|\\(", symbols, "\\))"), tmp2));
        tmp0.addItem(new LanguageRule("([a-z]\\w*/)*([A-Z]\\w*)", tmp2));
        tmp0.addItem(
                // Operators and punctuation
                new LanguageRule(symbols, tmp2));
        tmp0.addItem(new LanguageRule("[{}\\(\\)\\[\\];,]", tmp2));
        tmp0.addItem(
                // Literals
                new LanguageRule("0[xX][\\da-fA-F]+|\\d+(\\.\\d+([eE][\\-+]?\\d+)?)?", tmp2));
        tmp0.addItem(new LanguageRule(StringExtensions.concat("(?s)'(?:[^\\t\\n\\\\']+|(", escape, ")|\\\\)*'"), tmp2));
        tmp0.addItem(new LanguageRule("(?s)@\"(?:(\"\")|[^\"]+)*\"(?!\")", tmp2));
        tmp0.addItem(new LanguageRule(StringExtensions.concat("(?s)\"(?:[^\\t\\n\\\\\"]+|(", escape, ")|\\\\)*\""), tmp2));
        tmp0.addItem(new LanguageRule("^\\s*(\\#error|\\#line|\\#pragma|\\#warning|\\#!/usr/bin/env\\s+koka|\\#).*?$", tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"kk"*/0:
            case /*"kki"*/1:
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
                    "kk",
                    "kki"
            );

}

