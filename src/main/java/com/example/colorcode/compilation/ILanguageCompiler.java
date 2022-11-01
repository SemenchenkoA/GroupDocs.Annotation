package com.example.colorcode.compilation;

import com.example.colorcode.ILanguage;

public interface ILanguageCompiler {
    CompiledLanguage compile(ILanguage language);
}
