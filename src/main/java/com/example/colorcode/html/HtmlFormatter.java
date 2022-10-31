// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.html;

//import com.example.colorcode.ExtensionMethods;
//import com.aspose.ms.System.IDisposable;
//import java.util.Iterator;
//import com.aspose.ms.lang.Operators;
//import com.aspose.ms.System.IO.TextWriter;
//import com.aspose.ms.System.Text.msStringBuilder;
//import com.aspose.ms.System.IO.StringWriter;
//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.Collections.Generic.List;
//import com.aspose.ms.System.Comparison;
//import com.aspose.ms.System.Int32Extensions;
//import com.aspose.ms.System.StringExtensions;
//import com.aspose.ms.System.Collections.Generic.IGenericCollection;


import com.aspose.note.system.collections.Generic.IGenericCollection;
import com.aspose.note.system.collections.Generic.IGenericList;
import com.aspose.note.system.collections.Generic.List;
import com.example.colorcode.*;
import com.example.colorcode.ILanguageParser;
import com.example.colorcode.Scope;
import com.example.colorcode.Style;
import com.example.colorcode.StyleDictionary;
import com.example.colorcode.common.ScopeName;
import com.example.colorcode.common.TextInsertion;

import java.io.StringWriter;
import java.util.Iterator;

/**
 * <p>
 * Creates a {@link HtmlFormatter}, for creating HTML to display Syntax Highlighted code.
 * </p>
 */
public class HtmlFormatter extends CodeColorizerBase
{
    /**
     * <p>
     * Creates a {@link HtmlFormatter}, for creating HTML to display Syntax Highlighted code.
     * </p>
     * @param Style The Custom styles to Apply to the formatted Code.
     * @param languageParser The language parser that the {@link HtmlFormatter} instance will use for its lifetime.
     */
    public HtmlFormatter(StyleDictionary Style = null, ILanguageParser languageParser = null)
    {
    	super(Style, languageParser);
	
    }

    private TextWriter getWriter(){ return auto_Writer; }
    private void setWriter(TextWriter value){ auto_Writer = value; }
    private TextWriter auto_Writer;

    /**
     * <p>
     * Creates the HTML Markup, which can be saved to a .html file.
     * </p>
     * @return Colorised HTML Markup.
     * @param sourceCode The source code to colorize.
     * @param language The language to use to colorize the source code.
     */
    public final String getHtmlString(String sourceCode, ILanguage language)
    {
        msStringBuilder buffer = new msStringBuilder(sourceCode.length() * 2);

        final TextWriter writer = new StringWriter(buffer);
        try /*JAVA: was using*/
        {
            setWriter(writer);
            writeHeader(language);

            languageParser.Parse(sourceCode, language, (parsedSourceCode,captures) => Write(parsedSourceCode, captures));

            writeFooter(language);

            writer.flush();
        }
        finally { if (writer != null) ((IDisposable)writer).dispose(); }

        return buffer.toString();
    }

    protected /*override*/ void write(String parsedSourceCode, IGenericList<Scope> scopes)
    {
        List<TextInsertion> styleInsertions = new List<TextInsertion>();

        //foreach to while statements conversion
        Iterator tmp0 = ( scopes).iterator();
        try
        {
          while (tmp0.hasNext())
          {
            Scope scope = (Scope)tmp0.next();
            getStyleInsertionsForCapturedStyle(scope, styleInsertions);
          }
        }
        finally
        {
          if (Operators.is(tmp0, IDisposable.class))
            ((IDisposable)tmp0).dispose();
        }

        ExtensionMethods.sortStable(styleInsertions,  new Comparison<TextInsertion>() {
        	public int invoke(TextInsertion x,TextInsertion y){return   Int32Extensions.compareTo(x.getIndex(), y.getIndex());}
        });

        int offset = 0;

        //foreach to while statements conversion
        Iterator tmp1 = ( styleInsertions).iterator();
        try
        {
          while (tmp1.hasNext())
          {
            TextInsertion styleInsertion = (TextInsertion)tmp1.next();
            String text = StringExtensions.substring(parsedSourceCode, offset, styleInsertion.getIndex() - offset);
            getWriter().Write(WebUtility.HtmlEncode(text));
            if (StringExtensions.isNullOrEmpty(styleInsertion.getText()))
                buildSpanForCapturedStyle(styleInsertion.getScope());
            else
                getWriter().write(styleInsertion.getText());
            offset = styleInsertion.getIndex();
          }
        }
        finally
        {
          if (Operators.is(tmp1, IDisposable.class))
            ((IDisposable)tmp1).dispose();
        }

        getWriter().Write(WebUtility.HtmlEncode(StringExtensions.substring(parsedSourceCode, offset)));
    }

