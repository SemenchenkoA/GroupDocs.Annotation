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

public class PowerShell implements ILanguage
{
    public final String getId() { return LanguageId.PowerShell; }

    public final String getName() { return "PowerShell"; }

    public final String getCssClassName() { return "powershell"; }

    public final String getFirstLinePattern() { return null; }

    public final IGenericList<LanguageRule> getRules()
    {
        Dictionary<Integer,String> tmp2 =
                           new Dictionary<Integer,String>();
        tmp2.addItem(1, ScopeName.PowerShellOperator);
        tmp2.addItem(2, ScopeName.PowerShellType);
        tmp2.addItem(3, ScopeName.PowerShellOperator);
        tmp2.addItem(4, ScopeName.PowerShellOperator);
         List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                           "(?s)(<\\#.*?\\#>)",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "(\\#.*?)\\r?$",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "'[^\\n]*?(?<!\\\\)'",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?s)@\".*?\"@",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?s)(\"[^\\n]*?(?<!`)\")",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\$(?:[\\d\\w\\-]+(?::[\\d\\w\\-]+)?|\\$|\\?|\\^)",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\${[^}]+}",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "\\b(begin|break|catch|continue|data|do|dynamicparam|elseif|else|end|exit|filter|finally|foreach|for|from|function|if|in|param|process|return|switch|throw|trap|try|until|while)\\b",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "-(?:c|i)?(?:eq|ne|gt|ge|lt|le|notlike|like|notmatch|match|notcontains|contains|replace)",tmp2
                             
                               
                                    
                               
                           ));
        tmp0.addItem(new LanguageRule(
                           "-(?:band|and|as|join|not|bxor|xor|bor|or|isnot|is|split)",tmp2
                             
                               
                                    
                               
                           ));
        tmp0.addItem(new LanguageRule(
                           "(?:\\+=|-=|\\*=|/=|%=|=|\\+\\+|--|\\+|-|\\*|/|%)",tmp2
                             
                               
                                    
                               
                           ));
        tmp0.addItem(new LanguageRule(
                           "(?:\\>\\>|2\\>&1|\\>|2\\>\\>|2\\>)",tmp2
                             
                               
                                    
                               
                           ));
        tmp0.addItem(new LanguageRule(
                           "(?s)\\[(CmdletBinding)[^\\]]+\\]",tmp2
                             
                               
                                    
                               ));
        tmp0.addItem(new LanguageRule(
                           "(\\[)([^\\]]+)(\\])(::)?",tmp2));
        return tmp0;
    }

    public final boolean hasAlias(String lang)
    {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang)))
        {
            case /*"posh"*/0:
            case /*"ps1"*/1:
                return true;

            default:
                return false;
        }
    }

	//JAVA-added for string switch emulation
	private static final StringSwitchMap gStringSwitchMap = new StringSwitchMap
	(
		"posh",
		"ps1"
	);

}
