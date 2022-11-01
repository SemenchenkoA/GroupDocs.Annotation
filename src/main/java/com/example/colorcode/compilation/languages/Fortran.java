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

public class Fortran implements ILanguage {
    public final String getId() {
        return LanguageId.Fortran;
    }

    public final String getName() {
        return "Fortran";
    }

    public final String getCssClassName() {
        return "fortran";
    }

    public final String getFirstLinePattern() {
        return null;
    }

    public final IGenericList<LanguageRule> getRules() {
        Dictionary<Integer, String> tmp1 =new Dictionary<>();
        tmp1.addItem(0, ScopeName.Keyword);
        List<LanguageRule> tmp0 = new List<LanguageRule>();
        tmp0.addItem(
                // Comments
                new LanguageRule("!.*", tmp1));
        tmp0.addItem(
                // String type 1
                new LanguageRule("\".*?\"|'.*?'", tmp1));
        tmp0.addItem(
                // Program keywords
                new LanguageRule("(?i)\\b(?:program|endprogram)\\b", tmp1));
        tmp0.addItem(
                // Module keywords
                new LanguageRule("(?i)\\b(?:module|endmodule|contains)\\b", tmp1));
        tmp0.addItem(
                // Type keywords
                new LanguageRule("(?i)\\b(?:type|endtype|abstract)\\b", tmp1));
        tmp0.addItem(
                // Interface definition keywords
                new LanguageRule("(?i)\\b(?:interface|endinterface|operator|assignment)\\b", tmp1));
        tmp0.addItem(
                // Procedure definition keywords
                new LanguageRule("(?i)\\b(?:function|endfunction|subroutine|endsubroutine|elemental|recursive|pure)\\b", tmp1));
        tmp0.addItem(
                // Variable keywords
                new LanguageRule("(?i)INTEGER|REAL|DOUBLE\\s*PRECISION|COMPLEX|CHARACTER|LOGICAL|TYPE", tmp1));
        tmp0.addItem(
                // Attribute keywords
                new LanguageRule("(?i)\\b(?:parameter|allocatable|optional|pointer|save|dimension|target)\\b", tmp1));
        tmp0.addItem(
                // Intent keywords
                new LanguageRule("(?i)\\b(intent)\\s*(\\()\\s*(in|out|inout)\\s*(\\))", tmp1));
        tmp0.addItem(
                // Namelist
                new LanguageRule("(?i)\\b(namelist)(/)\\w+(/)", tmp1));
        tmp0.addItem(
                // Intrinsic functions
                new LanguageRule(
                        StringExtensions.concat("(?i)\\b(PRESENT",
                                "|INT|REAL|DBLE|CMPLX|AIMAG|CONJG|AINT|ANINT|NINT|ABS|MOD|SIGN|DIM|DPROD|MODULO|FLOOR|CEILING|MAX|MIN",
                                "|SQRT|EXP|LOG|LOG10|SIN|COS|TAN|ASIN|ACOS|ATAN|ATAN2|SINH|COSH|TANH",
                                "|ICHAR|CHAR|LGE|LGT|LLE|LLT|IACHAR|ACHAR|INDEX|VERIFY|ADJUSTL|ADJUSTR|SCAN|LEN_TRIM|REPEAT|TRIM",
                                "|KIND|SELECTED_INT_KIND|SELECTED_REAL_KIND",
                                "|LOGICAL",
                                "|IOR|IAND|NOT|IEOR| ISHFT|ISHFTC|BTEST|IBSET|IBCLR|BITSIZE",
                                "|TRANSFER",
                                "|RADIX|DIGITS|MINEXPONENT|MAXEXPONENT|PRECISION|RANGE|HUGE|TINY|EPSILON",
                                "|EXPONENT|SCALE|NEAREST|FRACTION|SET_EXPONENT|SPACING|RRSPACING",
                                "|LBOUND|SIZE|UBOUND",
                                "|MASK",
                                "|MATMUL|DOT_PRODUCT",
                                "|SUM|PRODUCT|MAXVAL|MINVAL|COUNT|ANY|ALL",
                                "|ALLOCATED|SIZE|SHAPE|LBOUND|UBOUND",
                                "|MERGE|SPREAD|PACK|UNPACK",
                                "|RESHAPE",
                                "|TRANSPOSE|EOSHIFT|CSHIFT",
                                "|MAXLOC|MINLOC",
                                "|ASSOCIATED)\\b(\\()")
                        , tmp1
                ));
        tmp0.addItem(
                // Intrinsic functions
                new LanguageRule(StringExtensions.concat("(?i)(call)\\s+(",
                                "DATE_AND_TIME|SYSTEM_CLOCK",
                                "|RANDOM_NUMBER|RANDOM_SEED",
                                "|MVBITS",
                                ")\b"), tmp1));
        tmp0.addItem(
                // Special Character
                new LanguageRule("\\=|\\*|\\+|\\\\|\\-|\\.\\w+\\.|>|<|::|%|,|;|\\?|\\$", tmp1));
        tmp0.addItem(
                // Line Continuation
                new LanguageRule("&", tmp1));
        tmp0.addItem(
                // Number
                new LanguageRule("\\b[0-9.]+(_\\w+)?\\b", tmp1));
        tmp0.addItem(
                // Brackets
                new LanguageRule("[\\(\\)\\[\\]]", tmp1));
        tmp0.addItem(
                // Preprocessor keywords
                new LanguageRule("(?i)(?:#define|#elif|#elifdef|#elifndef|#else|#endif|#error|#if|#ifdef|#ifndef|#include|#line|#pragma|#undef)\\b", tmp1));
        tmp0.addItem(
                // General keywords
                new LanguageRule(StringExtensions.concat("(?i)\\b(?:end|use|do|enddo|select|endselect|case|endcase|if|then|else|endif|implicit|none", "|do\\s+while|call|public|private|protected|where|go\\s*to|file|block|data|blockdata", "|end\\s*blockdata|default|procedure|include|go\\s*to|allocate|deallocate|open|close|write|stop|return)\\b"), tmp1));
        return tmp0;
    }

    public final boolean hasAlias(String lang) {
        switch (gStringSwitchMap.of(StringExtensions.toLower(lang))) {
            case /*"fortran"*/0:
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
                    "fortran"
            );

}
