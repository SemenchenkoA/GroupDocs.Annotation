// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.common;

//import com.aspose.ms.System.ArgumentNullException;
//import com.aspose.ms.System.StringExtensions;
//import com.aspose.ms.System.ArgumentException;
//import com.aspose.ms.System.Collections.Generic.IGenericDictionary;
//import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.note.system.collections.Generic.IGenericDictionary;
import com.aspose.note.system.collections.Generic.IGenericList;
import com.aspose.note.system.exceptions.ArgumentException;
import com.aspose.note.system.exceptions.ArgumentNullException;



public class Guard
{
    public static void argNotNull(Object arg, String paramName)
    {
        if (arg == null)
            throw new ArgumentNullException(paramName);
    }

    public static void argNotNullAndNotEmpty(String arg, String paramName)
    {
        if (arg == null)
            throw new ArgumentNullException(paramName);

        if (StringExtensions.isNullOrEmpty(arg))
            throw new ArgumentException(StringExtensions.format("The {0} argument value must not be empty.", paramName), paramName);
    }

    public static <TKey, TValue>  void ensureParameterIsNotNullAndNotEmpty(IGenericDictionary<TKey, TValue> parameter, String parameterName)
    {
        if (parameter == null || parameter.size() == 0)
            throw new ArgumentNullException(parameterName);
    }

    public static <T>  void argNotNullAndNotEmpty(IGenericList<T> arg, String paramName)
    {
        if (arg == null)
            throw new ArgumentNullException(paramName);

        if (arg.size() == 0)
            throw new ArgumentException(StringExtensions.format("The {0} argument value must not be empty.", paramName), paramName);
    }
}

