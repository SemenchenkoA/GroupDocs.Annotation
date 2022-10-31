package com.example.colorcode;

//import com.aspose.ms.System.Collections.Generic.IGenericList;


import com.aspose.note.system.collections.Generic.IGenericList;
import com.example.colorcode.compilation.LanguageCompiler;
import com.example.colorcode.parsing.ILanguageParser;
import com.example.colorcode.parsing.LanguageParser;
import com.example.colorcode.parsing.Scope;
import com.example.colorcode.styling.StyleDictionary;

/**
 * <p>
 * Creates a {@link CodeColorizerBase}, for creating Syntax Highlighted code.
 * </p>
 * @param Styles The Custom styles to Apply to the formatted Code.
 * @param languageParser The language parser that the {@link CodeColorizerBase} instance will use for its lifetime.
 */
public abstract class CodeColorizerBase
{
    public CodeColorizerBase(StyleDictionary Styles, ILanguageParser languageParser)
    {
        ILanguageParser tmp0 = languageParser;
        if (tmp0 == null)
        {
            tmp0=(ILanguageParser)
             new LanguageParser(new LanguageCompiler(Languages.CompiledLanguages, Languages.CompileLock), Languages.LanguageRepository);
        }
        this.languageParser =tmp0;
        StyleDictionary tmp1 = Styles;
        if (tmp1 == null)
        {
            tmp1=  StyleDictionary.getDefaultLight();
        }

        this.Styles =tmp1;
    }

    /**
     * <p>
     * Writes the parsed source code to the ouput using the specified style sheet.
     * </p>
     * @param parsedSourceCode The parsed source code to format and write to the output.
     * @param scopes The captured scopes for the parsed source code.
     */
    protected abstract void write(String parsedSourceCode, IGenericList<Scope> scopes);

    /**
     * <p>
     * The language parser that the {@link CodeColorizerBase} instance will use for its lifetime.
     * </p>
     */
    protected final ILanguageParser languageParser;

    /**
     * <p>
     * The styles to Apply to the formatted Code.
     * </p>
     */
    public final StyleDictionary Styles;
}
