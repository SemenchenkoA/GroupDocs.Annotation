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
import com.example.colorcode.compilation.RuleCaptures;
import com.example.colorcode.RuleFormats;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;
import com.example.colorcode.compilation.RuleCaptures;


public class AspxVb implements ILanguage
{
    public final String getId() { return LanguageId.AspxVb; }

    public final String getName() { return "ASPX (VB.NET)"; }

    public final String getCssClassName() { return "aspx-vb"; }

    public final String getFirstLinePattern()
    {
        return "(?xims)<%@\\s*?(?:page|control|master|webhandler|servicehost|webservice).*?language=\"vb\".*?%>";
    }

    public final IGenericList<LanguageRule> getRules()
    {
        Dictionary<Integer,String> tmp1 =
                           new Dictionary<Integer,String>();
        tmp1.addItem(0, ScopeName.HtmlEntity);
         List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(new LanguageRule(
                           "(?s)(<%)(--.*?--)(%>)",tmp1
                             
                               
                                      
                                      
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?s)<!--.*-->",tmp1
                             
                               
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?i)(<%)(@)(?:\\s+([a-z0-9]+))*(?:\\s+([a-z0-9]+)\\s*(=)\\s*(\"[^\\n]*?\"))*\\s*?(%>)",tmp1
                             
                               
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?s)(?:(<%=|<%)(?!=|@|--))(.*?)(%>)",tmp1
                             
                               
                                      
                                        
                                      
                               ));
        tmp0.addItem(new LanguageRule(RuleFormats.ServerScript, RuleCaptures.VbDotNetScript));
        tmp0.addItem(new LanguageRule(
                           "(?i)(<!)(DOCTYPE)(?:\\s+([a-zA-Z0-9]+))*(?:\\s+(\"[^\"]*?\"))*(>)",tmp1
                             
                               
                                      
                                      
                                      
                                      
                                      
                               ));
        tmp0.addItem(new LanguageRule(RuleFormats.JavaScript, RuleCaptures.JavaScript));
        tmp0.addItem(new LanguageRule(
                           "(?xis)(</?)\r\n                                          (?: ([a-z][a-z0-9-]*)(:) )*\r\n                                          ([a-z][a-z0-9-_]*)\r\n                                          (?:\r\n                                             [\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*(?:'(<%\\#)(.+?)(%>)')\r\n                                            |[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*(?:\"(<%\\#)(.+?)(%>)\")\r\n                                            |[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*([^\\s\\n\"']+?)\r\n                                            |[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*(\"[^\\n]+?\")\r\n                                            |[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*('[^\\n]+?')\r\n                                            |[\\s\\n]+([a-z0-9-_]+) )*\r\n                                          [\\s\\n]*\r\n                                          (/?>)",tmp1
                             
                               
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                        
                                      
                                      
                                      
                                      
                                        
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                               ));
        tmp0.addItem(new LanguageRule(
                           "(?i)&\\#?[a-z0-9]+?;",tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang)
    {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang)))
        {
            case 0:
            case 1:
            case 2:
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
		"aspx-vb",
		"aspx (vb.net)",
		"aspx(vb.net)"
	);



}
