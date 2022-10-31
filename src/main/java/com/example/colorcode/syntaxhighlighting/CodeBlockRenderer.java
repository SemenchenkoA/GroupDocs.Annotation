package com.example.colorcode.syntaxhighlighting;

//import com.aspose.ms.lang.Operators;
//import com.example.colorcode.HtmlClassFormatter;
//import com.aspose.ms.System.StringExtensions;
//import com.aspose.ms.System.Console;
//import com.example.colorcode.Languages;
//import com.aspose.ms.System.Text.msStringBuilder;


import com.example.colorcode.Languages;
import com.example.colorcode.html.HtmlClassFormatter;

class SyntaxHighlightingCodeBlockRenderer extends HtmlObjectRenderer<CodeBlock>
{
    private final CodeBlockRenderer _underlyingRenderer;
    private final HtmlClassFormatter formatter;

    public SyntaxHighlightingCodeBlockRenderer(CodeBlockRenderer underlyingRenderer)
    {
         tmp0 = underlyingRenderer;
        if (tmp0 == null)
        {
            tmp0=()  new CodeBlockRenderer();
        }
        _underlyingRenderer =tmp0;
        formatter = new HtmlClassFormatter();
    }

    protected /*override*/ void write(HtmlRenderer renderer, CodeBlock obj)
    {
        FencedCodeBlock fencedCodeBlock = Operators.as(obj, FencedCodeBlock.class);
        FencedCodeBlockParser parser = Operators.as(obj.Parser, FencedCodeBlockParser.class);
        if (fencedCodeBlock == null || parser == null)
        {
            _underlyingRenderer.Write(renderer, obj);
            return;
        }

         languageMoniker = fencedCodeBlock.Info.Replace(parser.InfoPrefix, StringExtensions.Empty);
        if (String.IsNullOrEmpty(languageMoniker))
        {
            _underlyingRenderer.Write(renderer, obj);
            return;
        }

        String firstLine = null;
        String[] referenceToFirstLine = { firstLine };
        String code = getCode(obj, /*out*/ referenceToFirstLine);
        firstLine = referenceToFirstLine[0];

        Console.writeLine(formatter.getCSSString());
        renderer.WriteLine(formatter.GetHtmlString(code, Languages.FindById(languageMoniker)));
    }

    private static String getCode(LeafBlock obj, /*out*/ String[] firstLine)
    {
        msStringBuilder code = new msStringBuilder();
        firstLine[0] = null;
        for (var line : obj.Lines.Lines)
        {
             slice = line.Slice;
            if (slice.Text == null)
            {
                continue;
            }

             lineText = slice.Text.Substring(slice.Start, slice.Length);

            if (firstLine[0] == null)
            {
                firstLine[0] = lineText;
            }
            else
            {
                code.appendLine();
            }

            code.Append(lineText);
        }
        return code.toString();
    }
}

