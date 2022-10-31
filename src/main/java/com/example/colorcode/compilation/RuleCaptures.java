// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.compilation;

//import com.aspose.ms.System.Collections.Generic.IGenericDictionary;
//import com.aspose.ms.System.Collections.Generic.Dictionary;
//import com.aspose.ms.System.StringExtensions;


import com.aspose.note.system.collections.Generic.Dictionary;
import com.aspose.note.system.collections.Generic.IGenericDictionary;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;

public class RuleCaptures
{
    public static IGenericDictionary<Integer,String> JavaScript;
    public static IGenericDictionary<Integer,String> CSharpScript;
    public static IGenericDictionary<Integer,String> VbDotNetScript;

    private static IGenericDictionary<Integer,String> buildCaptures(String languageId)
    {
        Dictionary<Integer,String> tmp0 = new Dictionary<Integer,String>();
        tmp0.addItem(1, ScopeName.HtmlTagDelimiter);
        tmp0.addItem(2, ScopeName.HtmlElementName);
        tmp0.addItem(3, ScopeName.HtmlAttributeName);
        tmp0.addItem(4, ScopeName.HtmlOperator);
        tmp0.addItem(5, ScopeName.HtmlAttributeValue);
        tmp0.addItem(6, ScopeName.HtmlAttributeName);
        tmp0.addItem(7, ScopeName.HtmlOperator);
        tmp0.addItem(8, ScopeName.HtmlAttributeValue);
        tmp0.addItem(9, ScopeName.HtmlAttributeName);
        tmp0.addItem(10, ScopeName.HtmlOperator);
        tmp0.addItem(11, ScopeName.HtmlAttributeValue);
        tmp0.addItem(12, ScopeName.HtmlAttributeName);
        tmp0.addItem(13, ScopeName.HtmlAttributeName);
        tmp0.addItem(14, ScopeName.HtmlOperator);
        tmp0.addItem(15, ScopeName.HtmlAttributeValue);
        tmp0.addItem(16, ScopeName.HtmlAttributeName);
        tmp0.addItem(17, ScopeName.HtmlOperator);
        tmp0.addItem(18, ScopeName.HtmlAttributeValue);
        tmp0.addItem(19, ScopeName.HtmlAttributeName);
        tmp0.addItem(20, ScopeName.HtmlOperator);
        tmp0.addItem(21, ScopeName.HtmlAttributeValue);
        tmp0.addItem(22, ScopeName.HtmlAttributeName);
        tmp0.addItem(23, ScopeName.HtmlOperator);
        tmp0.addItem(24, ScopeName.HtmlAttributeValue);
        tmp0.addItem(25, ScopeName.HtmlAttributeName);
        tmp0.addItem(26, ScopeName.HtmlTagDelimiter);
        tmp0.addItem(27, StringExtensions.format("{0}{1}",ScopeName.LanguagePrefix,languageId));
        tmp0.addItem(28, ScopeName.HtmlTagDelimiter);
        tmp0.addItem(29, ScopeName.HtmlElementName);
        tmp0.addItem(30, ScopeName.HtmlTagDelimiter);
        return tmp0;
    }

    static /*RuleCaptures()*/
    {
        JavaScript = buildCaptures(LanguageId.JavaScript);
        CSharpScript = buildCaptures(LanguageId.CSharp);
        VbDotNetScript = buildCaptures(LanguageId.VbDotNet);
    }
}
