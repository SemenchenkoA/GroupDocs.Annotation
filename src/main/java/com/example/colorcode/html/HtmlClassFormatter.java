package com.example.colorcode.html;

import com.aspose.ms.System.*;
import com.aspose.ms.System.Collections.Generic.IGenericCollection;
import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.ms.System.Collections.Generic.List;
import com.aspose.ms.System.Collections.IList;
import com.aspose.ms.System.IO.StringWriter;
import com.aspose.ms.System.IO.TextWriter;
import com.aspose.ms.System.Text.msStringBuilder;

import com.aspose.ms.lang.Operators;
import com.example.colorcode.CodeColorizerBase;
import com.example.colorcode.ILanguage;
import com.example.colorcode.common.ExtensionMethods;
import com.example.colorcode.common.Guard;
import com.example.colorcode.common.ScopeName;
import com.example.colorcode.common.TextInsertion;
import com.example.colorcode.parsing.ILanguageParser;
import com.example.colorcode.parsing.Scope;
import com.example.colorcode.styling.Style;
import com.example.colorcode.styling.StyleDictionary;

import java.util.Iterator;

import static com.example.colorcode.html.ExtensionMethods.encodeHTML;


/**
 * <p>
 * Creates a {@link HtmlClassFormatter}, for creating HTML to display Syntax Highlighted code.
 * </p>
 */
public class HtmlClassFormatter extends CodeColorizerBase {
    /**
     * <p>
     * Creates a {@link HtmlClassFormatter}, for creating HTML to display Syntax Highlighted code, with Styles applied via CSS.
     * </p>
     *
     * @param Style          The Custom styles to Apply to the formatted Code.
     * @param languageParser The language parser that the {@link HtmlClassFormatter} instance will use for its lifetime.
     */
    public HtmlClassFormatter(StyleDictionary Style, ILanguageParser languageParser) {
        super(Style, languageParser);

    }


    private TextWriter getWriter() {
        return auto_Writer;
    }

    private void setWriter(TextWriter value) {
        auto_Writer = value;
    }

    private TextWriter auto_Writer;

    /**
     * <p>
     * Creates the HTML Markup, which can be saved to a .html file.
     * </p>
     *
     * @param sourceCode The source code to colorize.
     * @param language   The language to use to colorize the source code.
     * @return Colorised HTML Markup.
     */
    public final String getHtmlString(String sourceCode, ILanguage language) {
        msStringBuilder buffer = new msStringBuilder(sourceCode.length() * 2);

        final TextWriter writer = new StringWriter(buffer);
        try /*JAVA: was using*/ {
            setWriter(writer);
            writeHeader(language);

            //languageParser.parse(sourceCode, language, (parsedSourceCode, captures) =>write(parsedSourceCode, captures));
            Action<List> parseHandler = new Action<List>() {
                @Override
                public void invoke(List list) {
                    write(sourceCode, new List<>());
                }
            };

            languageParser.parse(sourceCode, language, parseHandler);

            writeFooter(language);

            writer.flush();
        } finally {
            if (writer != null) ((IDisposable) writer).dispose();
        }

        return buffer.toString();
    }

    /**
     * <p>
     * Creates the CSS Markup, which can be saved to a .CSS file. <p></p>
     * This is required for Coloring the Html output. Be sure to reference the File from the HTML, or insert it inline to the Head.
     * </p>
     *
     * @return
     */
    public final String getCSSString() {
        msStringBuilder str = new msStringBuilder();

        Style plainText = styles.get_Item(ScopeName.PlainText);

        if(!com.example.colorcode.html.ExtensionMethods.isNullOrWhiteSpace(plainText.getBackground())){
            str.append("body{{background-color:{plainText.Background};}}");
        }

        for (Style style : styles) {
            str.append(" .{style.ReferenceName}{{");

            if(!com.example.colorcode.html.ExtensionMethods.isNullOrWhiteSpace(style.getForeground()))
                str.append("color:{style.Foreground.ToHtmlColor()};");

            if(!com.example.colorcode.html.ExtensionMethods.isNullOrWhiteSpace(style.getBackground()))
                str.append("color:{style.Background.ToHtmlColor()};");

            if (style.getItalic())
                str.append("font-style: italic;");

            if (style.getBold())
                str.append("font-weight: bold;");

            str.append("}");
        }

        return str.toString();
    }

