// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.parsing;

//import com.example.colorcode.ExtensionMethods;
//import java.util.Iterator;
//import com.aspose.ms.System.IDisposable;
//import com.aspose.ms.lang.Operators;
//import com.aspose.ms.System.StringExtensions;
//import com.aspose.ms.System.Text.RegularExpressions.Match;
//import com.aspose.ms.System.Collections.Generic.List;
//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.Comparison;
//import com.aspose.ms.System.Int32Extensions;
//import com.aspose.ms.System.Collections.Generic.IGenericCollection;
//import com.aspose.ms.System.Text.RegularExpressions.Group;
//import com.aspose.ms.System.InvalidOperationException;


import com.aspose.note.system.collections.Generic.IGenericCollection;
import com.aspose.note.system.collections.Generic.IGenericList;
import com.aspose.note.system.collections.Generic.List;
import com.aspose.note.system.collections.IList;
import com.example.colorcode.ILanguage;
import com.example.colorcode.Scope;
import com.example.colorcode.common.ExtensionMethods;
import com.example.colorcode.common.ILanguageRepository;
import com.example.colorcode.common.ScopeName;
import com.example.colorcode.compilation.CompiledLanguage;
import com.example.colorcode.compilation.ILanguageCompiler;

import java.util.Iterator;

public class LanguageParser implements ILanguageParser
{
    private final ILanguageCompiler languageCompiler;
    private final ILanguageRepository languageRepository;

    public LanguageParser(ILanguageCompiler languageCompiler,
                          ILanguageRepository languageRepository)
    {
        this.languageCompiler = languageCompiler;
        this.languageRepository = languageRepository;
    }

    public final void parse(String sourceCode,
                      ILanguage language,
                      Action<String, IList<Scope>> parseHandler)
    {
        if (StringExtensions.isNullOrEmpty(sourceCode))
            return;

        CompiledLanguage compiledLanguage = languageCompiler.compile(language);

        parse(sourceCode, compiledLanguage, parseHandler);
    }

    private void parse(String sourceCode,
                       CompiledLanguage compiledLanguage,
                       Action<String, IList<Scope>> parseHandler)
    {
        Match regexMatch = compiledLanguage.getRegexInternal().match(sourceCode);

        if (!regexMatch.getSuccess())
            parseHandler(sourceCode, new List<Scope>());
        else
        {
            int currentIndex = 0;

            while (regexMatch.getSuccess())
            {
                String sourceCodeBeforeMatch = StringExtensions.substring(sourceCode, currentIndex, regexMatch.getIndex() - currentIndex);
                if (!StringExtensions.isNullOrEmpty(sourceCodeBeforeMatch))
                    parseHandler(sourceCodeBeforeMatch, new List<Scope>());

                String matchedSourceCode = StringExtensions.substring(sourceCode, regexMatch.getIndex(), regexMatch.getLength());
                if (!StringExtensions.isNullOrEmpty(matchedSourceCode))
                {
                    List<Scope> capturedStylesForMatchedFragment = getCapturedStyles(regexMatch, regexMatch.getIndex(), compiledLanguage);
                    List<Scope> capturedStyleTree = createCapturedStyleTree(capturedStylesForMatchedFragment);
                    parseHandler(matchedSourceCode, capturedStyleTree);
                }

                currentIndex = regexMatch.getIndex() + regexMatch.getLength();
                regexMatch = regexMatch.nextMatch();
            }

            String sourceCodeAfterAllMatches = StringExtensions.substring(sourceCode, currentIndex);
            if (!StringExtensions.isNullOrEmpty(sourceCodeAfterAllMatches))
                parseHandler(sourceCodeAfterAllMatches, new List<Scope>());
        }
    }

    private static List<Scope> createCapturedStyleTree(IGenericList<Scope> capturedStyles)
    {
        ExtensionMethods.sortStable(capturedStyles,  new Comparison<Scope>() {
        	public int invoke(Scope x,Scope y){return   Int32Extensions.compareTo(x.getIndex(), y.getIndex());}
        });

        List<Scope> capturedStyleTree = new List<Scope>(capturedStyles.size());
        Scope currentScope = null;

        //foreach to while statements conversion
        Iterator tmp0 = ( capturedStyles).iterator();
        try
        {
          while (tmp0.hasNext())
          {
            Scope capturedStyle = (Scope)tmp0.next();
            if (currentScope == null)
            {
                capturedStyleTree.addItem(capturedStyle);
                currentScope = capturedStyle;
                continue;
            }

            Scope[] referenceToCurrentScope = { currentScope };
            addScopeToNestedScopes(capturedStyle, /*ref*/ referenceToCurrentScope, capturedStyleTree);
            currentScope = referenceToCurrentScope[0];
          }
        }
        finally
        {
          if (Operators.is(tmp0, IDisposable.class))
            ((IDisposable)tmp0).dispose();
        }

        return capturedStyleTree;
    }

