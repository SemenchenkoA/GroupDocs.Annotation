package com.example.colorcode;

import com.aspose.ms.lang.Operators;
import com.aspose.ms.System.Collections.Generic.Dictionary;
import com.aspose.ms.System.Collections.Generic.IGenericEnumerable;

import com.example.colorcode.common.LanguageId;
import com.example.colorcode.common.LanguageRepository;
import com.example.colorcode.compilation.CompiledLanguage;
import com.example.colorcode.compilation.languages.*;

/**
 * <p>
 * Provides easy access to ColorCode's built-in languages, as well as methods to load and find custom languages.
 * </p>
 */
public class Languages {
    static final com.example.colorcode.common.LanguageRepository LanguageRepository;
    static final Dictionary<String, ILanguage> LoadedLanguages;
    static Dictionary<String, CompiledLanguage> CompiledLanguages;
    static ReaderWriterLockSlim CompileLock;

    /**
     * <p>
     * Gets an enumerable list of all loaded languages.
     * </p>
     */
    public static IGenericEnumerable<ILanguage> getAll() {
        return LanguageRepository.getAll();
    }

    /**
     * <p>
     * Language support for ASP.NET HTTP Handlers (.ashx files).
     * </p>Value: Language support for ASP.NET HTTP Handlers (.ashx files).
     */
    public static ILanguage getAshx() {
        return LanguageRepository.findById(LanguageId.Ashx);
    }

    /**
     * <p>
     * Language support for ASP.NET application files (.asax files).
     * </p>Value: Language support for ASP.NET application files (.asax files).
     */
    public static ILanguage getAsax() {
        return LanguageRepository.findById(LanguageId.Asax);
    }

    /**
     * <p>
     * Language support for ASP.NET pages (.aspx files).
     * </p>Value: Language support for ASP.NET pages (.aspx files).
     */
    public static ILanguage getAspx() {
        return LanguageRepository.findById(LanguageId.Aspx);
    }

    /**
     * <p>
     * Language support for ASP.NET C# code-behind files (.aspx.cs files).
     * </p>Value: Language support for ASP.NET C# code-behind files (.aspx.cs files).
     */
    public static ILanguage getAspxCs() {
        return LanguageRepository.findById(LanguageId.AspxCs);
    }

    /**
     * <p>
     * Language support for ASP.NET Visual Basic.NET code-behind files (.aspx.vb files).
     * </p>Value: Language support for ASP.NET Visual Basic.NET code-behind files (.aspx.vb files).
     */
    public static ILanguage getAspxVb() {
        return LanguageRepository.findById(LanguageId.AspxVb);
    }

    /**
     * <p>
     * Language support for C#.
     * </p>Value: Language support for C#.
     */
    public static ILanguage getCSharp() {
        return LanguageRepository.findById(LanguageId.CSharp);
    }

    /**
     * <p>
     * Language support for HTML.
     * </p>Value: Language support for HTML.
     */
    public static ILanguage getHtml() {
        return LanguageRepository.findById(LanguageId.Html);
    }

    /**
     * <p>
     * Language support for Java.
     * </p>Value: Language support for Java.
     */
    public static ILanguage getJava() {
        return LanguageRepository.findById(LanguageId.Java);
    }

    /**
     * <p>
     * Language support for JavaScript.
     * </p>Value: Language support for JavaScript.
     */
    public static ILanguage getJavaScript() {
        return LanguageRepository.findById(LanguageId.JavaScript);
    }

    /**
     * <p>
     * Language support for PowerShell
     * </p>Value: Language support for PowerShell.
     */
    public static ILanguage getPowerShell() {
        return LanguageRepository.findById(LanguageId.PowerShell);
    }

    /**
     * <p>
     * Language support for SQL.
     * </p>Value: Language support for SQL.
     */
    public static ILanguage getSql() {
        return LanguageRepository.findById(LanguageId.Sql);
    }

