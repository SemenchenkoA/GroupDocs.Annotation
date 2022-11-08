package com.example.colorcode.html;

import com.aspose.ms.System.StringExtensions;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class ExtensionMethods {
    public static String toHtmlColor(String color) {
        if (color == null) return null;

        int length = 6;
        int start = color.length() - length;
        return StringExtensions.concat("#", StringExtensions.substring(color, start, length));
    }

    public static boolean isNullOrWhiteSpace(String str){
        return str == null || str == " " ? true : false;
    }

    public static String encodeHTML(String aText) {
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (character == '<') {
                result.append("&lt;");
            } else if (character == '>') {
                result.append("&gt;");
            } else if (character == '&') {
                result.append("&amp;");
                //            } else if (character == '\"') {
                //                result.append("&quot;");
                //            } else if (character == '\t') {
                //                addCharEntity(9, result);
                //            } else if (character == '!') {
                //                addCharEntity(33, result);
                //            } else if (character == '#') {
                //                addCharEntity(35, result);
                //            } else if (character == '$') {
                //                addCharEntity(36, result);
                //            } else if (character == '%') {
                //                addCharEntity(37, result);
                //            } else if (character == '\'') {
                //                addCharEntity(39, result);
                //            } else if (character == '(') {
                //                addCharEntity(40, result);
                //            } else if (character == ')') {
                //                addCharEntity(41, result);
                //            } else if (character == '*') {
                //                addCharEntity(42, result);
                //            } else if (character == '+') {
                //                addCharEntity(43, result);
                //            } else if (character == ',') {
                //                addCharEntity(44, result);
                //            } else if (character == '-') {
                //                addCharEntity(45, result);
                //            } else if (character == '.') {
                //                addCharEntity(46, result);
                //            } else if (character == '/') {
                //                addCharEntity(47, result);
                //            } else if (character == ':') {
                //                addCharEntity(58, result);
                //            } else if (character == ';') {
                //                addCharEntity(59, result);
                //            } else if (character == '=') {
                //                addCharEntity(61, result);
                //            } else if (character == '?') {
                //                addCharEntity(63, result);
                //            } else if (character == '@') {
                //                addCharEntity(64, result);
                //            } else if (character == '[') {
                //                addCharEntity(91, result);
                //            } else if (character == '\\') {
                //                addCharEntity(92, result);
                //            } else if (character == ']') {
                //                addCharEntity(93, result);
                //            } else if (character == '^') {
                //                addCharEntity(94, result);
                //            } else if (character == '_') {
                //                addCharEntity(95, result);
                //            } else if (character == '`') {
                //                addCharEntity(96, result);
                //            } else if (character == '{') {
                //                addCharEntity(123, result);
                //            } else if (character == '|') {
                //                addCharEntity(124, result);
                //            } else if (character == '}') {
                //                addCharEntity(125, result);
                //            } else if (character == '~') {
                //                addCharEntity(126, result);
            } else {
                //the char is not a special one
                //add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }
}
