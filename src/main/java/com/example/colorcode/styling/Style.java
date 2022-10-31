// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.styling;

//import com.aspose.ms.System.StringExtensions;


import com.example.colorcode.common.Guard;

/**
 * <p>
 * Defines the styling for a given scope.
 * </p>
 */
public class Style
{
    /**
     * <p>
     * Initializes a new instance of the {@link Style} class.
     * </p>
     * @param scopeName The name of the scope the style defines.
     */
    public Style(String scopeName)
    {
        Guard.argNotNullAndNotEmpty(scopeName, "scopeName");

        setScopeName(scopeName);
    }

    /**
     * <p>
     * Gets or sets the background color.
     * </p>Value: The background color.
     */
    public final String getBackground(){ return auto_Background; }
    /**
     * <p>
     * Gets or sets the background color.
     * </p>Value: The background color.
     */
    public final void setBackground(String value){ auto_Background = value; }
    private String auto_Background;

    /**
     * <p>
     * Gets or sets the foreground color.
     * </p>Value: The foreground color.
     */
    public final String getForeground(){ return auto_Foreground; }
    /**
     * <p>
     * Gets or sets the foreground color.
     * </p>Value: The foreground color.
     */
    public final void setForeground(String value){ auto_Foreground = value; }
    private String auto_Foreground;

    /**
     * <p>
     * Gets or sets the name of the scope the style defines.
     * </p>Value: The name of the scope the style defines.
     */
    public final String getScopeName(){ return auto_ScopeName; }
    /**
     * <p>
     * Gets or sets the name of the scope the style defines.
     * </p>Value: The name of the scope the style defines.
     */
    public final void setScopeName(String value){ auto_ScopeName = value; }
    private String auto_ScopeName;

    /**
     * <p>
     * Gets or sets the reference name of the scope, such as in CSS.
     * </p>Value: The plain text Reference name.
     */
    public final String getReferenceName(){ return auto_ReferenceName; }
    /**
     * <p>
     * Gets or sets the reference name of the scope, such as in CSS.
     * </p>Value: The plain text Reference name.
     */
    public final void setReferenceName(String value){ auto_ReferenceName = value; }
    private String auto_ReferenceName;

    /**
     * <p>
     * Gets or sets italic font style.
     * </p>Value: True if italic.
     */
    public final boolean getItalic(){ return auto_Italic; }
    /**
     * <p>
     * Gets or sets italic font style.
     * </p>Value: True if italic.
     */
    public final void setItalic(boolean value){ auto_Italic = value; }
    private boolean auto_Italic;

    /**
     * <p>
     * Gets or sets bold font style.
     * </p>Value: True if bold.
     */
    public final boolean getBold(){ return auto_Bold; }
    /**
     * <p>
     * Gets or sets bold font style.
     * </p>Value: True if bold.
     */
    public final void setBold(boolean value){ auto_Bold = value; }
    private boolean auto_Bold;

    /**
     * <p>
     * Returns a {@link String} that represents this instance.
     * </p>
     * @return 
     * A {@link String} that represents this instance.
     * <p><hr>
     * Returns the scope name if specified, or String.Empty otherwise.
     * </hr></p>
     */
    public /*override*/ String toString()
    {
        String tmp0 = getScopeName();
        if (tmp0 == null)
        {
            tmp0=  StringExtensions.Empty;
        }
        return tmp0;
    }
}
