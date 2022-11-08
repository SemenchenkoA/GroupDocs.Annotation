package com.sa.runner;

import com.aspose.ms.System.Action;
import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.List;
import com.example.colorcode.ILanguage;
import com.example.colorcode.common.LanguageRepository;
import com.example.colorcode.compilation.CompiledLanguage;
import com.example.colorcode.compilation.LanguageCompiler;
import com.example.colorcode.html.HtmlFormatter;
import com.example.colorcode.parsing.ILanguageParser;
import com.example.colorcode.parsing.LanguageParser;
import com.example.colorcode.styling.StyleDictionary;

/**
 * This is Runner class
 */
public class Runner {
    public static void main(String[] args) {

        System.out.println("Main run!");

//        Dictionary<String, CompiledLanguage> compiledLanguages = new Dictionary<>();
//        compiledLanguages.addItem("java", new CompiledLanguage("java", "java", Regex.fromJava(Pattern.compile("")), ));
//        Object mutex = new Object();
//
//        new HtmlFormatter(StyleDictionary.getDefaultDark(), new LanguageParser(new LanguageCompiler(compiledLanguages, mutex), new LanguageRepository(compiledLanguages)));

        new HtmlFormatter(StyleDictionary.getDefaultDark(), new ILanguageParser() {
            @Override
            public void parse(String sourceCode, ILanguage language, Action<List> parseHandler) {

            }
        });
    }
}
