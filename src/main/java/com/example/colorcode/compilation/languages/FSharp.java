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

public class FSharp implements ILanguage
{
    public final String getId() { return LanguageId.FSharp; }

    public final String getName() { return "F#"; }

    public final String getCssClassName() { return "FSharp"; }

    public final String getFirstLinePattern()
    {
        return null;
    }

    public final IGenericList<LanguageRule> getRules()
    {
        Dictionary<Integer,String> tmp1 =
                           new Dictionary<Integer,String>();
        tmp1.addItem(2, ScopeName.Keyword);
         List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                           "\\(\\*([^*]|[\\r\\n]|(\\*+([^*)]|[\\r\\n])))*\\*+\\)",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(///)(?:\\s*?(<[/a-zA-Z0-9\\s\"=]+>))*([^\\r\\n]*)",tmp1
                             
                               
                                      
                                      
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(//.*?)\\r?$",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "'[^\\n]*?(?<!\\\\)'",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                              "(?s)@\"(?:\"\"|.)*?\"(?!\")",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                              "(?s)\"\"\"(?:\"\"|.)*?\"\"\"(?!\")",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?s)(\"[^\\n]*?(?<!\\\\)\")",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "^\\s*(\\#else|\\#endif|\\#if).*?$",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\b(let!|use!|do!|yield!|return!)\\s",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\b(abstract|and|as|assert|base|begin|class|default|delegate|do|done|downcast|downto|elif|else|end|exception|extern|false|finally|for|fun|function|global|if|in|inherit|inline|interface|internal|lazy|let|match|member|module|mutable|namespace|new|null|of|open|or|override|private|public|rec|return|sig|static|struct|then|to|true|try|type|upcast|use|val|void|when|while|with|yield|atomic|break|checked|component|const|constraint|constructor|continue|eager|fixed|fori|functor|include|measure|method|mixin|object|parallel|params|process|protected|pure|recursive|sealed|tailcall|trait|virtual|volatile|async|let!|use!|do!)\\b",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(\\w|\\s)(->)(\\w|\\s)",tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang)
    {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang)))
        {
            case /*"fs"*/0:
            case /*"f#"*/1:
            case /*"fsharp"*/2:
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
		"fs",
		"f#",
		"fsharp"
	);

}
