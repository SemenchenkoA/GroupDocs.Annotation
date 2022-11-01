package com.example.colorcode.syntaxhighlighting;

import com.aspose.ms.lang.Operators;
import com.aspose.ms.System.ArgumentNullException;

public class SyntaxHighlightingExtension extends IMarkdownExtension {
    public SyntaxHighlightingExtension() {
    }

    public final void setup(MarkdownPipelineBuilder pipeline) {
    }

    public final void setup(MarkdownPipeline pipeline, IMarkdownRenderer renderer) {
        if (renderer == null) {
            throw new ArgumentNullException(nameof(renderer));
        }

        htmlRenderer = Operators.as(renderer, TextRendererBase<HtmlRenderer>.class);
        if (htmlRenderer == null) {
            return;
        }

        originalCodeBlockRenderer = htmlRenderer.ObjectRenderers.<CodeBlockRenderer>FindExact();
        if (originalCodeBlockRenderer != null) {
            htmlRenderer.ObjectRenderers.Remove(originalCodeBlockRenderer);
        }

        htmlRenderer.ObjectRenderers.AddIfNotAlready(
                new SyntaxHighlightingCodeBlockRenderer(originalCodeBlockRenderer));
    }
}