    protected void write(String parsedSourceCode, IGenericList<Scope> scopes) {
        List<TextInsertion> styleInsertions = new List<>();

        //foreach to while statements conversion
        Iterator tmp0 = (scopes).iterator();
        try {
            while (tmp0.hasNext()) {
                Scope scope = (Scope) tmp0.next();
                getStyleInsertionsForCapturedStyle(scope, styleInsertions);
            }
        } finally {
            if (Operators.is(tmp0, IDisposable.class))
                ((IDisposable) tmp0).dispose();
        }

        ExtensionMethods.sortStable(styleInsertions, new Comparison<TextInsertion>() {
            public int invoke(TextInsertion x, TextInsertion y) {
                return Int32Extensions.compareTo(x.getIndex(), y.getIndex());
            }
        });

        int offset = 0;

        //foreach to while statements conversion
        Iterator tmp1 = (styleInsertions).iterator();
        try {
            while (tmp1.hasNext()) {
                TextInsertion styleInsertion = (TextInsertion) tmp1.next();
                getWriter().write(encodeHTML(StringExtensions.substring(parsedSourceCode, offset, styleInsertion.getIndex() - offset)));
                if (StringExtensions.isNullOrEmpty(styleInsertion.getText()))
                    buildSpanForCapturedStyle(styleInsertion.getScope());
                else
                    getWriter().write(styleInsertion.getText());
                offset = styleInsertion.getIndex();
            }
        } finally {
            if (Operators.is(tmp1, IDisposable.class))
                ((IDisposable) tmp1).dispose();
        }

        getWriter().write(encodeHTML(StringExtensions.substring(parsedSourceCode, offset)));
    }

    private void writeFooter(ILanguage language) {
        Guard.argNotNull(language, "language");

        getWriter().writeLine();
        writeHeaderPreEnd();
        writeHeaderDivEnd();
    }

    private void writeHeader(ILanguage language) {
        Guard.argNotNull(language, "language");

        writeHeaderDivStart(language);
        writeHeaderPreStart();
        getWriter().writeLine();
    }

    private static void getStyleInsertionsForCapturedStyle(Scope scope, IGenericCollection<TextInsertion> styleInsertions) {
        TextInsertion tmp0 = new TextInsertion();
        tmp0.setIndex(scope.getIndex());
        tmp0.setScope(scope);
        styleInsertions.addItem(tmp0);

        //foreach to while statements conversion
        Iterator tmp2 = (scope.getChildren()).iterator();
        try {
            while (tmp2.hasNext()) {
                Scope childScope = (Scope) tmp2.next();
                getStyleInsertionsForCapturedStyle(childScope, styleInsertions);
            }
        } finally {
            if (Operators.is(tmp2, IDisposable.class))
                ((IDisposable) tmp2).dispose();
        }
        TextInsertion tmp1 = new TextInsertion();
        tmp1.setIndex(scope.getIndex() + scope.getLength());
        tmp1.setText("</span>");

        styleInsertions.addItem(tmp1);
    }

    private void buildSpanForCapturedStyle(Scope scope) {
        String cssClassName = "";

        if (styles.containsKey(scope.getName())) {
            Style style = styles.get_Item(scope.getName());

            cssClassName = style.getReferenceName();
        }

        writeElementStart("span", cssClassName);
    }

    private void writeHeaderDivEnd() {
        writeElementEnd("div");
    }

    private void writeElementEnd(String elementName) {
        getWriter().write("</{0}>", elementName);
    }

    private void writeHeaderPreEnd() {
        writeElementEnd("pre");
    }

    private void writeHeaderPreStart() {
        writeElementStart("pre");
    }

    private void writeHeaderDivStart(ILanguage language) {
        writeElementStart("div", language.getCssClassName());
    }

    private void writeElementStart(String elementName) {
        writeElementStart(elementName, "");
    }

    private void writeElementStart(String elementName, String cssClassName) {
        getWriter().write("<{0}", elementName);
        if (!StringExtensions.isNullOrEmpty(cssClassName)) {
            getWriter().write(" class=\"{0}\"", cssClassName);
        }
        getWriter().write(">");
    }
}