    /**
     * <p>
     * Language support for Visual Basic.NET.
     * </p>Value: Language support for Visual Basic.NET.
     */
    public static ILanguage getVbDotNet() {
        return LanguageRepository.findById(LanguageId.VbDotNet);
    }

    /**
     * <p>
     * Language support for XML.
     * </p>Value: Language support for XML.
     */
    public static ILanguage getXml() {
        return LanguageRepository.findById(LanguageId.Xml);
    }

    /**
     * <p>
     * Language support for PHP.
     * </p>Value: Language support for PHP.
     */
    public static ILanguage getPhp() {
        return LanguageRepository.findById(LanguageId.Php);
    }

    /**
     * <p>
     * Language support for CSS.
     * </p>Value: Language support for CSS.
     */
    public static ILanguage getCss() {
        return LanguageRepository.findById(LanguageId.Css);
    }

    /**
     * <p>
     * Language support for C++.
     * </p>Value: Language support for C++.
     */
    public static ILanguage getCpp() {
        return LanguageRepository.findById(LanguageId.Cpp);
    }

    /**
     * <p>
     * Language support for Typescript.
     * </p>Value: Language support for typescript.
     */
    public static ILanguage getTypescript() {
        return LanguageRepository.findById(LanguageId.TypeScript);
    }

    /**
     * <p>
     * Language support for F#.
     * </p>Value: Language support for F#.
     */
    public static ILanguage getFSharp() {
        return LanguageRepository.findById(LanguageId.FSharp);
    }

    /**
     * <p>
     * Language support for Koka.
     * </p>Value: Language support for Koka.
     */
    public static ILanguage getKoka() {
        return LanguageRepository.findById(LanguageId.Koka);
    }

    /**
     * <p>
     * Language support for Haskell.
     * </p>Value: Language support for Haskell.
     */
    public static ILanguage getHaskell() {
        return LanguageRepository.findById(LanguageId.Haskell);
    }

    /**
     * <p>
     * Language support for Markdown.
     * </p>Value: Language support for Markdown.
     */
    public static ILanguage getMarkdown() {
        return LanguageRepository.findById(LanguageId.Markdown);
    }

    /**
     * <p>
     * Language support for Fortran.
     * </p>Value: Language support for Fortran.
     */
    public static ILanguage getFortran() {
        return LanguageRepository.findById(LanguageId.Fortran);
    }

    /**
     * <p>
     * Finds a loaded language by the specified identifier.
     * </p>
     *
     * @param id The identifier of the language to find.
     * @return An {@link ILanguage} instance if the specified identifier matches a loaded language; otherwise, null.
     */
    public static ILanguage findById(String id) {
        return LanguageRepository.findById(id);
    }

    private static <T extends ILanguage /* new() */> void load(Class<T> typeOfT) {
        load(Operators.createInstance(typeOfT));
    }

    /**
     * <p>
     * Loads the specified language.
     * </p>
     *
     * @param language The language to load.
     *                 <p><hr>
     *                 If a language with the same identifier has already been loaded, the existing loaded language will be replaced by the new specified language.
     *                 </hr></p>
     */
    public static void load(ILanguage language) {
        LanguageRepository.load(language);
    }

    static /*Languages()*/ {
        LoadedLanguages = new Dictionary<String, ILanguage>();
        CompiledLanguages = new Dictionary<String, CompiledLanguage>();
        LanguageRepository = new LanguageRepository(LoadedLanguages);
        CompileLock = new ReaderWriterLockSlim();

        load(JavaScript.class);
        load(Html.class);
        load(CSharp.class);
        load(VbDotNet.class);
        load(Ashx.class);
        load(Asax.class);
        load(Aspx.class);
        load(AspxCs.class);
        load(AspxVb.class);
        load(Sql.class);
        load(Xml.class);
        load(Php.class);
        load(Css.class);
        load(Cpp.class);
        load(Java.class);
        load(PowerShell.class);
        load(Typescript.class);
        load(FSharp.class);
        load(Koka.class);
        load(Haskell.class);
        load(Markdown.class);
        load(Fortran.class);
    }
}
