package com.example.colorcode;

import com.aspose.ms.System.Collections.Generic.IGenericList;

/**
 * <p>
 * Defines how ColorCode will parse the source code of a given language.
 * </p>
 */
public interface ILanguage {
    /**
     * <p>
     * Gets the identifier of the language (e.g., csharp).
     * </p>
     */
    String getId();

    /**
     * <p>
     * Gets the first line pattern (regex) to use when determining if the language matches a source text.
     * </p>
     */
    String getFirstLinePattern();

    /**
     * <p>
     * Gets the "friendly" name of the language (e.g., C#).
     * </p>
     */
    String getName();

    /**
     * <p>
     * Gets the collection of language rules in the language.
     * </p>
     */
    IGenericList<LanguageRule> getRules();

    /**
     * <p>
     * Get the CSS class name to use for a language
     * </p>
     */
    String getCssClassName();

    /**
     * <p>
     * Returns true if the specified string is an alias for the language
     * </p>
     */
    boolean hasAlias(String lang);
}
