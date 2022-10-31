// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.html;

//import com.aspose.ms.System.StringExtensions;


public class ExtensionMethods
{
    public static String toHtmlColor(/*this*/ String color)
    {
        if (color == null) return null;

        int length = 6;
        int start = color.length() - length;
        return StringExtensions.concat("#",  StringExtensions.substring(color, start, length));
    }
}
