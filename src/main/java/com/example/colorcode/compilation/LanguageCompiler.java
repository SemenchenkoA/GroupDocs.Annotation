package com.example.colorcode.compilation;

import com.aspose.ms.System.ArgumentException;
import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.IGenericCollection;
import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.ms.System.Collections.Generic.List;
import com.aspose.ms.System.IDisposable;
import com.aspose.ms.System.StringExtensions;
import com.aspose.ms.System.Text.RegularExpressions.Regex;
import com.aspose.ms.System.Text.RegularExpressions.RegexOptions;
import com.aspose.ms.System.Text.msStringBuilder;
import com.aspose.ms.lang.Operators;
import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.common.Guard;

import java.util.Iterator;


public class LanguageCompiler implements ILanguageCompiler {
    private static final Regex numberOfCapturesRegex = new Regex("(?x)(?<!(\\\\|(?!\\\\)\\(\\?))\\((?!\\?)", RegexOptions.Compiled);
    private final Dictionary<String, CompiledLanguage> compiledLanguages;
    private final ReaderWriterLockSlim compileLock;

    public LanguageCompiler(Dictionary<String, CompiledLanguage> compiledLanguages, ReaderWriterLockSlim compileLock) {
        this.compiledLanguages = compiledLanguages;
        this.compileLock = compileLock;
    }

    public final CompiledLanguage compile(ILanguage language) {
        Guard.argNotNull(language, "language");

        if (StringExtensions.isNullOrEmpty(language.getId()))
            throw new ArgumentException("The language identifier must not be null.", "language");

        CompiledLanguage compiledLanguage;

        compileLock.EnterReadLock();
        try {
            // for performance reasons we should first try with
            // only a read lock since the majority of the time
            // it'll be created already and upgradeable lock blocks
            if (compiledLanguages.containsKey(language.getId()))
                return compiledLanguages.get_Item(language.getId());
        } finally {
            compileLock.ExitReadLock();
        }

        compileLock.EnterUpgradeableReadLock();
        try {
            if (compiledLanguages.containsKey(language.getId()))
                compiledLanguage = compiledLanguages.get_Item(language.getId());
            else {
                compileLock.EnterWriteLock();

                try {
                    if (StringExtensions.isNullOrEmpty(language.getName()))
                        throw new ArgumentException("The language name must not be null or empty.", "language");

                    if (language.getRules() == null || language.getRules().size() == 0)
                        throw new ArgumentException("The language rules collection must not be empty.", "language");

                    compiledLanguage = compileLanguage(language);

                    compiledLanguages.addItem(compiledLanguage.getId(), compiledLanguage);
                } finally {
                    compileLock.ExitWriteLock();
                }
            }
        } finally {
            compileLock.ExitUpgradeableReadLock();
        }

        return compiledLanguage;
    }

    private static CompiledLanguage compileLanguage(ILanguage language) {
        String id = language.getId();
        String name = language.getName();

        //Regex[] referenceToRegex = { regex };
        Regex regex = null;
        IGenericList<String> captures = null;
        compileRules(language.getRules(), regex, captures);
        //Regex = referenceToRegex[0];   IGenericList<String> captures

        return new CompiledLanguage(id, name, regex, captures);
    }

    private static void compileRules(IGenericList<LanguageRule> rules, /*out*/ Regex regex, /*out*/ IGenericList<String> captures) {
        msStringBuilder regexBuilder = new msStringBuilder();
        captures = new List<String>();

        regexBuilder.appendLine("(?x)");
        captures.addItem(null);

        compileRule(rules.get_Item(0), regexBuilder, captures, true);

        for (int i = 1; i < rules.size(); i++)
            compileRule(rules.get_Item(i), regexBuilder, captures, false);

        regex = new Regex(regexBuilder.toString());
    }

    private static void compileRule(LanguageRule languageRule, msStringBuilder regex, IGenericCollection<String> captures, boolean isFirstRule) {
        if (!isFirstRule) {
            regex.appendLine();
            regex.appendLine();
            regex.appendLine("|");
            regex.appendLine();
        }

        regex.appendFormat("(?-xis)(?m)({0})(?x)", languageRule.getRegex());

        int numberOfCaptures = getNumberOfCaptures(languageRule.getRegex());

        for (int i = 0; i <= numberOfCaptures; i++) {
            String scope = null;

            //foreach to while statements conversion
            Iterator tmp0 = (languageRule.getCaptures().getKeys()).iterator();
            try {
                while (tmp0.hasNext()) {
                    int captureIndex = Operators.unboxing(tmp0.next(), int.class);
                    if (i == captureIndex) {
                        scope = languageRule.getCaptures().get_Item(captureIndex);
                        break;
                    }
                }
            } finally {
                if (Operators.is(tmp0, IDisposable.class))
                    ((IDisposable) tmp0).dispose();
            }

            captures.addItem(scope);
        }
    }

    private static int getNumberOfCaptures(String regex) {
        return numberOfCapturesRegex.matches(regex).getCount();
    }
}