    private static void addScopeToNestedScopes(Scope scope,
                                               /*ref*/ Scope[] currentScope,
                                               IGenericCollection<Scope> capturedStyleTree)
    {
        if (scope.getIndex() >= currentScope[0].getIndex() && (scope.getIndex() + scope.getLength() <= currentScope[0].getIndex() + currentScope[0].getLength()))
        {
            currentScope[0].addChild(scope);
            currentScope[0] = scope;
        }
        else
        {
            currentScope[0] = currentScope[0].getParent();

            if (currentScope[0] != null)
                addScopeToNestedScopes(scope, /*ref*/ currentScope, capturedStyleTree);
            else
                capturedStyleTree.addItem(scope);
        }
    }


    private List<Scope> getCapturedStyles(Match regexMatch,
                                                  int currentIndex,
                                                  CompiledLanguage compiledLanguage)
    {
        List<Scope> capturedStyles = new List<Scope>();

        for (int i = 0; i < regexMatch.getGroups().getCount(); i++)
        {
            Group regexGroup = regexMatch.getGroups().get_Item(i);
            if (regexGroup.getLength() > 0 && i < compiledLanguage.getCaptures().size()) {  //note: i can be >= Captures.Count due to named groups; these do capture a group but always get added after all non-named groups (which is why we do not count them in numberOfCaptures)
                String styleName = compiledLanguage.getCaptures().get_Item(i);
                if (!StringExtensions.isNullOrEmpty(styleName)) {
                    //foreach to while statements conversion
                    Iterator tmp0 = ( regexGroup.getCaptures()).iterator();
                    try
                    {
                      while (tmp0.hasNext())
                      {
                        Capture regexCapture = (Capture)tmp0.next();
                        appendCapturedStylesForRegexCapture(regexCapture, currentIndex, styleName, capturedStyles);
                      }
                    }
                    finally
                    {
                      if (Operators.is(tmp0, IDisposable.class))
                        ((IDisposable)tmp0).dispose();
                    }
                }
            }
        }

        return capturedStyles;
    }

    private void appendCapturedStylesForRegexCapture(Capture regexCapture,
                                                     int currentIndex,
                                                     String styleName,
                                                     IGenericCollection<Scope> capturedStyles)
    {
        if (StringExtensions.startsWith(styleName, ScopeName.LanguagePrefix))
        {
            String nestedGrammarId = StringExtensions.substring(styleName, 1);
            appendCapturedStylesForNestedLanguage(regexCapture, regexCapture.getIndex() - currentIndex, nestedGrammarId, capturedStyles);
        }
        else
            capturedStyles.addItem(new Scope(styleName, regexCapture.getIndex() - currentIndex, regexCapture.getLength()));
    }

    private void appendCapturedStylesForNestedLanguage(Capture regexCapture,
                                                       int offset,
                                                       String nestedLanguageId,
                                                       IGenericCollection<Scope> capturedStyles)
    {
        ILanguage nestedLanguage = languageRepository.findById(nestedLanguageId);

        if (nestedLanguage == null)
            throw new InvalidOperationException("The nested language was not found in the language repository.");
        else
        {
            CompiledLanguage nestedCompiledLanguage = languageCompiler.compile(nestedLanguage);

            Match regexMatch = nestedCompiledLanguage.getRegexInternal().match(regexCapture.getValue(), 0, regexCapture.getValue().length());

            if (!regexMatch.getSuccess())
                return;
            else
            {
                while (regexMatch.getSuccess())
                {
                    List<Scope> capturedStylesForMatchedFragment = getCapturedStyles(regexMatch, 0, nestedCompiledLanguage);
                    List<Scope> capturedStyleTree = createCapturedStyleTree(capturedStylesForMatchedFragment);

                    //foreach to while statements conversion
                    Iterator tmp0 = ( capturedStyleTree).iterator();
                    try
                    {
                      while (tmp0.hasNext())
                      {
                        Scope nestedCapturedStyle = (Scope)tmp0.next();
                        increaseCapturedStyleIndicies(capturedStyleTree, offset);
                        capturedStyles.addItem(nestedCapturedStyle);
                      }
                    }
                    finally
                    {
                      if (Operators.is(tmp0, IDisposable.class))
                        ((IDisposable)tmp0).dispose();
                    }

                    regexMatch = regexMatch.nextMatch();
                }
            }
        }
    }

    private static void increaseCapturedStyleIndicies(IGenericList<Scope> capturedStyles,
                                                      int amountToIncrease)
    {
        for (int i = 0; i < capturedStyles.size(); i++)
        {
            Scope scope = capturedStyles.get_Item(i);

            scope.setIndex(scope.getIndex() + amountToIncrease);

            if (scope.getChildren().size() > 0)
                increaseCapturedStyleIndicies(scope.getChildren(), amountToIncrease);
        }
    }
}
