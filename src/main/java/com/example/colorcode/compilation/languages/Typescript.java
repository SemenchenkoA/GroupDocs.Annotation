// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.compilation.languages;

//import com.aspose.ms.lang.StringSwitchMap;
//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.Collections.Generic.Dictionary;
//import com.aspose.ms.System.Collections.Generic.List;
//import com.aspose.ms.System.StringExtensions;


import com.aspose.note.system.collections.Generic.Dictionary;
import com.aspose.note.system.collections.Generic.IGenericList;
import com.aspose.note.system.collections.Generic.List;
import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;

public class Typescript implements ILanguage
{
    public final String getId() { return LanguageId.TypeScript; }

    public final String getName() { return "Typescript"; }

    public final String getCssClassName() { return "typescript"; }

    public final String getFirstLinePattern()
    {
        return null;
    }

    public final IGenericList<LanguageRule> getRules()
    {
        Dictionary<Integer,String> tmp1 =
                           new Dictionary<Integer,String>();
        tmp1.addItem(1, ScopeName.Keyword);
         List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                           "/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(//.*?)\\r?$",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "'[^\\n]*?'",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "\"[^\\n]*?\"",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\b(abstract|any|bool|boolean|break|byte|case|catch|char|class|const|constructor|continue|debugger|declare|default|delete|do|double|else|enum|export|extends|false|final|finally|float|for|function|goto|if|implements|import|in|instanceof|int|interface|long|module|native|new|number|null|package|private|protected|public|return|short|static|string|super|switch|synchronized|this|throw|throws|transient|true|try|typeof|var|void|volatile|while|with)\\b",tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang)
    {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang)))
        {
            case /*"ts"*/0:
                return true;

            default:
                return false;
        }
    }

    public /*override*/ String toString()
    {
        return getName();
    }

	//JAVA-added for string switch emulation
	private static final StringSwitchMap gStringSwitchMap = new StringSwitchMap
	(
		"ts"
	);

}
