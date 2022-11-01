package com.example.colorcode.compilation;

import com.aspose.ms.System.StringExtensions;

public class RuleFormats {
    public static String JavaScript;
    public static String ServerScript;

    static {
        final String script = "(?xs)(<)(script){0}[\\s\\n]+({1})[\\s\\n]*(=)[\\s\\n]*(\"{2}\"){0}[\\s\\n]*(>)(.*?)(</)(script)(>)";

        final String attributes = "(?:[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*([^\\s\\n\"']+?)|[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*(\"[^\\n]+?\")|[\\s\\n]+([a-z0-9-_]+)[\\s\\n]*(=)[\\s\\n]*('[^\\n]+?')|[\\s\\n]+([a-z0-9-_]+) )*";

        JavaScript = StringExtensions.format(script, attributes, "type|language", "[^\n]*javascript");
        ServerScript = StringExtensions.format(script, attributes, "runat", "server");
    }
}
