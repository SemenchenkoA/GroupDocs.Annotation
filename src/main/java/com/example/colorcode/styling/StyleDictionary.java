package com.example.colorcode.styling;

import com.aspose.ms.System.Collections.ObjectModel.KeyedCollection;
import com.example.colorcode.common.ScopeName;


/**
 * <p>
 * A dictionary of {@link Style} instances, keyed by the styles' scope name.
 * </p>
 *
 * <p>
 * Defines the Default Dark Theme.
 * </p>
 */

/**
 * <p>
 * Defines the Default Dark Theme.
 * </p>
 */

/**
 * <p>
 * Defines the Default Light Theme.
 * </p>
 */
public /*partial*/ class StyleDictionary extends KeyedCollection<String, Style> {
    /**
     * <p>
     * When implemented in a derived class, extracts the key from the specified element.
     * </p>
     * @return The key for the specified element.
     * @param item The element from which to extract the key.
     */
    protected /*override*/ String getKeyForItem(Style item) {
        return item.getScopeName();
    }

    public static final String Blue = "#FF0000FF";
    public static final String White = "#FFFFFFFF";
    public static final String Black = "#FF000000";
    public static final String DullRed = "#FFA31515";
    public static final String Yellow = "#FFFFFF00";
    public static final String Green = "#FF008000";
    public static final String PowderBlue = "#FFB0E0E6";
    public static final String Teal = "#FF008080";
    public static final String Gray = "#FF808080";
    public static final String Navy = "#FF000080";
    public static final String OrangeRed = "#FFFF4500";
    public static final String Purple = "#FF800080";
    public static final String Red = "#FFFF0000";
    public static final String MediumTurqoise = "FF48D1CC";
    public static final String Magenta = "FFFF00FF";
    public static final String OliveDrab = "#FF6B8E23";
    public static final String DarkOliveGreen = "#FF556B2F";
    public static final String DarkCyan = "#FF008B8B";
    private static final String VSDarkBackground = "#FF1E1E1E";
    private static final String VSDarkPlainText = "#FFDADADA";

    private static final String VSDarkXMLDelimeter = "#FF808080";
    private static final String VSDarkXMLName = "#FF#E6E6E6";
    private static final String VSDarkXMLAttribute = "#FF92CAF4";
    private static final String VSDarkXAMLCData = "#FFC0D088";
    private static final String VSDarkXMLComment = "#FF608B4E";

    private static final String VSDarkComment = "#FF57A64A";
    private static final String VSDarkKeyword = "#FF569CD6";
    private static final String VSDarkGray = "#FF9B9B9B";
    private static final String VSDarkNumber = "#FFB5CEA8";
    private static final String VSDarkClass = "#FF4EC9B0";
    private static final String VSDarkString = "#FFD69D85";

    /**
     * <p>
     * A theme with Dark Colors.
     * </p>
     */
    public static StyleDictionary getDefaultDark() {
        StyleDictionary tmp0 = new StyleDictionary();
        Style tmp1 = new Style(ScopeName.PlainText);
        tmp1.setForeground(VSDarkPlainText);
        tmp1.setBackground(VSDarkBackground);
        tmp1.setReferenceName("plainText");
        tmp0.addItem(tmp1);
        Style tmp2 = new Style(ScopeName.HtmlServerSideScript);
        tmp2.setBackground(Yellow);
        tmp2.setReferenceName("htmlServerSideScript");
        tmp0.addItem(tmp2);
        Style tmp3 = new Style(ScopeName.HtmlComment);
        tmp3.setForeground(VSDarkComment);
        tmp3.setReferenceName("htmlComment");
        tmp0.addItem(tmp3);
        Style tmp4 = new Style(ScopeName.HtmlTagDelimiter);
        tmp4.setForeground(VSDarkKeyword);
        tmp4.setReferenceName("htmlTagDelimiter");
        tmp0.addItem(tmp4);
        Style tmp5 = new Style(ScopeName.HtmlElementName);
        tmp5.setForeground(DullRed);
        tmp5.setReferenceName("htmlElementName");
        tmp0.addItem(tmp5);
        Style tmp6 = new Style(ScopeName.HtmlAttributeName);
        tmp6.setForeground(Red);
        tmp6.setReferenceName("htmlAttributeName");
        tmp0.addItem(tmp6);
        Style tmp7 = new Style(ScopeName.HtmlAttributeValue);
        tmp7.setForeground(VSDarkKeyword);
        tmp7.setReferenceName("htmlAttributeValue");
        tmp0.addItem(tmp7);
        Style tmp8 = new Style(ScopeName.HtmlOperator);
        tmp8.setForeground(VSDarkKeyword);
        tmp8.setReferenceName("htmlOperator");
        tmp0.addItem(tmp8);
        Style tmp9 = new Style(ScopeName.Comment);
        tmp9.setForeground(VSDarkComment);
        tmp9.setReferenceName("comment");
        tmp0.addItem(tmp9);
        Style tmp10 = new Style(ScopeName.XmlDocTag);
        tmp10.setForeground(VSDarkXMLComment);
        tmp10.setReferenceName("xmlDocTag");
        tmp0.addItem(tmp10);
        Style tmp11 = new Style(ScopeName.XmlDocComment);
        tmp11.setForeground(VSDarkXMLComment);
        tmp11.setReferenceName("xmlDocComment");
        tmp0.addItem(tmp11);
        Style tmp12 = new Style(ScopeName.String);
        tmp12.setForeground(VSDarkString);
        tmp12.setReferenceName("string");
        tmp0.addItem(tmp12);
        Style tmp13 = new Style(ScopeName.StringCSharpVerbatim);
        tmp13.setForeground(VSDarkString);
        tmp13.setReferenceName("stringCSharpVerbatim");
        tmp0.addItem(tmp13);
        Style tmp14 = new Style(ScopeName.Keyword);
        tmp14.setForeground(VSDarkKeyword);
        tmp14.setReferenceName("keyword");
        tmp0.addItem(tmp14);
        Style tmp15 = new Style(ScopeName.PreprocessorKeyword);
        tmp15.setForeground(VSDarkKeyword);
        tmp15.setReferenceName("preprocessorKeyword");
        tmp0.addItem(tmp15);
        Style tmp16 = new Style(ScopeName.HtmlEntity);
        tmp16.setForeground(Red);
        tmp16.setReferenceName("htmlEntity");
        tmp0.addItem(tmp16);
        Style tmp17 = new Style(ScopeName.XmlAttribute);
        tmp17.setForeground(VSDarkXMLAttribute);
        tmp17.setReferenceName("xmlAttribute");
        tmp0.addItem(tmp17);
        Style tmp18 = new Style(ScopeName.XmlAttributeQuotes);
        tmp18.setForeground(VSDarkKeyword);
        tmp18.setReferenceName("xmlAttributeQuotes");
        tmp0.addItem(tmp18);
        Style tmp19 = new Style(ScopeName.XmlAttributeValue);
        tmp19.setForeground(VSDarkKeyword);
        tmp19.setReferenceName("xmlAttributeValue");
        tmp0.addItem(tmp19);
        Style tmp20 = new Style(ScopeName.XmlCDataSection);
        tmp20.setForeground(VSDarkXAMLCData);
        tmp20.setReferenceName("xmlCDataSection");
        tmp0.addItem(tmp20);
        Style tmp21 = new Style(ScopeName.XmlComment);
        tmp21.setForeground(VSDarkComment);
        tmp21.setReferenceName("xmlComment");
        tmp0.addItem(tmp21);
        Style tmp22 = new Style(ScopeName.XmlDelimiter);
        tmp22.setForeground(VSDarkXMLDelimeter);
        tmp22.setReferenceName("xmlDelimiter");
        tmp0.addItem(tmp22);
        Style tmp23 = new Style(ScopeName.XmlName);
        tmp23.setForeground(VSDarkXMLName);
        tmp23.setReferenceName("xmlName");
        tmp0.addItem(tmp23);
        Style tmp24 = new Style(ScopeName.ClassName);
        tmp24.setForeground(VSDarkClass);
        tmp24.setReferenceName("className");
        tmp0.addItem(tmp24);
        Style tmp25 = new Style(ScopeName.CssSelector);
        tmp25.setForeground(DullRed);
        tmp25.setReferenceName("cssSelector");
        tmp0.addItem(tmp25);
        Style tmp26 = new Style(ScopeName.CssPropertyName);
        tmp26.setForeground(Red);
        tmp26.setReferenceName("cssPropertyName");
        tmp0.addItem(tmp26);
        Style tmp27 = new Style(ScopeName.CssPropertyValue);
        tmp27.setForeground(VSDarkKeyword);
        tmp27.setReferenceName("cssPropertyValue");
        tmp0.addItem(tmp27);
        Style tmp28 = new Style(ScopeName.SqlSystemFunction);
        tmp28.setForeground(Magenta);
        tmp28.setReferenceName("sqlSystemFunction");
        tmp0.addItem(tmp28);
        Style tmp29 = new Style(ScopeName.PowerShellAttribute);
        tmp29.setForeground(PowderBlue);
        tmp29.setReferenceName("powershellAttribute");
        tmp0.addItem(tmp29);
        Style tmp30 = new Style(ScopeName.PowerShellOperator);
        tmp30.setForeground(VSDarkGray);
        tmp30.setReferenceName("powershellOperator");
        tmp0.addItem(tmp30);
        Style tmp31 = new Style(ScopeName.PowerShellType);
        tmp31.setForeground(Teal);
        tmp31.setReferenceName("powershellType");
        tmp0.addItem(tmp31);
        Style tmp32 = new Style(ScopeName.PowerShellVariable);
        tmp32.setForeground(OrangeRed);
        tmp32.setReferenceName("powershellVariable");
        tmp0.addItem(tmp32);
        Style tmp33 = new Style(ScopeName.Type);
        tmp33.setForeground(Teal);
        tmp33.setReferenceName("type");
        tmp0.addItem(tmp33);
        Style tmp34 = new Style(ScopeName.TypeVariable);
        tmp34.setForeground(Teal);
        tmp34.setItalic(true);
        tmp34.setReferenceName("typeVariable");
        tmp0.addItem(tmp34);
        Style tmp35 = new Style(ScopeName.NameSpace);
        tmp35.setForeground(Navy);
        tmp35.setReferenceName("namespace");
        tmp0.addItem(tmp35);
        Style tmp36 = new Style(ScopeName.Constructor);
        tmp36.setForeground(Purple);
        tmp36.setReferenceName("constructor");
        tmp0.addItem(tmp36);
        Style tmp37 = new Style(ScopeName.Predefined);
        tmp37.setForeground(Navy);
        tmp37.setReferenceName("predefined");
        tmp0.addItem(tmp37);
        Style tmp38 = new Style(ScopeName.PseudoKeyword);
        tmp38.setForeground(Navy);
        tmp38.setReferenceName("pseudoKeyword");
        tmp0.addItem(tmp38);
        Style tmp39 = new Style(ScopeName.StringEscape);
        tmp39.setForeground(VSDarkGray);
        tmp39.setReferenceName("stringEscape");
        tmp0.addItem(tmp39);
        Style tmp40 = new Style(ScopeName.ControlKeyword);
        tmp40.setForeground(VSDarkKeyword);
        tmp40.setReferenceName("controlKeyword");
        tmp0.addItem(tmp40);
        Style tmp41 = new Style(ScopeName.Number);
        tmp41.setReferenceName("number");
        tmp41.setForeground(VSDarkNumber);
        tmp0.addItem(tmp41);
        Style tmp42 = new Style(ScopeName.Operator);
        tmp42.setReferenceName("operator");
        tmp0.addItem(tmp42);
        Style tmp43 = new Style(ScopeName.Delimiter);
        tmp43.setReferenceName("delimiter");
        tmp0.addItem(tmp43);
        Style tmp44 = new Style(ScopeName.MarkdownHeader);
        tmp44.setForeground(VSDarkKeyword);
        tmp44.setBold(true);
        tmp44.setReferenceName("markdownHeader");
        tmp0.addItem(tmp44);
        Style tmp45 = new Style(ScopeName.MarkdownCode);
        tmp45.setForeground(VSDarkString);
        tmp45.setReferenceName("markdownCode");
        tmp0.addItem(tmp45);
        Style tmp46 = new Style(ScopeName.MarkdownListItem);
        tmp46.setBold(true);
        tmp46.setReferenceName("markdownListItem");
        tmp0.addItem(tmp46);
        Style tmp47 = new Style(ScopeName.MarkdownEmph);
        tmp47.setItalic(true);
        tmp47.setReferenceName("italic");
        tmp0.addItem(tmp47);
        Style tmp48 = new Style(ScopeName.MarkdownBold);
        tmp48.setBold(true);
        tmp48.setReferenceName("bold");
        tmp0.addItem(tmp48);
        Style tmp49 = new Style(ScopeName.BuiltinFunction);
        tmp49.setForeground(OliveDrab);
        tmp49.setBold(true);
        tmp49.setReferenceName("builtinFunction");
        tmp0.addItem(tmp49);
        Style tmp50 = new Style(ScopeName.BuiltinValue);
        tmp50.setForeground(DarkOliveGreen);
        tmp50.setBold(true);
        tmp50.setReferenceName("builtinValue");
        tmp0.addItem(tmp50);
        Style tmp51 = new Style(ScopeName.Attribute);
        tmp51.setForeground(DarkCyan);
        tmp51.setItalic(true);
        tmp51.setReferenceName("attribute");
        tmp0.addItem(tmp51);
        Style tmp52 = new Style(ScopeName.SpecialCharacter);
        tmp52.setReferenceName("specialChar");
        tmp0.addItem(tmp52);
        return tmp0;
    }

    /**
     * <p>
     * A theme with Light Colors.
     * </p>
     */
    public static StyleDictionary getDefaultLight() {
        StyleDictionary tmp0 = new StyleDictionary();
        Style tmp1 = new Style(ScopeName.PlainText);
        tmp1.setForeground(Black);
        tmp1.setBackground(White);
        tmp1.setReferenceName("plainText");
        tmp0.addItem(tmp1);
        Style tmp2 = new Style(ScopeName.HtmlServerSideScript);
        tmp2.setBackground(Yellow);
        tmp2.setReferenceName("htmlServerSideScript");
        tmp0.addItem(tmp2);
        Style tmp3 = new Style(ScopeName.HtmlComment);
        tmp3.setForeground(Green);
        tmp3.setReferenceName("htmlComment");
        tmp0.addItem(tmp3);
        Style tmp4 = new Style(ScopeName.HtmlTagDelimiter);
        tmp4.setForeground(Blue);
        tmp4.setReferenceName("htmlTagDelimiter");
        tmp0.addItem(tmp4);
        Style tmp5 = new Style(ScopeName.HtmlElementName);
        tmp5.setForeground(DullRed);
        tmp5.setReferenceName("htmlElementName");
        tmp0.addItem(tmp5);
        Style tmp6 = new Style(ScopeName.HtmlAttributeName);
        tmp6.setForeground(Red);
        tmp6.setReferenceName("htmlAttributeName");
        tmp0.addItem(tmp6);
        Style tmp7 = new Style(ScopeName.HtmlAttributeValue);
        tmp7.setForeground(Blue);
        tmp7.setReferenceName("htmlAttributeValue");
        tmp0.addItem(tmp7);
        Style tmp8 = new Style(ScopeName.HtmlOperator);
        tmp8.setForeground(Blue);
        tmp8.setReferenceName("htmlOperator");
        tmp0.addItem(tmp8);
        Style tmp9 = new Style(ScopeName.Comment);
        tmp9.setForeground(Green);
        tmp9.setReferenceName("comment");
        tmp0.addItem(tmp9);
        Style tmp10 = new Style(ScopeName.XmlDocTag);
        tmp10.setForeground(Gray);
        tmp10.setReferenceName("xmlDocTag");
        tmp0.addItem(tmp10);
        Style tmp11 = new Style(ScopeName.XmlDocComment);
        tmp11.setForeground(Green);
        tmp11.setReferenceName("xmlDocComment");
        tmp0.addItem(tmp11);
        Style tmp12 = new Style(ScopeName.String);
        tmp12.setForeground(DullRed);
        tmp12.setReferenceName("string");
        tmp0.addItem(tmp12);
        Style tmp13 = new Style(ScopeName.StringCSharpVerbatim);
        tmp13.setForeground(DullRed);
        tmp13.setReferenceName("stringCSharpVerbatim");
        tmp0.addItem(tmp13);
        Style tmp14 = new Style(ScopeName.Keyword);
        tmp14.setForeground(Blue);
        tmp14.setReferenceName("keyword");
        tmp0.addItem(tmp14);
        Style tmp15 = new Style(ScopeName.PreprocessorKeyword);
        tmp15.setForeground(Blue);
        tmp15.setReferenceName("preprocessorKeyword");
        tmp0.addItem(tmp15);
        Style tmp16 = new Style(ScopeName.HtmlEntity);
        tmp16.setForeground(Red);
        tmp16.setReferenceName("htmlEntity");
        tmp0.addItem(tmp16);
        Style tmp17 = new Style(ScopeName.XmlAttribute);
        tmp17.setForeground(Red);
        tmp17.setReferenceName("xmlAttribute");
        tmp0.addItem(tmp17);
        Style tmp18 = new Style(ScopeName.XmlAttributeQuotes);
        tmp18.setForeground(Black);
        tmp18.setReferenceName("xmlAttributeQuotes");
        tmp0.addItem(tmp18);
        Style tmp19 = new Style(ScopeName.XmlAttributeValue);
        tmp19.setForeground(Blue);
        tmp19.setReferenceName("xmlAttributeValue");
        tmp0.addItem(tmp19);
        Style tmp20 = new Style(ScopeName.XmlCDataSection);
        tmp20.setForeground(Gray);
        tmp20.setReferenceName("xmlCDataSection");
        tmp0.addItem(tmp20);
        Style tmp21 = new Style(ScopeName.XmlComment);
        tmp21.setForeground(Green);
        tmp21.setReferenceName("xmlComment");
        tmp0.addItem(tmp21);
        Style tmp22 = new Style(ScopeName.XmlDelimiter);
        tmp22.setForeground(Blue);
        tmp22.setReferenceName("xmlDelimiter");
        tmp0.addItem(tmp22);
        Style tmp23 = new Style(ScopeName.XmlName);
        tmp23.setForeground(DullRed);
        tmp23.setReferenceName("xmlName");
        tmp0.addItem(tmp23);
        Style tmp24 = new Style(ScopeName.ClassName);
        tmp24.setForeground(MediumTurqoise);
        tmp24.setReferenceName("className");
        tmp0.addItem(tmp24);
        Style tmp25 = new Style(ScopeName.CssSelector);
        tmp25.setForeground(DullRed);
        tmp25.setReferenceName("cssSelector");
        tmp0.addItem(tmp25);
        Style tmp26 = new Style(ScopeName.CssPropertyName);
        tmp26.setForeground(Red);
        tmp26.setReferenceName("cssPropertyName");
        tmp0.addItem(tmp26);
        Style tmp27 = new Style(ScopeName.CssPropertyValue);
        tmp27.setForeground(Blue);
        tmp27.setReferenceName("cssPropertyValue");
        tmp0.addItem(tmp27);
        Style tmp28 = new Style(ScopeName.SqlSystemFunction);
        tmp28.setForeground(Magenta);
        tmp28.setReferenceName("sqlSystemFunction");
        tmp0.addItem(tmp28);
        Style tmp29 = new Style(ScopeName.PowerShellAttribute);
        tmp29.setForeground(PowderBlue);
        tmp29.setReferenceName("powershellAttribute");
        tmp0.addItem(tmp29);
        Style tmp30 = new Style(ScopeName.PowerShellOperator);
        tmp30.setForeground(Gray);
        tmp30.setReferenceName("powershellOperator");
        tmp0.addItem(tmp30);
        Style tmp31 = new Style(ScopeName.PowerShellType);
        tmp31.setForeground(Teal);
        tmp31.setReferenceName("powershellType");
        tmp0.addItem(tmp31);
        Style tmp32 = new Style(ScopeName.PowerShellVariable);
        tmp32.setForeground(OrangeRed);
        tmp32.setReferenceName("powershellVariable");
        tmp0.addItem(tmp32);
        Style tmp33 = new Style(ScopeName.Type);
        tmp33.setForeground(Teal);
        tmp33.setReferenceName("type");
        tmp0.addItem(tmp33);
        Style tmp34 = new Style(ScopeName.TypeVariable);
        tmp34.setForeground(Teal);
        tmp34.setItalic(true);
        tmp34.setReferenceName("typeVariable");
        tmp0.addItem(tmp34);
        Style tmp35 = new Style(ScopeName.NameSpace);
        tmp35.setForeground(Navy);
        tmp35.setReferenceName("namespace");
        tmp0.addItem(tmp35);
        Style tmp36 = new Style(ScopeName.Constructor);
        tmp36.setForeground(Purple);
        tmp36.setReferenceName("constructor");
        tmp0.addItem(tmp36);
        Style tmp37 = new Style(ScopeName.Predefined);
        tmp37.setForeground(Navy);
        tmp37.setReferenceName("predefined");
        tmp0.addItem(tmp37);
        Style tmp38 = new Style(ScopeName.PseudoKeyword);
        tmp38.setForeground(Navy);
        tmp38.setReferenceName("pseudoKeyword");
        tmp0.addItem(tmp38);
        Style tmp39 = new Style(ScopeName.StringEscape);
        tmp39.setForeground(Gray);
        tmp39.setReferenceName("stringEscape");
        tmp0.addItem(tmp39);
        Style tmp40 = new Style(ScopeName.ControlKeyword);
        tmp40.setForeground(Blue);
        tmp40.setReferenceName("controlKeyword");
        tmp0.addItem(tmp40);
        Style tmp41 = new Style(ScopeName.Number);
        tmp41.setReferenceName("number");
        tmp0.addItem(tmp41);
        Style tmp42 = new Style(ScopeName.Operator);
        tmp42.setReferenceName("operator");
        tmp0.addItem(tmp42);
        Style tmp43 = new Style(ScopeName.Delimiter);
        tmp43.setReferenceName("delimiter");
        tmp0.addItem(tmp43);
        Style tmp44 = new Style(ScopeName.MarkdownHeader);
        tmp44.setForeground(Blue);
        tmp44.setBold(true);
        tmp44.setReferenceName("markdownHeader");
        tmp0.addItem(tmp44);
        Style tmp45 = new Style(ScopeName.MarkdownCode);
        tmp45.setForeground(Teal);
        tmp45.setReferenceName("markdownCode");
        tmp0.addItem(tmp45);
        Style tmp46 = new Style(ScopeName.MarkdownListItem);
        tmp46.setBold(true);
        tmp46.setReferenceName("markdownListItem");
        tmp0.addItem(tmp46);
        Style tmp47 = new Style(ScopeName.MarkdownEmph);
        tmp47.setItalic(true);
        tmp47.setReferenceName("italic");
        tmp0.addItem(tmp47);
        Style tmp48 = new Style(ScopeName.MarkdownBold);
        tmp48.setBold(true);
        tmp48.setReferenceName("bold");
        tmp0.addItem(tmp48);
        Style tmp49 = new Style(ScopeName.BuiltinFunction);
        tmp49.setForeground(OliveDrab);
        tmp49.setBold(true);
        tmp49.setReferenceName("builtinFunction");
        tmp0.addItem(tmp49);
        Style tmp50 = new Style(ScopeName.BuiltinValue);
        tmp50.setForeground(DarkOliveGreen);
        tmp50.setBold(true);
        tmp50.setReferenceName("builtinValue");
        tmp0.addItem(tmp50);
        Style tmp51 = new Style(ScopeName.Attribute);
        tmp51.setForeground(DarkCyan);
        tmp51.setItalic(true);
        tmp51.setReferenceName("attribute");
        tmp0.addItem(tmp51);
        Style tmp52 = new Style(ScopeName.SpecialCharacter);
        tmp52.setReferenceName("specialChar");
        tmp0.addItem(tmp52);
        return tmp0;
    }
}