    private void writeFooter(ILanguage language)
    {
        getWriter().writeLine();
        writeHeaderPreEnd();
        writeHeaderDivEnd();
    }

    private void writeHeader(ILanguage language)
    {
        writeHeaderDivStart();
        writeHeaderPreStart();
        getWriter().writeLine();
    }

    private void getStyleInsertionsForCapturedStyle(Scope scope, IGenericCollection<TextInsertion> styleInsertions)
    {
        TextInsertion tmp0 = new TextInsertion();
        tmp0.setIndex(scope.getIndex());
        tmp0.setScope(scope);
        styleInsertions.addItem(tmp0);

        //foreach to while statements conversion
        Iterator tmp2 = ( scope.getChildren()).iterator();
        try
        {
          while (tmp2.hasNext())
          {
            Scope childScope = (Scope)tmp2.next();
            getStyleInsertionsForCapturedStyle(childScope, styleInsertions);
          }
        }
        finally
        {
          if (Operators.is(tmp2, IDisposable.class))
            ((IDisposable)tmp2).dispose();
        }
        TextInsertion tmp1 = new TextInsertion();
        tmp1.setIndex(scope.getIndex() + scope.getLength());
        tmp1.setText("</span>");

        styleInsertions.addItem(tmp1);
    }

    private void buildSpanForCapturedStyle(Scope scope)
    {
        String foreground = StringExtensions.Empty;
        String background = StringExtensions.Empty;
        boolean italic = false;
        boolean bold = false;

        if (Styles.containsItem(scope.getName()))
        {
            Style style = Styles.get_Item(scope.getName());

            foreground = style.getForeground();
            background = style.getBackground();
            italic = style.getItalic();
            bold = style.getBold();
        }

        writeElementStart("span", foreground, background, italic, bold);
    }

    private void writeHeaderDivEnd()
    {
        writeElementEnd("div");
    }

    private void writeElementEnd(String elementName)
    {
        getWriter().write("</{0}>", elementName);
    }

    private void writeHeaderPreEnd()
    {
        writeElementEnd("pre");
    }

    private void writeHeaderPreStart()
    {
        writeElementStart("pre");
    }

    private void writeHeaderDivStart()
    {
        String foreground = StringExtensions.Empty;
        String background = StringExtensions.Empty;

        if (Styles.containsItem(ScopeName.PlainText))
        {
            Style plainTextStyle = Styles.get_Item(ScopeName.PlainText);

            foreground = plainTextStyle.getForeground();
            background = plainTextStyle.getBackground();
        }

        writeElementStart("div", foreground, background);
    }

    private void writeElementStart(String elementName, String foreground, String background, boolean italic, boolean bold)
    {
        getWriter().write("<{0}", elementName);

        if (!String.IsNullOrWhiteSpace(foreground) || !String.IsNullOrWhiteSpace(background) || italic || bold)
        {
            getWriter().write(" style=\"");

            if (!String.IsNullOrWhiteSpace(foreground))
                getWriter().write("color:{0};", ExtensionMethods.toHtmlColor(foreground));

            if (!String.IsNullOrWhiteSpace(background))
                getWriter().write("background-color:{0};", ExtensionMethods.toHtmlColor(background));

            if (italic)
                getWriter().write("font-style: italic;");

            if (bold)
                getWriter().write("font-weight: bold;");

            getWriter().write("\"");
        }

        getWriter().write(">");
    }
}
