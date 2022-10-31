// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode;

import com.aspose.note.system.collections.Generic.IGenericDictionary;
import com.example.colorcode.common.Guard;

/**
 * <p>
 * Defines a single rule for a language. For instance a language rule might define string literals for a given language.
 * </p>
 */
public class LanguageRule
{
    /**
     * <p>
     * Initializes a new instance of the {@link LanguageRule} class.
     * </p>
     * @param regex The regular expression that defines what the language rule matches and captures.
     * @param captures The scope indices and names of the regular expression's captures.
     */
    public LanguageRule(String regex,
                        IGenericDictionary<Integer,String> captures)
    {
        Guard.argNotNullAndNotEmpty(regex, "regex");
        Guard.ensureParameterIsNotNullAndNotEmpty(captures, "captures");

        setRegex(regex);
        setCaptures(captures);
    }

    /**
     * <p>
     * Gets the regular expression that defines what the language rule matches and captures.
     * </p>Value: The regular expression that defines what the language rule matches and captures.
     */
    public final String getRegex(){ return auto_Regex; }
    /**
     * <p>
     * Gets the regular expression that defines what the language rule matches and captures.
     * </p>Value: The regular expression that defines what the language rule matches and captures.
     */
    private void setRegex(String value){ auto_Regex = value; }
    private String auto_Regex;
    /**
     * <p>
     * Gets the scope indices and names of the regular expression's captures.
     * </p>Value: The scope indices and names of the regular expression's captures.
     */
    public final IGenericDictionary<Integer,String> getCaptures(){ return auto_Captures; }
    /**
     * <p>
     * Gets the scope indices and names of the regular expression's captures.
     * </p>Value: The scope indices and names of the regular expression's captures.
     */
    private void setCaptures(IGenericDictionary<Integer,String> value){ auto_Captures = value; }
    private IGenericDictionary<Integer,String> auto_Captures;
}
