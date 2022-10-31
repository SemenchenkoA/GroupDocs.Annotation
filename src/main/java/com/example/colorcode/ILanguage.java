// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode;

import com.aspose.note.system.collections.Generic.IGenericList;

/**
 * <p>
 * Defines how ColorCode will parse the source code of a given language.
 * </p>
 */
public interface ILanguage
{
    /**
     * <p>
     * Gets the identifier of the language (e.g., csharp).
     * </p>
     */
    public String getId();

    /**
     * <p>
     * Gets the first line pattern (regex) to use when determining if the language matches a source text.
     * </p>
     */
    public String getFirstLinePattern();

    /**
     * <p>
     * Gets the "friendly" name of the language (e.g., C#).
     * </p>
     */
    public String getName();

    /**
     * <p>
     * Gets the collection of language rules in the language.
     * </p>
     */
    public IGenericList<LanguageRule> getRules();

    /**
     * <p>
     * Get the CSS class name to use for a language
     * </p>
     */
    public String getCssClassName();

    /**
     * <p>
     * Returns true if the specified string is an alias for the language
     * </p>
     */
    public boolean hasAlias(String lang);
}
