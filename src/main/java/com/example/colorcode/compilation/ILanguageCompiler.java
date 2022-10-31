// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.compilation;


import com.example.colorcode.ILanguage;

public interface ILanguageCompiler
{
    public CompiledLanguage compile(ILanguage language);
}
