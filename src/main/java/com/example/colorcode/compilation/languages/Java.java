// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.compilation.languages;

//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.Collections.Generic.Dictionary;
//import com.aspose.ms.System.Collections.Generic.List;


import com.aspose.note.system.collections.Generic.Dictionary;
import com.aspose.note.system.collections.Generic.IGenericList;
import com.aspose.note.system.collections.Generic.List;
import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;

public class Java implements ILanguage
{
    public final String getId() { return LanguageId.Java; }

    public final String getName() { return "Java"; }

    public final String getCssClassName() { return "java"; }

    public final String getFirstLinePattern()
    {
        return null;
    }

    public final IGenericList<LanguageRule> getRules()
    {
        Dictionary<Integer,String> tmp2 =
                           new Dictionary<Integer,String>();
        tmp2.addItem(0, ScopeName.Number);
         List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                           "/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/",tmp2
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(//.*?)\\r?$",tmp2
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "'[^\\n]*?(?<!\\\\)'",tmp2
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?s)(\"[^\\n]*?(?<!\\\\)\")",tmp2
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\b(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|false|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|null|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|true|try|void|volatile|while)\\b",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\b[0-9]{1,}\\b",tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang)
    {
        return false;
    }

    public /*override*/ String toString()
    {
        return getName();
    }
}
