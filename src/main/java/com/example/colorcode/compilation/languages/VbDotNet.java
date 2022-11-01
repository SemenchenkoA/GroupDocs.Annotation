package com.example.colorcode.compilation.languages;

import com.aspose.ms.lang.StringSwitchMap;
import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.List;
import com.aspose.ms.System.StringExtensions;

import com.example.colorcode.ILanguage;
import com.example.colorcode.LanguageRule;
import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.ScopeName;

public class VbDotNet implements ILanguage {
    public final String getId() {
        return LanguageId.VbDotNet;
    }

    public final String getName() {
        return "VB.NET";
    }

    public final String getCssClassName() {
        return "vb-net";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp1 = new Dictionary<>();
        tmp1.addItem(1, ScopeName.Keyword);
        List<LanguageRule> tmp0 = new List<>();
        tmp0.addItem(new LanguageRule("('''[^\\n]*?)\\r?$", tmp1));
        tmp0.addItem(new LanguageRule("((?:'|REM\\s+).*?)\\r?$", tmp1));
        tmp0.addItem(new LanguageRule("\"(?:\"\"|[^\"\\n])*\"", tmp1));
        tmp0.addItem(new LanguageRule("(?:\\s|^)(\\#End\\sRegion|\\#Region|\\#Const|\\#End\\sExternalSource|\\#ExternalSource|\\#If|\\#Else|\\#End\\sIf)(?:\\s|\\(|\\r?$)", tmp1));
        tmp0.addItem(new LanguageRule("(?i)\\b(AddHandler|AddressOf|Aggregate|Alias|All|And|AndAlso|Ansi|Any|As|Ascending|(?<!<)Assembly|Auto|Average|Boolean|By|ByRef|Byte|ByVal|Call|Case|Catch|CBool|CByte|CChar|CDate|CDec|CDbl|Char|CInt|Class|CLng|CObj|Const|Continue|Count|CShort|CSng|CStr|CType|Date|Decimal|Declare|Default|DefaultStyleSheet|Delegate|Descending|Dim|DirectCast|Distinct|Do|Double|Each|Else|ElseIf|End|Enum|Equals|Erase|Error|Event|Exit|Explicit|False|Finally|For|Friend|From|Function|Get|GetType|GoSub|GoTo|Group|Group|Handles|If|Implements|Imports|In|Inherits|Integer|Interface|Into|Is|IsNot|Join|Let|Lib|Like|Long|LongCount|Loop|Max|Me|Min|Mod|Module|MustInherit|MustOverride|My|MyBase|MyClass|Namespace|New|Next|Not|Nothing|NotInheritable|NotOverridable|(?<!\\.)Object|Off|On|Option|Optional|Or|Order|OrElse|Overloads|Overridable|Overrides|ParamArray|Partial|Preserve|Private|Property|Protected|Public|RaiseEvent|ReadOnly|ReDim|RemoveHandler|Resume|Return|Select|Set|Shadows|Shared|Short|Single|Skip|Static|Step|Stop|String|Structure|Sub|Sum|SyncLock|Take|Then|Throw|To|True|Try|TypeOf|Unicode|Until|Variant|When|Where|While|With|WithEvents|WriteOnly|Xor|SByte|UInteger|ULong|UShort|Using|CSByte|CUInt|CULng|CUShort|Async|Await)\\b", tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"vb.net"*/0:
            case /*"vbnet"*/1:
            case /*"vb"*/2:
            case /*"visualbasic"*/3:
            case /*"visual basic"*/4:
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
                    "vb.net",
                    "vbnet",
                    "vb",
                    "visualbasic",
                    "visual basic"
            );

}
